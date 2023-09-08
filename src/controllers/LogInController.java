package controllers;

import dao.LogInDAO;
import model.User;

/**
 * Controlador para buscar el usuario que desea ingresar al sistema.
 *
 * @author Jacobo-bc
 */
public class LogInController {
    
    private final LogInDAO logInDAO;

    public LogInController() {
        logInDAO = new LogInDAO();
    }

    public User searchUser(String username, String password) {
         return logInDAO.searchUser(username, password);
    }
}
