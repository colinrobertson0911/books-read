package com.example.booksread.repository;

import com.example.booksread.model.Author;
import com.example.booksread.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);

    @Query(value = "select * from book inner join book_author on book.bookid = book_author.bookid inner join author on book_author.authorid = author.authorid where author.lastname = ?", nativeQuery = true)
    List<Book> findByAuthor(@Param("lastname") String lastname);

    List<Book> findBySeriesContainingIgnoreCase(@Param("series") String series);

    @Query(value = "select * from book where book.read = false", nativeQuery = true)
    List<Book> findAllNotRead();
}
