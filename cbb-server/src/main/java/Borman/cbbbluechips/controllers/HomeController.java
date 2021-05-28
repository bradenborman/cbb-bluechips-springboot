//package Borman.cbbbluechips.controllers;
//
//import Borman.cbbbluechips.services.UserGroupService;
//import Borman.cbbbluechips.services.UserService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class HomeController extends ControllerHelper {
//
//    UserService userService;
//    UserGroupService userGroupService;
//    boolean usersAllowedToSignUp;
//
//    public HomeController(UserService userService, UserGroupService userGroupService,  @Qualifier("signUpAllowed") boolean usersAllowedToSignUp) {
//        this.userService = userService;
//        this.userGroupService = userGroupService;
//        this.usersAllowedToSignUp = usersAllowedToSignUp;
//    }
//
////    @RequestMapping("/")
////    public String welcome(Model model, @RequestParam(defaultValue = "false") String wasError) {
////        if (!wasError.equals("false"))
////            model.addAttribute("error", "Failed");
////
////        model.addAttribute("signUpAllowed", usersAllowedToSignUp);
////
////        return !"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName()) ? "redirect:/portfolio" : "home";
////    }
////
//
//}