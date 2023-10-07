package controllers;

import dao.BookDao;
import java.util.ArrayList;
import model.Book;
import model.Genre;

/**
 * Controlador para gestionar los libros.
 *
 * @author joanp
 */
public class BookManagementController {

    private final BookDao bookDao;

    public BookManagementController() {
        bookDao = new BookDao();
    }

    public ArrayList<Book> listBooks() {
        return bookDao.listBooks();
    }
    
    public ArrayList<Book> listBooksByGenre(int id) {
        return bookDao.listBooksByGenre(id);
    }

    public ArrayList<Genre> listAllGenres() {
        return bookDao.listAllGenres();
    }
    
    public Book selectBook(String isbn) {
        return bookDao.selectBook(isbn);
    }

    public void insertBook(Book book) {
        bookDao.insertBook(book);
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

}
