package com.Borman.cbbbluechips.controllers;


import com.Borman.cbbbluechips.models.Comment;
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
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {


    @Autowired
    CommentService commentService;

    @Autowired
    CookieService cookieService;

    @RequestMapping("")
    public String comments(HttpServletRequest request, HttpServletResponse response, Model model) {
        if(!cookieService.isLoggedIn(request))
            return "redirect:/";
        String userId = cookieService.getUserIdLoggedIn(request);
        model.addAttribute("comments", commentService.getComments(userId, cookieService.isUserAdmin(request)));
        return "comments-new";
    }


    @PostMapping("/submitReply")
    public String submitReply(HttpServletRequest request, @RequestParam("reply") String reply, @RequestParam("commentId") String parentId) {
        String userId = cookieService.getUserIdLoggedIn(request);
        commentService.createReplyToParentComment(userId, reply, parentId);
        return "redirect:/comments";
    }


    @PostMapping("/submitNew")
    public String submitNew(HttpServletRequest request, @RequestParam("comment") String comment) {
        String userId = cookieService.getUserIdLoggedIn(request);
        commentService.createParentComment(userId, comment);
        return "redirect:/comments";
    }

    @PostMapping("/deleteComment")
    public String deleteComment(HttpServletRequest request, @RequestParam("CommentId") String CommentId, @RequestParam("isParentComment") boolean isParentComment) {
        commentService.deleteComment(CommentId, isParentComment);
        return "redirect:/comments";
    }

}
