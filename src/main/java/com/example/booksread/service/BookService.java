package com.example.booksread.service;

import com.example.booksread.model.Author;
import com.example.booksread.model.Book;
import com.example.booksread.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> findByTitle(String title){
        return bookDao.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findByAuthor(String lastname){
        return bookDao.findByAuthor(lastname);
    }

    public List<Book> findBySeries(String series) {
        return bookDao.findBySeriesContainingIgnoreCase(series);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public Book save(Book book) {
        return bookDao.save(book);
    }

    public List<Book> findAllNotRead() {
        return bookDao.findAllNotRead();
    }
}
