package model;

import java.time.LocalDate;

/**
 *
 * @author Jacobo-bc
 */
public class Loan {

    private final User user;
    private final Book book;
    private final int bookQuantity;
    private int id;
    private LocalDate date;
    private LocalDate dueDate;

    public Loan(User user, Book book, int bookQuantity, LocalDate date, LocalDate dueDate) {
        this.user = user;
        this.book = book;
        this.bookQuantity = bookQuantity;
        this.date = date;
        this.dueDate = dueDate;
    }

    public Loan(User user, Book book, int bookQuantity, int id, LocalDate date, LocalDate dueDate) {
        this.user = user;
        this.book = book;
        this.bookQuantity = bookQuantity;
        this.id = id;
        this.date = date;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
