package com.juba.springtest.model.mongo;

import com.juba.springtest.model.BaseEntity;
import javax.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Author extends BaseEntity{
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    

    @Column(name = "AUTHOR_ADDRESS")
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