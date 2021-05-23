package Borman.cbbbluechips.controllers.api;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.models.Investment;
import Borman.cbbbluechips.services.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PortfolioController extends AuthenticatedController {


    InvestmentService investmentService;

    public PortfolioController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/user-investments")
    public ResponseEntity<List<Investment>> userInvestments(@RequestParam(required = false) String userId) {
        String idToGet = userId != null ? userId : retrieveLoggedInUserId();
        return ResponseEntity.ok(
                investmentService.retrieveUsersInvestments(idToGet)
        );
    }

}