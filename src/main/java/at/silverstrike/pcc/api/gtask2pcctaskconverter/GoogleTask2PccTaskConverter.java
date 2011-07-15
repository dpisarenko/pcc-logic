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

package at.silverstrike.pcc.api.gtask2pcctaskconverter;

import at.silverstrike.pcc.api.model.UserData;
import ru.altruix.commons.api.conventions.SingleActivityModule;
import ru.altruix.commons.api.di.ModuleWithInjectableDependencies;

/**
 * @author DP118M
 * 
 */
public interface GoogleTask2PccTaskConverter extends SingleActivityModule,
        ModuleWithInjectableDependencies {
    void setGoogleTask(final com.google.api.services.tasks.v1.model.Task aTask);

    at.silverstrike.pcc.api.model.Task getPccTask();

    void setUser(final UserData aUser);
}
