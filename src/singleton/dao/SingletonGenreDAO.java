/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.dao;

import dao.GenreDao;

/**
 *
 * @author joanp
 */
public class SingletonGenreDAO {
    
    public static SingletonGenreDAO INSTANCE;
    private final GenreDao genredao;

    private SingletonGenreDAO() {
        genredao = new GenreDao();
    }

    public static SingletonGenreDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonGenreDAO();
        }
        return INSTANCE;
    }

    public GenreDao getGenreDao() {
        return genredao;
    }
    
}
