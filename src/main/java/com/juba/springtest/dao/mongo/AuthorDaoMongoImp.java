package com.juba.springtest.dao.mongo;

import com.juba.springtest.dao.AuthorDao;
import com.juba.springtest.model.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AuthorDaoMongoImp implements AuthorDao {

    @Autowired
    private MongoTemplate mongoTemplate;

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
        mongoTemplate.save(author);
        return author;
    }
}
