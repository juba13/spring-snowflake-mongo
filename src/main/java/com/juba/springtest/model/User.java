package com.juba.springtest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends BaseEntity {
    
    
    private String name;
    private String email;
    private String password;
    
    public User(){} 

    public User(String id,String name, String email) {
        this.setId(id);
        this.name = name;
        this.email = email;
    }

    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
