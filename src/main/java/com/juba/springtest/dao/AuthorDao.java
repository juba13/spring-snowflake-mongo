/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juba.springtest.dao;

import com.juba.springtest.model.Author;
import java.util.List;

/**
 *
 * @author mohammed
 */
public interface AuthorDao {
      List<Author> getAll();
      Author getById(String id);
      Author save(Author author);
}
