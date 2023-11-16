/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author jacobobc
 */
public class TransactionsPdfDao {

    private final Connection con;

    public TransactionsPdfDao() {
        con = Singleton.getINSTANCE().getConnection();
    }

    public boolean generateLoginsPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Ingreso al sistema");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;
                    
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateRegistrationBooksPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Registro de libro");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;
                    
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateUpdateBooksPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Actualización de datos libro");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateDeletionBooksPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Eliminación libro");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateRegistrationUsersPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Registro de usuario");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateUpdateUsersPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Edición de usuario");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateDeletionUsersPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Eliminación usuario");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateRequestsLoansPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Solicitud préstamo");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    public boolean generateLoanRepaymentsPdf(String filename) {

        boolean hasTransactions = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable table = createTable();

            String query = "SELECT users.id AS user_id, users.fullname, action_type, action_time FROM transactions JOIN users"
                    + " ON transactions.user_id = users.id WHERE action_type = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "Devolución préstamo");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    hasTransactions = true;

                    String date = LocalDate.now().toString();
                    String file = filename + "_" + date;

                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Escritorio/" + file + ".pdf"));
                    document.open();

                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTimestamp = dateFormat.format(rs.getTimestamp(4));
                        table.addCell(formattedTimestamp);
                    } while (rs.next());
                    document.add(table);

                    document.close();
                    openFile(ruta, file);

                }
            } catch (SQLException | DocumentException ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        }
        return hasTransactions;
    }

    private PdfPTable createTable() {
        float[] columnWidths = {10, 15, 15, 15};
        PdfPTable table = new PdfPTable(columnWidths);

        table.addCell(new Phrase("User id"));
        table.addCell(new Phrase("User name"));
        table.addCell(new Phrase("Action"));
        table.addCell(new Phrase("Date"));

        return table;

    }

    private void openFile(String ruta, String file) {
        try {
            Desktop.getDesktop().open(new File(ruta + "/Escritorio/" + file + ".pdf"));
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

}
