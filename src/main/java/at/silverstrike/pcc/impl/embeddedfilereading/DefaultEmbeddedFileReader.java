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

package at.silverstrike.pcc.impl.embeddedfilereading;

import static org.apache.commons.io.FileUtils.openInputStream;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.embeddedfilereading.EmbeddedFileReader;

/**
 * @author Dmitri Pisarenko
 * 
 */
class DefaultEmbeddedFileReader implements EmbeddedFileReader {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DefaultEmbeddedFileReader.class);
    private String filename;
    private String fileContents;
    private ClassLoader classLoader;

    @Override
    public void run() throws PccException {
        if (this.classLoader == null) {
            this.classLoader = Thread.currentThread().getContextClassLoader();
        }

        InputStream inputStream = null;
        String projectTemplate = null;
        try {
            inputStream = this.classLoader.getResourceAsStream(this.filename);

            if (inputStream == null) {
                /**
                 * If we are here, it means that this code is invoked outside of
                 * the web application, e. g. in a unit test.
                 */
                inputStream =
                        openInputStream(new File(System.getProperty("user.dir")
                                +
                                "/src/main/webapp/WEB-INF/classes/"
                                + this.filename));
            }

            LOGGER.debug("inputStream: " + inputStream);
            LOGGER.debug("aFileName: " + this.filename);
            LOGGER.debug("pwd: " + System.getProperty("user.dir"));
            projectTemplate = IOUtils.toString(inputStream);
        } catch (final Exception exception) {
            LOGGER.debug("", exception);
            throw new PccException(exception);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        fileContents = projectTemplate;
    }

    @Override
    public void setFilename(final String aFileName) {
        this.filename = aFileName;
    }

    @Override
    public String getFileContents() {
        // TODO Auto-generated method stub
        return fileContents;
    }

    @Override
    public void setClassLoader(final ClassLoader aClassLoader) {
        this.classLoader = aClassLoader;
    }

}
