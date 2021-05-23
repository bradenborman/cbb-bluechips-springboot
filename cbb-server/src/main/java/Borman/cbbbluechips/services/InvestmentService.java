package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.InvestmentDao;
import Borman.cbbbluechips.models.Investment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {


    InvestmentDao investmentDao;

    public InvestmentService(InvestmentDao investmentDao) {
        this.investmentDao = investmentDao;
    }

    public List<Investment> retrieveUsersInvestments(String userId) {
        return investmentDao.getTeamsUserOwns(userId);
    }

}