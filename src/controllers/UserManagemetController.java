package controllers;

import dao.UserDao;
import java.util.ArrayList;
import model.User;
import singleton.dao.SingletonUserDAO;

/**
 * Controlador para gestionar los usuarios.
 *
 * @author joanp
 */
public class UserManagemetController {

    private final UserDao userDao;

    public UserManagemetController() {
        userDao = SingletonUserDAO.getINSTANCE().getUserdao();
    }

    public ArrayList<User> listUsers() {
        return userDao.listUsers();
    }

    public User searchUser(String id) {
        return userDao.searchUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
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
