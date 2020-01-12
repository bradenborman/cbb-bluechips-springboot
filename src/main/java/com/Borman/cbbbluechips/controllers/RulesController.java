package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.CalculatorDetail;
import com.Borman.cbbbluechips.models.Portfolio;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/rules")
public class RulesController {

    @Autowired
    CookieService cookieService;

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping("")
    public String portfolio(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", cookieService.isLoggedIn(request));
        return "rules";
    }


    @RequestMapping("/calculator")
    public String calculator(Model model, HttpServletRequest request) {
        if (cookieService.isLoggedIn(request)) {
            CalculatorDetail detail = calculatorService.getCalculatorDetails(cookieService.getUserIdLoggedIn(request));
            model.addAttribute("calculatorDetail", detail);
            return detail.getTeamNamePlaying() == null ? "calculator" : "calculator-personalized";
        }
        return "calculator";

    }

}