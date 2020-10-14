package com.example.booksread.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.booksread.model.Book;

public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);

    @Query(value = "SELECT * FROM BOOK INNER JOIN BOOK_AUTHOR ON BOOK.BOOKID = BOOK_AUTHOR.BOOKID INNER JOIN AUTHOR ON BOOK_AUTHOR.AUTHORID = AUTHOR.AUTHORID WHERE AUTHOR.FULLNAME = ?", nativeQuery = true)
    List<Book> findByAuthor(@Param("name") String fullName);

    List<Book> findBySeriesContainingIgnoreCase(@Param("series") String series);

    @Query(value = "select * from book where book.read = false", nativeQuery = true)
    List<Book> findAllNotRead();
}
