package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import com.apsidepoei.projetpoei.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.Optional;

public interface CrudRestController<T, ID> {

  Page<T> getAll(@PageableDefault() final Pageable pageable);
  Optional<T> getById(ID id);
  void deleteById(ID id);
  void deleteAll();
  T create(T item);
  Long count();
  T savetest(T item);
  T update(T item, ID id) throws NotFoundException;

}
