/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package at.silverstrike.pcc.impl.export2tj3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.embeddedfilereading.EmbeddedFileReader;
import at.silverstrike.pcc.api.export2tj3.InvalidDurationException;
import at.silverstrike.pcc.api.export2tj3.NoProcessesException;
import at.silverstrike.pcc.api.export2tj3.NoProjectExportInfoException;
import at.silverstrike.pcc.api.export2tj3.NoResourcesException;
import at.silverstrike.pcc.api.export2tj3.TaskJuggler3Exporter;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.DailyLimitResourceAllocation;
import at.silverstrike.pcc.api.model.Resource;
import at.silverstrike.pcc.api.model.ResourceAllocation;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.projectscheduler.ProjectExportInfo;

import com.google.inject.Injector;

/**
 * @author Dmitri Pisarenko
 * 
 */
class DefaultTaskJuggler3Exporter implements TaskJuggler3Exporter {
    private static final String RESOURCE_ID = "${resourceId}";

    private static final String ABBREVIATION = "${abbreviation}";

    private static final String CHILD_TASKS = "${childTasks}";

    private static final String DAILY_LIMIT_IN_HOURS = "${dailyLimitInHours}";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd");

    private static final String EFFORT = "${effort}";

    private static final String EFFORT_INFO = "${effortInfo}";

    private static final String TEMPLATE_DIRECTORY = "export2tj3/";

    private static final String EXPORT2TJ3_TEMPLATE_EFFORT =
            TEMPLATE_DIRECTORY + "export2tj3.template.effort";

    private static final String EXPORT2TJ3_TEMPLATE_RESOURCEALLOCATION_LIMITS =
            TEMPLATE_DIRECTORY
                    + "export2tj3.template.resourceallocation.limits";

    private static final String EXPORT2TJ3_TEMPLATE_RESOURCEALLOCATION_NOLIMITS =
            TEMPLATE_DIRECTORY
                    + "export2tj3.template.resourceallocation.nolimits";

    private static final String EXPORT2TJ3_TEMPLATE_START =
            TEMPLATE_DIRECTORY + "export2tj3.template.start";

    private static final String EXPORT2TJ3_TEMPLATE_TASK =
            TEMPLATE_DIRECTORY + "export2tj3.template.task";

    private static final String ID = "${soId}";

    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultTaskJuggler3Exporter.class);

    private static final String MAX_HOURS_PER_DAY = "${maxHoursPerDay}";

    private static final int MAX_TASK_NAME_LENGTH = 30;

    private static final String NAME = "${taskName}";

    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat(
            "#0.00");

    private static final String PLACEHOLDER_COPYRIGHT = "${copyright}";

    private static final String PLACEHOLDER_CURRENCY = "${currency}";

    private static final String PLACEHOLDER_NOW = "${now}";

    private static final String PLACEHOLDER_PROJECT_NAME = "${projectName}";

    private static final String PLACEHOLDER_SCHEDULING_HORIZON_MONTHS =
            "${schedulingHorizonMonths}";

    private static final String PRIORITY = "${priority}";

    private static final String PROJECT_HEADER_TEMPLATE =
            TEMPLATE_DIRECTORY + "export2tj3.template.project";

    private static final String REPORT_TEMPLATE = TEMPLATE_DIRECTORY
            + "export2tj3.template.reports";

    private static final String RESOURCE = "${resource}";

    private static final String RESOURCE_ALLOCATIONS = "${resourceAllocations}";

    private static final String RESOURCE_TEMPLATE =
            TEMPLATE_DIRECTORY + "export2tj3.template.resource";
    private static final String START_DATE_TIME = "${startDateTime}";

    private static final Double TIMING_RESOLUTION_IN_HOURS = 0.16667;

    private String effortTemplate;
    private EmbeddedFileReader embeddedFileReader;
    private Persistence persistence;
    private String resourceAllocationLimitsTemplate;
    private String resourceAllocationNoLimitsTemplate;
    private String result;
    private String startDateTimeTemplate;
    private String taskTemplate;
    private ProjectExportInfo projectExportInfo;
    private boolean transientMode;

    public DefaultTaskJuggler3Exporter() {
    }

    @Override
    public String getTaskJugglerIIIProjectFileContents() {
        return result;
    }

    /**
     * @see at.silverstrike.pcc.api.export2tj3.TaskJuggler3Exporter#run()
     */
    @Override
    public void run() throws PccException {
        validateInputs();

        final StringBuilder builder = new StringBuilder();

        LOGGER.debug("this.embeddedFileReader: " + embeddedFileReader);

        embeddedFileReader.setFilename(PROJECT_HEADER_TEMPLATE);
        embeddedFileReader.setClassLoader(getClass().getClassLoader());
        embeddedFileReader.run();

        final String projectTemplate =
                embeddedFileReader.getFileContents();
        final String projectHeader =
                substituteProjectHeaderPlaceholders(projectTemplate);

        builder.append(projectHeader);

        // Add resource information
        addResourceInformation(builder);

        // Add task information
        final List<SchedulingObject> processes;
        if (this.transientMode) {
            processes =
                    filterOutTopLevelTasks(this.projectExportInfo
                            .getSchedulingObjectsToExport());
        } else {
            processes =
                    this.projectExportInfo.getSchedulingObjectsToExport();
        }

        if (processes != null) {
            embeddedFileReader.setFilename(EXPORT2TJ3_TEMPLATE_TASK);
            embeddedFileReader.run();
            taskTemplate = embeddedFileReader.getFileContents();

            embeddedFileReader.setFilename(EXPORT2TJ3_TEMPLATE_EFFORT);
            embeddedFileReader.run();
            effortTemplate = embeddedFileReader.getFileContents();

            embeddedFileReader
                    .setFilename(EXPORT2TJ3_TEMPLATE_RESOURCEALLOCATION_LIMITS);
            embeddedFileReader.run();
            resourceAllocationLimitsTemplate =
                    embeddedFileReader.getFileContents();

            embeddedFileReader
                    .setFilename(EXPORT2TJ3_TEMPLATE_RESOURCEALLOCATION_NOLIMITS);
            embeddedFileReader.run();
            resourceAllocationNoLimitsTemplate =
                    embeddedFileReader.getFileContents();

            embeddedFileReader.setFilename(EXPORT2TJ3_TEMPLATE_START);
            embeddedFileReader.run();
            startDateTimeTemplate = embeddedFileReader.getFileContents();

            for (final SchedulingObject process : processes) {
                builder.append(getTaskInformation(process, null));
            }
        }

        // Add footer (report definitions)
        embeddedFileReader.setFilename(REPORT_TEMPLATE);
        embeddedFileReader.run();
        builder.append(embeddedFileReader.getFileContents());

        result = builder.toString();
    }

    private List<SchedulingObject> filterOutTopLevelTasks(
            final List<SchedulingObject> aSchedulingObjectsToExport) {
        final DirectedGraph<SchedulingObject, DefaultEdge> graph =
                new ListenableDirectedGraph<SchedulingObject, DefaultEdge>(
                        DefaultEdge.class);

        for (final SchedulingObject curSchedulingObject : aSchedulingObjectsToExport) {
            final SchedulingObject parent = curSchedulingObject.getParent();
            addToGraphIfNecessary(graph, curSchedulingObject);
            if (parent != null) {
                addToGraphIfNecessary(graph, parent);
                graph.addEdge(parent, curSchedulingObject);
            }
        }

        final List<SchedulingObject> topLevelSchedulingObjects =
                new LinkedList<SchedulingObject>();

        for (final SchedulingObject vertex : graph.vertexSet()) {
            if (graph.inDegreeOf(vertex) == 0) {
                topLevelSchedulingObjects.add(vertex);
            }
        }

        return topLevelSchedulingObjects;
    }

    private void addToGraphIfNecessary(
            final DirectedGraph<SchedulingObject, DefaultEdge> aGraph,
            final SchedulingObject aVertex) {
        if (!aGraph.containsVertex(aVertex)){
            aGraph.addVertex(aVertex);
        }
    }

    @Override
    public void setInjector(final Injector aInjector) {
        if (aInjector != null) {
            persistence = aInjector.getInstance(Persistence.class);
            embeddedFileReader =
                    aInjector.getInstance(EmbeddedFileReader.class);
        }
    }

    private void addResourceInformation(final StringBuilder aBuilder)
            throws PccException {
        final List<Resource> resources =
                this.projectExportInfo.getResourcesToExport();

        if (resources != null) {
            embeddedFileReader.setFilename(RESOURCE_TEMPLATE);
            embeddedFileReader.run();

            final String resourceDefinitionTemplate =
                    embeddedFileReader.getFileContents();

            for (final Resource resource : resources) {
                final String resourceDefinition =
                        subsituteResourcePlaceHolders(
                                resourceDefinitionTemplate, resource);

                aBuilder.append(resourceDefinition);
            }
        }
    }

    /**
     * Formats a Date instance to format YYYY-MM-DD, e. g. 2010-04-28 for
     * 28.04.2010.
     */
    private CharSequence formatDate(final Date aDate) {
        return DATE_FORMAT.format(aDate);
    }

    private String formatDouble(final double aNumber) {
        return NUMBER_FORMAT.format(aNumber).replace(',', '.');
    }

    private CharSequence formatInt(final int aNumber) {
        return "" + aNumber;
    }

    private CharSequence formatLong(final Long aNumber) {
        if (aNumber != null) {
            return aNumber.toString();
        } else {
            return "";
        }
    }

    private List<SchedulingObject>
            getChildProcesses(final SchedulingObject aProcess) {
        if ((this.transientMode) && (aProcess instanceof Task)) {
            final Task task = (Task) aProcess;

            return task.getChildren();
        } else if ((this.transientMode) && !(aProcess instanceof Task)) {
            return new LinkedList<SchedulingObject>();
        } else if (!this.transientMode) {
            return persistence.getChildTasks(aProcess);
        } else {
            return null;
        }
    }

    private CharSequence getEffortAllocations(final Task aProcess) {
        final StringBuilder stringBuilder = new StringBuilder();

        final String resource =
                "R"
                        + Long.toString(this.projectExportInfo
                                .getResourcesToExport().get(0).getId());

        if ((aProcess != null) && (aProcess.getResourceAllocations() != null)) {
            for (final ResourceAllocation resourceAllocation : aProcess
                    .getResourceAllocations()) {
                final String resourceAllocationInfo;

                if (resourceAllocation instanceof DailyLimitResourceAllocation) {
                    final DailyLimitResourceAllocation limitAlloc =
                            (DailyLimitResourceAllocation) resourceAllocation;

                    resourceAllocationInfo =
                            resourceAllocationLimitsTemplate.replace(
                                    RESOURCE,
                                    resource).replace(
                                    MAX_HOURS_PER_DAY,
                                    formatDouble(limitAlloc.getDailyLimit()));
                } else {
                    resourceAllocationInfo =
                            resourceAllocationNoLimitsTemplate.replace(
                                    RESOURCE,
                                    getResourceIdentifier(resourceAllocation
                                            .getResource()));
                }
                stringBuilder.append(resourceAllocationInfo);
            }
        }

        return stringBuilder.toString();
    }

    private CharSequence getEffortInfo(final Task aProcess) {
        final Double bestCaseEffort = aProcess.getBestCaseEffort();
        final Double worstCaseEffort = aProcess.getWorstCaseEffort();

        if ((bestCaseEffort != null) && (worstCaseEffort != null)) {
            return effortTemplate.replace(EFFORT,
                    formatDouble(aProcess.getAverageCaseEffort()));
        } else if ((bestCaseEffort != null) && (worstCaseEffort == null)) {
            return effortTemplate.replace(EFFORT, formatDouble(bestCaseEffort));
        } else if ((bestCaseEffort == null) && (worstCaseEffort != null)) {
            return effortTemplate
                    .replace(EFFORT, formatDouble(worstCaseEffort));
        } else {
            return "";
        }
    }

    private String getResourceIdentifier(final Resource aResource) {
        return "R" + aResource.getId();
    }

    private CharSequence getStartDateTime(final Task aParent) {
        if (aParent == null) {
            return startDateTimeTemplate;
        } else {
            return "";
        }
    }

    private String getTaskInformation(final SchedulingObject aProcess,
            final SchedulingObject aParent) {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<SchedulingObject> childProcesses =
                getChildProcesses(aProcess);
        if (childProcesses != null) {
            for (final SchedulingObject childProcess : childProcesses) {
                stringBuilder
                        .append(getTaskInformation(childProcess, aProcess));
            }
        }

        final String childProcessDefinitions = stringBuilder.toString();

        final Integer boxedPriority =
                getBoxedPriority(aProcess, childProcesses);
        final int priority = getPriority(boxedPriority);

        final String taskDefinition =
                taskTemplate
                        .replace(ID, formatLong(aProcess.getId()))
                        .replace(NAME, shortenName(((Task) aProcess).getName()))
                        .replace(START_DATE_TIME,
                                getStartDateTime((Task) aParent))
                        .replace(PRIORITY, formatInt(priority))
                        .replace(RESOURCE_ALLOCATIONS,
                                getEffortAllocations((Task) aProcess))
                        .replace(EFFORT_INFO, getEffortInfo((Task) aProcess))
                        .replace(CHILD_TASKS, childProcessDefinitions);

        return taskDefinition;
    }

    private int getPriority(Integer boxedPriority) {
        final int priority;
        if (boxedPriority != null) {
            priority = boxedPriority;
        } else {
            priority = 0;
        }
        return priority;
    }

    private Integer getBoxedPriority(final SchedulingObject aProcess,
            final List<SchedulingObject> aChildProcesses) {
        Integer boxedPriority = null;

        if (aChildProcesses.size() > 0) {
            boxedPriority = 0;
        } else {
            boxedPriority = aProcess.getPriority();
        }

        return boxedPriority;
    }

    private CharSequence shortenName(final String aName) {
        if (aName != null) {
            return StringUtils.abbreviate(removeSpecialCharacters(aName),
                    MAX_TASK_NAME_LENGTH);
        } else {
            return "";
        }
    }

    private String removeSpecialCharacters(final String aName) {
        return aName.replace('\"', ' ');
    }

    private String subsituteResourcePlaceHolders(
            final String aResourceDefinitionTemplate, final Resource aResource) {
        final String resourceDefinition =
                aResourceDefinitionTemplate
                        .replace(ABBREVIATION, aResource.getAbbreviation())
                        .replace(RESOURCE_ID, aResource.getId().toString())
                        .replace(DAILY_LIMIT_IN_HOURS,
                                formatDouble(aResource.getDailyLimitInHours()));
        return resourceDefinition;
    }

    private String substituteProjectHeaderPlaceholders(
            final String aProjectTemplate) {

        LOGGER.error("projectTemplate: {}", aProjectTemplate);
        LOGGER.error("this.projectExportInfo: {}", this.projectExportInfo);

        final String projectHeader =
                aProjectTemplate
                        .replace(PLACEHOLDER_PROJECT_NAME,
                                this.projectExportInfo.getProjectName())
                        .replace(PLACEHOLDER_COPYRIGHT,
                                this.projectExportInfo.getCopyright())
                        .replace(PLACEHOLDER_CURRENCY,
                                this.projectExportInfo.getCurrency())
                        .replace(PLACEHOLDER_NOW,
                                formatDate(this.projectExportInfo.getNow()))
                        .replace(
                                PLACEHOLDER_SCHEDULING_HORIZON_MONTHS,
                                formatInt(this.projectExportInfo
                                        .getSchedulingHorizonMonths()));
        return projectHeader;
    }

    private void validateInputs() throws NoProcessesException,
            NoResourcesException, NoProjectExportInfoException,
            InvalidDurationException {
        if (this.projectExportInfo == null) {
            throw new NoProjectExportInfoException();
        }

        final List<SchedulingObject> processes =
                this.projectExportInfo.getSchedulingObjectsToExport();
        final List<Resource> resources =
                this.projectExportInfo.getResourcesToExport();

        if (processes == null) {
            throw new NoProcessesException();
        }

        if (processes.size() < 1) {
            throw new NoProcessesException();
        }

        if (resources == null) {
            throw new NoResourcesException();
        }

        if (resources.size() < 1) {
            throw new NoResourcesException();
        }

        for (final SchedulingObject proc : processes) {
            if (proc instanceof Task) {
                final Task task = (Task) proc;

                LOGGER.debug("task: " + task.getName());

                if (task.getChildren() == null) {
                    checkTimingResolution(task, task.getBestCaseEffort());
                    checkTimingResolution(task, task.getAverageCaseEffort());
                    checkTimingResolution(task, task.getWorstCaseEffort());
                }
            }
        }
    }

    private void checkTimingResolution(final Task aProcess,
            final Double aBestCaseEffort) throws InvalidDurationException {
        if ((aBestCaseEffort != null)
                && (aBestCaseEffort < TIMING_RESOLUTION_IN_HOURS)) {
            throw new InvalidDurationException(aProcess.getId(),
                    aProcess.getName());
        }
    }

    public ProjectExportInfo getProjectExportInfo() {
        return projectExportInfo;
    }

    public void
            setProjectExportInfo(final ProjectExportInfo aProjectExportInfo) {
        this.projectExportInfo = aProjectExportInfo;
    }

    public void setTransientMode(final boolean aTransientMode) {
        this.transientMode = aTransientMode;
    }

}
