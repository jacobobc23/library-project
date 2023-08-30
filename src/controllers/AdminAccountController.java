package controllers;

import connection.BDConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jacobo-bc
 */
public class AdminAccountController {

    private final BDConnection conn;
    private final Connection con;

    public AdminAccountController() {
        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }

    public boolean updateAdmin(User admin) {
        try {
            PreparedStatement ps;

            String query = "UPDATE users SET username = ?, password = ? WHERE id = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getId());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    public boolean deleteAdmin(String id) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM users WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, id);

            int rowsDeleted = ps.executeUpdate();

            return rowsDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

}
