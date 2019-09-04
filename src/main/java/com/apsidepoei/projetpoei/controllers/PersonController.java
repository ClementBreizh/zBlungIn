package com.apsidepoei.projetpoei.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Person;

/**
 * Controller for persons form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/persons")
public class PersonController extends BaseController {

  @Autowired
  private PersonRepository repository;

  @GetMapping("/userByFLName")
  public List<Person> getAllUserByFirstnameLastname(@PathParam(value = "firstname") String firstname,
      @PathParam(value = "lastname") String lastname) {
    return (List<Person>) repository.findAllByFirstnameAndLastname(firstname, lastname);
  }

  /**
   * Constructor.
   */
  public PersonController() {
    super("/persons");
    System.out.println("test");
  }
}
