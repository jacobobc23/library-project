package controllers;

import dao.LoanDao;
import dao.UserDao;
import java.util.ArrayList;
import model.Loan;
import singleton.dao.SingletonLoanDAO;
import singleton.dao.SingletonUserDAO;

/**
 *
 * @author joanp
 */
public class LoanManagementController {
    
    private final UserDao userDao;
    private final LoanDao loanDao;

    public LoanManagementController() {
        userDao = SingletonUserDAO.getINSTANCE().getUserdao();
        loanDao = SingletonLoanDAO.getINSTANCE().getLoanDao();
    }
    
    public void applyLoan(Loan loan) {
        userDao.applyLoan(loan);
    }
    
    public ArrayList<Loan> listLoans() {
        return loanDao.listLoans();
    }
    
}
