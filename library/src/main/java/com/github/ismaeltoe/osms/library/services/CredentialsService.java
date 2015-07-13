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

package com.github.ismaeltoe.osms.library.services;

import com.github.ismaeltoe.osms.library.entities.CredentialsEntity;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface CredentialsService {

    /**
     * Retrieves an access token from Orange server. Synchronous execution.
     *
     * @param grant_type must be set to "client_credentials"
     *
     * @return object made of the following fields: "access_token", "token_type", "expires_in"
     *
     * @see <a href="https://www.orangepartner.com/content/authorization-oauth2?api=sms_ci_product">
     *     https://www.orangepartner.com/content/authorization-oauth2?api=sms_ci_product</a>
     */
    @FormUrlEncoded
    @POST("/oauth/v2/token")
    CredentialsEntity getAccessToken(@Field("grant_type") String grant_type);

    /**
     * Retrieves an access token from Orange server. Asynchronous execution.
     *
     * @param grant_type must be set to "client_credentials"
     * @param callback Communicates the response from the server. If the request was successful,
     *                 the response will be a {@link CredentialsEntity} object
     *                 (accessible from <code>success</code> method). Otherwise an error
     *                 object (accessible from <code>failure</code> method).
     *
     * @see <a href="https://www.orangepartner.com/content/authorization-oauth2?api=sms_ci_product">
     *     https://www.orangepartner.com/content/authorization-oauth2?api=sms_ci_product</a>
     */
    @FormUrlEncoded
    @POST("/oauth/v2/token")
    void getAccessToken(@Field("grant_type") String grant_type, Callback<CredentialsEntity> callback);
}