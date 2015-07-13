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

import com.github.ismaeltoe.osms.library.entities.statistic.StatisticEntity;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface StatisticsService {

    /**
     * Lists the usage statistics per contract. Allows filtering by country and application id.
     * Synchronous execution.
     *
     * @param country ISO 3166 alpha 3 country code (e.g. CIV, see
     *                <a href="https://fr.wikipedia.org/wiki/ISO_3166-1">
     *                    https://fr.wikipedia.org/wiki/ISO_3166-1)</a>.
     *                    If {@code null} no filtering by country.
     * @param appId The application ID, you can retrieve it from your dashboard application.
     *              If {@code null} no filtering by application ID.
     *
     * @return object containing information about your SMS usage per application and per country
     *
     * @see <a href="https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getstats">
     *     https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getstats</a>
     */
    @GET("/sms/admin/v1/statistics")
    StatisticEntity getStatistics(
            @Query("country") String country,
            @Query("appid") String appId
    );

    /**
     * Lists the usage statistics per contract. Allows filtering by country and application id.
     * Asynchronous execution.
     *
     * @param country ISO 3166 alpha 3 country code (e.g. CIV, see
     *                <a href="https://fr.wikipedia.org/wiki/ISO_3166-1">
     *                    https://fr.wikipedia.org/wiki/ISO_3166-1)</a>.
     *                    If {@code null} no filtering by country.
     * @param appId The application ID, you can retrieve it from your dashboard application.
     *              If {@code null} no filtering by application ID.
     * @param callback Communicates the response from the server. If the request was successful,
     *                 the response will be a {@link StatisticEntity} object
     *                 (accessible from <code>success</code> method). Otherwise an error
     *                 object (accessible from <code>failure</code> method).
     *
     * @see <a href="https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getstats">
     *     https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getstats</a>
     */
    @GET("/sms/admin/v1/statistics")
    void getStatistics(
            @Query("country") String country,
            @Query("appid") String appId,
            Callback<StatisticEntity> callback
    );
}
