package dao;

import interfaces.LoanDaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Book;
import model.Loan;
import model.User;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class LoanDao implements LoanDaoInterface {

    private final Connection con;

    public LoanDao() {
        con = Singleton.getINSTANCE().getConnection();
    }

    @Override
    public ArrayList<Loan> listUserLoans(User user) {
        ArrayList<Loan> loans = new ArrayList<>();
        String query = "SELECT * FROM loans WHERE user_id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn_book");
                int loanId = rs.getInt("loan_id");
                int bookQuantity = rs.getInt("book_quantity");
                LocalDate date = rs.getDate("loan_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();

                Book book = getBook(isbn);

                Loan loan = new Loan(user, book, bookQuantity, loanId, date, dueDate);
                loans.add(loan);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return loans;
    }

    @Override
    public ArrayList<Loan> listAllLoans() {
        ArrayList<Loan> loans = new ArrayList<>();

        String query = "SELECT * FROM loans";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            rs = ps.executeQuery();

            while (rs.next()) {
                String userId = rs.getString("user_id");
                String isbn = rs.getString("isbn_book");
                int loanId = rs.getInt("loan_id");
                int bookQuantity = rs.getInt("book_quantity");
                LocalDate date = rs.getDate("loan_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();

                User user = getUser(userId);
                Book book = getBook(isbn);

                Loan loan = new Loan(user, book, bookQuantity, loanId, date, dueDate);
                loans.add(loan);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return loans;
    }

    @Override
    public Loan selectLoan(int id) {
        String query = "SELECT * FROM loans WHERE loan_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("user_id");
                String isbn = rs.getString("isbn_book");
                int bookQuantity = rs.getInt("book_quantity");
                LocalDate date = rs.getDate("loan_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();

                User user = getUser(userId);
                Book book = getBook(isbn);

                return new Loan(user, book, bookQuantity, id, date, dueDate);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
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
