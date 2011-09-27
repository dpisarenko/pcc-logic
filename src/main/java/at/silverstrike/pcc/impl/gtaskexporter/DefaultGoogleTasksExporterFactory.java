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

package at.silverstrike.pcc.impl.gtaskexporter;

import at.silverstrike.pcc.api.gtaskexporter.GoogleTasksExporter;
import at.silverstrike.pcc.api.gtaskexporter.GoogleTasksExporterFactory;

/**
 * @author DP118M
 *
 */
public final class DefaultGoogleTasksExporterFactory implements
        GoogleTasksExporterFactory {

    @Override
    public GoogleTasksExporter create() {
        return new DefaultGoogleTasksExporter();
    }

}
