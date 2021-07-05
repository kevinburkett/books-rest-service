package com.service.book;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import java.util.List;

interface BookRepository extends JpaRepository<Book, String> {
    // @Query("SELECT b FROM Book b WHERE CONCAT(b.id, ' ', b.AuthorName, ' ', b.title, ' ', b.publishDate, ' ', b.tags) LIKE %?1%")
    // public List<Book> search(String keyword); 

    // @Query("SELECT count(b) FROM Book b WHERE year(b.publishDate) = %?1%")
    // public List<Book> countByYear(Integer year); 

    // @Query("SELECT count(b) FROM Book b WHERE b.authorName LIKE %?1%")
    // public List<Book> countByAuthorName(String authorName); 
}
