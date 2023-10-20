/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Loan;
import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class LoanDaoTest {
    
    public LoanDaoTest() {
    }

    /**
     * Test of selectLoan method, of class LoanDao.
     */
//    @Test
//    public void testSelectLoan() {
//        int id = 0;
//        LoanDao instance = new LoanDao();
//        Loan expResult = null;
//        Loan result = instance.selectLoan(id);
//        assertEquals(expResult, result);
//    }
    
    @Test
    public void testSelectNullLoan() {
        int id = 0;
        LoanDao instance = new LoanDao();
        Loan expResult = null;
        Loan result = instance.selectLoan(id);
        assertEquals(expResult, result);
    }
    
}
