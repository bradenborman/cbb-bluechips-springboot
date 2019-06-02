package com.Borman.cbbbluechips.twilio;

import com.Borman.cbbbluechips.models.MarketValue;
import com.Borman.cbbbluechips.models.SMS_Alert;
import com.Borman.cbbbluechips.services.OwnsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TwiloService {


    @Autowired
    OwnsService ownsService;

    private final String applicationsPhoneNumber = "15732791590";
    private final String ACCOUNT_SID = "AC6af1055b717a97f8dee68ce32b01b6fb";


    @Autowired
    @Qualifier("Twilio_Auth")
    private String AUTH_TOKEN;


    public void sendMessage(String phoneNumber, String Body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(applicationsPhoneNumber), Body).create();
        System.out.println("Message Sent");
    }



    public void sendPriceChangeAlert(MarketValue marketValue) {
      List<SMS_Alert> textsToSend = ownsService.getUsersWhoOwnedTeamWithTextAlertOn(marketValue.getTeamId());
      textsToSend.forEach(text ->
               sendMessage(text.getPhoneNumber(), TwiloBodyBuilderUtility.buildGameCompletedMessage(marketValue.getTeamName(), text.getAmountOwned(), marketValue.getPrice()))
       );

    }

}
