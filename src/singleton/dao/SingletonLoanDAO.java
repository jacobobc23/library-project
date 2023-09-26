/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.dao;

import dao.LoanDao;

/**
 *
 * @author joanp
 */
public class SingletonLoanDAO {
    
    public static SingletonLoanDAO INSTANCE;
    private final LoanDao loandao;

    private SingletonLoanDAO() {
        loandao = new LoanDao();
    }

    public static SingletonLoanDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLoanDAO();
        }
        return INSTANCE;
    }

    public LoanDao getLoanDao() {
        return loandao;
    }
    
}
