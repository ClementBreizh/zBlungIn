/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.CompanyCandidatesSessionRepository;
import com.apsidepoei.projetpoei.entities.CompanyCandidatesSession;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/candidBySessionAndCompany")

public class CompanyCandidatesSessionRestController extends BaseRestController<CompanyCandidatesSession, Integer> {

  public CompanyCandidatesSessionRestController(@Autowired CompanyCandidatesSessionRepository repository) {
    super(repository);
  }
}
