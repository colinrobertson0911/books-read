package com.example.booksread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.booksread.model.Book;
import com.example.booksread.service.AuthorService;
import com.example.booksread.service.BookService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	@GetMapping("")
	public ModelAndView home() {
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}

	@GetMapping("/home")
	public ModelAndView homeScreen() {
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}
	
	@GetMapping("/search")
	public ModelAndView search() {
		return new ModelAndView("WEB-INF/search.jsp", "books", bookService.findAll());
	}
	
	@GetMapping("/addBook")
	public ModelAndView addBook() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addBook.jsp");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("allAuthors", authorService.findAll());
		return modelAndView;
	}
	
	@PostMapping("/addBookSubmit")
	public ModelAndView addBookSubmit(@ModelAttribute("book")Book book) {
		bookService.save(book);
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}

}
