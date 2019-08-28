package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Person;

/**
 * @author clement
 *
 */
@RestController
@RequestMapping("/api/persons")
public class PersonRestController extends BaseRestController<Person, Integer> {
  public PersonRestController(@Autowired PersonRepository repository) {
    super(repository);
  }
}
