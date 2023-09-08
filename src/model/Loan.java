package model;

import java.time.LocalDate;

/**
 *
 * @author Jacobo-bc
 */
public class Loan {
    
    private final User user;
    private final Book book;
    private final LocalDate returnDate;
    private LocalDate date;
    private LocalDate dueDate;
    private boolean returned;

    public Loan(User user, Book book, LocalDate date, LocalDate dueDate) {
        this.user = user;
        this.book = book;
        this.date = date;
        this.dueDate = dueDate;
        returnDate = null;
        returned = false;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
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

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
    
}