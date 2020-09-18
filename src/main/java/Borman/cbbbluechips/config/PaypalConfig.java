package Borman.cbbbluechips.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="paypal")
public class PaypalConfig {

    private String clientId;
    private double entryFee;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public String getPayPalUrl() {
        return  "https://www.paypal.com/sdk/js?client-id=${client_id}&disable-funding=credit,card"
                .replace("${client_id}", clientId);
    }

}