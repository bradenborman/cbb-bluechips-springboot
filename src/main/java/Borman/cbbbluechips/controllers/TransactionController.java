package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.analysis.AnalysisService;
import Borman.cbbbluechips.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/transactions")
public class TransactionController extends ControllerHelper {

    private TransactionService transactionService;
    private AnalysisService analysisService;

    public TransactionController(TransactionService transactionService, AnalysisService analysisService) {
        this.transactionService = transactionService;
        this.analysisService = analysisService;
    }

    @RequestMapping("")
    public String transactions(Model model) {
        model.addAttribute("transactions", transactionService.getLatest50Transactions());
        return "transaction";
    }

    @Deprecated
    @RequestMapping("/filtered")
    public String filteredTransactions(@RequestParam(defaultValue = "") String teamName, @RequestParam(defaultValue = "") String userName, Model model) {
        model.addAttribute("transactions", transactionService.getFilteredTransaction(teamName, userName));
        return "transaction";
    }

    @RequestMapping("/analyse")
    public String analyseMyTransactions(Model model) {
            model.addAttribute("breakdown", analysisService.buildMyTransactionBreakdown(getLoggedInUserId()));
            return "analyse";
    }

}