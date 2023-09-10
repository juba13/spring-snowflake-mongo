package com.juba.springtest.service;

import java.util.List;

/**
 *
 * @author mohammed
 */
public interface AuthorService<M,D> {
      List<M> getAll();
      M getById(String id);
      M create(D authorCreateDto);
      M update(D authoUpdateDto) throws Exception;
}
