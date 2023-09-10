package com.juba.springtest.service;

import java.util.List;

/**
 *
 * @author mohammed
 */
public interface AuthorService<M,D> {
      List<M> getAll();
      M getById(String id);
      M save(D author);
}
