package model;

import java.util.Objects;

/**
 *
 * @author Jacobo-bc
 */
public class Book {

    private final String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int publicationYear;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getCopiesNumber() {
        return copiesNumber;
    }

    public void setCopiesNumber(int copiesNumber) {
        this.copiesNumber = copiesNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return Objects.equals(isbn, book.getIsbn())
                && Objects.equals(title, book.getTitle())
                && Objects.equals(author, book.getAuthor())
                && genre == book.getGenre()
                && publicationYear == book.getPublicationYear()
                && copiesNumber == book.getCopiesNumber();
    }

}
