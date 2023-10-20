/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.DaoInterface;
import java.util.ArrayList;
import org.mariadb.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import model.Book;
import model.LoanRepayment;
import model.User;
import singleton.Singleton;

/**
 *
 * @author jacobobc
 */
public class LoanRepaymentDao implements DaoInterface {

    private final Connection con;

    public LoanRepaymentDao() {
        con = Singleton.getINSTANCE().getConnection();
    }

    @Override
    public ArrayList<Object> listEntity() {
        ArrayList<Object> loanRepayments = new ArrayList<>();
        String query = "SELECT * FROM loan_repayments";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String userId = rs.getString("user_id");
                String isbn = rs.getString("isbn_book");
                LocalDate returnDate = rs.getDate("return_date").toLocalDate();

                User user = getUser(userId);
                Book book = getBook(isbn);

                LoanRepayment loanRepayment = new LoanRepayment(user, book, returnDate, id);
                loanRepayments.add(loanRepayment);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return loanRepayments;
    }

    @Override
    public Object selectEntity(Object obj) {
        String query = "SELECT * FROM loan_repayments WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            int id = (int) obj;

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("user_id");
                String isbn = rs.getString("isbn_book");
                LocalDate returnDate = rs.getDate("return_date").toLocalDate();

                User user = getUser(userId);
                Book book = getBook(isbn);

                return new LoanRepayment(user, book, returnDate, id);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    @Override
    public void insertEntity(Object obj) {
        String query = "INSERT INTO loan_repayments(user_id, isbn_book, return_date) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            LoanRepayment loanRepayment = (LoanRepayment) obj;

            ps.setString(1, loanRepayment.getUser().getId());
            ps.setString(2, loanRepayment.getBook().getIsbn());
            ps.setDate(3, java.sql.Date.valueOf(loanRepayment.getReturnDate()));

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void updateEntity(Object obj) {

    }

    @Override
    public void deleteEntity(Object obj) {

    }

    private User getUser(String id) {
        UserDao userDao = new UserDao();
        return (User) userDao.selectEntity(id);
}

    private Book getBook(String isbn) {
        BookDao bookDao = new BookDao();
        return (Book) bookDao.selectEntity(isbn);
    }
}
