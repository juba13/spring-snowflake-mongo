package com.juba.springtest.controller.mongo;

import com.juba.springtest.dto.AuthorDTO;
import com.juba.springtest.model.mongo.Author;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.juba.springtest.service.AuthorService;
import java.util.List;


@RestController
@RequestMapping(value = "/mongo/author")
public class AuthorControllerMongo {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
        @Qualifier("authorServiceMongoImp") 
	private final AuthorService<Author,AuthorDTO> authorDao = null;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Author save(@RequestBody AuthorDTO author) {
		LOG.info("Save", author);
		return authorDao.save(author);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Author> getAll() {
		LOG.info("Get all author");
		return authorDao.getAll();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Author get(@PathVariable String id) {
		LOG.info("Getting by auth with id: {}.", id);
		return authorDao.getById(id);
	}

}