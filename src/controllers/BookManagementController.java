package controllers;

import dao.BookDao;
import java.util.ArrayList;
import model.Book;
import model.Genre;

/**
 * Controlador para gestionar los libros.
 *
 * @author Jacobo-bc
 */
public class BookManagementController {

    private final BookDao bookDao;

    public BookManagementController() {
        bookDao = new BookDao();
    }

    public ArrayList<Book> listBooks() {
        return bookDao.listBooks();
    }

    public Book searchBook(String isbn) {
        return bookDao.searchBook(isbn);
    }
    
    public ArrayList<Book> searchBooksByGenre(int id) {
        return bookDao.searchBooksByGenre(id);
    }

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(String isbn) {
        bookDao.deleteBook(isbn);
    }

    public boolean isTitleInUse(String title) {
        return bookDao.isTitleInUse(title);
    }

    public boolean isBookRegistered(String isbn) {
        return bookDao.isBookRegistered(isbn);
    }
    
    public ArrayList<Genre> getAllGenres() {
        return bookDao.getAllGenres();
    }

}
