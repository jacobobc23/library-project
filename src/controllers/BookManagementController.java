package controllers;

import connection.BDConnection;
import enums.Genre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jacobo-bc
 */
public class BookManagementController {

    private final BDConnection conn;
    private final Connection con;

    public BookManagementController() {
        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }

    /**
     * Devuelve un arraylist que contiene todos los libros de la bd
     *
     * @return Un arraylist que tiene todos los productos y su información
     */
    public ArrayList<Book> listBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM books";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Genre genre = Genre.valueOf(rs.getString("genre"));
                int publicationYear = rs.getInt("publicationYear");
                int copiesNumber = rs.getInt("copiesNumber");

                Book book = new Book(isbn, title, author, genre, publicationYear, copiesNumber);
                books.add(book);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return books;
    }

    /**
     * Busca un libro por su isbn
     *
     * @param isbn El isbn del libro que se está buscando
     * @return Un libro. isbn es vacío, se devuelven todos los libros.
     */
    public Book searchBook(String isbn) {
        String where = "";

        if (!"".equals(isbn)) {
            where = "WHERE isbn = '" + isbn + "'";
        }

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM books " + where;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                Genre genre = Genre.valueOf(rs.getString("genre"));
                int publicationYear = rs.getInt("publicationYear");
                int copiesNumber = rs.getInt("copiesNumber");

                Book book = new Book(isbn, title, author, genre, publicationYear, copiesNumber);

                return book;
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    /**
     * Agrega un nuevo libro
     *
     * @param book
     * @throws SQLException
     */
    public void addBook(Book book) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO books (isbn, title, author, genre, publicationYear, copiesNumber) VALUES (?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getGenre().toString());
            ps.setInt(5, book.getPublicationYear());
            ps.setInt(6, book.getCopiesNumber());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    /**
     * Actualiza un libro
     *
     * @param book
     * @return
     */
    public boolean updateBook(Book book) {
        try {
            PreparedStatement ps;

            String query = "UPDATE books SET title = ?, author = ?, genre = ?, publicationYear = ?, copiesNumber = ? WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, String.valueOf(book.getGenre()));
            ps.setInt(4, book.getPublicationYear());
            ps.setInt(5, book.getCopiesNumber());
            ps.setString(6, book.getIsbn());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    /**
     * Elimina un libro de la bd.
     *
     * @param isbn El isbn del libro que se desea eliminar
     * @return true si se pudo eliminar, false en caso contrario.
     */
    public boolean deleteBook(String isbn) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM books WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, isbn);

            int rowDeleted = ps.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    public boolean titleInUse(String title) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM books WHERE title = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, title);

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
