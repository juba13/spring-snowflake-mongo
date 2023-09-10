package com.juba.springtest.controller;

import com.juba.springtest.model.snowflake.Student;
import com.juba.springtest.repository.snowflake.StudentRepository;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/snowflake/stduent")
public class StunentControllerSnowflake {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
        StudentRepository repo;
       
        
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Student save(@RequestBody Student author) {
		return repo.save(author);
	}
        
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Iterator<Student> getAll() {
		return repo.findAll().iterator();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Student get(@PathVariable String id) {
		return repo.findById(id).get();
	}

}