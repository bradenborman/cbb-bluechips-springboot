package com.Borman.cbbbluechips.twilio;

import com.Borman.cbbbluechips.models.MarketValue;
import com.Borman.cbbbluechips.models.SMS_Alert;
import com.Borman.cbbbluechips.services.OwnsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TwiloService {

    private final String APPLICATION_PHONE_NUMBER = "15732791590";

    private OwnsService ownsService;
    private String ACCOUNT_SID;
    private String AUTH_TOKEN;

    public TwiloService(OwnsService ownsService, @Qualifier("Twilio_ACCOUNT_SID") String ACCOUNT_SID, @Qualifier("Twilio_Auth") String AUTH_TOKEN) {
        this.ownsService = ownsService;
        this.ACCOUNT_SID = ACCOUNT_SID;
        this.AUTH_TOKEN = AUTH_TOKEN;
    }

    public void sendPriceChangeAlert(MarketValue marketValue) {
        List<SMS_Alert> textsToSend = ownsService.getUsersWhoOwnedTeamWithTextAlertOn(marketValue.getTeamId());
        textsToSend.forEach(text -> {
                    if (!"".equals(text.getPhoneNumber()) || text.getPhoneNumber() != null)
                        sendMessage(text.getPhoneNumber(), TwiloBodyBuilderUtility.buildGameCompletedMessage(marketValue.getTeamName(), text.getAmountOwned(), marketValue.getPrice()));
                }
        );
    }

    public void sendMessage(String phoneNumber, String Body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(APPLICATION_PHONE_NUMBER), Body).create();
        System.out.println("Message Sent");
    }


}
