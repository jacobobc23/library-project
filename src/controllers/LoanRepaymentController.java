/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.LoanRepaymentDao;
import java.util.ArrayList;
import model.LoanRepayment;

/**
 *
 * @author jacobobc
 */
public class LoanRepaymentController {
    
    private final LoanRepaymentDao loanRepaymentDao;
    
    public LoanRepaymentController() {
        loanRepaymentDao = new LoanRepaymentDao();
    }
    
    public ArrayList<Object> listAllLoanRepayments() {
        return loanRepaymentDao.listEntity();
    }
    
    public Object selectLoanRepayment(int id) {
        return loanRepaymentDao.selectEntity(id);
    }
    
    public void insertLoanRepayment(LoanRepayment loanRepayment) {
        loanRepaymentDao.insertEntity(loanRepayment);
    }
    
    
}
