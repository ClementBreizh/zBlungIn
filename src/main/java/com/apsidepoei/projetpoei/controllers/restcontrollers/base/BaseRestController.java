package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import com.apsidepoei.projetpoei.controllers.restcontrollers.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
  @JsonDeserialize(using=LocalDateDeserializer.class)
  public T save(@ModelAttribute T item) {
    return repository.save(item);
  }

 /*JSON ok

  @PostMapping(value= {"","/","/index"})
  @Override
  @JsonDeserialize(using=LocalDateDeserializer.class)
  public T save(@RequestBody T item) {
    return repository.save(item);
  }*/

  @GetMapping("/count")
  @Override
  public Long count() {
    return repository.count();
  }
}
