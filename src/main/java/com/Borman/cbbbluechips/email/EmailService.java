package com.Borman.cbbbluechips.email;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private JavaMailSenderImpl javaMailSender;


    public EmailService(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    private static final String receivingAddress = "bradenborman@hotmail.com";

    public void sendEmail() {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(receivingAddress);
            helper.setSubject("Test Email");
            helper.setText(buildEmailBody(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);

    }


    private String buildEmailBody() {
        return "<h2>TEST</h2>";
    }

}
