/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class PdfDao {

    private static final int NUM_COLUMNS = 6;

    private final Connection connection;
    private final Document document;

    public PdfDao() {
        connection = Singleton.getINSTANCE().getConnection();
        document = new Document();
    }

    public boolean generatePDF(String title, String subtitle, String aditionalInformation, String fileName) {
        boolean hasLoans = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = new PdfPTable(NUM_COLUMNS);

            // Establecer el ancho de las columnas
            float[] columnWidths = {7, 16, 15, 15, 15, 7};

            table.setWidths(columnWidths);

            table.addCell(new Phrase("Id Usuario"));
            table.addCell(new Phrase("Nombre Usuario"));
            table.addCell(new Phrase("Nombre Libro"));
            table.addCell(new Phrase("Fecha prestamo"));
            table.addCell(new Phrase("Fecha vencimiento"));
            table.addCell(new Phrase("Cantidad"));

            String query = "SELECT * FROM loans";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    // Agregar un título
                    Paragraph titleAssigment = new Paragraph(title);
                    titleAssigment.setAlignment(Paragraph.ALIGN_CENTER);
                    document.add(titleAssigment);

                    // Agregar un subtítulo
                    Paragraph subtitleAssigment = new Paragraph(subtitle);
                    subtitleAssigment.setAlignment(Paragraph.ALIGN_CENTER);
                    subtitleAssigment.setSpacingAfter(10f); // Espacio después del subtítulo
                    document.add(subtitleAssigment);


                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(8));
                    } while (rs.next());
                    document.add(table);

                    Paragraph additionalText = new Paragraph(aditionalInformation);
                    additionalText.setAlignment(Paragraph.ALIGN_LEFT);
                    additionalText.setSpacingBefore(10f); // Espacio antes del texto
                    document.add(additionalText);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (DocumentException | HeadlessException | FileNotFoundException ex) {
        }
        return hasLoans;
    }

    public boolean generatePDFByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasLoans = false;
        try {

            String ruta = System.getProperty("user.home");

            PdfPTable table = new PdfPTable(NUM_COLUMNS);

            // Establecer el ancho de las columnas
            float[] columnWidths = {7, 16, 15, 15, 15, 7};

            table.setWidths(columnWidths);

            table.addCell(new Phrase("Id Usuario"));
            table.addCell(new Phrase("Nombre Usuario"));
            table.addCell(new Phrase("Nombre Libro"));
            table.addCell(new Phrase("Fecha prestamo"));
            table.addCell(new Phrase("Fecha vencimiento"));
            table.addCell(new Phrase("Cantidad"));

            String query = "SELECT * FROM loans WHERE loan_date >= ? AND loan_date <= ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(startDate.toString()));
                ps.setDate(2, java.sql.Date.valueOf((endDate.toString())));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    Paragraph titleAssigment = new Paragraph(title);
                    titleAssigment.setAlignment(Paragraph.ALIGN_CENTER);
                    document.add(titleAssigment);

                    Paragraph subtitleAssigment = new Paragraph(subtitle);
                    subtitleAssigment.setAlignment(Paragraph.ALIGN_CENTER);
                    subtitleAssigment.setSpacingAfter(10f); // Espacio después del subtítulo
                    document.add(subtitleAssigment);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(8));
                    } while (rs.next());
                    document.add(table);

                    Paragraph additionalText = new Paragraph(aditionalInformation);
                    additionalText.setAlignment(Paragraph.ALIGN_LEFT);
                    additionalText.setSpacingBefore(10f); // Espacio antes del texto
                    document.add(additionalText);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (DocumentException | HeadlessException | FileNotFoundException ex) {
        }
        return hasLoans;
    }

}
