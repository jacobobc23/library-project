package controllers;

import connection.BDConnection;
import enums.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jacobo-bc
 */
public class UserManagemetController {

    private final BDConnection conn;
    private final Connection con;

    public UserManagemetController() {
        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }

    public ArrayList<User> listUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM users";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String fullname = rs.getString("fullname");
                Role role = Role.valueOf(rs.getString("role"));
                String mobilenumber = rs.getString("mobilenumber");
                String username = rs.getString("username");
                String password = rs.getString("password");

                User user = new User(id, fullname, role, mobilenumber, username, password);
                users.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return users;
    }

    public User searchUser(String id) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM users WHERE id = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                String fullName = rs.getString("fullname");
                Role role = Role.valueOf(rs.getString("role"));
                String mobileNumber = rs.getString("mobilenumber");
                String username = rs.getString("username");
                String password = rs.getString("password");

                User user = new User(id, fullName, role, mobileNumber, username, password);

                return user;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void addUser(User user) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO users (id, fullname, role, mobilenumber, username, password) VALUES (?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setString(1, user.getId());
            ps.setString(2, user.getFullName());
            ps.setString(3, String.valueOf(user.getRole()));
            ps.setString(4, user.getMobileNumber());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public boolean updateUser(User user) {
        try {
            PreparedStatement ps;

            String query = "UPDATE users SET mobilenumber = ?, username = ?, password = ? WHERE id = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, user.getMobileNumber());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getId());

            int rowUpdated = ps.executeUpdate();

            return rowUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    public boolean deleteUser(String id) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM users WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, id);

            int rowDeleted = ps.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    public boolean mobileNumberInUse(String mobileNumber) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM users WHERE mobilenumber = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, mobileNumber);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
    
    public boolean usernameInUse(String username) {
        try {
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM users WHERE username = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

}
