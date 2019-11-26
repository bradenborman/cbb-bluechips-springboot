package com.Borman.cbbbluechips.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CCBConfig {

    @Bean(name = "dataSource")
    @Primary
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    @Bean("Twilio_Auth")
    public String getTwilio_Auth() {
        return System.getenv("Twilio_Auth");
    }

    @Bean("Twilio_ACCOUNT_SID")
    public String getTwilio_ACCOUNT_SID() {
        return System.getenv("Twilio_ACCOUNT_SID");
    }

    @Bean("SportsDataApiKey")
    public String getSportsDataApiKey() {
        return System.getenv("SportsDataApiKey");
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean("startingCash")
    public int getStartingCash(@Value("${game-rules.starting-cash}") int startingCash) {
        return startingCash;
    }

    @Bean("sportsDataUrl")
    public String getSportsDataUrl(@Value("${sports-data-api.url}") String sportsDataUrl) {
        return sportsDataUrl;
    }

    @Bean("admins")
    public List<String> getAdmins(@Value("${admins}") String[] admins) {
        return Arrays.asList(admins);
    }

    @Bean("make_api_call")
    public boolean getMakeApiCall() {
        return Boolean.parseBoolean(System.getenv("Make_Api_Call"));
    }


}