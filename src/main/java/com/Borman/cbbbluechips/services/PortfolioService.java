package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.Portfolio;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
class PortfolioService {

    Logger logger = LoggerFactory.getLogger(PortfolioService.class);


    public Portfolio getPortfolio() {
        logger.info("Getting Portfolio data");
        Portfolio portfolio = new Portfolio();
        portfolio.setCash(200000);
        return portfolio;
    }

}