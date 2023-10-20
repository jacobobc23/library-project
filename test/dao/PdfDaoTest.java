/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class PdfDaoTest {

    public PdfDaoTest() {
    }

    /**
     * Test of generateGeneralLoansDelaysPDF method, of class PdfDao.
     */
    @Test
    public void testGenerateGeneralLoansDelaysPDF() {
        String title = "Test 3";
        String subtitle = "Test 3 subtitle";
        String aditionalInformation = "Additional info";
        String fileName = "Test3";
        LocalDate currentDate = LocalDate.now();

        PdfDao instance = new PdfDao();

        boolean hasOverdueLoans = instance.generateGeneralLoansDelaysPDF(title, subtitle, aditionalInformation, fileName, currentDate);

        assertTrue(hasOverdueLoans);
    }

    /**
     * Test of generatePDFLoansDelaysByUser method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoansDelaysByUser() {
        String id = "18493675";
        String fileName = "test";
        String title = "Test";
        String subtitle = "Test Subtitle";
        String aditionalInformation = "Additional info";
        LocalDate currentDate = LocalDate.now();

        PdfDao instance = new PdfDao();

        boolean hasOverdueLoans = instance.generatePDFLoansDelaysByUser(id, fileName, title, subtitle, aditionalInformation, currentDate);

        assertTrue(hasOverdueLoans);
    }

    /**
     * Test of generatePDFLoansDelaysByDates method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoansDelaysByDates() {
        LocalDate startDate = LocalDate.of(2023, 10, 01);
        LocalDate endDate = LocalDate.of(2023, 10, 31);
        LocalDate currentDate = LocalDate.now();
        String fileName = "Test2";
        String title = "Test 2";
        String subtitle = "Test 2 subtitle";
        String aditionalInformation = "Additional info";

        PdfDao instance = new PdfDao();

        boolean hasOverdueLoans = instance.generatePDFLoansDelaysByDates(startDate, endDate, currentDate, fileName, title, subtitle, aditionalInformation);

        assertTrue(hasOverdueLoans);
    }

    /**
     * Test of generateGeneralLoansPDF method, of class PdfDao.
     */
    @Test
    public void testGenerateGeneralLoansPDF() {
        String title = "Test 5";
        String subtitle = "Test 5 subtitle";
        String aditionalInformation = "Additional info";
        String fileName = "Test5";

        PdfDao instance = new PdfDao();

        boolean hasLoans = instance.generateGeneralLoansPDF(title, subtitle, aditionalInformation, fileName);

        assertTrue(hasLoans);
    }

    /**
     * Test of generatePDFLoansByUserAndDates method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoansByUserAndDates() {
        String id = "18493675";
        LocalDate startDate = LocalDate.of(2023, 10, 01);
        LocalDate endDate = LocalDate.of(2023, 10, 31);
        String fileName = "Test4";
        String title = "Test 4";
        String subtitle = "Test 4 subtitle";
        String aditionalInformation = "Additional info";

        PdfDao instance = new PdfDao();

        boolean hasLoans = instance.generatePDFLoansByUserAndDates(id, startDate, endDate, fileName, title, subtitle, aditionalInformation);

        assertTrue(hasLoans);
    }

    /**
     * Test of generatePDFLoansByUser method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoansByUser() {
        String id = "18493675";
        String fileName = "Test9";
        String title = "Test 9";
        String subtitle = "Test 9 subtitle";
        String aditionalInformation = "Additonal info";
        PdfDao instance = new PdfDao();

        boolean hasLoans = instance.generatePDFLoansByUser(id, fileName, title, subtitle, aditionalInformation);

        assertTrue(hasLoans);
    }

    /**
     * Test of generatePDFLoansByDates method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoansByDates() {
        LocalDate startDate = LocalDate.of(2023, 10, 01);
        LocalDate endDate = LocalDate.of(2023, 10, 31);
        String fileName = "Test7";
        String title = "Test 7";
        String subtitle = "Test 7 subtitle";
        String aditionalInformation = "Additional info";
        PdfDao instance = new PdfDao();

        boolean hasLoans = instance.generatePDFLoansByDates(startDate, endDate, fileName, title, subtitle, aditionalInformation);

        assertTrue(hasLoans);

    }

    /**
     * Test of generateGeneralLoanRepaymentPDF method, of class PdfDao.
     */
    @Test
    public void testGenerateGeneralLoanRepaymentPDF() {
        String title = "Test 6";
        String subtitle = "Test 6 subtitle";
        String aditionalInformation = "Additional info";
        String fileName = "Test6";
        PdfDao instance = new PdfDao();

        boolean hasLoanRepayments = instance.generateGeneralLoanRepaymentPDF(title, subtitle, aditionalInformation, fileName);

        assertTrue(hasLoanRepayments);
    }

    /**
     * Test of generatePDFLoanRepaymentsByDates method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoanRepaymentsByDates() {
        LocalDate startDate = LocalDate.of(2023, 10, 01);
        LocalDate endDate = LocalDate.of(2023, 10, 31);
        String fileName = "Test8";
        String title = "Test 8";
        String subtitle = "Test 8 subtitle";
        String aditionalInformation = "Additional info";
        PdfDao instance = new PdfDao();

        boolean hasLoanRepayments = instance.generatePDFLoanRepaymentsByDates(startDate, endDate, fileName, title, subtitle, aditionalInformation);

        assertTrue(hasLoanRepayments);

    }

    /**
     * Test of generatePDFLoanRepaymentsByUser method, of class PdfDao.
     */
    @Test
    public void testGeneratePDFLoanRepaymentsByUser() {
        String id = "18493675";
        String fileName = "Test10";
        String title = "Test 10";
        String subtitle = "Test 10 subtitle";
        String aditionalInformation = "Additional info";
        PdfDao instance = new PdfDao();

        boolean hasLoanRepayments = instance.generatePDFLoanRepaymentsByUser(id, fileName, title, subtitle, aditionalInformation);

        assertTrue(hasLoanRepayments);
    }
}
