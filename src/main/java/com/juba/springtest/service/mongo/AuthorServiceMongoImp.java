//package com.juba.springtest.service.mongo;
//
//import com.juba.springtest.dto.AuthorCreateDTO;
//import com.juba.springtest.dto.AuthorUpdateDTO;
//import com.juba.springtest.dto.DTO;
//import com.juba.springtest.model.mongo.Author;
//import com.juba.springtest.service.AuthService;
//import java.util.Date;
//import java.util.Iterator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Repository;
//import com.juba.springtest.service.AuthorService;
//import java.util.List;
//
//
//@Repository
//public class AuthorServiceMongoImp implements AuthorService<Author ,DTO> {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//    
//    
//    @Autowired
//    private final AuthService authService = null;
//
//    @Override
//    public List<Author> getAll() {
//        return mongoTemplate.findAll(Author.class);
//    }
//
//    @Override
//    public Author getById(String id) {
//        return mongoTemplate.findById(id, Author.class);
//    }
//
//    @Override
//    public Author create(DTO dto) {
//        AuthorCreateDTO  authorDTO = (AuthorCreateDTO)dto;
//        Author author = new  Author();
//        author.setAuhorName(authorDTO.getAuthorName());
//        
//        author.set(authorDTO.getAuthorName());
//        author.preCreate(authService.getUser());
//        mongoTemplate.save(author);
//        return author;
//    }
//    
//    
//    @Override
//    public Author update(DTO dto) {
//        AuthorUpdateDTO  authorDTO = (AuthorUpdateDTO)dto;
//        Author author = new  Author();
//        author.setId(authorDTO.getId());
//        author.setAuhorName(authorDTO.getAuthorName());
//        author.preUpdate(authService.getUser());
//        mongoTemplate.save(author);
//        return author;
//    }
//}
