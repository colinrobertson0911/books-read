package com.example.booksread;

import com.example.booksread.model.Author;
import com.example.booksread.model.Book;
import com.example.booksread.service.AuthorService;
import com.example.booksread.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Test
    public void test_thatABookCanBeAdded() {
    	LocalDate publishedDate = LocalDate.of(2020, 8, 31); 
        List<Author> authors = authorService.findAll();
        authors.get(0);
        Book book = new Book();
        book.setTitle("Cursed Mate");
        book.setSeries("Shadow Guild: The Rebel Book 5");
        book.setRead(false);
        book.setAuthors(authors);
        book.setAsin("B08DP6RSDM");
        book.setPublishedDate(publishedDate);
        int numberBeforeAdding = bookService.findAll().size();
        bookService.save(book);
        System.out.println(book);
        int numberAfterAdding = bookService.findAll().size();
        assertNotEquals(numberBeforeAdding, numberAfterAdding);
    }

    @Test
    public void test_thatABookCanBeRetrievedByTitle() {
        List<Book> book = bookService.findByTitle("Grimm");
        assertFalse(book.isEmpty());
    }

    @Test
    public void test_thatAListOfBooksCanBeRetrievedBySeries() {
        List<Book> books = bookService.findBySeries("Nate Temple");
        assertFalse(books.isEmpty());
    }

    @Test
    public void test_thatAListOfBooksCanBeRetrievedThatIHaventRead() {
        List<Book> books = bookService.findAllNotRead();
        assertFalse(books.isEmpty());
    }
    
    @Test
    public void test_thatAListOfBooksCanBeRetrievedByAuthor() {
    	List<Book> books = bookService.findByAuthor("Shayne Silvers");
    	System.out.println(books);
    	assertFalse(books.isEmpty());
    }
}
