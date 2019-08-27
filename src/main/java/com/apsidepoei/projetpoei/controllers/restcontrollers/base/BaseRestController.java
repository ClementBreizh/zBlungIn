package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author vianney
 *
 */
public abstract class BaseRestController<T, ID> implements CrudRestController<T, ID> {

  @Autowired
  protected JpaRepository<T, ID> repository;

  public BaseRestController(JpaRepository<T, ID> repository) {
    super();
    this.repository = repository;
  }

  @GetMapping(value= {"","/","/index"})
  @Override
  public List<T> getAll() {
    return repository.findAll();
  }

  @GetMapping(value= {"/{id}"})
  @Override
  public Optional<T> getById(@PathVariable(name="id") ID id) {
    return repository.findById(id);
  }

  @DeleteMapping(value= {"/{id}"})
  @Override
  public void deleteById(@PathVariable(name="id") ID id) {
    repository.deleteById(id);
  }

  @DeleteMapping(value= {"","/","/index"})
  @Override
  public void deleteAll() {
    repository.deleteAll();
  }

  @PostMapping(value= {"","/","/index"})
  @Override
  public T save(T item) {
    return repository.save(item);
  }

  @GetMapping("/count")
  @Override
  public Long count() {
    return repository.count();
  }
}
