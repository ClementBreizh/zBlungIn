package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;
import com.apsidepoei.projetpoei.entities.Degree;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/degrees")
public class DegreeRestController extends BaseRestController<Degree, Integer> {
  public DegreeRestController(@Autowired DegreeRepository repository) {
    super(repository);
  }
}
