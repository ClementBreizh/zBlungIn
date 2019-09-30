package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.apsidepoei.projetpoei.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/users")

public class UserRestController extends BaseRestController<User, Integer> {

  public UserRestController(@Autowired UserRepository repository) {
    super(repository);
  }

  @GetMapping("filtered")
  public Page<User> getAllFiltered(
      final Pageable pageable,
      @RequestParam(defaultValue = "") final String firstname,
      @RequestParam(defaultValue = "") final String lastname,
      @RequestParam(defaultValue = "") final String email,
      @RequestParam(defaultValue = "") final String cellPhone,
      @RequestParam(defaultValue = "") final String homePhone,
      @RequestParam(defaultValue = "") final String login){
    return this.getRepository().findAll(pageable,firstname, lastname, email, cellPhone, homePhone, login);

  }


  protected UserRepository getRepository() {
    return (UserRepository) this.repository;
  }
}
