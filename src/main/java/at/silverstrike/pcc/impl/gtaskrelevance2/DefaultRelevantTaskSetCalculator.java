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

package at.silverstrike.pcc.impl.gtaskrelevance2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;

import ru.altruix.commons.api.di.PccException;

import com.google.api.services.tasks.v1.model.Task;
import com.google.inject.Injector;

import at.silverstrike.pcc.api.gtaskrelevance.IsGoogleTaskRelevantCalculator;
import at.silverstrike.pcc.api.gtaskrelevance.IsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculator;

/**
 * @author DP118M
 * 
 */
final class DefaultRelevantTaskSetCalculator implements
        RelevantTaskSetCalculator {
    private List<com.google.api.services.tasks.v1.model.Task> googleTasks;
    private List<com.google.api.services.tasks.v1.model.Task> relevantTasks;
    private Injector injector;
    private DirectedGraph<com.google.api.services.tasks.v1.model.Task, DefaultEdge> parentChildGraph;
    private Map<String, com.google.api.services.tasks.v1.model.Task> tasksByIds;

    public List<com.google.api.services.tasks.v1.model.Task> getRelevantTasks() {
        return relevantTasks;
    }

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
    public void run() throws PccException {
        this.relevantTasks =
                new LinkedList<com.google.api.services.tasks.v1.model.Task>();

        initTasksByIds();

        final IsGoogleTaskRelevantCalculator calculator =
                getIsGoogleTaskRelevantCalculator();

        for (final com.google.api.services.tasks.v1.model.Task curTask : this.googleTasks) {
            calculator.setGoogleTask(curTask);
            calculator.run();

            if (calculator.isRelevant()) {
                relevantTasks.add(curTask);
            }
        }

        buildParentChildGraph();

        for (final com.google.api.services.tasks.v1.model.Task curTask : this.googleTasks) {
            final boolean taskRelevantByItself =
                relevantTasks.contains(curTask);
            final boolean taskParentOfRelevantTasks =
                    isTaskParentOfRelevantTasks(curTask);

            if (taskRelevantByItself || taskParentOfRelevantTasks) {
                this.relevantTasks.add(curTask);
            }
        }
    }

    private void initTasksByIds() {
        this.tasksByIds =
                new HashMap<String, com.google.api.services.tasks.v1.model.Task>();

        for (final com.google.api.services.tasks.v1.model.Task curTask : this.googleTasks) {
            this.tasksByIds.put(curTask.id, curTask);
        }
    }

    private boolean isTaskParentOfRelevantTasks(final Task aTask) {
        if (!this.parentChildGraph.containsVertex(aTask)) {
            return false;
        } else if (this.parentChildGraph.inDegreeOf(aTask) < 1) {
            return this.relevantTasks.contains(aTask);
        } else {
            final List<Task> childTasks = new LinkedList<Task>();

            for (final DefaultEdge curEdge : this.parentChildGraph
                    .incomingEdgesOf(aTask)) {
                final Task curChildTask =
                        this.parentChildGraph.getEdgeSource(curEdge);
                childTasks.add(curChildTask);
            }

            boolean relevantTaskFound = false;
            int i = 0;

            while (!relevantTaskFound && (i < childTasks.size())) {
                relevantTaskFound =
                        isTaskParentOfRelevantTasks(childTasks.get(i));
                i++;
            }

            return relevantTaskFound;
        }

    }

    private IsGoogleTaskRelevantCalculator getIsGoogleTaskRelevantCalculator() {
        final IsGoogleTaskRelevantCalculatorFactory factory =
                this.injector
                        .getInstance(IsGoogleTaskRelevantCalculatorFactory.class);
        final IsGoogleTaskRelevantCalculator calculator = factory.create();

        calculator.setInjector(this.injector);

        return calculator;
    }

    private void buildParentChildGraph() {
        parentChildGraph =
                new ListenableDirectedGraph<com.google.api.services.tasks.v1.model.Task, DefaultEdge>(
                        DefaultEdge.class);

        for (final com.google.api.services.tasks.v1.model.Task curTask : this.googleTasks) {
            if (!StringUtils.isBlank(curTask.parent)) {
                addVertexIfNecessary(curTask);

                com.google.api.services.tasks.v1.model.Task parentTask =
                        this.tasksByIds.get(curTask.parent);

                addVertexIfNecessary(parentTask);

                this.parentChildGraph.addEdge(curTask, parentTask);
            }
        }
    }

    private void addVertexIfNecessary(
            com.google.api.services.tasks.v1.model.Task aTask) {
        if (!this.parentChildGraph.containsVertex(aTask)) {
            this.parentChildGraph.addVertex(aTask);
        }
    }
}
