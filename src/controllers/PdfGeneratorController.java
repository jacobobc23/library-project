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

    public boolean generatePDF(String title, String subtitle, String aditionalInformation, String fileName) {
        return pdfdao.generatePDF(title, subtitle, aditionalInformation, fileName);
    }

    public boolean generatePDFByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {
        return pdfdao.generatePDFByDates(startDate, endDate, fileName, title, subtitle, aditionalInformation);
    }
}
