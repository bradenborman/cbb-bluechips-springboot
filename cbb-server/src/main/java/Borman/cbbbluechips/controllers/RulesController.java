//package Borman.cbbbluechips.controllers;
//
//import Borman.cbbbluechips.models.CalculatorDetail;
//import Borman.cbbbluechips.models.User;
//import Borman.cbbbluechips.services.CalculatorService;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//@Controller
//@RequestMapping("/rules")
//public class RulesController {
//
//    private CalculatorService calculatorService;
//
//    public RulesController(CalculatorService calculatorService) {
//        this.calculatorService = calculatorService;
//    }
//
////    @RequestMapping("")
////    public String portfolio(Model model) {
////        model.addAttribute("loggedIn", !"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName()));
////        return "rules";
////    }
//
//    @RequestMapping("/calculator")
//    public String calculator(Model model) {
//        User user;
//        try {
//            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        }catch (Exception e) {
//            return "calculator";
//        }
//        CalculatorDetail detail = calculatorService.getCalculatorDetails(user.getID());
//        model.addAttribute("calculatorDetail", detail);
//        return detail.getTeamNamePlaying() == null ? "calculator" : "calculator-personalized";
//    }
//
//}