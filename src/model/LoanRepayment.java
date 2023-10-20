/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author jacobobc
 */
public class LoanRepayment {

    private final User user;
    private final Book book;
    private final LocalDate returnDate;

    private int id;

    public LoanRepayment(User user, Book book) {
        this.user = user;
        this.book = book;
        this.returnDate = LocalDate.now();
    }

    public LoanRepayment(User user, Book book, LocalDate returnDate, int id) {
        this.user = user;
        this.book = book;
        this.returnDate = returnDate;
        this.id = id;
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

    public int getId() {
        return id;
    }

}
