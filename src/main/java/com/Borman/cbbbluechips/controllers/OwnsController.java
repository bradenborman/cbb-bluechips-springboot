package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.services.OwnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owns")
public class OwnsController {

    @Autowired
    OwnsService ownsService;


    @PostMapping("/{userId}")
    public ResponseEntity<List<Owns>> getTeamsUserOwns(@PathVariable String userId) {
        return ResponseEntity.ok(ownsService.getTeamsUserOwns(userId));
    }

}
