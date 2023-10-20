/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import enums.Role;
import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class UserDaoTest {

    public UserDaoTest() {
    }

    /**
     * Test of selectEntity method, of class UserDao.
     */
    @Test
    public void testSelectEntity() {
        Object id = "1092850716";
        UserDao instance = new UserDao();
        User expResult = new User((String) id, "Jacobo Blandón Castro", Role.ADMIN, "322-684-3150", "jacobo123", "123");
        Object result = instance.selectEntity(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testSelectNullEntity() {
        Object obj = "invalid_id";
        UserDao instance = new UserDao();
        User expResult = null;
        Object result = instance.selectEntity(obj);
        assertEquals(expResult, result);
    }

}
