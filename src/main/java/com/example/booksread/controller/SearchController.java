package com.example.booksread.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.booksread.model.Author;
import com.example.booksread.model.Book;
import com.example.booksread.service.AuthorService;
import com.example.booksread.service.BookService;

@Controller
public class SearchController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/searchByTitle")
    public ModelAndView searchByTitle(@ModelAttribute("books") Book book) {
    	List<Book> books = bookService.findByTitle(book.getTitle());
    	ModelAndView modelAndView = new ModelAndView();
    	if (books.isEmpty()) {
    		modelAndView.setViewName("home.jsp");
    		modelAndView.addObject("errorMessage", "No Books by that Title");
    		modelAndView.addObject("visabilityMessage", "All Books");
    		modelAndView.addObject("books", bookService.findAll());
    		return modelAndView;
    	}
    	modelAndView.setViewName("WEB-INF/search.jsp");
    	modelAndView.addObject("books", books);
    	return modelAndView;
    }
    
    @PostMapping("/searchBySeries")
    public ModelAndView searchBySeries(@ModelAttribute("books") Book book) {
    	List<Book> books = bookService.findBySeries(book.getSeries());
    	ModelAndView modelAndView = new ModelAndView();
    	if (books.isEmpty()) {
    		modelAndView.setViewName("home.jsp");
    		modelAndView.addObject("errorMessage", "No Books in that Series");
    		modelAndView.addObject("visabilityMessage", "All Books");
    		modelAndView.addObject("books", bookService.findAll());
    		return modelAndView;
    	}
    	modelAndView.setViewName("WEB-INF/search.jsp");
    	modelAndView.addObject("books", books);
    	return modelAndView;
    }
    
    @PostMapping("/searchByAuthor")
    public ModelAndView searchByAuthor(@ModelAttribute("author") Author author) {
    	List<Book> books = bookService.findByAuthor(author.getFullName());
    	ModelAndView modelAndView = new ModelAndView();
    	if (books.isEmpty()) {
    		modelAndView.setViewName("home.jsp");
    		modelAndView.addObject("errorMessage", "No Books by " + author.getFullName());
    		modelAndView.addObject("visabilityMessage", "All Books");
    		modelAndView.addObject("books", bookService.findAll());
    		modelAndView.addObject("authors", authorService.findAll());
    		return modelAndView;
    	}
    	modelAndView.setViewName("WEB-INF/search.jsp");
    	modelAndView.addObject("books", books);
    	modelAndView.addObject("authors", authorService.findAll());
    	return modelAndView;
    }
    
    @PostMapping("/searchNotRead")
    public ModelAndView searchNotRead(@ModelAttribute("books") Book book) {
    	List<Book> books = bookService.findAllNotRead();
    	ModelAndView modelAndView = new ModelAndView();
    	if (books.isEmpty()) {
    		modelAndView.setViewName("home.jsp");
    		modelAndView.addObject("errorMessage", "You have read all books");
    		modelAndView.addObject("visabilityMessage", "All Books");
    		modelAndView.addObject("books", bookService.findAll());
    		return modelAndView;
    	}
    	modelAndView.setViewName("WEB-INF/search.jsp");
    	modelAndView.addObject("books", books);
    	return modelAndView;
    }
}
