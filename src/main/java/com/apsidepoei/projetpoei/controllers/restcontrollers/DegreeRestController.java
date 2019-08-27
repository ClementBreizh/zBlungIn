package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/degrees")
public class DegreeRestController {
  public DegreeRestController(@Autowired DegreeRepository repository) {
    super();
  }
}
