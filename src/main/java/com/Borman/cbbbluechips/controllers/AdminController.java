package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/update-teams")
    public ResponseEntity<String> updateSportsDataApiTeamInfo() {
        adminService.updateTeamsStoredInDataBase();
        return ResponseEntity.ok("Updated Teams");
    }

}
