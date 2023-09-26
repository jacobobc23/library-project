package dao;

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
import singleton.dao.SingletonBookDAO;
import singleton.dao.SingletonUserDAO;

/**
 *
 * @author joanp
 */
public class LoanDao {

    private final Connection connection;

    private final UserDao userDao;
    private final BookDao bookDao;

    public LoanDao() {
        connection = Singleton.getINSTANCE().getConnection();
        userDao = SingletonUserDAO.getINSTANCE().getUserdao();
        bookDao = SingletonBookDAO.getINSTANCE().getBookdao();
    }

    public ArrayList<Loan> listLoans() {
        ArrayList<Loan> loans = new ArrayList<>();

        String query = "SELECT * FROM loans";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ResultSet rs;

            rs = ps.executeQuery();

            while (rs.next()) {
                String userId = rs.getString("user_id");
                String isbn = rs.getString("isbn_book");
                LocalDate date = rs.getDate("loan_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                LocalDate returnDate = (rs.getDate("return_date") != null) ? rs.getDate("return_date").toLocalDate() : null;
                boolean returned = rs.getBoolean("returned");

                User user = userDao.searchUser(userId);
                Book book = bookDao.searchBook(isbn);

                Loan loan = new Loan(user, book, date, dueDate);
                loans.add(loan);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return loans;
    }
}
