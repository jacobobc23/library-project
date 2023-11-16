/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.TransactionsPdfDao;

/**
 *
 * @author jacobobc
 */
public class PdfTransactionsController {
    
    private final TransactionsPdfDao pdfDao;

    public PdfTransactionsController() {
        pdfDao = new TransactionsPdfDao();
    }
    
    public boolean generateLoginsPdf(String filename) {
        return pdfDao.generateLoginsPdf(filename);
    }
    
    public boolean generateRegistrationBooksPdf(String filename) {
        return pdfDao.generateRegistrationBooksPdf(filename);
    }
    
    public boolean generateUpdateBooksPdf(String filename) {
        return pdfDao.generateUpdateBooksPdf(filename);
    }
    
    public boolean generateDeletionBooksPdf(String filename) {
        return pdfDao.generateDeletionBooksPdf(filename);
    }
    
    
    public boolean generateRegistrationUsersPdf(String filename) {
        return pdfDao.generateRegistrationUsersPdf(filename);
    }
    
    public boolean generateUpdateUsersPdf(String filename) {
        return pdfDao.generateUpdateUsersPdf(filename);
    }
    
    public boolean generateDeletionUsersPdf(String filename) {
        return pdfDao.generateDeletionUsersPdf(filename);
    }
    
    public boolean generateRequestsLoansPdf(String filename) {
        return pdfDao.generateRequestsLoansPdf(filename);
    }
    
    public boolean generateLoanRepaymentsPdf(String filename) {
        return pdfDao.generateLoanRepaymentsPdf(filename);
    }
    
}
