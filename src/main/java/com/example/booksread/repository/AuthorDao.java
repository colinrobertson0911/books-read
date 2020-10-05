package com.example.booksread.repository;

import com.example.booksread.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorDao extends JpaRepository<Author, Long> {

    List<Author> findByFullName(@Param("fullName") String fullName);

}
