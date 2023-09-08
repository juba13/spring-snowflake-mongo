package com.juba.springtest.controller;

import com.juba.springtest.dao.AuthorDao;
import com.juba.springtest.model.Author;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/author")
public class AuthorController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
	private final AuthorDao authorDao = null;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Author save(@RequestBody Author author) {
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