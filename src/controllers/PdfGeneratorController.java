/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.PdfDao;
import java.time.LocalDate;

/**
 *
 * @author joanp
 */
public class PdfGeneratorController {

    private final PdfDao pdfdao;

    public PdfGeneratorController() {
        this.pdfdao = new PdfDao();
    }

    public boolean generateGeneralLoansPDF(String title, String subtitle, String aditionalInformation, String fileName) {
        return pdfdao.generateGeneralLoansPDF(title, subtitle, aditionalInformation, fileName);
    }

    public boolean generateGeneralLoanRepaymentPDF(String title, String subtitle, String aditionalInformation, String fileName) {
        return pdfdao.generateGeneralLoanRepaymentPDF(title, subtitle, aditionalInformation, fileName);
    }

    public boolean generatePDFLoansByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {
        return pdfdao.generatePDFLoansByDates(startDate, endDate, fileName, title, subtitle, aditionalInformation);
    }

    public boolean generatePDFLoanRepaymentsByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {
        return pdfdao.generatePDFLoanRepaymentsByDates(startDate, endDate, fileName, title, subtitle, aditionalInformation);
    }

    public boolean generatePDFLoansByUser(String id, String fileName, String title, String subtitle,
            String aditionalInformation) {
        return pdfdao.generatePDFLoansByUser(id, fileName, title, subtitle, aditionalInformation);
    }

    public boolean generatePDFLoanRepaymentsByUser(String id, String fileName, String title, String subtitle,
            String aditionalInformation) {
        return pdfdao.generatePDFLoanRepaymentsByUser(id, fileName, title, subtitle, aditionalInformation);
    }

}
