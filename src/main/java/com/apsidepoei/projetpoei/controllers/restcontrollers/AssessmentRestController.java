package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.AssessmentRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/assesments")
public class AssessmentRestController {
  public AssessmentRestController(@Autowired AssessmentRepository repository) {
    super();
  }
}
