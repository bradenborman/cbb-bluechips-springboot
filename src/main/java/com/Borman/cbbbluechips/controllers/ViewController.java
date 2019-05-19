package com.Borman.cbbbluechips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/2/{team}")
    public String welcome2(@PathVariable String team, Model model) {
        model.addAttribute("title", team);
        System.out.println(team);
        return "index2";
    }

}
