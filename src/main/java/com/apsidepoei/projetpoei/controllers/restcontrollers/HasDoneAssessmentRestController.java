package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.HasDoneAssessmentRepository;
import com.apsidepoei.projetpoei.entities.HasDoneAssessment;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/hasdone")
public class HasDoneAssessmentRestController extends BaseRestController<HasDoneAssessment, Integer> {
  public HasDoneAssessmentRestController(@Autowired HasDoneAssessmentRepository repository) {
    super(repository);
  }
}


