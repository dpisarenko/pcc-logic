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

package at.silverstrike.pcc.api.gtaskrelevance2;

import java.util.List;

import ru.altruix.commons.api.conventions.SingleActivityModule;
import ru.altruix.commons.api.di.ModuleWithInjectableDependencies;

/**
 * @author DP118M
 * 
 */
public interface RelevantTaskSetCalculator extends SingleActivityModule,
        ModuleWithInjectableDependencies {
    void setGoogleTasks(
            final List<com.google.api.services.tasks.v1.model.Task> aTasks);

    List<com.google.api.services.tasks.v1.model.Task> getRelevantTasks();
}
