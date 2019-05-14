package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.GameInfo;
import com.Borman.cbbbluechips.services.TeamService;
import com.Borman.cbbbluechips.services.TransactionService;
import com.Borman.cbbbluechips.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;


    @Autowired
    TransactionService transactionService;

    @GetMapping("/api")
    public ResponseEntity<GameInfo> getData() {
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGameLobby("Shelter Insurance Crew");
        gameInfo.setAllUsers(userService.getUsers());
        gameInfo.setHighSore("235,000");
        gameInfo.setMoneyInPlay(2342352);
        gameInfo.setRoundOfPlay("Sweet Sixteen");
        gameInfo.setTeams(teamService.getTeams());
        gameInfo.setAllTransactions(transactionService.getAllTransactions());

        gameInfo.getTeams().get(0).setTeamData(teamService.getTeamData());

        logger.info("Request Complete\n");
        return ResponseEntity.ok(gameInfo);
    }


}
