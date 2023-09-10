/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juba.springtest.dao;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mohammed
 */
public interface AuthorDao<T> {
      Iterator<T> getAll();
      T getById(String id);
      T save(T author);
}
