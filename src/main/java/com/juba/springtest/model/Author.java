package com.juba.springtest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author extends BaseEntity {
    private String name;
    private String biography;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    
    
}
