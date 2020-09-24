package com.example.booksread.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_gen")
    @SequenceGenerator(name = "author_gen", sequenceName = "AUTHOR_SEQ", allocationSize = 1)
    private long authorId;

    @Column
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() &&
                getName().equals(author.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getName());
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
