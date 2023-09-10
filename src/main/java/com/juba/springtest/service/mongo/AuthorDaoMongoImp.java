package com.juba.springtest.service.mongo;

import com.juba.springtest.dao.AuthorDao;
import com.juba.springtest.model.mongo.Author;
import com.juba.springtest.service.AuthService;
import java.util.Date;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AuthorDaoMongoImp implements AuthorDao<Author> {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private final AuthService authService = null;

    @Override
    public Iterator<Author> getAll() {
        return mongoTemplate.findAll(Author.class).iterator();
    }

    @Override
    public Author getById(String id) {
        return mongoTemplate.findById(id, Author.class);
    }

    @Override
    public Author save(Author author) {
        if(author.getId() ==null){
           author.setCreatedOn(new Date());
           author.setCreatedBy(authService.getUserNo());
        }else{
           author.setUpdatedOn(new Date());
           author.setUpdatedBy(authService.getUserNo());
        }
        mongoTemplate.save(author);
        return author;
    }
}
