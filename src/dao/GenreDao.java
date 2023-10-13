package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import exceptions.BookGenreException;
import interfaces.DaoInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Genre;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class GenreDao implements DaoInterface {

    private final Connection connection;

    public GenreDao() {
        connection = Singleton.getINSTANCE().getConnection();
    }

    @Override
    public ArrayList<Object> listEntity() {
        ArrayList<Object> genres = new ArrayList<>();

        String query = "SELECT * FROM genres";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ResultSet rs;

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return genres;
    }

    @Override
    public Object selectEntity(Object obj) {
        String query = "SELECT id, name FROM genres WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ResultSet rs;

            int id = (int) obj;

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                Genre genre = new Genre(id, name);
                return genre;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    @Override
    public void insertEntity(Object obj) {
        String query = "INSERT INTO genres (id, name) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            Genre genre = (Genre) obj;

            ps.setInt(1, genre.getId());
            ps.setString(2, genre.getName());

            ps.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    @Override
    public void updateEntity(Object obj) {
        String query = "UPDATE genres SET name = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            Genre genre = (Genre) obj;

            ps.setString(1, genre.getName());
            ps.setInt(2, genre.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    @Override
    public void deleteEntity(Object obj) {
        String query = "DELETE FROM genres WHERE id = ? AND NOT EXISTS (SELECT 1 FROM books WHERE genre_id = ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            int id = (int) obj;

            ps.setInt(1, id);
            ps.setInt(2, id);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted == 0) {
                throw new BookGenreException();
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

}
