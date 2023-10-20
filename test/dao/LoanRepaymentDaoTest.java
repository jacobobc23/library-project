/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class LoanRepaymentDaoTest {

    public LoanRepaymentDaoTest() {
    }

    /**
     * Test of selectEntity method, of class LoanRepaymentDao.
     */
//    @Test
//    public void testSelectEntity() {
//        Object id = null;
//        LoanRepaymentDao instance = new LoanRepaymentDao();
//        Object expResult = null;
//        Object result = instance.selectEntity(id);
//        assertEquals(expResult, result);
//    }

    @Test
    public void testSelectNullEntity() {
        Object id = -1;
        LoanRepaymentDao instance = new LoanRepaymentDao();
        Object expResult = null;
        Object result = instance.selectEntity(id);
        assertEquals(expResult, result);
    }

}
