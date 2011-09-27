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

package at.silverstrike.pcc.api.gtaskexporter;

import java.io.File;

import ru.altruix.commons.api.conventions.SingleActivityModule;

/**
 * @author DP118M
 * 
 */
public interface GoogleTasksExporter extends SingleActivityModule {
    void setClientSecret(final String aClientSecret);

    void setClientId(final String aClientId);

    void setConsumerKey(final String aConsumerKey);

    void setTargetFile(final File aFile);

    void setRefreshToken(final String aGoogleTasksRefreshToken);
}
