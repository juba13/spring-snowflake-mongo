package com.juba.springtest.dao;

import com.juba.springtest.model.User;

public interface UserDao {
      User getByEmailAndPassword(String email , String password);
}
