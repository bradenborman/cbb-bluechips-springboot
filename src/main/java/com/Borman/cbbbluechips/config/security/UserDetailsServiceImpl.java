package com.Borman.cbbbluechips.config.security;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private UserDao userDao;
    private List<String> admins;

    public UserDetailsServiceImpl(UserDao userDao, @Qualifier("admins") List<String> admins) {
        this.userDao = userDao;
        this.admins = admins;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Looking up user: {}", email);
        User user = userDao.getUserByEmail(email);

        user.addAuthority("CBB_USER");
        if(admins.contains(user.getUsername()))
            user.addAuthority("CBB_ADMIN");

        return user;
    }
}