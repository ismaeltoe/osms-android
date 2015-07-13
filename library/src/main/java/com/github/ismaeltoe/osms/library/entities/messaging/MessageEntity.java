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

package com.github.ismaeltoe.osms.library.entities.messaging;

public class MessageEntity {

    private OutboundSMSMessageRequest outboundSMSMessageRequest;

    /**
     * Builds a {@link MessageEntity} object.
     */
    public MessageEntity() {
    }

    /**
     * Builds a {@link MessageEntity} object.
     *
     * @param outboundSMSMessageRequest content of the object to post on the messaging request
     */
    public MessageEntity(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }

    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    /**
     * Sets the {@link OutboundSMSMessageRequest} object.
     *
     * @param outboundSMSMessageRequest content of the object to post on the messaging request
     */
    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }
}
