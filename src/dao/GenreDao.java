package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import exceptions.BookGenreException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Genre;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class GenreDao {

    private final Connection connection;

    public GenreDao() {
        connection = Singleton.getINSTANCE().getConnection();
    }

    public ArrayList<Genre> listAllGenres() {
        ArrayList<Genre> genres = new ArrayList<>();

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

    public Genre selectGenre(int id) {
        String query = "SELECT id, name FROM genres WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ResultSet rs;

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

    public void insertGenre(Genre genre) throws SQLException {
        String query = "INSERT INTO genres (id, name) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, genre.getId());
            ps.setString(2, genre.getName());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void updateGenre(int id, String name) throws SQLException {
        String query = "UPDATE genres SET name = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void deleteGenre(int id) {
        String query = "DELETE FROM genres WHERE id = ? AND NOT EXISTS (SELECT 1 FROM books WHERE genre_id = ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

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
