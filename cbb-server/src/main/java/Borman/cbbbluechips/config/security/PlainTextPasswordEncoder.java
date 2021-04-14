package Borman.cbbbluechips.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        String password = charSequence.toString();
        return password;
    }

    @Override
    public boolean matches(CharSequence entered, String realPassword) {
        return entered.toString().equals(realPassword);
    }

}