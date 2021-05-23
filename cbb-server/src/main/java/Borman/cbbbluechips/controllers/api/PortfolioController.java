package Borman.cbbbluechips.controllers.api;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.models.GameData;
import Borman.cbbbluechips.models.Investment;
import Borman.cbbbluechips.models.UserGameData;
import Borman.cbbbluechips.models.fixtures.TestDataProvider;
import Borman.cbbbluechips.services.InvestmentService;
import Borman.cbbbluechips.services.PortfolioService;
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
    PortfolioService portfolioService;

    public PortfolioController(InvestmentService investmentService, PortfolioService portfolioService) {
        this.investmentService = investmentService;
        this.portfolioService = portfolioService;
    }

    @GetMapping("/user-investments")
    public ResponseEntity<List<Investment>> userInvestments(@RequestParam(required = false) String userId) {
        String idToGet = userId != null ? userId : retrieveLoggedInUserId();
        return ResponseEntity.ok(
                investmentService.retrieveUsersInvestments(idToGet)
        );
    }

    @GetMapping("/cbb-game-data")
    public ResponseEntity<GameData> cbbGameData() {
        return ResponseEntity.ok(TestDataProvider.gameDataFixture());
//        return ResponseEntity.ok(portfolioService.retrieveGameData());
    }

    @GetMapping("/user-game-data")
    public ResponseEntity<UserGameData> userGameData() {
        return ResponseEntity.ok(TestDataProvider.userGameDataFixture());
//        return ResponseEntity.ok(portfolioService.retrieveUsersGameData(retrieveLoggedInUserId()));
    }

}