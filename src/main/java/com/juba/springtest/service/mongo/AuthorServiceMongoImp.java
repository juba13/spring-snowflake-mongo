package com.juba.springtest.service.mongo;

import com.juba.springtest.dto.AuthorDTO;
import com.juba.springtest.model.mongo.Author;
import com.juba.springtest.service.AuthService;
import java.util.Date;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.juba.springtest.service.AuthorService;
import java.util.List;


@Repository
public class AuthorServiceMongoImp implements AuthorService<Author ,AuthorDTO> {

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
    public Author save(AuthorDTO authorDTO) {
        Author author = new  Author();
        author.setId(authorDTO.getId());
        author.setAuhorName(authorDTO.getAuthorName());
        author.bindAccessInfo(authService.getUser());
        mongoTemplate.save(author);
        return author;
    }
}
