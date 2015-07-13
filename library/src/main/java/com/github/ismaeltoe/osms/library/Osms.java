/*
 * Copyright 2015 Ismael Toé
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ismaeltoe.osms.library;

import android.util.Base64;

import com.github.ismaeltoe.osms.library.services.ContractsService;
import com.github.ismaeltoe.osms.library.services.CredentialsService;
import com.github.ismaeltoe.osms.library.services.MessagingService;
import com.github.ismaeltoe.osms.library.services.PurchaseHistoryService;
import com.github.ismaeltoe.osms.library.services.StatisticsService;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class Osms {

    private static final String API_URL = "https://api.orange.com";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    private RestAdapter restAdapter;

    private String clientId;
    private String clientSecret;
    private String accessToken;
    private boolean isDebug;

    /**
     * Gets a new API manager instance.
     */
    public Osms() {
    }

    /**
     * Gets a new API manager instance.
     *
     * @param clientId your client ID provided by Orange
     * @param clientSecret your client secret provided by Orange
     */
    public Osms(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Creates a new RestAdapter. Override this to e.g. set your own client or executor.
     *
     * @return A RestAdapter with no modifications.
     */
    protected RestAdapter.Builder newRestAdapterBuilder() {
        return new RestAdapter.Builder();
    }

    /**
     * Returns the current RestAdapter instance. If none exists (first call or API keys changed),
     * builds a new one.
     *
     * <p>When building, sets the endpoint, adds the access token to an Authorization HTTP header
     * and sets the log level.</p>
     */
    protected RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            RestAdapter.Builder builder = newRestAdapterBuilder();
            if (isDebug) {
                builder.setLogLevel(RestAdapter.LogLevel.FULL);
            }
            builder.setEndpoint(API_URL);
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String accessToken = getAccessToken();
                    if (accessToken != null && accessToken.length() != 0) {
                        request.addHeader(HEADER_AUTHORIZATION, "Bearer " + accessToken);
                    }
                }
            });
            restAdapter = builder.build();
        }
        return restAdapter;
    }

    /**
     * Returns the client ID.
     *
     * @return the client ID you have set
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the client ID.
     *
     * @param clientId your client ID provided by Orange
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
        // allows the usage of this client id in the next requests
        restAdapter = null;
    }

    /**
     * Returns the client secret.
     *
     * @return the client secret you have set
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Sets the client secret.
     *
     * @param clientSecret your client secret provided by Orange
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        // allows the usage of this client secret in the next requests
        restAdapter = null;
    }

    /**
     * Returns the access token.
     *
     * <p>It doesn't retrieve a new access token from Orange server but returns the current one you
     * have set via {@link #setAccessToken(String)} or retrieved
     * via {@link CredentialsService#getAccessToken}.</p>
     *
     * <p>To retrieve a new access token from Orange server, use
     * {@link CredentialsService#getAccessToken}.</p>
     *
     * @return the current access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token.
     *
     * @param accessToken the access token retrieved from Orange
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        // allows the usage of this access token in the next requests
        restAdapter = null;
    }

    /**
     * Returns the {@link #isDebug} value.
     *
     * @return the value of the debug log level parameter
     */
    public boolean getIsDebug() {
        return isDebug;
    }

    /**
     * Sets the debug log level.
     *
     * @param isDebug If true, the log level is set to FULL. Otherwise NONE.
     */
    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
        if (restAdapter != null) {
            restAdapter.setLogLevel(getIsDebug() ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
        }
    }

    /**
     * A Service wrapper around the Authorization API.
     *
     * @return an implementation of the {@link CredentialsService} interface
     */
    public CredentialsService credentials() {
        RestAdapter.Builder builder = newRestAdapterBuilder();
        if (isDebug) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }
        builder.setEndpoint(API_URL);
        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                String creds = getClientId() + ":" + getClientSecret();
                String base64EncodedCreds = Base64.encodeToString(creds.getBytes(), Base64.NO_WRAP);
                request.addHeader(HEADER_AUTHORIZATION, "Basic " + base64EncodedCreds);
            }
        });
        return builder.build().create(CredentialsService.class);
    }

    /**
     * A Service wrapper around the Contracts API.
     *
     * @return an implementation of the {@link ContractsService} interface
     */
    public ContractsService contracts() {
        return getRestAdapter().create(ContractsService.class);
    }

    /**
     * A Service wrapper around the Purchase History API.
     *
     * @return an implementation of the {@link PurchaseHistoryService} interface
     */
    public PurchaseHistoryService purchaseHistory() {
        return getRestAdapter().create(PurchaseHistoryService.class);
    }

    /**
     * A Service wrapper around the Statistics API.
     *
     * @return an implementation of the {@link StatisticsService} interface
     */
    public StatisticsService statistics() {
        return getRestAdapter().create(StatisticsService.class);
    }

    /**
     * A Service wrapper around the Messaging API.
     *
     * @return an implementation of the {@link MessagingService} interface
     */
    public MessagingService messaging() {
        return getRestAdapter().create(MessagingService.class);
    }
}
