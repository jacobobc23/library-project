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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import model.Book;
import model.Loan;
import model.User;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class PdfDao {

    private final Connection connection;

    private int reportNumber;
    Document document;

    public PdfDao() {
        connection = Singleton.getINSTANCE().getConnection();
        reportNumber = obtainNumberReport();
        document = new Document();
    }

    public void generatePDF(String title, String subtitle, String aditionalInformation) {
        try {

            String ruta = System.getProperty("user.home");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(new Date());

            // se le asigna fecha y numero de reporte autoincrementable
            String nombreArchivo = "Reporte_" + reportNumber + "_" + date + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + nombreArchivo));

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

            PdfPTable table = new PdfPTable(8);

            // Establecer el ancho de las columnas
            float[] columnWidths = {7, 16, 15, 15, 15, 7, 15, 7};
            table.setWidths(columnWidths);

            table.addCell(new Phrase("Id"));
            table.addCell(new Phrase("Usuario"));
            table.addCell(new Phrase("Isbn"));
            table.addCell(new Phrase("Fecha prestamo"));
            table.addCell(new Phrase("Fecha vencimiento"));
            table.addCell(new Phrase("¿Regresado?"));
            table.addCell(new Phrase("Fecha de regreso"));
            table.addCell(new Phrase("Cantidad"));

            String query = "SELECT * FROM loans";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(6));
                        table.addCell(rs.getString(7) != null && !rs.getString(7).isEmpty() ? rs.getString(7) : "No lo ha devuelto");
                        table.addCell(rs.getString(8));
                    } while (rs.next());
                    document.add(table);
                } else {
                    document.add(new Paragraph("No se encontraron resultados."));
                }
            } catch (DocumentException | SQLException ex) {
                ex.printStackTrace();
            }
            Paragraph additionalText = new Paragraph(aditionalInformation);
            additionalText.setAlignment(Paragraph.ALIGN_LEFT);
            additionalText.setSpacingBefore(10f); // Espacio antes del texto
            document.add(additionalText);

            document.close();
            incrementReportNumber(reportNumber + 1);
        } catch (DocumentException | HeadlessException | FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    private static int obtainNumberReport() {
        // Método para obtener el número de reporte actual desde un archivo de configuración
        try {
            BufferedReader reader = new BufferedReader(new FileReader("numeroreporte.txt"));
            int number = Integer.parseInt(reader.readLine());
            reader.close();
            return number;
        } catch (IOException e) {
            return 1; // Si ocurre un error al leer el archivo, se inicia con el número 1
        }
    }

    private static void incrementReportNumber(int number) {
        // Método para guardar el número de reporte actual en el archivo de configuración
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("numeroreporte.txt"));
            writer.write(String.valueOf(number));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
