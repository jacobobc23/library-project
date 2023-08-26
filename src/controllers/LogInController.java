package controllers;

import connection.BDConnection;
import enums.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jacobo-bc
 */
public class LogInController {

    private final BDConnection conn;
    private final Connection con;

    public LogInController() {
        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }
    
    /**
     * Busca el usuario que está intentando acceder al sistema.
     * @param username
     * @param password
     * @return 
     */
    public User searchUser(String username, String password) {
        try {
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                String id = rs.getString("id");
                String fullName = rs.getString("fullname");
                Role role = Role.valueOf(rs.getString("role"));
                String mobileNumber = rs.getString("mobilenumber");
                
                User user = new User(id, fullName, role, mobileNumber, username, password);
                
                return user;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

}
