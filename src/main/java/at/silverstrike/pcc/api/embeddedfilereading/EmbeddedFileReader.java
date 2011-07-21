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

package at.silverstrike.pcc.api.embeddedfilereading;

import ru.altruix.commons.api.conventions.SingleActivityModule;

/**
 * @author Dmitri Pisarenko
 * 
 */
public interface EmbeddedFileReader extends SingleActivityModule {
    void setFilename(final String aFileName);
    void setClassLoader(final ClassLoader aClassLoader);
    
    String getFileContents();
}
