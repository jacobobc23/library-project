package model;

import enums.TransactionType;
import java.time.LocalDate;

/**
 *
 * @author Jacobo-bc
 */
public class Transaction {
    
    private int id;
    private final Book book;
    private final LocalDate date;
    private final LocalDate dueDate;
    private final TransactionType type;
    
    public Transaction(Book book, LocalDate date, TransactionType type) {
        this.book = book;
        this.date = date;
        this.type = type;
        dueDate = null;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TransactionType getType() {
        return type;
    }
    
}
