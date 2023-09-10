package com.juba.springtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthorDTO  {
    private String id;
    private String authorName;

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }
}
