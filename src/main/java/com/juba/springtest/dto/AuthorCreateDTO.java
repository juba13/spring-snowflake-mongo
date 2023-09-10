package com.juba.springtest.dto;


public class AuthorCreateDTO implements DTO{
    private String authorName;
    private String authorAddress;


    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }
}
