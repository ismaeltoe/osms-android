package com.github.ismaeltoe.osms.sample;

import com.github.ismaeltoe.osms.library.entities.messaging.MessageEntity;
import com.github.ismaeltoe.osms.library.entities.messaging.OutboundSMSMessageRequest;
import com.github.ismaeltoe.osms.library.entities.messaging.OutboundSMSTextMessage;

/**
 * Created by Ismael on 08/07/2015.
 */
public interface Constants {

    String CLIENT_ID = "";
    String CLIENT_SECRET = "";
    String ACCESS_TOKEN = "";

    String COUNTRY = "CIV";

    String SENDER_ADDRESS = "tel:+22500000000";
    String RECEIVER_ADDRESS = "tel:+22500000000";
    String MESSAGE = "Hello World!";
    String SENDER_NAME = "";

    OutboundSMSTextMessage OUTBOUND_SMS_TEXT_MESSAGE = new OutboundSMSTextMessage(MESSAGE);

    OutboundSMSMessageRequest OUTBOUND_SMS_MESSAGE_REQUEST = new OutboundSMSMessageRequest(
            RECEIVER_ADDRESS,
            OUTBOUND_SMS_TEXT_MESSAGE,
            SENDER_ADDRESS,
            SENDER_NAME
    );

    MessageEntity MESSAGE_ENTITY = new MessageEntity(OUTBOUND_SMS_MESSAGE_REQUEST);
}
