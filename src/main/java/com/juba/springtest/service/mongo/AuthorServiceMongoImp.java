package com.juba.springtest.service.mongo;

import com.juba.springtest.dto.AuthorCreateDTO;
import com.juba.springtest.dto.AuthorUpdateDTO;
import com.juba.springtest.dto.DTO;
import com.juba.springtest.model.mongo.Author;
import com.juba.springtest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.juba.springtest.service.AuthorService;
import java.util.List;


@Repository
public class AuthorServiceMongoImp implements AuthorService<Author ,DTO> {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    
    @Autowired
    private final AuthService authService = null;

    @Override
    public List<Author> getAll() {
        return mongoTemplate.findAll(Author.class);
    }

    @Override
    public Author getById(String id) {
        return mongoTemplate.findById(id, Author.class);
    }

    
    @Override
    public Author create(DTO authorCreateDto) {
        AuthorCreateDTO  authorDTO = (AuthorCreateDTO)authorCreateDto;
        Author author = new  Author();
        author.setAuthorName(authorDTO.getAuthorName());
        author.setAuthorAddress(authorDTO.getAuthorAddress());
        author.preCreate(authService.getUser());
        mongoTemplate.save(author);
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
        mongoTemplate.save(author);
        return author;
    }
}
