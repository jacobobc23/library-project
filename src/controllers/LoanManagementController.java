package controllers;

import dao.LoanDao;
import dao.UserDao;
import java.util.ArrayList;
import model.Loan;

/**
 *
 * @author Jacobo-bc
 */
public class LoanManagementController {
    
    private final UserDao userDao;
    private final LoanDao loanDao;

    public LoanManagementController() {
        userDao = new UserDao();
        loanDao = new LoanDao();
    }
    
    public void applyLoan(Loan loan) {
        userDao.applyLoan(loan);
    }
    
    public ArrayList<Loan> listLoans() {
        return loanDao.listLoans();
    }
    
}
