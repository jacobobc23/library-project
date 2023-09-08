package controllers;

import dao.LogInDao;
import model.User;

/**
 * Controlador para buscar el usuario que desea ingresar al sistema.
 *
 * @author Jacobo-bc
 */
public class LogInController {
    
    private final LogInDao logInDAO;

    public LogInController() {
        logInDAO = new LogInDao();
    }

    public User searchUser(String username, String password) {
         return logInDAO.searchUser(username, password);
    }
}
