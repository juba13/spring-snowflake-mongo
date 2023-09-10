package com.juba.springtest.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public abstract class BaseEntity  {
   
    @Id
    @Column(name = "ID")
    protected String id;
    
    @Column(name = "CREATED_BY")
    protected String createdBy;
    
    @Column(name = "CREATED_ON")
    protected Date createdOn;
    
    @Column(name = "UPDATED_ON")
    protected Date updatedOn;
    
    @Column(name = "UPDATED_BY")
    protected String updatedBy;

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
        if(id == null){
           id= UUID.randomUUID().toString();
           createdOn= new Date();
           createdBy= user.getId();
        }else{
           updatedBy=user.getUpdatedBy();
           updatedOn = new Date();
        }
    }

}

