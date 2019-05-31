package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Team;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

    private CookieService cookieService;

    public HomeController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @RequestMapping("/")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        return cookieService.isLoggedIn(request) ? "redirect:/portfolio" : "home";
    }

}