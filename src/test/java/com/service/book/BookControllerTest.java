package com.service.book;

import java.time.LocalDate;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private TestRestTemplate restTemplate;
 
    private final BookRepository repository;
    BookControllerTest(BookRepository repository) {
        this.repository = repository;
    }

    private String id = "439023483";
    private String authorName = "Suzanne Collins";
    private String title = "The Hunger Games";
    private LocalDate publishDate = LocalDate.parse("09/14/2008");
    private String tags = "Drama";

    @BeforeTest
    public void addTestData() {
        Book book = new Book(id, authorName, title, publishDate, tags);
        repository.save(book);
    }

    @AfterTest
    public void deleteTetsData() {
        repository.deleteById(id);
    }

    @Test
    public void testGetAll() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/books", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody())
            .isEqualTo(id)
            .isEqualTo(authorName)
            .isEqualTo(title)
            .isEqualTo(publishDate)
            .isEqualTo(tags);
    }

    @Test
    public void testGet() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/books/" + id, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody())
            .isEqualTo(id)
            .isEqualTo(authorName)
            .isEqualTo(title)
            .isEqualTo(publishDate)
            .isEqualTo(tags);
    }

    @Test
    public void testDelete() {
        this.restTemplate.delete("/books/{id}");
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/books/" + id, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testPost() {
        Book book = new Book(id, authorName, title, publishDate, tags);
        ResponseEntity<Book> entity = this.restTemplate.postForEntity("/books", book, Book.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody())
            .isEqualTo(id)
            .isEqualTo(authorName)
            .isEqualTo(title)
            .isEqualTo(publishDate)
            .isEqualTo(tags);
    }
}
