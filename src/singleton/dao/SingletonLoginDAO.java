/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.dao;

import dao.LogInDao;

/**
 *
 * @author joanp
 */
public class SingletonLoginDAO {
    
    public static SingletonLoginDAO INSTANCE;
    private final LogInDao logindao;

    private SingletonLoginDAO() {
        logindao = new LogInDao();
    }

    public static SingletonLoginDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLoginDAO();
        }
        return INSTANCE;
    }

    public LogInDao getLoginDao() {
        return logindao;
    }
    
}
