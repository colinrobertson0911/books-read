package com.example.booksread.service;

import com.example.booksread.model.Author;
import com.example.booksread.repository.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public List<Author> findByLastname(String lastname){
        return authorDao.findByLastname(lastname);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }

    public Author save(Author author) {
        return authorDao.save(author);
    }

}
