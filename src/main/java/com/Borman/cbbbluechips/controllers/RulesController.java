package com.Borman.cbbbluechips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rules")
public class RulesController {

    @RequestMapping("")
    public String portfolio(Model model) {
     return "rules";
    }

}