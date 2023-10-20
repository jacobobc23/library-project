package dao;

import enums.Role;
import exceptions.InsufficientCopiesException;
import exceptions.LoanPastDueException;
import exceptions.MobileNumberAlreadyInUseException;
import exceptions.UserAlreadyRegisteredException;
import exceptions.UserHasLoansException;
import exceptions.UserNameAlreadyInUseException;
import interfaces.DaoInterface;
import interfaces.UserDaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.Book;
import model.Loan;
import model.LoanRepayment;
import model.User;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class UserDao implements DaoInterface, UserDaoInterface {

    private final Connection connection;
    private final LoanRepaymentDao loanRepaymentDao;

    public UserDao() {
        connection = Singleton.getINSTANCE().getConnection();
        loanRepaymentDao = new LoanRepaymentDao();
    }

    @Override
    public ArrayList<Object> listEntity() {
        ArrayList<Object> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                users.add(getUser(rs));
            }
            return users;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    @Override
    public Object selectEntity(Object obj) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs;

            String id = (String) obj;

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

    @Override
    public void insertEntity(Object obj) {
        String query = "INSERT INTO users (id, fullname, role, mobilenumber, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            User user = (User) obj;

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

    @Override
    public void updateEntity(Object obj) {
        String query = "UPDATE users SET mobilenumber = ?, username = ?, password = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            User user = (User) obj;

            ps.setString(1, user.getMobileNumber());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void deleteEntity(Object obj) {
        String query = "DELETE FROM users WHERE id = ? AND NOT EXISTS (SELECT 1 FROM loans WHERE user_id = ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            String id = (String) obj;

            ps.setString(1, id);
            ps.setString(2, id);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted == 0) {
                throw new UserHasLoansException();
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void applyLoan(Loan loan) throws LoanPastDueException, InsufficientCopiesException {
        String query = "INSERT INTO loans (user_id, isbn_book, loan_date, due_date, book_quantity) VALUES "
                + "(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            User user = loan.getUser();

            if (!copiesAvailable(loan.getBook(), loan.getBookQuantity())) {
                throw new InsufficientCopiesException();
            }

            if (hasPastDueLoan(user)) {
                throw new LoanPastDueException();
            }

            ps.setString(1, loan.getUser().getId());
            ps.setString(2, loan.getBook().getIsbn());
            ps.setDate(3, java.sql.Date.valueOf(loan.getDate()));
            ps.setDate(4, java.sql.Date.valueOf(loan.getDueDate()));
            ps.setInt(5, loan.getBookQuantity());
            ps.executeUpdate();
            subtractAvailableCopy(loan.getBook().getIsbn(), loan.getBookQuantity());
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void repayLoan(Loan loan) {
        String query = "DELETE FROM loans WHERE loan_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, loan.getId());
            ps.executeUpdate();
            sumAvailableCopy(loan.getBook().getIsbn(), loan.getBookQuantity());

            LoanRepayment loanRepayment = new LoanRepayment(loan.getUser(), loan.getBook());
            loanRepaymentDao.insertEntity(loanRepayment);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public boolean hasPastDueLoan(User user) {
        String query = "SELECT * FROM loans WHERE user_id = ? AND due_date < ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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

    private Book getBook(String isbn) {
        BookDao bookDao = new BookDao();
        return (Book) bookDao.selectEntity(isbn);
    }

    private boolean copiesAvailable(Book book, int quantity) {
        Book b = getBook(book.getIsbn());

        if (b != null) {
            if (quantity <= book.getCopiesNumber()) {
                return true;
            }
        }
        return false; // No hay suficientes copias.
    }

    private void subtractAvailableCopy(String isbn, int quantity) {
        String query = "UPDATE books SET copiesNumber = copiesNumber - ? WHERE isbn = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, quantity);
            ps.setString(2, isbn);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    private void sumAvailableCopy(String isbn, int quantity) {
        String query = "UPDATE books SET copiesNumber = copiesNumber + ? WHERE isbn = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, quantity);
            ps.setString(2, isbn);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

}
