/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import enums.Role;
import exceptions.CredentialsException;
import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class LogInDaoTest {

    public LogInDaoTest() {
    }

    /**
     * Test of selectUser method, of class LogInDao.
     */
    @Test
    public void testSelectUser() {
        String username = "jacobo123";
        String password = "123";
        LogInDao instance = new LogInDao();
        User expResult = new User("1092850716", "Jacobo Blandón Castro", Role.ADMIN, "322-684-3150", username, password);
        User result = instance.selectUser(username, password);
        assertEquals(expResult, result);
    }
    
    @Test(expected = CredentialsException.class)
    public void testSelectUserWithException() {
        String invalidUser = "invalid_user";
        String invalidPassword = "invalid_password";
        LogInDao instance = new LogInDao();

        instance.selectUser(invalidUser, invalidPassword);
    }
}
