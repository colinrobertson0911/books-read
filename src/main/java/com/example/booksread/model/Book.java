package com.example.booksread.model;

import com.example.booksread.controller.utility.FormatWithLocale;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    @SequenceGenerator(name = "book_gen", sequenceName = "BOOK_SEQ", allocationSize = 1)
    private long bookId;

    @Column(nullable = false)
    private String title;

    @Column
    private String series;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns =
    @JoinColumn(name = "bookId"), inverseJoinColumns =
    @JoinColumn(name = "authorId"))
    private List<Author> authors;

    @Column
    private LocalDate dateRead;

    @Column
    private boolean read;

    public Book(String title, String series, List<Author> authors, LocalDate dateRead, boolean read) {
        this.title = title;
        this.series = series;
        this.authors = authors;
        this.dateRead = dateRead;
        this.read = read;
    }

    public Book() {
    }

    public String getReadDateFormatted() {
        return this.getDateRead().format(FormatWithLocale.DATE_FORMATTER);
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public LocalDate getDateRead() {
        return dateRead;
    }

    public void setDateRead(LocalDate dateRead) {
        this.dateRead = dateRead;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() &&
                isRead() == book.isRead() &&
                getTitle().equals(book.getTitle()) &&
                Objects.equals(getSeries(), book.getSeries()) &&
                Objects.equals(getAuthors(), book.getAuthors()) &&
                Objects.equals(getDateRead(), book.getDateRead());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getTitle(), getSeries(), getAuthors(), getDateRead(), isRead());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", series='" + series + '\'' +
                ", authors=" + authors +
                ", dateRead=" + dateRead +
                ", read=" + read +
                '}';
    }
}
