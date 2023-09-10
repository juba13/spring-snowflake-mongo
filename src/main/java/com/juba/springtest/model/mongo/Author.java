package com.juba.springtest.model.mongo;

import com.juba.springtest.model.BaseEntity;
import javax.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Author extends BaseEntity {
    @Column(name = "AUTHOR_NAME")
    private String auhorName;
    

    public String getAuhorName() {
        return auhorName;
    }

    public void setAuhorName(String auhorName) {
        this.auhorName = auhorName;
    }
}
