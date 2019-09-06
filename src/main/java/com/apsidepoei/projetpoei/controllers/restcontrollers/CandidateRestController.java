/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.entities.Candidate;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateRestController extends BaseRestController<Candidate, Integer>{

  public CandidateRestController(@Autowired CandidateRepository repository) {
    super(repository);
  }
}

