package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.LeaderboardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    OwnsService ownsService;


    public List<LeaderboardUser> getLeaders() {
        return ownsService.getLeaders();
    }


}
