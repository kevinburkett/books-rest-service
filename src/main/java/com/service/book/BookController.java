package com.service.book;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookRepository repository;
    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> all() {
        return repository.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    Book one(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    // @GetMapping("/books/search/{keywords}")
    // Book search(@PathVariable String keywords) {
    //     return repository.search(keywords).orElseThrow(() -> new BookNotFoundException(id));
    // }

    // @GetMapping("/books/count-by-year/{year}")
    // Book countByYear(@PathVariable Integer year) {
    //     return repository.countByYear(year).orElseThrow(() -> new BookNotFoundException(id));
    // }

    // @GetMapping("/books/count-by-author-name/{authorName}")
    // Book countByAuthorName(@PathVariable String authorName) {
    //     return repository.countByAuthorName(authorName).orElseThrow(() -> new BookNotFoundException(id));
    // }

    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable String id) {
        return repository.findById(id).map(book -> {
                book.setAuthorName(newBook.getAuthorName());
                book.setTitle(newBook.getTitle());
                book.setPublishDate(newBook.getPublishDate());
                book.setTags(newBook.getTags());
                return repository.save(book);
            })
            .orElseGet(() -> {
                newBook.setId(id);
                return repository.save(newBook);
            });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable String id) {
        repository.deleteById(id);
    }
}
