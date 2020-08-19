package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.CalculatorDetail;
import com.Borman.cbbbluechips.models.Portfolio;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/rules")
public class RulesController {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping("")
    public String portfolio(Model model) {
        model.addAttribute("loggedIn", !"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "rules";
    }

    @RequestMapping("/calculator")
    public String calculator(Model model) {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e) {
            return "calculator";
        }
        CalculatorDetail detail = calculatorService.getCalculatorDetails(user.getID());
        model.addAttribute("calculatorDetail", detail);
        return detail.getTeamNamePlaying() == null ? "calculator" : "calculator-personalized";
    }

}