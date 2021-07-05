package com.service.book;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Book {
    private @Id String id;
    private String authorName;
    private String title;
    private @JsonFormat(pattern = "MM/dd/yyyy") LocalDate publishDate;
    private String tags;

    Book() {}

    Book(String id, String authorName, String title, LocalDate publishDate, String tags) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.publishDate = publishDate;
        this.tags = tags;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return this.publishDate.getYear();
    }

    public LocalDate getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        return Objects.equals(this.id, book.id) && 
            Objects.equals(this.authorName, book.authorName) && 
            Objects.equals(this.title, book.title) && 
            Objects.equals(this.publishDate, book.publishDate) && 
            Objects.equals(this.tags, book.tags);
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.authorName, this.title, this.publishDate, this.tags);
    }
  
    @Override
    public String toString() {
        return "Book{" + "id=" + this.id + ", authorName='" + this.authorName + '\'' + ", title='" + this.title + '\'' + ", publishDate='" + this.publishDate + '\'' + ", tags='" + this.tags + '\'' + '}';
    }
}
