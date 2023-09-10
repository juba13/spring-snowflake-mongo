package com.juba.springtest.controller.snowflake;

import com.juba.springtest.dto.AuthorCreateDTO;
import com.juba.springtest.dto.AuthorUpdateDTO;
import com.juba.springtest.dto.DTO;
import com.juba.springtest.model.snowflake.Author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.juba.springtest.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
@RequestMapping(value = "/snowflake/author")
public class AuthorControllerSnowflake {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
        @Qualifier("authorServiceSnowflakeImp") 
        AuthorService<Author , DTO> service =null;
        
        
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Author> getAll() {
		return service.getAll()	;
        }

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Author get(@PathVariable String id) {
		return service.getById(id);
	}
        
        
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Author create(@RequestBody AuthorCreateDTO author) {
		return service.create(author);
	}

        
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Author update(@RequestBody AuthorUpdateDTO author) throws Exception {
		return service.update(author);
	}

}