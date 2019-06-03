package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.LeaderboardDao;
import com.Borman.cbbbluechips.models.LeaderboardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    LeaderboardDao leaderboardDao;


    public List<LeaderboardUser> getTopFiftyScores() {
        return leaderboardDao.getTopFiftyScores();
    }


}
