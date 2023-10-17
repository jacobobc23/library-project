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

    private final Connection connection;
    private final Document document;

    public PdfDao() {
        connection = Singleton.getINSTANCE().getConnection();
        document = new Document();
    }

    public boolean generatePDFLoansDelaysByUser(String id, String fileName, String title, String subtitle, String aditionalInformation, LocalDate currentDate) {

        boolean hasOverdueLoans = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTableDelays();

            String query = "SELECT users.id, users.fullname, books.title, loans.loan_date, loans.due_date, loans.book_quantity"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn WHERE loans.user_id = ?"
                    + "AND loans.due_date < ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, id);
                ps.setDate(2, java.sql.Date.valueOf((currentDate.toString())));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasOverdueLoans = true;

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
                        table.addCell(rs.getString(6));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }

            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {
        }
        return hasOverdueLoans;
    }

    public boolean generatePDFLoansDelaysByDates(LocalDate startDate, LocalDate endDate, LocalDate currentDate, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasOverdueLoans = false;
        try {

            String ruta = System.getProperty("user.home");

            PdfPTable table = createTableDelays();

            String query = "SELECT users.id, users.fullname, books.title,loans.loan_date, loans.due_date, loans.book_quantity"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn JOIN genres "
                    + "ON books.genre_id = genres.id WHERE loan_date >= ? AND loan_date <= ? AND loans.due_date < ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(startDate.toString()));
                ps.setDate(2, java.sql.Date.valueOf((endDate.toString())));
                ps.setDate(3, java.sql.Date.valueOf((currentDate.toString())));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasOverdueLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(6));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return hasOverdueLoans;
    }

    public boolean generateGeneralLoansDelaysPDF(String title, String subtitle, String aditionalInformation, String fileName, LocalDate currentDate) {
        boolean hasOverdueLoans = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTableDelays();

            String query = "SELECT users.id, users.fullname, books.title, loans.loan_date, loans.due_date, loans.book_quantity"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn JOIN genres"
                    + " ON books.genre_id = genres.id WHERE loans.due_date < ? ";

            try (PreparedStatement ps = connection.prepareStatement(query)) {

                ps.setDate(1, java.sql.Date.valueOf(currentDate.toString()));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasOverdueLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(6));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (HeadlessException | FileNotFoundException ex) {
        }
        return hasOverdueLoans;
    }

    public boolean generatePDFLoansByUserAndDates(String id, LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasLoans = false;
        try {

            String ruta = System.getProperty("user.home");

            PdfPTable table = createTableUsersDates();

            String query = "SELECT users.id, users.fullname, books.isbn, books.author, books.title, genres.name, loans.loan_date, loans.due_date"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn JOIN genres "
                    + "ON books.genre_id = genres.id WHERE loan_date >= ? AND loan_date <= ? AND loans.user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(startDate.toString()));
                ps.setDate(2, java.sql.Date.valueOf((endDate.toString())));
                ps.setString(3, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(6));
                        table.addCell(rs.getString(7));
                        table.addCell(rs.getString(8));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return hasLoans;
    }

    public boolean generateGeneralLoansPDF(String title, String subtitle, String aditionalInformation, String fileName) {
        boolean hasLoans = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id, users.fullname, books.title, genres.name, loans.loan_date"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn JOIN genres ON books.genre_id = genres.id";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (HeadlessException | FileNotFoundException ex) {
        }
        return hasLoans;
    }

    public boolean generateGeneralLoanRepaymentPDF(String title, String subtitle, String aditionalInformation, String fileName) {
        boolean hasLoans = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id, users.fullname, books.title, genres.name, loan_repayments.return_date FROM"
                    + " loan_repayments JOIN users ON loan_repayments.user_id = users.id JOIN books ON loan_repayments.isbn_book = books.isbn JOIN genres ON books.genre_id = genres.id";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasLoans = true;

                    String date = LocalDate.now().toString();
                    String file = fileName + "_" + date;

                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + file + ".pdf"));
                    document.open();

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
                System.err.println(ex.toString());
            }

        } catch (HeadlessException | FileNotFoundException ex) {
            System.err.println(ex.toString());

        }
        return hasLoans;
    }

    public boolean generatePDFLoansByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasLoans = false;
        try {

            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id, users.fullname, books.title, genres.name, loans.loan_date"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn JOIN genres ON books.genre_id = genres.id WHERE loan_date >= ? AND loan_date <= ?";

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

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return hasLoans;
    }

    public boolean generatePDFLoanRepaymentsByDates(LocalDate startDate, LocalDate endDate, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasLoans = false;
        try {

            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id, users.fullname, books.title, genres.name, loan_repayments.return_date FROM"
                    + " loan_repayments JOIN users ON loan_repayments.user_id = users.id JOIN books ON loan_repayments.isbn_book = books.isbn JOIN genres ON books.genre_id = genres.id WHERE return_date >= ? AND return_date <= ?";

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

                    insertImportantInformation(title, subtitle);

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }
            } catch (DocumentException | SQLException ex) {
            }

        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return hasLoans;
    }

    public boolean generatePDFLoansByUser(String id, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasLoans = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id, users.fullname, books.title, genres.name, loans.loan_date"
                    + " FROM loans JOIN users ON loans.user_id = users.id JOIN books ON loans.isbn_book = books.isbn WHERE loans.user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, id);
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
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }

            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {
        }
        return hasLoans;
    }

    public boolean generatePDFLoanRepaymentsByUser(String id, String fileName, String title, String subtitle,
            String aditionalInformation) {

        boolean hasLoans = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id, users.fullname, books.title, genres.name, loan_repayments.return_date FROM"
                    + " loan_repayments JOIN users ON loan_repayments.user_id = users.id JOIN books ON loan_repayments.isbn_book = books.isbn JOIN genres ON books.genre_id = genres.id WHERE loan_repayments.user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, id);
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
                    } while (rs.next());
                    document.add(table);

                    insertAditionalInformation(aditionalInformation);

                    document.close();
                }

            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {
        }
        return hasLoans;
    }

    private PdfPTable createTableDelays() {
        float[] columnWidths = {7, 15, 15, 15, 15, 7};
        PdfPTable table = new PdfPTable(columnWidths);

        table.addCell(new Phrase("Id Usuario"));
        table.addCell(new Phrase("Nombre Usuario"));
        table.addCell(new Phrase("Nombre Libro"));
        table.addCell(new Phrase("Fecha préstamo"));
        table.addCell(new Phrase("Fecha de vencimiento"));
        table.addCell(new Phrase("Libros prestados"));

        return table;
    }

    private PdfPTable createTable() {
        float[] columnWidths = {7, 15, 15, 15, 15};
        PdfPTable table = new PdfPTable(columnWidths);

        table.addCell(new Phrase("Id Usuario"));
        table.addCell(new Phrase("Nombre Usuario"));
        table.addCell(new Phrase("Nombre Libro"));
        table.addCell(new Phrase("Categoría"));
        table.addCell(new Phrase("Fecha"));

        return table;
    }

    private PdfPTable createTableUsersDates() {
        float[] columnWidths = {7, 15, 20, 15, 15, 15, 15, 15};
        PdfPTable table = new PdfPTable(columnWidths);

        table.addCell(new Phrase("Id Usuario"));
        table.addCell(new Phrase("Nombre Usuario"));
        table.addCell(new Phrase("ISBN"));
        table.addCell(new Phrase("Autor"));
        table.addCell(new Phrase("Nombre Libro"));
        table.addCell(new Phrase("Categoria"));
        table.addCell(new Phrase("Fecha prestamo"));
        table.addCell(new Phrase("Fecha vencimiento"));

        return table;
    }

    private void insertImportantInformation(String title, String subtitle) {
        Paragraph titleAssigment = new Paragraph(title);
        titleAssigment.setAlignment(Paragraph.ALIGN_CENTER);
        try {
            document.add(titleAssigment);
        } catch (DocumentException ex) {
        }

        Paragraph subtitleAssigment = new Paragraph(subtitle);
        subtitleAssigment.setAlignment(Paragraph.ALIGN_CENTER);
        subtitleAssigment.setSpacingAfter(10f); // Espacio después del subtítulo
        try {
            document.add(subtitleAssigment);
        } catch (DocumentException ex) {
        }
    }

    private void insertAditionalInformation(String aditionalInformation) {
        Paragraph additionalText = new Paragraph(aditionalInformation);
        additionalText.setAlignment(Paragraph.ALIGN_LEFT);
        additionalText.setSpacingBefore(10f); // Espacio antes del texto
        try {
            document.add(additionalText);
        } catch (DocumentException ex) {

        }
    }
}
