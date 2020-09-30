package com.example.booksread;

import com.example.booksread.model.Author;
import com.example.booksread.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorServiceTest {

    @Autowired
    AuthorService authorService;

    @Test
    public void test_thatAnAuthorCanBeAdded() {
        Author author = new Author();
        author.setFirstname("Michael");
        author.setLastname("Anderle");
        int numberBeforeAdding = authorService.findAll().size();
        authorService.save(author);
        int numberAfterAdding = authorService.findAll().size();
        assertNotEquals(numberBeforeAdding, numberAfterAdding);
    }

    @Test
    public void test_thatAnAuthorCanBeRetrievedByName() {
        List<Author> authors = authorService.findByLastname("Silvers");
        assertFalse(authors.isEmpty());
    }
}
