package com.juba.springtest.service.snowflake;
import com.juba.springtest.dto.AuthorDTO;
import com.juba.springtest.model.snowflake.Author;
import com.juba.springtest.service.AuthService;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.juba.springtest.service.AuthorService;
import com.juba.springtest.repository.snowflake.AuthorRepository;
import java.util.List;


@Repository
public class AuthorServiceSnowflakeImp implements AuthorService<Author, AuthorDTO> {

     @Autowired
     AuthorRepository repo;
       
     
    @Autowired
    private final AuthService authService = null;
    

    @Override
    public List<Author> getAll() {
        return repo.findAllAuthors();
    }

    @Override
    public Author getById(String id) {
        return repo.findAuthorById(id);
    }

    @Override
    public Author save(AuthorDTO authorDTO) {
        Author author = new  Author();
        author.setId(authorDTO.getId());
        author.setAuthorName(authorDTO.getAuthorName());
        author.bindAccessInfo(authService.getUser());
        repo.save(author);
        return author;
    }
}
