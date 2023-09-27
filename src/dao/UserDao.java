package dao;

import enums.Role;
import exceptions.LoanPastDueException;
import exceptions.MobileNumberAlreadyInUseException;
import exceptions.UserAlreadyRegisteredException;
import exceptions.UserNameAlreadyInUseException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import model.Book;
import model.Loan;
import model.User;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;
import singleton.dao.SingletonBookDAO;

/**
 *
 * @author joanp
 */
public class UserDao {

    private final Connection connection;
    private final BookDao bookDao;

    public UserDao() {
        connection = Singleton.getINSTANCE().getConnection();
        bookDao = SingletonBookDAO.getINSTANCE().getBookdao();
    }

    public ArrayList<User> listUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                users.add(getUser(rs));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return users;
    }

    public ArrayList<Loan> listLoans(User user) {
        ArrayList<Loan> loans = new ArrayList<>();
        String query = "SELECT * FROM loans WHERE user_id = ?";

        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn_book");
                int loanId = rs.getInt("loan_id");
                LocalDate date = rs.getDate("loan_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                LocalDate returnDate = (rs.getDate("return_date") != null) ? rs.getDate("return_date").toLocalDate() : null;
                boolean returned = rs.getBoolean("returned");

                Book book = bookDao.searchBook(isbn);

                Loan loan = new Loan(user, book, returnDate, loanId, date, dueDate, returned);
                loans.add(loan);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return loans;
    }

    public User searchUser(String id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;

            ps.setString(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return getUser(rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void addUser(User user) {
        String query = "INSERT INTO users (id, fullname, role, mobilenumber, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {

            if (isUserRegistered(user.getId())) {
                throw new UserAlreadyRegisteredException();
            }

            if (isMobileNumberInUse(user.getMobileNumber())) {
                throw new MobileNumberAlreadyInUseException();
            }

            if (isUsernameInUse(user.getUsername())) {
                throw new UserNameAlreadyInUseException();
            }

            ps.setString(1, user.getId());
            ps.setString(2, user.getFullName());
            ps.setString(3, String.valueOf(user.getRole()));
            ps.setString(4, user.getMobileNumber());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void updateUser(User user) {
        String query = "UPDATE users SET mobilenumber = ?, username = ?, password = ? WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {

            if (isMobileNumberInUse(user.getMobileNumber())) {
                throw new MobileNumberAlreadyInUseException();
            }

            ps.setString(1, user.getMobileNumber());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void deleteUser(String id) {
        String query = "DELETE FROM users WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void applyLoan(Loan loan) throws LoanPastDueException {
        String query = "INSERT INTO loans (user_id, isbn_book, loan_date, due_date, returned, return_date) VALUES "
                + "(?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            User user = loan.getUser();

            if (hasPastDueLoan(user)) {
                throw new LoanPastDueException();
            }

            ps.setString(1, loan.getUser().getId());
            ps.setString(2, loan.getBook().getIsbn());
            ps.setDate(3, java.sql.Date.valueOf(loan.getDate()));
            ps.setDate(4, java.sql.Date.valueOf(loan.getDueDate()));
            ps.setBoolean(5, false);
            ps.setDate(6, null);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        subtractAvailableCopy(loan.getBook().getIsbn());
    }

    public void repayLoan(Loan loan) {
        String query = "UPDATE loans SET returned = true, return_date = ? WHERE loan_id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            Date currentDate = new Date();
            ps.setDate(1, new java.sql.Date(currentDate.getTime()));
            ps.setInt(2, loan.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        sumAvailableCopy(loan.getBook().getIsbn());
    }

    private void subtractAvailableCopy(String isbn) {
        String query = "UPDATE books SET copiesNumber = copiesNumber - 1 WHERE isbn = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, isbn);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    private void sumAvailableCopy(String isbn) {
        String query = "UPDATE books SET copiesNumber = copiesNumber + 1 WHERE isbn = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, isbn);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public boolean hasPastDueLoan(User user) {
        String query = "SELECT * FROM loans WHERE user_id = ? AND returned = false AND due_date < ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getId());
            Date currentDate = new Date();
            ps.setDate(2, new java.sql.Date(currentDate.getTime()));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    public boolean isMobileNumberInUse(String mobileNumber) {
        String query = "SELECT COUNT(*) FROM users WHERE mobilenumber = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;

            ps.setString(1, mobileNumber);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    public boolean isUserRegistered(String id) {
        String query = "SELECT COUNT(*) FROM users WHERE id = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;

            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    public boolean isUsernameInUse(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try ( PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;

            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    private User getUser(ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String fullname = rs.getString("fullname");
        Role role = Role.valueOf(rs.getString("role"));
        String mobilenumber = rs.getString("mobilenumber");
        String username = rs.getString("username");
        String password = rs.getString("password");

        return new User(id, fullname, role, mobilenumber, username, password);

    }
}
