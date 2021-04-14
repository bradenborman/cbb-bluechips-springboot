package Borman.cbbbluechips.controllers.admin;

import Borman.cbbbluechips.builders.TransactionBuilder;
import Borman.cbbbluechips.daos.TransactionDao;
import Borman.cbbbluechips.models.Transaction;
import Borman.cbbbluechips.models.enums.TradeAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin/test-action")
public class AdminTestDataActionsController {

    Logger logger = LoggerFactory.getLogger(AdminTestDataActionsController.class);

    @Autowired
    TransactionDao transactionDao;

    //localhost:8080/admin/test-action/populate-transactions/100
    @GetMapping("/populate-transactions/{amount}")
    public String populateTransactions(Model model, @PathVariable int amount) {

       Transaction transaction = TransactionBuilder.aTransaction()
                .withFullName("Int Test Insert")
                .withTeamName("Missouri")
                .withVolumeTraded(3)
                .withCashTraded(4300)
                .withTradeAction(TradeAction.BUY.getCode())
                .withStrTimeofTransaction(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")))
                .build();

        logger.info("Addding {} fake transactions for population of test data.", amount);

        for (int i = 0; i < amount; i++) {
            logger.info("..Inserting record: {}", i);
            transactionDao.recordTransaction(transaction);
        }

        return "redirect:/transactions";
    }



}