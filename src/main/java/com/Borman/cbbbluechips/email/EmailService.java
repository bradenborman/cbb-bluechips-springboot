package com.Borman.cbbbluechips.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static com.Borman.cbbbluechips.zdata.PasswordRecoveryData.PASSWORD_RECOVERY_BODY;

@Service
public class EmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    private Logger logger = LoggerFactory.getLogger(EmailService.class);

    public boolean sendPasswordRecoveryEmail(String email, String password) {
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

        try {
            javaMailSender.send(message);
            logger.info("Mail sent");
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }

    }

    private String buildPasswordRecoveryEmailBody(String password) {
        return PASSWORD_RECOVERY_BODY.replace("${password}", password);
    }

}
