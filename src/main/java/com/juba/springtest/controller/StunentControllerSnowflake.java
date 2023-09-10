package com.juba.springtest.controller;

import com.juba.springtest.model.snowflake.Author;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.juba.springtest.repository.snowflake.AuthorRepository;


@RestController
@RequestMapping(value = "/snowflake/stduent")
public class StunentControllerSnowflake {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
        AuthorRepository repo;
       
        
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Author save(@RequestBody Author author) {
		return repo.save(author);
	}
        
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Iterator<Author> getAll() {
		return repo.findAll().iterator();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Author get(@PathVariable String id) {
		return repo.findById(id).get();
	}

}