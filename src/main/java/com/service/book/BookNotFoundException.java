package com.service.book;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(String id) {
        super("Could not find book " + id);
    }
}
