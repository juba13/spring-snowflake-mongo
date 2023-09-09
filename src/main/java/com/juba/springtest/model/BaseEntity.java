package com.juba.springtest.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

public class BaseEntity {

   
    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdOn;

    @LastModifiedDate
    private Date updatedOn;

    @LastModifiedBy
    private String updatedBy;
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    public void bindAccessInfo(User user){
        if(getId() ==null){
           createdOn = new Date();
           createdBy = user.getId();
        }else{
           updatedOn = new Date();
           updatedBy = user.getId();
        }
       
    } 

}

