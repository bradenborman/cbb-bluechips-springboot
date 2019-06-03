package com.Borman.cbbbluechips.controllers;


import com.Borman.cbbbluechips.services.CommentService;
import com.Borman.cbbbluechips.services.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/comments")
public class CommentController {


    @Autowired
    CommentService commentService;

    @Autowired
    CookieService cookieService;

    @RequestMapping("")
    public String comments(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("comments", commentService.getComments());
        return "comments";
    }

    //TODO
    @PostMapping("/submitReply")
    public String submitReply(HttpServletRequest request, @RequestParam("reply") String reply, @RequestParam("commentId") String parentId) {
        String userId = cookieService.getUserIdLoggedIn(request);
        commentService.createReplyToParentComment(userId, reply, parentId);
        return "redirect:/comments";
    }

    //TODO
    @PostMapping("/submitNew")
    public String submitNew(@RequestParam("comment") String comment) {
        return "redirect:/comments";
    }

}
