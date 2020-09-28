package com.example.booksread.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
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
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "book_author", joinColumns =
    @JoinColumn(name = "bookId"), inverseJoinColumns =
    @JoinColumn(name = "authorId"))
    private List<Author> authors;


    @Column
    private boolean read;

    public Book(String title, String series, List<Author> authors, boolean read) {
        this.title = title;
        this.series = series;
        this.authors = authors;
        this.read = read;
    }

    public Book() {
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
                Objects.equals(getAuthors(), book.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getTitle(), getSeries(), getAuthors(), isRead());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", series='" + series + '\'' +
                ", authors=" + authors +
                ", read=" + read +
                '}';
    }
}
