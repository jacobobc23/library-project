/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.dao;

import dao.BookDao;

/**
 *
 * @author joanp
 */
public class SingletonBookDAO {

    public static SingletonBookDAO INSTANCE;
    private final BookDao bookdao;

    private SingletonBookDAO() {
        bookdao = new BookDao();
    }

    public static SingletonBookDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonBookDAO();
        }
        return INSTANCE;
    }

    public BookDao getBookdao() {
        return bookdao;
    }

}
