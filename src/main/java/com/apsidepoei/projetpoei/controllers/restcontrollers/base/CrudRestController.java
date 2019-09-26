package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.Optional;

public interface CrudRestController<T, ID> {

  Page<T> getAll(@PageableDefault() final Pageable pageable);
  Optional<T> getById(ID id);
  void deleteById(ID id);
  void deleteAll();
  T save(T item);
  Long count();
  T savetest(T item);
}
