package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class CookieService {

    @Autowired
    @Qualifier("admins")
    private List<String> admins;

    @Autowired
    UserDao userDao;

    private final String disguiseCookieString = "H4PS2NHTIIX5J13OFEG6ZC7GRSO2H5F01VWHLDBP.";


    public void login(User user, HttpServletResponse response) {
        if (user != null) {
            Cookie cookie = new Cookie("_t1zd", disguiseCookieString + user.getID());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    }

    public boolean isLoggedIn(HttpServletRequest request) {
        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie allCookie : allCookies) {
                if (allCookie.getName().equals("_t1zd") && allCookie.getValue() != null) {
                    String userID = allCookie.getValue().replace(disguiseCookieString, "");
                    return true;
                }
            }
        }
        return false;
    }


    public void logout(HttpServletResponse response) {
        if (response != null) {
            Cookie cookie = new Cookie("_t1zd", "");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    public String getUserIdLoggedIn(HttpServletRequest request) {
        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie cookie : allCookies) {
                if (cookie.getName().equals("_t1zd") && cookie.getValue() != null) {
                    return cookie.getValue().replace(disguiseCookieString, "");
                }
            }
        }
        return null;
    }


    public boolean isUserAdmin(HttpServletRequest request) {
        User attemptedAdmin = userDao.getUserById(getUserIdLoggedIn(request));
        for (String AllowedAdmin : admins)
            if (AllowedAdmin.equals(attemptedAdmin.getEmail()))
                return true;
        return false;
    }


}
