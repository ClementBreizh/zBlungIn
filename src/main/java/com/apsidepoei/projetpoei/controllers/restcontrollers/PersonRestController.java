package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.PersonRepository;

/**
* @author vianney
*
*/
@RestController
@RequestMapping("/api/persons")
public class PersonRestController {
 public PersonRestController(@Autowired PersonRepository repository) {
   super();
 }
}
