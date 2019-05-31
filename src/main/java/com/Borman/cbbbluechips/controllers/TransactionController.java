package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping("")
    public String transactions(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Transaction> allTrans = transactionService.getAllTransactions();
        model.addAttribute("transactions", allTrans);
        return "transaction";
    }

}
