package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.BDConnection;
import exceptions.BookGenreException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Genre;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jacobo-bc
 */
public class GenreDao {

    private final BDConnection conn;
    private final Connection con;

    public GenreDao() {
        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }

    public ArrayList<Genre> listGenres() {
        ArrayList<Genre> genres = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM genres";

            ps = con.prepareStatement(query);
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

    public Genre searchGenre(String name) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT id, name FROM genres WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                Genre genre = new Genre(id, name);
                return genre;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void addGenre(Genre genre) throws SQLException {
        try {

            PreparedStatement ps;

            String query = "INSERT INTO genres (id, name) VALUES (?, ?)";

            ps = con.prepareStatement(query);

            ps.setInt(1, genre.getId());
            ps.setString(2, genre.getName());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void updateGenre(int id, String name) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "UPDATE genres SET name = ? WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void deleteGenre(int id) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM genres WHERE id = ? AND NOT EXISTS (SELECT 1 FROM books WHERE genre_id = ?)";

            ps = con.prepareStatement(query);
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
