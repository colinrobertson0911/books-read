package com.example.booksread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.booksread.service.BookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	

    @GetMapping("")
    public ModelAndView home(){
    	return new ModelAndView("home.jsp", "books", bookService.findAll());
    }

}
