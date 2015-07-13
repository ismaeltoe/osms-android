# osms-android

Provides an Android wrapper for the Orange SMS API.

## Usage

**Send a message**

```java
Osms osms = new Osms();
osms.setAccessToken('YOUR_ACCESS_TOKEN');

MessagingService messagingService = osms.messaging();

OutboundSMSTextMessage outboundSMSTextMessage = new OutboundSMSTextMessage("Hello World!");

OutboundSMSMessageRequest outboundSMSMessageRequest = new OutboundSMSMessageRequest(
    "tel:+22500000000", // the receiver address
	outboundSMSTextMessage,
	"tel:+22500000000", // the sender address
	"Optimus Prime" // the sender name
);

MessageEntity messageEntity = new MessageEntity(outboundSMSMessageRequest);

messagingService.sendMessage(
    "tel:+22500000000", // the sender address
	messageEntity,
	new Callback<MessageEntity>() {
	    @Override
		public void success(MessageEntity messageEntity, Response response) {
		    // the message has been sent
		}
		
		@Override
		public void failure(RetrofitError error) {
		    // an error has occured
		}
	}
)
```

See the [sample app](https://github.com/ismaeltoe/osms-android/tree/master/app/src/main) for more examples.

## Download

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ismaeltoe/osms-android/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ismaeltoe/osms-android)

Add the following dependency to your Gradle project:

```groovy
    compile 'com.github.ismaeltoe:osms-android:1.0'
```

## Reference

 * Native API [https://www.orangepartner.com/SMS-CI-API](https://www.orangepartner.com/SMS-CI-API)
 
## Developed By

 * Ismael Toé - <ismael.toe@gmail.com>

## License

    Copyright 2015 Ismael Toé

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.