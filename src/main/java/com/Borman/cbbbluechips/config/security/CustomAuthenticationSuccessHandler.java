package com.Borman.cbbbluechips.config.security;

import com.Borman.cbbbluechips.daos.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserDao userDao;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        com.Borman.cbbbluechips.models.User user = userDao.getUserByEmail(authUser.getUsername());

        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());
        session.setAttribute("user_id", user.getID());

        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        System.out.println("HERE");

        httpServletResponse.sendRedirect("/leaderboard");

    }
}