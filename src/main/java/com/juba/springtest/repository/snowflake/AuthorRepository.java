package com.juba.springtest.repository.snowflake;
import com.juba.springtest.model.snowflake.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {

}
