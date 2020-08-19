package com.Borman.cbbbluechips.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

    Logger logger = LoggerFactory.getLogger(PlainTextPasswordEncoder.class);

    @Override
    public String encode(CharSequence charSequence) {
        String password = charSequence.toString();
//        logger.info("Password: {}", password);
        return password;
    }

    @Override
    public boolean matches(CharSequence entered, String realPassword) {
//        logger.info("Password: {} | Password Entered: {}", realPassword, entered.toString());
        return entered.toString().equals(realPassword);
    }

}