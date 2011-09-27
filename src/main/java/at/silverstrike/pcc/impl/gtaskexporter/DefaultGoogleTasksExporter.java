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

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import com.google.api.client.auth.oauth2.draft10.AccessTokenResponse;
import com.google.api.client.googleapis.auth.oauth2.draft10.GoogleAccessProtectedResource;
import com.google.api.client.googleapis.auth.oauth2.draft10.GoogleAccessTokenRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.tasks.v1.Tasks;

import at.silverstrike.pcc.api.gtaskexporter.GoogleTasksExporter;

/**
 * @author DP118M
 * 
 */
class DefaultGoogleTasksExporter implements GoogleTasksExporter {
    private static final String LINE_SEPARATOR_PLACEHOLDER = "${lineSeparator}";
    private static final String POSITION = "${position}";
    private static final String COMPLETED = "${completed}";
    private static final String NOTES = "${notes}";
    private static final String PARENT = "${parent}";
    private static final String TITLE = "${title}";
    private static final String ID = "${id}";
    private static final String LINE_TEMPLATE = "${id};${title};${parent};${notes};${completed};${position}${lineSeparator}";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private String clientSecret;
    private String clientId;
    private String consumerKey;
    private String refreshToken;
    private File targetFile;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultGoogleTasksExporter.class);

    @Override
    public void run() throws PccException {

        final HttpTransport httpTransport = new NetHttpTransport();
        final JacksonFactory jsonFactory = new JacksonFactory();

        try {
            final AccessTokenResponse response =
                    new GoogleAccessTokenRequest.GoogleRefreshTokenGrant(
                            httpTransport,
                            jsonFactory,
                            clientId, clientSecret,
                            refreshToken)
                            .execute();

            final GoogleAccessProtectedResource accessProtectedResource =
                    new GoogleAccessProtectedResource(
                            response.accessToken, httpTransport, jsonFactory,
                            clientId, clientSecret,
                            refreshToken);

            final Tasks service =
                    new Tasks(httpTransport, accessProtectedResource,
                            jsonFactory);
            service.setApplicationName(this.consumerKey);

            final StringBuilder fileContents = new StringBuilder();

            final String[] searchList =
                    new String[] { ID, TITLE, PARENT,
                            NOTES, COMPLETED, POSITION,
                            LINE_SEPARATOR_PLACEHOLDER };

            final com.google.api.services.tasks.v1.model.Tasks tasks =
                    service.tasks.list("@default").execute();

            for (final com.google.api.services.tasks.v1.model.Task curTask : tasks.items) {

                final String[] replacementList =
                        new String[] { curTask.id, curTask.title, curTask.parent,
                                curTask.notes, curTask.completed, curTask.position,
                                LINE_SEPARATOR };

                fileContents.append(StringUtils.replaceEach(LINE_TEMPLATE,
                        searchList, replacementList));
            }

            FileUtils.writeStringToFile(this.targetFile,
                    fileContents.toString());
        } catch (final IOException exception) {
            LOGGER.error("", exception);
        }
    }

    public void setClientSecret(final String aClientSecret) {
        this.clientSecret = aClientSecret;
    }

    public void setClientId(final String aClientId) {
        this.clientId = aClientId;
    }

    public void setConsumerKey(final String aConsumerKey) {
        this.consumerKey = aConsumerKey;
    }

    public void setTargetFile(final File aTargetFile) {
        this.targetFile = aTargetFile;
    }

    public void setRefreshToken(final String aRefreshToken) {
        this.refreshToken = aRefreshToken;
    }

}
