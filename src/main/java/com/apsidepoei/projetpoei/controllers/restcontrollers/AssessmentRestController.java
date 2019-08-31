package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AssessmentRepository;
import com.apsidepoei.projetpoei.entities.Assessment;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/assessments")
public class AssessmentRestController extends BaseRestController<Assessment, Integer> {
  public AssessmentRestController(@Autowired AssessmentRepository repository) {
    super(repository);
  }
}
