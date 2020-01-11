package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.services.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/rules")
public class RulesController {

    @Autowired
    CookieService cookieService;

    @RequestMapping("")
    public String portfolio(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", cookieService.isLoggedIn(request));
        return "rules";
    }

    @RequestMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

}