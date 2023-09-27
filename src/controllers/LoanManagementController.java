package controllers;

import dao.LoanDao;
import dao.UserDao;
import java.util.ArrayList;
import model.Loan;
import model.User;
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
    
    public ArrayList<Loan> listLoans(User user) {
        return userDao.listLoans(user);
    }
    
    public Loan searchLoan(int id) {
        return loanDao.searchLoan(id);
    }
    
    public void applyLoan(Loan loan) {
        userDao.applyLoan(loan);
    }
    
    public void repayLoan(Loan loan) {
        userDao.repayLoan(loan);
    }
    
    public ArrayList<Loan> listLoans() {
        return loanDao.listLoans();
    }
    
    public boolean hasPastDueLoan(User user) {
        return userDao.hasPastDueLoan(user);
    }
    
}
