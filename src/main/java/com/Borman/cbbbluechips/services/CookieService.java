package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {

    public void login(User user, HttpServletResponse response) {
        if (user != null) {
            Cookie cookie = new Cookie("user_id", user.getID());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    }

    //TODO redo inquire to check if exists so no one modified it
    public boolean isLoggedIn(HttpServletRequest request) {
        Cookie[] allCookies = request.getCookies();

        if(allCookies != null) {
            for (Cookie allCookie : allCookies) {
                if (allCookie.getName().equals("user_id") && allCookie.getValue() != null)
                    return true;
            }
        }
        return false;
    }


}
