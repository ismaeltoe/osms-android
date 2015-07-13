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

public class OutboundSMSTextMessage {

    private String message;

    /**
     * Builds an {@link OutboundSMSTextMessage} object.
     */
    public OutboundSMSTextMessage() {
    }

    /**
     * Builds an {@link OutboundSMSTextMessage} object.
     *
     * @param message Content of the message to send. Must not exceed 160 characters.
     */
    public OutboundSMSTextMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Sets the message to send.
     *
     * @param message Content of the message to send. Must not exceed 160 characters.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
