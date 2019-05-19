package com.Borman.cbbbluechips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/2/{team}")
    public String welcome2(@PathVariable String team, Model model) {

        List<String> allStrings = Arrays.asList("Test1", "Test", "Test3");
        model.addAttribute("title", team);
        model.addAttribute("list", allStrings);
        System.out.println(team);
        return "index2";
    }

}
