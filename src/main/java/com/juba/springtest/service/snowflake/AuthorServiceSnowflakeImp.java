package com.juba.springtest.service.snowflake;
import com.juba.springtest.dto.AuthorCreateDTO;
import com.juba.springtest.dto.AuthorUpdateDTO;
import com.juba.springtest.dto.DTO;
import com.juba.springtest.model.snowflake.Author;
import com.juba.springtest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.juba.springtest.service.AuthorService;
import com.juba.springtest.repository.snowflake.AuthorRepository;
import java.util.List;
import javassist.NotFoundException;


@Repository
public class AuthorServiceSnowflakeImp implements AuthorService<Author, DTO> {

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
    public Author create(DTO authorCreateDto) {
        AuthorCreateDTO  authorDTO = (AuthorCreateDTO)authorCreateDto;
        Author author = new  Author();
        author.setAuthorName(authorDTO.getAuthorName());
        author.setAuthorAddress(authorDTO.getAuthorAddress());
        author.preCreate(authService.getUser());
        repo.save(author);
        return author;
    }

    @Override
    public Author update(DTO authoUpdateDto) throws Exception{
        AuthorUpdateDTO  authorDTO = (AuthorUpdateDTO)authoUpdateDto;
        Author author = getById(authorDTO.getId());
        if (author==null){
           throw new Exception("Record not found");
        }
        author.setAuthorName(authorDTO.getAuthorName());
        author.setAuthorAddress(authorDTO.getAuthorAddress());
        author.preUpdate(authService.getUser());
        repo.save(author);
        return author;
    }
}
