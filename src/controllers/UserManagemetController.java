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

    public ArrayList<Object> listUsers() {
        return userDao.listEntity();
    }

    public User selectUser(String id) {
        return (User) userDao.selectEntity(id);
    }

    public void insertUser(User user) {
        userDao.insertEntity(user);
    }

    public void updateUser(User user) {
        userDao.updateEntity(user);
    }

    public void deleteUser(String id) {
        userDao.deleteEntity(id);
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
