package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @author vianney
 *
 */
public abstract class BaseRestController<T, ID> implements CrudRestController<T, ID> {

  protected JpaRepository<T, ID> repository;

  public BaseRestController(JpaRepository<T, ID> repository) {
    super();
    this.repository = repository;
  }

  @GetMapping(value = {"","/","/index"})
  @Override
  public Page<T> getAll(final Pageable pageable) {
    return repository.findAll(pageable);
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

  @PostMapping(value= {"/test"})
  @Override
  public T savetest(@RequestBody T item) {
    return repository.save(item);
  }

  @GetMapping("/count")
  @Override
  public Long count() {
    return repository.count();
  }
}
