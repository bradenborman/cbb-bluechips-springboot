package com.Borman.cbbbluechips.controllers;


import com.Borman.cbbbluechips.models.Portfolio;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.OwnsService;
import com.Borman.cbbbluechips.services.PortfolioService;
import com.Borman.cbbbluechips.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    private CookieService cookieService;
    private UserService userService;
    private OwnsService ownsService;
    private PortfolioService portfolioService;

    public PortfolioController(CookieService cookieService, UserService userService, OwnsService ownsService, PortfolioService portfolioService) {
        this.cookieService = cookieService;
        this.userService = userService;
        this.ownsService = ownsService;
        this.portfolioService = portfolioService;
    }

    @RequestMapping("")
    public String portfolio(Model model, HttpServletRequest request, HttpServletResponse response) {
            if (!cookieService.isLoggedIn(request)) {
                return "redirect:/";
            } else {
                User user = userService.getUser(cookieService.getUserIdLoggedIn(request));
                user.setTeamsOwned(ownsService.getTeamsUserOwns(user.getID()));
                model.addAttribute("user", user);
                model.addAttribute("portfolio", portfolioService.getPortfolioDetails(user));
                return "portfolio";
            }
    }

}
