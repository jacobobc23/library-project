package controllers;

import dao.BookDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;

/**
 * Controlador para gestionar los libros.
 *
 * @author Jacobo-bc
 */
public class BookManagementController {

    private final BookDAO bookDAO;

    public BookManagementController() {
        bookDAO = new BookDAO();
    }

    public ArrayList<Book> listBooks() {
        return bookDAO.listBooks();
    }

    public Book searchBook(String isbn) {
        return bookDAO.searchBook(isbn);
    }

    public void addBook(Book book) throws SQLException {
        bookDAO.addBook(book);
    }

    public boolean updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    public boolean deleteBook(String isbn) {
        return bookDAO.deleteBook(isbn);
    }

    public boolean titleInUse(String title) {
        return bookDAO.titleInUse(title);
    }

}
