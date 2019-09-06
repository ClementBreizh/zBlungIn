package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.apsidepoei.projetpoei.entities.User;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/users")

public class UserRestController extends BaseRestController<User, Integer> {

  public UserRestController(@Autowired UserRepository repository) {
    super(repository);
  }
}
