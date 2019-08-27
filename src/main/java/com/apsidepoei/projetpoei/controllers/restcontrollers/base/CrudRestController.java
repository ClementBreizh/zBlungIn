package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import java.util.List;
import java.util.Optional;

public interface CrudRestController<T, ID> {

  List<T> getAll();
  Optional<T> getById(ID id);
  void deleteById(ID id);
  void deleteAll();
  T save(T item);
  Long count();
}
