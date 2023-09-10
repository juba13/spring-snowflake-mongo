package com.juba.springtest.dto;


public class AuthorUpdateDTO  implements DTO{
    private String id;
    private String authorName;
    private String authorAddress;

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

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }
}
