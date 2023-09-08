package com.juba.springtest.dao.mongo;

import com.juba.springtest.dao.UserDao;
import com.juba.springtest.model.User;
import org.springframework.stereotype.Repository;



@Repository
public class UserDaoMongoImp implements UserDao {

    @Override
    public User getByEmailAndPassword(String email, String password) {
        
        if (email.equalsIgnoreCase("admin@abc.com") && password.equals("1234")) {
            return new User("64fb6d0102969c0e35dd7e9b", "admin", email);
        }
        return null;
    }

  
}
