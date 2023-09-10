package com.juba.springtest.repository.snowflake;
import com.juba.springtest.model.snowflake.Author;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {
    
    @Query(value = "SELECT ID as \"id\", AUTHOR_NAME as \"author_name\", CREATED_BY as \"created_by\", CREATED_ON as \"created_on\", UPDATED_ON as \"updated_on\", UPDATED_BY as \"updated_by\" FROM AUTHOR WHERE ID = ?", nativeQuery = true)
    Author findAuthorById(String id);
    
    @Query(value = "SELECT ID as \"id\", AUTHOR_NAME as \"author_name\", CREATED_BY as \"created_by\", CREATED_ON as \"created_on\", UPDATED_ON as \"updated_on\", UPDATED_BY as \"updated_by\" FROM AUTHOR ", nativeQuery = true)
    List<Author> findAllAuthors();

}
