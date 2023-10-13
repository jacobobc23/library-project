/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import exceptions.InsufficientCopiesException;
import exceptions.LoanPastDueException;
import model.Loan;

/**
 *
 * @author jacobobc
 */
public interface UserDaoInterface {
    
    void applyLoan(Loan loan) throws LoanPastDueException, InsufficientCopiesException;
    void repayLoan(Loan loan);
    
}
