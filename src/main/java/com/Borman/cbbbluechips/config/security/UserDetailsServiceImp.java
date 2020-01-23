package com.Borman.cbbbluechips.config.security;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.getUserByEmail(username);

        if (user != null) {
            UserBuilder builder;
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));

            if (username.equals("bradenborman@hotmail.com"))
                builder.roles("PLAYER", "ADMIN");
            else
                builder.roles("PLAYER");

            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

    }

}
