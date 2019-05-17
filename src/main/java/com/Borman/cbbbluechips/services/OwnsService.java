package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.OwnsDao;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.TradeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnsService {

    @Autowired
    OwnsDao ownsDao;

    public List<Owns> getTeamsUserOwns(String user) {
        return ownsDao.getTeamsUserOwns(user);
    }

}
