package controllers;

import dao.LogInDao;
import model.User;
import singleton.dao.SingletonLoginDAO;

/**
 * Controlador para buscar el usuario que desea ingresar al sistema.
 *
 * @author joanp
 */
public class LogInController {
    
    private final LogInDao logInDAO;

    public LogInController() {
        logInDAO = SingletonLoginDAO.getINSTANCE().getLoginDao();
    }

    public User searchUser(String username, String password) {
         return logInDAO.searchUser(username, password);
    }
}
