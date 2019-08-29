package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/acquiredmatters")
public class AcquiredMattersRestController extends BaseRestController<AcquiredMatters, Integer> {
  public AcquiredMattersRestController(@Autowired AcquiredMattersRepository repository) {
    super(repository);
  }
}
