package com.juba.springtest.model;

import javax.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Genre extends BaseEntity {

    @NotNull
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}