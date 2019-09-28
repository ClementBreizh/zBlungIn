package com.apsidepoei.projetpoei.controllers.restcontrollers.base;

import com.apsidepoei.projetpoei.entities.ResourceDb;
import com.apsidepoei.projetpoei.exceptions.NotFoundException;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Generic REST Controller.
 *
 * @author vianney
 */

public abstract class BaseRestController<T extends ResourceDb<ID>, ID>
    implements CrudRestController<T, ID> {

  protected JpaRepository<T, ID> repository;

  public BaseRestController(JpaRepository<T, ID> repository) {
    super();
    this.repository = repository;
  }

  @GetMapping(value = {"", "/", "/index"})
  @Override
  public Page<T> getAll(final Pageable pageable) {
    return repository.findAll(pageable);
  }

  @GetMapping(value = {"/{id}"})
  @Override
  public Optional<T> getById(@PathVariable(name = "id") ID id) {
    return repository.findById(id);
  }

  @DeleteMapping(value = {"/{id}"})
  @Override
  public void deleteById(@PathVariable(name = "id") ID id) {
    repository.deleteById(id);
  }

  @PutMapping(value = "{id}")
  @Override
  public T update(@Valid @RequestBody T item, @PathVariable ID id) throws NotFoundException {
    if (!repository.existsById(id)) {
      throw new NotFoundException();
    }
    item.setId(id);
    return this.save(item);
  }


  @DeleteMapping(value = {"", "/", "/index"})
  @Override
  public void deleteAll() {
    repository.deleteAll();
  }

  @PostMapping(value = {"", "/", "/index"})
  @Override
  public T create(@Valid @RequestBody T item) {
    return this.save(item);
  }

  @PostMapping(value = {"/test"})
  @Override
  public T savetest(@RequestBody T item) {
    return repository.save(item);
  }

  @GetMapping("/count")
  @Override
  public Long count() {
    return repository.count();
  }

  protected T save(final T item) {
    return repository.save(item);
  }
}
