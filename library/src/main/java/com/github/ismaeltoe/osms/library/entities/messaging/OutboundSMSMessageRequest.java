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

public class OutboundSMSMessageRequest {

    private String address;
    private OutboundSMSTextMessage outboundSMSTextMessage;
    private String senderAddress;
    private String senderName;

    /**
     * Builds an {@link OutboundSMSMessageRequest} object.
     */
    public OutboundSMSMessageRequest() {

    }

    /**
     * Builds an {@link OutboundSMSMessageRequest} object.
     *
     * @param address the receiver address, the MSISDN including the "tel:" protocol identifier and
     *                the country code prefixed by "+" (i.e. tel:+16309700001)
     * @param outboundSMSTextMessage object containing the message to send
     * @param senderAddress the sender address, the MSISDN including the "tel:" protocol identifier
     *                      and the country code prefixed by "+" (i.e. tel:+16309700001)
     * @param senderName name of the sender to appear on the terminal
     */
    public OutboundSMSMessageRequest(String address, OutboundSMSTextMessage outboundSMSTextMessage,
                                     String senderAddress, String senderName) {
        this.address = address;
        this.outboundSMSTextMessage = outboundSMSTextMessage;
        this.senderAddress = senderAddress;
        this.senderName = senderName;
    }

    public String getAddress() {
        return address;
    }

    public OutboundSMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets the receiver address.
     *
     * @param address the receiver address, the MSISDN including the "tel:" protocol identifier and the
     *                country code prefixed by "+". (i.e. tel:+16309700001)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the {@link OutboundSMSTextMessage} object.
     *
     * @param outboundSMSTextMessage object containing the message to send
     */
    public void setOutboundSMSTextMessage(OutboundSMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

    /**
     * Sets the sender address.
     *
     * @param senderAddress the sender address, the MSISDN including the "tel:" protocol identifier
     *                      and the country code prefixed by "+" (i.e. tel:+16309700001)
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * Sets the sender name.
     *
     * @param senderName name of the sender to appear on the terminal
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
