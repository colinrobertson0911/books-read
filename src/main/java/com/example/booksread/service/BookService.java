package com.example.booksread.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booksread.model.Book;
import com.example.booksread.repository.BookDao;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
    
    public Book retrieveOne(Long bookId){
    	return bookDao.findByBookId(bookId);
    }
    
    public Optional<Book> findById(Long bookId){
    	return bookDao.findById(bookId);
    }

    public List<Book> findByTitle(String title){
        return bookDao.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findByAuthor(String fullName){
        return bookDao.findByAuthor(fullName);
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
    
    public List<Book> findAllOrderedBySeries(){
    	return bookDao.findAllOrderBySeries();
    }
    
}
