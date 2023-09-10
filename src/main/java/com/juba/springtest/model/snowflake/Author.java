
package com.juba.springtest.model.snowflake;
import com.juba.springtest.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
public class Author extends BaseEntity{
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    

    @Column(name = "AUTHOR_ARRDESS")
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