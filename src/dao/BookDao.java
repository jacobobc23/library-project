package dao;

import connection.BDConnection;
import enums.Genre;
import exceptions.BookAlreadyRegisteredException;
import exceptions.TitleAlreadyInUseException;
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
public class BookDAO {

    private final BDConnection conn;
    private final Connection con;

    public BookDAO() {
        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }

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
     * @return Un libro, null en caso de que no se encuentre.
     */
    public Book searchBook(String isbn) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM books WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, isbn);
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
    public void addBook(Book book) {
        try {

            if (isBookRegistered(book.getIsbn())) {
                throw new BookAlreadyRegisteredException();
            }

            if (isTitleInUse(book.getTitle())) {
                throw new TitleAlreadyInUseException();
            }

            PreparedStatement ps;

            String query = "INSERT INTO books (isbn, title, author, genre, publicationYear, copiesNumber) VALUES (?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getGenre().name());
            ps.setInt(5, book.getPublicationYear());
            ps.setInt(6, book.getCopiesNumber());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Actualiza un libro
     *
     * @param book
     * @return
     */
    public void updateBook(Book book) {
        try {

            if (isTitleInUse(book.getTitle())) {
                throw new TitleAlreadyInUseException();
            }

            PreparedStatement ps;

            String query = "UPDATE books SET title = ?, author = ?, genre = ?, publicationYear = ?, copiesNumber = ? WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre().name());
            ps.setInt(4, book.getPublicationYear());
            ps.setInt(5, book.getCopiesNumber());
            ps.setString(6, book.getIsbn());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Elimina un libro de la bd.
     *
     * @param isbn El isbn del libro que se desea eliminar
     * @return true si se pudo eliminar, false en caso contrario.
     */
    public void deleteBook(String isbn) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM books WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, isbn);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Valida si el titulo de un libro está en uso. En caso de que si, prohibe
     * el registro con ese nombre.
     *
     * @param title
     * @return true si existe un libro con ese titulo, false en caso contrario.
     */
    public boolean isTitleInUse(String title) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT COUNT(*) FROM books WHERE title = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, title);
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

    /**
     * Valida si un libro ya se encuentra registrado.
     *
     * @param isbn
     * @return
     */
    public boolean isBookRegistered(String isbn) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT COUNT(*) FROM books WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, isbn);
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

}
