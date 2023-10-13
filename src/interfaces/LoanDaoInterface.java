/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import model.Loan;
import model.User;

/**
 *
 * @author jacobobc
 */
public interface LoanDaoInterface {

    ArrayList<Loan> listUserLoans(User user);
    ArrayList<Loan> listAllLoans();
    Loan selectLoan(int id);
}
