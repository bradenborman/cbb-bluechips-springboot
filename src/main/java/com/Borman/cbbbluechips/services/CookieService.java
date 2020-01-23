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
            Cookie cookie = new Cookie("_t1zd", disguiseCookieString + getDisguiseId(user.getID()));
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

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getUserIdLoggedIn(HttpServletRequest request) {
        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie cookie : allCookies) {
                if (cookie.getName().equals("_t1zd") && cookie.getValue() != null) {
                    return parseDisguiseId(cookie.getValue().replace(disguiseCookieString, ""));
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
//
//    private String disguisedId(String id) {
//        int idx = Integer.parseInt(id);
//        return String.valueOf(idx * 250);
//    }
//
//    private String getDisguisedId(String id) {
//        int idx = Integer.parseInt(id);
//        return String.valueOf(idx / 250);
//    }


    String getDisguiseId(String id) {

        StringBuilder hashed = new StringBuilder();

        String[] idSplit = id.split("");

        for (String s : idSplit) {
            hashed.append(getLetter(s));
        }

        return hashed.toString();
    }

    String parseDisguiseId(String hashed) {

        StringBuilder idString = new StringBuilder();

        String[] idSplit = hashed.split("");

        for (String s : idSplit) {
            idString.append(parseLetter(s));
        }

        return idString.toString();
    }

    private char getLetter(String id) {

        switch (id) {

            case "0":
                return  'Q';

            case "1":
                return  'W';

            case "2":
                return  'E';

            case "3":
                return  'R';

            case "4":
                return  'T';

            case "5":
                return  'Y';

            case "6":
                return  'U';

            case "7":
                return  'I';

            case "8":
                return  'O';

            case "9":
                return  'P';

            default:
                return ' ';
        }

    }

    private char parseLetter(String letter) {

        switch (letter) {

            case "Q":
                return  '0';

            case "W":
                return  '1';

            case "E":
                return  '2';

            case "R":
                return  '3';

            case "T":
                return  '4';

            case "Y":
                return  '5';

            case "U":
                return  '6';

            case "I":
                return  '7';

            case "O":
                return  '8';

            case "P":
                return  '9';

            default:
                return ' ';
        }

    }

}
