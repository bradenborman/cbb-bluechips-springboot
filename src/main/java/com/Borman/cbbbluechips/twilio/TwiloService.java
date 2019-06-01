package com.Borman.cbbbluechips.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class TwiloService {


    private static final String applicationsPhoneNumber = "15732791590";
    private static final String ACCOUNT_SID = "AC6af1055b717a97f8dee68ce32b01b6fb";
    private static final String AUTH_TOKEN = "f42c86dbe4705c6eb8fe88f8642e82a8";


    public static void sendMessage(String phoneNumber, String Body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(applicationsPhoneNumber), Body).create();
        System.out.println("Message Sent");
    }


}
