package com.Borman.cbbbluechips.controllers;

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


    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/2/{team}")
    public String welcome2(@PathVariable String team, Model model) {
        model.addAttribute("title", team);
        model.addAttribute("list", userService.getAllUsers());
        System.out.println(team);
        return "index2";
    }

}
