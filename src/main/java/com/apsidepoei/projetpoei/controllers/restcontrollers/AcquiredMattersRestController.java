package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for acquired matter.
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/acquiredmatters")
@Api(tags = "Matière validées")
public class AcquiredMattersRestController extends BaseRestController<AcquiredMatters, Integer> {
  public AcquiredMattersRestController(@Autowired AcquiredMattersRepository repository) {
    super(repository);
  }
}
