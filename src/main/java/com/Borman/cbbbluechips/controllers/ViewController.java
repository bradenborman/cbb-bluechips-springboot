package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.services.TransactionService;
import com.Borman.cbbbluechips.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    UserService userService;

    @Autowired
    TeamDao teamDao;

    @Autowired
    TransactionService transactionService;


    @RequestMapping("/")
    public String welcome() {
        return "apiHelp";
    }

    @RequestMapping("/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("title", "My Portfolio");
        model.addAttribute("teams", teamDao.getAllTeams());
        return "portfolio";
    }

    @RequestMapping("/market")
    public String market(Model model) {
        model.addAttribute("title", "Market");
        model.addAttribute("teams", teamDao.getAllTeams());
        return "market";
    }


}
