package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.GameInfo;
import com.Borman.cbbbluechips.services.TeamService;
import com.Borman.cbbbluechips.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;


    @GetMapping("/")
    public ResponseEntity<GameInfo> getData() {
        GameInfo gameInfo = new GameInfo();
        gameInfo.setAllUsers(userService.getUsers());
        gameInfo.setHighSore("235,000");
        gameInfo.setMoneyInPlay(2342352);
        gameInfo.setRoundOfPlay("Sweet Sixteen");
        gameInfo.setTeams(teamService.getTeams());
        return ResponseEntity.ok(gameInfo);
    }

}
