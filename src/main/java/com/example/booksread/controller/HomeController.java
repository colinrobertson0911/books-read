package com.example.booksread.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.booksread.model.Author;
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

	@GetMapping("home")
	public ModelAndView homeScreen() {
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}
	
	@GetMapping("search")
	public ModelAndView search() {
		return new ModelAndView("WEB-INF/search.jsp", "books", bookService.findAll());
	}
	
	@GetMapping("addBook")
	public ModelAndView addBook() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addBook.jsp");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("authors", authorService.findAll());
		return modelAndView;
	}
	
	@PostMapping("addBookSubmit")
	public ModelAndView addBookSubmit(@ModelAttribute("book")Book book) {
		bookService.save(book);
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}
	
	@GetMapping("viewBook")
	public ModelAndView viewBook(@RequestParam("bookId")Long bookId) {
		return new ModelAndView("WEB-INF/viewBook.jsp", "book", bookService.retrieveOne(bookId));
	}
	
	@GetMapping("addAuthor")
	public ModelAndView addAuthor() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addAuthor.jsp");
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
	
	@PostMapping("addAuthorSubmit")
	public ModelAndView addAuthorSubmit(@ModelAttribute("author")Author author) {
		authorService.save(author);
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}
	
	@GetMapping("orderBySeries")
	public ModelAndView orderBySeries() {
		return new ModelAndView("home.jsp", "books", bookService.findAllOrderedBySeries());
	}
	
	@GetMapping("editBook")
	public ModelAndView editBook(@RequestParam("bookId")Long bookId) {
		Optional<Book> book = bookService.findById(bookId);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/editBook.jsp");
		modelAndView.addObject("book", book.get());
		modelAndView.addObject("authors", authorService.findAll());
		return modelAndView;
	}
	
	@PostMapping("editBookSubmit")
	public ModelAndView editBookSubmit(@ModelAttribute("book")Book book) {
		bookService.save(book);
		return new ModelAndView("home.jsp", "books", bookService.findAll());
	}

}
