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

package at.silverstrike.pcc.impl.gcaltasks2pccimporter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import com.google.api.services.tasks.v1.model.Task;
import com.google.inject.Injector;

import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2;
import at.silverstrike.pcc.api.gtask2pcctaskconverter.GoogleTask2PccTaskConverter;
import at.silverstrike.pcc.api.gtask2pcctaskconverter.GoogleTask2PccTaskConverterFactory;
import at.silverstrike.pcc.api.gtasknoteparser.GoogleTaskNotesParser;
import at.silverstrike.pcc.api.gtasknoteparser.GoogleTaskNotesParserFactory;
import at.silverstrike.pcc.api.gtaskprioritycalculator.GoogleTasksPriorityCalculator;
import at.silverstrike.pcc.api.gtaskprioritycalculator.GoogleTasksPriorityCalculatorFactory;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculator;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculatorFactory;
import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.persistence.Persistence;

/**
 * @author DP118M
 * 
 */
class DefaultGoogleCalendarTasks2PccImporter2 implements
        GoogleCalendarTasks2PccImporter2 {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultGoogleCalendarTasks2PccImporter2.class);

    private List<com.google.api.services.tasks.v1.model.Task> googleTasks;
    private List<SchedulingObject> createdPccTasks;
    private Injector injector;
    private UserData user;

    public
            void
            setGoogleTasks(
                    final List<com.google.api.services.tasks.v1.model.Task> aGoogleTasks) {
        this.googleTasks = aGoogleTasks;
    }

    @Override
    public void setInjector(final Injector aInjector) {
        this.injector = aInjector;
    }

    @Override
    public void run() {
        final Persistence persistence =
                this.injector.getInstance(Persistence.class);

        persistence.removeUserSchedulingObjects(this.user);

        final Map<String, com.google.api.services.tasks.v1.model.Task> relevantTasksByIds =
                    new HashMap<String,
                    com.google.api.services.tasks.v1.model.Task>();

        getRelevantGoogleTasks(relevantTasksByIds);

        LOGGER.debug("Relevant tasks: " + relevantTasksByIds.size());

        this.createdPccTasks =
                new LinkedList<SchedulingObject>();

        // Create tasks in PCC database
        final Map<String, at.silverstrike.pcc.api.model.Task> pccTasksByGoogleIds =
                    createPccTasks(relevantTasksByIds, persistence);

        // Set parents
        setParents(persistence, relevantTasksByIds, pccTasksByGoogleIds);

        // Set dependencies
        setDependencies(persistence, relevantTasksByIds,
                    pccTasksByGoogleIds);

        // Set priorities
        setPriorities(relevantTasksByIds,
                    pccTasksByGoogleIds);

        for (final at.silverstrike.pcc.api.model.Task curTask : pccTasksByGoogleIds
                .values()) {
            this.createdPccTasks.add(curTask);
        }
    }

    private
            void
            setPriorities(
                    final Map<String, Task> aRelevantTasksByIds,
                    final Map<String, at.silverstrike.pcc.api.model.Task> aPccTasksByGoogleIds) {

        final GoogleTasksPriorityCalculatorFactory factory =
                this.injector
                        .getInstance(GoogleTasksPriorityCalculatorFactory.class);
        final GoogleTasksPriorityCalculator calculator = factory.create();

        calculator.setTasks(aRelevantTasksByIds);
        try {
            calculator.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
        }

        final Map<String, Integer> prioritiesByTaskIds =
                calculator.getPrioritiesByTaskIds();

        for (final String curTaskId : prioritiesByTaskIds.keySet()) {
            final at.silverstrike.pcc.api.model.Task pccTask =
                    aPccTasksByGoogleIds
                            .get(curTaskId);

            pccTask.setPriority(prioritiesByTaskIds.get(curTaskId));

        }
    }

    private
            void
            setDependencies(
                    final Persistence aPersistence,
                    final Map<String, com.google.api.services.tasks.v1.model.Task> aRelevantTasksByIds,
                    final Map<String, at.silverstrike.pcc.api.model.Task> aPccTasksByGoogleIds) {
        final GoogleTaskNotesParserFactory factory =
                this.injector.getInstance(GoogleTaskNotesParserFactory.class);
        final GoogleTaskNotesParser notesParser = factory.create();

        final List<RelevantTaskInformation> tuples =
                new LinkedList<RelevantTaskInformation>();

        for (final String curGoogleTaskId : aRelevantTasksByIds.keySet()) {
            try {
                final RelevantTaskInformation tuple =
                        new RelevantTaskInformation();

                final com.google.api.services.tasks.v1.model.Task curGoogleTask =
                        aRelevantTasksByIds.get(curGoogleTaskId);

                notesParser.setNotes(curGoogleTask.notes);
                notesParser.run();

                if (notesParser.arePredecessorsSpecified()) {
                    tuple.setPredecessorLabels(notesParser
                            .getPredecessorLabels());
                }

                tuple.setPccTask(aPccTasksByGoogleIds.get(curGoogleTaskId));

                tuples.add(tuple);
            } catch (final PccException exception) {
                LOGGER.error("", exception);
            }
        }

        final Map<String, at.silverstrike.pcc.api.model.Task> pccTasksByLabels =
                new HashMap<String, at.silverstrike.pcc.api.model.Task>();

        for (final at.silverstrike.pcc.api.model.Task curPccTask : aPccTasksByGoogleIds
                .values()) {
            final String label = curPccTask.getLabel();

            if (!StringUtils.isBlank(label)) {
                pccTasksByLabels.put(label, curPccTask);
            }
        }

        for (final RelevantTaskInformation curTuple : tuples) {
            final Set<SchedulingObject> predecessors =
                    new HashSet<SchedulingObject>();

            for (final String curPredecessorLabel : curTuple
                    .getPredecessorLabels()) {
                predecessors.add(pccTasksByLabels.get(curPredecessorLabel));
            }

            curTuple.getPccTask().setPredecessors(predecessors);
        }
    }

    private
            void
            setParents(
                    final Persistence aPersistence,
                    final Map<String, com.google.api.services.tasks.v1.model.Task> aRelevantTasksByIds,
                    final Map<String, at.silverstrike.pcc.api.model.Task> aPccTasksByGoogleIds) {
        for (final String curGoogleTaskId : aRelevantTasksByIds.keySet()) {
            // Fetch child Google Task
            final com.google.api.services.tasks.v1.model.Task childTask =
                    aRelevantTasksByIds.get(curGoogleTaskId);

            // Fetch parent ID
            final String parentId = childTask.parent;

            if (!StringUtils.isBlank(parentId)) {
                // Fetch child PCC task
                final at.silverstrike.pcc.api.model.Task childPccTask =
                        aPccTasksByGoogleIds.get(curGoogleTaskId);

                // Fetch parent PCC task
                final at.silverstrike.pcc.api.model.Task parentPccTask =
                        aPccTasksByGoogleIds.get(parentId);

                parentPccTask.getChildren().add(childPccTask);
                childPccTask.setParent(parentPccTask);
            }
        }
    }

    private
            Map<String, at.silverstrike.pcc.api.model.Task>
            createPccTasks(
                    final Map<String, com.google.api.services.tasks.v1.model.Task> aRelevantTasksByIds,
                    final Persistence aPersistence) {
        final GoogleTask2PccTaskConverterFactory factory =
                this.injector
                        .getInstance(GoogleTask2PccTaskConverterFactory.class);
        final GoogleTask2PccTaskConverter converter = factory.create();

        converter.setUser(this.user);
        converter.setInjector(this.injector);

        final Map<String, at.silverstrike.pcc.api.model.Task> pccTasksByGoogleIds =
                new HashMap<String, at.silverstrike.pcc.api.model.Task>();

        for (final com.google.api.services.tasks.v1.model.Task curTask : aRelevantTasksByIds
                .values()) {
            try {
                converter.setGoogleTask(curTask);
                converter.run();

                final at.silverstrike.pcc.api.model.Task pccTask =
                        converter.getPccTask();
                pccTasksByGoogleIds.put(curTask.id, pccTask);
            } catch (final PccException exception) {
                LOGGER.error("", exception);
            }
        }
        return pccTasksByGoogleIds;
    }

    private
            void
            getRelevantGoogleTasks(
                    final Map<String, com.google.api.services.tasks.v1.model.Task> aRelevantTasksByIds) {
        final RelevantTaskSetCalculatorFactory factory =
                this.injector
                        .getInstance(RelevantTaskSetCalculatorFactory.class);
        final RelevantTaskSetCalculator calculator = factory.create();

        calculator.setInjector(this.injector);
        calculator.setGoogleTasks(this.googleTasks);
        try {
            calculator.run();
            final List<com.google.api.services.tasks.v1.model.Task> relevantTasks =
                    calculator.getRelevantTasks();

            for (final com.google.api.services.tasks.v1.model.Task curTask : relevantTasks) {
                aRelevantTasksByIds.put(curTask.id, curTask);
            }

        } catch (final PccException exception) {
            LOGGER.error("", exception);
        }

        // final IsGoogleTaskRelevantCalculatorFactory factory =
        // this.injector
        // .getInstance(IsGoogleTaskRelevantCalculatorFactory.class);
        // final IsGoogleTaskRelevantCalculator relevanceCalculator =
        // factory.create();
        //
        // relevanceCalculator.setInjector(this.injector);
        //
        // for (final com.google.api.services.tasks.v1.model.Task curTask :
        // this.googleTasks) {
        // LOGGER.debug(
        // "Task list: title='{}', completed='{}', id='{}', kind='{}', notes='{}', parent='{}', position='{}', status='{}', updated='{}'",
        // new Object[] { curTask.title, curTask.completed,
        // curTask.id, curTask.kind, curTask.notes,
        // curTask.parent, curTask.position, curTask.status,
        // curTask.updated });
        //
        // try {
        // relevanceCalculator.setGoogleTask(curTask);
        // relevanceCalculator.run();
        // if (relevanceCalculator.isRelevant()) {
        // relevantTasksByIds.put(curTask.id, curTask);
        // }
        // } catch (final PccException exception) {
        // LOGGER.error("", exception);
        // }
        // }
    }

    public void setUser(final UserData aUser) {
        this.user = aUser;
    }

    public List<SchedulingObject> getCreatedPccTasks() {
        return createdPccTasks;
    }

}
