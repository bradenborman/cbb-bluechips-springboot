package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.analysis.AnalysisService;
import Borman.cbbbluechips.models.SearchTag;
import Borman.cbbbluechips.services.TransactionService;
import Borman.cbbbluechips.utilities.SearchTagUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/transactions")
public class TransactionController extends ControllerHelper {

    private TransactionService transactionService;
    private AnalysisService analysisService;

    public TransactionController(TransactionService transactionService, AnalysisService analysisService) {
        this.transactionService = transactionService;
        this.analysisService = analysisService;
    }


    //TODO SQL => also prevent duplicate tag being added
    @RequestMapping("")
    public String transactions(Model model, @RequestParam Map<String, String> params) {
        List<SearchTag> tags = SearchTagUtility.parseTags(params);
        if(tags != null && !tags.isEmpty()) {
            model.addAttribute("searchTags", tags);
            model.addAttribute("transactions", transactionService.getFilteredTransaction(tags));
        }
        else
            model.addAttribute("transactions", transactionService.getLatest50Transactions());
        return "transaction";
    }

    @RequestMapping("/analyse")
    public String analyseMyTransactions(Model model) {
            model.addAttribute("breakdown", analysisService.buildMyTransactionBreakdown(getLoggedInUserId()));
            return "analyse";
    }

}