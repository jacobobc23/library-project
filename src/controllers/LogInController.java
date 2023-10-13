package controllers;

import dao.LogInDao;
import model.User;

/**
 * Controlador para buscar el usuario que desea ingresar al sistema.
 *
 * @author joanp
 */
public class LogInController {
    
    private final LogInDao loginDao;

    public LogInController() {
        loginDao = new LogInDao();
    }

    public User selectUser(String username, String password) {
         return loginDao.selectUser(username, password);
    }
}
