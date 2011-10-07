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

package at.silverstrike.pcc.api.gtaskprioritycalculator;

import java.util.Map;

import ru.altruix.commons.api.conventions.SingleActivityModule;

/**
 * @author DP118M
 * 
 */
public interface GoogleTasksPriorityCalculator extends SingleActivityModule {
            public static final int HIGHEST_PRIORITY = 800;
            public static final int PRIORITY_STEP = 10;

            void
            setTasks(
                    final Map<String, com.google.api.services.tasks.v1.model.Task> aTasksByTaskIds);

    Map<String, Integer> getPrioritiesByTaskIds();
}
