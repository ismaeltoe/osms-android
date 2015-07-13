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

import com.github.ismaeltoe.osms.library.entities.messaging.MessageEntity;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

public interface MessagingService {

    /**
     * Sends a SMS message. Synchronous execution.
     *
     * @param senderAddress the MSISDN, including the "tel:" protocol identifier and the country
     *                      code prefixed by '+', of the sender
     * @param messageEntity object containing the sender address, the receiver address, the sender
     *                      name and the message to be sent
     *
     * @return the same object as the one posted on request
     *
     * @see <a href="https://www.orangepartner.com/content/api-reference-messaging-sms?api=sms_ci_product">
     *     https://www.orangepartner.com/content/api-reference-messaging-sms?api=sms_ci_product</a>
     */
    @Headers("Content-Type: application/json")
    @POST("/smsmessaging/v1/outbound/{senderAddress}/requests")
    MessageEntity sendMessage(
            @Path("senderAddress") String senderAddress,
            @Body MessageEntity messageEntity
    );

    /**
     * Sends a SMS message. Asynchronous execution.
     *
     * @param senderAddress the MSISDN, including the "tel:" protocol identifier and the country
     *                      code prefixed by '+', of the sender
     * @param messageEntity object containing the sender address, the receiver address,
     *                                  the sender name and the message to be sent
     * @param callback Communicates the response from the server. If the request was successful,
     *                 the response will be a {@link MessageEntity} object
     *                 (accessible from <code>success</code> method). Otherwise an error
     *                 object (accessible from <code>failure</code> method).
     *
     * @see <a href="https://www.orangepartner.com/content/api-reference-messaging-sms?api=sms_ci_product">
     *     https://www.orangepartner.com/content/api-reference-messaging-sms?api=sms_ci_product</a>
     */
    @Headers("Content-Type: application/json")
    @POST("/smsmessaging/v1/outbound/{senderAddress}/requests")
    void sendMessage(
            @Path("senderAddress") String senderAddress,
            @Body MessageEntity messageEntity,
            Callback<MessageEntity> callback
    );
}
