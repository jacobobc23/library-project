package controllers;

import dao.LoanDao;
import dao.UserDao;
import java.util.ArrayList;
import model.Loan;
import model.User;

/**
 *
 * @author joanp
 */
public class LoanManagementController {
    
    private final UserDao userDao;
    private final LoanDao loanDao;

    public LoanManagementController() {
        userDao = new UserDao();
        loanDao = new LoanDao();
    }
   
    public ArrayList<Loan> listAllLoans() {
        return loanDao.listAllLoans();
    }
    
    public ArrayList<Loan> listUserLoans(User user) {
        return loanDao.listUserLoans(user);
    }
    
    public Loan selectLoan(int id) {
        return loanDao.selectLoan(id);
    }
    
    public void applyLoan(Loan loan) {
        userDao.applyLoan(loan);
    }
    
    public void repayLoan(Loan loan) {
        userDao.repayLoan(loan);
    }
    
    public boolean hasPastDueLoan(User user) {
        return userDao.hasPastDueLoan(user);
    }
    
}
