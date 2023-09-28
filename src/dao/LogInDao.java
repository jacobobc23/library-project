package dao;

import enums.Role;
import exceptions.CredentialsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class LogInDao {

    private final Connection connection;

    public LogInDao() {
        connection = Singleton.getINSTANCE().getConnection();
    }

    /**
     * Busca el usuario que está intentando acceder al sistema.
     *
     * @param username
     * @param password
     * @return el usuario que va a ingresar, null si no se encontró un usuario
     * con esas credenciales.
     */
    public User selectUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ResultSet rs;

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

            } else {
                throw new CredentialsException();
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

}
