/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.PdfDao;

/**
 *
 * @author joanp
 */
public class PdfGeneratorController {

    private final PdfDao pdfdao;

    public PdfGeneratorController() {
        this.pdfdao = new PdfDao();
    }

    public void generatePDF(String title, String subtitle, String aditionalInformation) {
        pdfdao.generatePDF(title, subtitle, aditionalInformation);
    }

}
