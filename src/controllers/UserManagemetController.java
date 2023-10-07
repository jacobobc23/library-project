package controllers;

import dao.UserDao;
import java.util.ArrayList;
import model.User;

/**
 * Controlador para gestionar los usuarios.
 *
 * @author joanp
 */
public class UserManagemetController {

    private final UserDao userDao;

    public UserManagemetController() {
        userDao = new UserDao();
    }

    public ArrayList<User> listUsers() {
        return userDao.listUsers();
    }

    public User selectUser(String id) {
        return userDao.selectUser(id);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    public boolean isUserRegistered(String id) {
        return userDao.isUserRegistered(id);
    }

    public boolean isMobileNumberInUse(String mobileNumber) {
        return userDao.isMobileNumberInUse(mobileNumber);
    }

    public boolean isUsernameInUse(String username) {
        return userDao.isUsernameInUse(username);
    }

}
