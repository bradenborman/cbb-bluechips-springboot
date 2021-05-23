//package Borman.cbbbluechips.controllers;
//
//import Borman.cbbbluechips.models.User;
//import Borman.cbbbluechips.models.enums.Ads;
//import Borman.cbbbluechips.services.CommentService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/comments")
//public class CommentController {
//
//    private CommentService commentService;
//    private boolean shouldDisplayAds;
//
//    public CommentController(CommentService commentService, @Qualifier("displayAds") boolean shouldDisplayAds) {
//        this.commentService = commentService;
//        this.shouldDisplayAds = shouldDisplayAds;
//    }
//
////    @RequestMapping("")
////    public String comments(Model model) {
////        model.addAttribute("comments", commentService.getComments(getLoggedInUser().getID(), getLoggedInUser()));
////        if(shouldDisplayAds)
////            model.addAttribute("ads", Ads.getDisplayAdds());
////        return "comments-new";
////    }
//
//    @PostMapping("/submitReply")
//    public String submitReply(@RequestParam("reply") String reply, @RequestParam("commentId") String parentId) {
//        commentService.createReplyToParentComment(getLoggedInUser().getID(), reply, parentId);
//        return "redirect:/comments";
//    }
//
//    @PostMapping("/submitNew")
//    public String submitNew(@RequestParam("comment") String comment) {
//        commentService.createParentComment(getLoggedInUser().getID(), comment);
//        return "redirect:/comments";
//    }
//
//    @PostMapping("/deleteComment")
//    public String deleteComment(@RequestParam("CommentId") String CommentId, @RequestParam("isParentComment") boolean isParentComment) {
//        commentService.deleteComment(CommentId, isParentComment);
//        return "redirect:/comments";
//    }
//
//    private User getLoggedInUser() {
//        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
//
//}