package controllers;

import dao.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 * Controlador para gestionar los usuarios.
 *
 * @author Jacobo-bc
 */
public class UserManagemetController {

    private final UserDAO userDAO;

    public UserManagemetController() {
        userDAO = new UserDAO();
    }

    public ArrayList<User> listUsers() {
        return userDAO.listUsers();
    }

    public User searchUser(String id) {
        return userDAO.searchUser(id);
    }

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(String id) {
        return userDAO.deleteUser(id);
    }

    public boolean mobileNumberInUse(String mobileNumber) {
        return userDAO.mobileNumberInUse(mobileNumber);
    }

    public boolean usernameInUse(String username) {
       return userDAO.usernameInUse(username);
    }

}
