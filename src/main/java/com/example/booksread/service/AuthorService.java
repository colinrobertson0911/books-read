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

    public List<Author> findByName(String name){
        return authorDao.findByName(name);
    }
}
