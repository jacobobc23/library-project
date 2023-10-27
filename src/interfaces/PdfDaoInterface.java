/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;

/**
 *
 * @author jacobobc
 */
public interface PdfDaoInterface {

    boolean generateGeneralLoansPDF(String title, String subtitle, String aditionalInformation, String fileName);
    
    boolean generatePDFLoansByUser(String id, String fileName, String title, String subtitle,
            String aditionalInformation);

    boolean generatePDFLoansByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation);

    boolean generatePDFLoansByUserAndDates(String id, LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle, String aditionalInformation);
    
    boolean generateGeneralLoansDelaysPDF(String title, String subtitle, String aditionalInformation, String fileName, LocalDate currentDate);

    boolean generatePDFLoansDelaysByUser(String id, String fileName, String title, String subtitle, String aditionalInformation, LocalDate currentDate);

    boolean generatePDFLoansDelaysByDates(LocalDate startDate, LocalDate endDate, LocalDate currentDate, String fileName, String title, String subtitle,
            String aditionalInformation);

    boolean generateGeneralLoanRepaymentPDF(String title, String subtitle, String aditionalInformation, String fileName);

    boolean generatePDFLoanRepaymentsByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation);

    boolean generatePDFLoanRepaymentsByUser(String id, String fileName, String title, String subtitle,
            String aditionalInformation);

}
