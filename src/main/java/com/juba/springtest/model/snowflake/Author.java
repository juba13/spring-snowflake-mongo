
package com.juba.springtest.model.snowflake;
import com.juba.springtest.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
public class Author extends BaseEntity{
    @Column(name = "AUTHOR_NAME")
    private String auhorName;

    public String getAuhorName() {
        return auhorName;
    }

    public void setAuhorName(String auhorName) {
        this.auhorName = auhorName;
    }
    
    
}