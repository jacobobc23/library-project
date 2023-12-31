package dao;

import exceptions.BookAlreadyRegisteredException;
import exceptions.BookIsLoanedException;
import exceptions.TitleAlreadyInUseException;
import interfaces.DaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import model.Genre;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class BookDao implements DaoInterface {

    private final Connection con;

    public BookDao() {
        con = Singleton.getINSTANCE().getConnection();
    }

    public ArrayList<Book> listBooksByGenre(int id) {
        ArrayList<Book> books = new ArrayList<>();

        String query = "SELECT books.isbn, books.title, books.author, books.publicationYear, books.copiesNumber,"
                + " genres.name FROM books JOIN genres ON books.genre_id = genres.id WHERE books.genre_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genreName = rs.getString("name");
                Genre genre = new Genre(id, genreName);
                int publicationYear = rs.getInt("publicationYear");
                int copiesNumber = rs.getInt("copiesNumber");

                Book book = new Book(isbn, title, author, genre, publicationYear, copiesNumber);
                books.add(book);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return books;
    }

    public ArrayList<Genre> listAllGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        String query = "SELECT * FROM genres";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String genreName = rs.getString("name");
                Genre genre = new Genre(id, genreName);
                genres.add(genre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return genres;
    }

    @Override
    public ArrayList<Object> listEntity() {
        ArrayList<Object> books = new ArrayList<>();
        String query = "SELECT books.isbn, books.title, books.author, books.publicationYear, books.copiesNumber,"
                + " books.genre_id, genres.name FROM books JOIN genres ON books.genre_id = genres.id";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int genreId = rs.getInt("genre_id");
                String genreName = rs.getString("name");
                Genre genre = new Genre(genreId, genreName);
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

    @Override
    public Object selectEntity(Object obj) {
        String query = "SELECT books.isbn, books.title, books.author, books.publicationYear, books.copiesNumber,"
                + " genres.id AS genre_id, genres.name AS genre_name FROM books JOIN genres ON books.genre_id = genres.id WHERE books.isbn = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            String isbn = (String) obj;
            ps.setString(1, isbn);
            rs = ps.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int genreId = rs.getInt("genre_id");
                String genreName = rs.getString("genre_name");
                Genre genre = new Genre(genreId, genreName);
                int publicationYear = rs.getInt("publicationYear");
                int copiesNumber = rs.getInt("copiesNumber");

                return new Book(isbn, title, author, genre, publicationYear, copiesNumber);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    @Override
    public void insertEntity(Object obj) {
        String query = "INSERT INTO books (isbn, title, author, publicationYear, copiesNumber, genre_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            Book book = (Book) obj;

            if (isBookRegistered(book.getIsbn())) {
                throw new BookAlreadyRegisteredException();
            }

            if (isTitleInUse(book.getTitle())) {
                throw new TitleAlreadyInUseException();
            }

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPublicationYear());
            ps.setInt(5, book.getCopiesNumber());
            ps.setInt(6, book.getGenre().getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void updateEntity(Object obj) {
        String query = "UPDATE books SET title = ?, author = ?, publicationYear = ?, copiesNumber = ?, genre_id = ? WHERE isbn = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            Book book = (Book) obj;

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublicationYear());
            ps.setInt(4, book.getCopiesNumber());
            ps.setInt(5, book.getGenre().getId());
            ps.setString(6, book.getIsbn());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void deleteEntity(Object obj) {
        String query = "DELETE FROM books WHERE isbn = ? AND NOT EXISTS (SELECT 1 FROM loans WHERE isbn_book = ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            String isbn = (String) obj;

            ps.setString(1, isbn);
            ps.setString(2, isbn);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted == 0) {
                throw new BookIsLoanedException();
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public boolean isTitleInUse(String title) {
        String query = "SELECT COUNT(*) FROM books WHERE title = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            ps.setString(1, title);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Hay un libro registrado con ese título
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    public boolean isBookRegistered(String isbn) {
        String query = "SELECT COUNT(*) FROM books WHERE isbn = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs;

            ps.setString(1, isbn);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Un libro ya se encuentra registrado
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

}
