package com.Borman.cbbbluechips.email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    Logger logger = LoggerFactory.getLogger(EmailService.class);

    private static final String receivingAddress = "bradenborman@hotmail.com";

    public void sendTESTEmail() {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(receivingAddress);
            helper.setSubject("Test Email");
            helper.setText(buildEmailTestBody(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);

    }

    private String buildEmailTestBody() {
        return "<h2>TEST</h2>";
    }


    public void sendPasswordRecoveryEmail(String email, String password) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setSubject("Password Recovery | CBB Bluechips");
            helper.setText(buildPasswordRecoveryEmailBody(password), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        logger.info("Sending Email to " + email);
        javaMailSender.send(message);

    }

    private String buildPasswordRecoveryEmailBody(String password) {

        return "<p style=\"font-size: 1.3em;\">As requested, here is your password: <i><b>" + password + "</b></i></p>" +
                "<br /><br /><p>Thank you again for playing and making this possible.</p><p>Braden Borman<br/>573 826-1903</p>";
    }


}
