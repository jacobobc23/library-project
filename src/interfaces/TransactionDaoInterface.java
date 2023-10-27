/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import model.Transaction;

/**
 *
 * @author jacobobc
 */
public interface TransactionDaoInterface {
    
    ArrayList<Transaction> listTransactions(String userId);
    void insertTransaction(Transaction transaction);
    
}
