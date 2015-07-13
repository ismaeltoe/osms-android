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

import com.github.ismaeltoe.osms.library.entities.purchase.PurchaseEntity;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface PurchaseHistoryService {

    /**
     * Lists your purchase history. Allows filtering by country. Synchronous execution.
     *
     * @param country ISO 3166 alpha 3 country code (e.g. CIV, see
     *                <a href="https://fr.wikipedia.org/wiki/ISO_3166-1">
     *                    https://fr.wikipedia.org/wiki/ISO_3166-1)</a>.
     *                    If {@code null} no filtering.
     *
     * @return object containing information about your SMS bundle(s) purchase history
     *
     * @see <a href="https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getpo">
     *     https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getpo</a>
     */
    @GET("/sms/admin/v1/purchaseorders")
    PurchaseEntity getPurchaseOrders(@Query("country") String country);

    /**
     * Lists your purchase history. Allows filtering by country. Asynchronous execution.
     *
     * @param country ISO 3166 alpha 3 country code (e.g. CIV, see
     *                <a href="https://fr.wikipedia.org/wiki/ISO_3166-1">
     *                    https://fr.wikipedia.org/wiki/ISO_3166-1)</a>.
     *                    If {@code null} no filtering.
     * @param callback Communicates the response from the server. If the request was successful,
     *                 the response will be a {@link PurchaseEntity} object
     *                 (accessible from <code>success</code> method). Otherwise an error
     *                 object (accessible from <code>failure</code> method).
     *
     * @see <a href="https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getpo">
     *     https://www.orangepartner.com/content/getting-started-sms?api=sms_ci_product#getpo</a>
     */
    @GET("/sms/admin/v1/purchaseorders")
    void getPurchaseOrders(
            @Query("country") String country,
            Callback<PurchaseEntity> callback
    );
}
