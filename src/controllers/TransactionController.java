/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.TransactionDao;
import interfaces.TransactionDaoInterface;
import java.util.ArrayList;
import model.Transaction;

/**
 *
 * @author jacobobc
 */
public class TransactionController implements TransactionDaoInterface {
    
    private final TransactionDao transactionDao;

    public TransactionController() {
        transactionDao = new TransactionDao();
    }
    
    @Override
    public ArrayList<Transaction> listTransactions(String userId) {
        return transactionDao.listTransactions(userId);
    }
    
    @Override
    public void insertTransaction(Transaction transaction) {
        transactionDao.insertTransaction(transaction);
    }
    
}
