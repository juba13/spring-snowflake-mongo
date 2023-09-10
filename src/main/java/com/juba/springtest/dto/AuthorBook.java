package com.juba.springtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthorBook  {
    private String id;
    private String name;
    private String biography;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    

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
