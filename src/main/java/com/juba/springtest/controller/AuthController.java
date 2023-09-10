package com.juba.springtest.controller;

import com.juba.springtest.service.UserDao;
import com.juba.springtest.model.User;
import com.juba.springtest.service.AuthService;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {

        
       
	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
	private final UserDao userDao = null;
        
        @Autowired
	private final AuthService authService = null;

        @RequestMapping(value = "/login" , method = RequestMethod.POST)
        public ResponseEntity<String>  login(
                @RequestParam("email") String email,
                @RequestParam("password") String password,
                HttpServletRequest request) {
                
             User user = userDao.getByEmailAndPassword(email, password);
             if (user!=null) {
                 String token = authService.getToken(user);
                  HttpHeaders headers = new HttpHeaders();
                  headers.add("Authorization",token );
                
                return ResponseEntity.ok().headers(headers).body(token);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not valid"); 
            }
        }

}