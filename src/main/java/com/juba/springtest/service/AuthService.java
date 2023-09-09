package com.juba.springtest.service;

import com.juba.springtest.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    @Autowired
    HttpServletRequest request;
    
    @Value("${auth.token.key}")
    private String tokenKey;
        
    
    public User getUser() {
        return new User(getUserNo(), "", "");
    }
    
    public String getUserNo() {
        return String.valueOf(request.getAttribute("USER_NO"));
    }
    
    public String getSessionNo() {
        return String.valueOf(request.getAttribute("SESSION_NO")) ;
    }
    
    public String getToken(User user){
        return Jwts.builder()
                        .setId(UUID.randomUUID().toString())
                        .setIssuer(String.valueOf(user.getId()))
                        .setIssuedAt(Calendar.getInstance().getTime())
                        .setAudience("mongo-snoflake")
                        .setSubject("user-token")
                        .setNotBefore(Calendar.getInstance().getTime())
                        .signWith(SignatureAlgorithm.HS256, tokenKey)
                        .compact();
    }
    
    
    
    
}
