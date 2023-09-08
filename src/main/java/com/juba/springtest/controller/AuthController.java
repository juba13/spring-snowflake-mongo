package com.juba.springtest.controller;

import com.juba.springtest.dao.UserDao;
import com.juba.springtest.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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

        
        @Value("${auth.token.key}")
        private String tokenKey;
        
	private final Logger LOG = LoggerFactory.getLogger(getClass());

        @Autowired
	private final UserDao userDao = null;

        @RequestMapping(value = "/login" , method = RequestMethod.POST)
        public ResponseEntity<String>  login(
                @RequestParam("email") String email,
                @RequestParam("password") String password,
                HttpServletRequest request) {
                
             User user = userDao.getByEmailAndPassword(email, password);
             if (user!=null) {
                String token = Jwts.builder()
                        .setId(UUID.randomUUID().toString())
                        .setIssuer(String.valueOf(user.getId()))
                        .setIssuedAt(Calendar.getInstance().getTime())
                        .setAudience("mongo-snoflake")
                        .setSubject("user-token")
                        .setNotBefore(Calendar.getInstance().getTime())
                        .signWith(SignatureAlgorithm.HS256, tokenKey)
                        .compact();
                
                  HttpHeaders headers = new HttpHeaders();
                  headers.add("Authorization", token);
                
                return ResponseEntity.ok().headers(headers).body(token);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not valid"); 
            }
        }

}