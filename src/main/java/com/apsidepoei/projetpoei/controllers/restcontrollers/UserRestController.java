package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.apsidepoei.projetpoei.entities.User;
import com.apsidepoei.projetpoei.securityservice.UserServiceImpl;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/users")

public class UserRestController extends BaseRestController<User, Integer> {

  @Autowired
  private UserServiceImpl userService;

  public UserRestController(@Autowired UserRepository repository) {
    super(repository);
  }

  @PostMapping(value= {"/test"})
  @Override
  public User savetest(@RequestBody User item) {
    return userService.save(item);
  }
}
