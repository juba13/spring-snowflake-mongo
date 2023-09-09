package com.juba.springtest.dao.mongo;

import com.juba.springtest.dao.AuthorDao;
import com.juba.springtest.model.Author;
import com.juba.springtest.service.AuthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AuthorDaoMongoImp implements AuthorDao {

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
    public Author save(Author author) {
        author.bindAccessInfo(authService.getUser());
        mongoTemplate.save(author);
        return author;
    }
}
