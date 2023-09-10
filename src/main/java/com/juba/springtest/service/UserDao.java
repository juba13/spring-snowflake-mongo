package com.juba.springtest.service;

import com.juba.springtest.model.User;

public interface UserDao {
      User getByEmailAndPassword(String email , String password);
}
