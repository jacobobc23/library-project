/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.dao;

import dao.UserDao;

/**
 *
 * @author joanp
 */
public final class SingletonUserDAO {

    public static SingletonUserDAO INSTANCE;
    private final UserDao userdao;

    private SingletonUserDAO() {
        userdao = new UserDao();
    }

    public static SingletonUserDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonUserDAO();
        }
        return INSTANCE;
    }

    public UserDao getUserdao() {
        return userdao;
    }

}
