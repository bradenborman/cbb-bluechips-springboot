package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.OwnedTeams;
import com.Borman.cbbbluechips.models.Portfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PortfolioService {


    protected Portfolio getPortfolio() {

        Portfolio portfolio = new Portfolio();
        portfolio.setCash(200000);
        portfolio.setOwnedTeams(getOwnedTeams());
        return portfolio;
    }


    private List<OwnedTeams> getOwnedTeams() {
        return new ArrayList<OwnedTeams>() {{
            add(new OwnedTeams(false, "Duke", 1, null, 14, null));
            add(new OwnedTeams(true, "Kentucky", 3, null, 0, null));

        }};
    }

}