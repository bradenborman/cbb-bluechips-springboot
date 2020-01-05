package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.analysis.AnalysisBreakdown;
import com.Borman.cbbbluechips.analysis.AnalysisService;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;
    private CookieService cookieService;
    private AnalysisService analysisService;

    public TransactionController(TransactionService transactionService, CookieService cookieService, AnalysisService analysisService) {
        this.transactionService = transactionService;
        this.cookieService = cookieService;
        this.analysisService = analysisService;
    }

    @RequestMapping("")
    public String transactions(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Transaction> allTrans = transactionService.getLatest50Transactions();
        model.addAttribute("transactions", allTrans);
        return "transaction";
    }

    @Deprecated
    @RequestMapping("/filtered")
    public String filteredTransactions(@RequestParam(defaultValue = "") String teamName, @RequestParam(defaultValue = "") String userName, Model model) {
        List<Transaction> allTrans = transactionService.getFilteredTransaction(teamName, userName);
        model.addAttribute("transactions", allTrans);
        return "transaction";
    }


    @RequestMapping("/analyse")
    public String analyseMyTransactions(HttpServletRequest request, Model model) {
        if(cookieService.isLoggedIn(request))
        {
            List<AnalysisBreakdown> breakdown = analysisService.buildMyTransactionBreakdown(cookieService.getUserIdLoggedIn(request));
            model.addAttribute("breakdown", breakdown);
            return "analyse";
        }

        return "redirect:/";
    }

}
