package model;

import enums.Genre;

/**
 *
 * @author Jacobo-bc
 */
public class Book {
    
    private final String isbn;
    private final String title;
    private final String author;
    private final Genre genre;
    private final int publicationYear;
    private int copiesNumber;
    
    public Book(String isbn, String title, String author, Genre genre, int publicationYear, int copiesNumber) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.copiesNumber = copiesNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }
    
    public int getPublicationYear() {
        return publicationYear;
    }

    public int getCopiesNumber() {
        return copiesNumber;
    }

    public void setCopiesNumber(int copiesNumber) {
        this.copiesNumber = copiesNumber;
    }
    
}
