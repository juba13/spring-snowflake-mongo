package com.juba.springtest.model;

import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document
public class Book extends BaseEntity {

    private String title;
    private String description;
    private String ISBN;
    private Genre genre;
    private Date publicationDate;
    private String publisher;
    private String language;
    private Map<String, String> bookSettings = new HashMap<>();
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Map<String, String> getBookSettings() {
        return bookSettings;
    }

    public void setBookSettings(Map<String, String> bookSettings) {
        this.bookSettings = bookSettings;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
