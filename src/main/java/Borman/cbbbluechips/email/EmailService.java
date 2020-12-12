package Borman.cbbbluechips.email;

import Borman.cbbbluechips.models.paypal.PaypalDonationRequest;
import Borman.cbbbluechips.utilities.HtmlTemplateLoader;
import Borman.cbbbluechips.zdata.PasswordRecoveryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    Logger logger = LoggerFactory.getLogger(EmailService.class);

    JavaMailSenderImpl javaMailSender;

    public EmailService(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendTermsAndServices(String email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setSubject("CBB Bluechips | Terms and Services");
            String htmlBody = HtmlTemplateLoader.loadFromTemplate("terms-and-service");
            helper.setText(htmlBody.replace("${email}", email), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        logger.info("Sending Terms and Service email to " + email);

        try {
            javaMailSender.send(message);
            logger.info("Mail sent");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

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

        logger.info("Sending Password Recovery email to " + email);

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
        return PasswordRecoveryData.PASSWORD_RECOVERY_BODY.replace("${password}", password);
    }


    public void sendUpdateEmail(PaypalDonationRequest paypalDonationRequest) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(paypalDonationRequest.getBuyerEmail());
            helper.addBcc("bradenborman00@gmail.com");
            helper.setSubject("CBB Bluechips | Donation Confirmed");
            helper.setText(buildDonationConfirmedEmailBody(paypalDonationRequest), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        logger.info("Sending Confirmed Payment Email to " + paypalDonationRequest.getBuyerEmail());

        try {
            javaMailSender.send(message);
            logger.info("Mail sent");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    private String buildDonationConfirmedEmailBody(PaypalDonationRequest request) {
        return PasswordRecoveryData.DONATION_CONFIRMED_BODY
                .replace("${order_id}", request.getOrderID())
                .replace("${description}", request.getPurchaseUnits().get(0).getDescription())
                .replace("${amount}", request.getPurchaseUnits().get(0).getAmount().getValue());
    }

}