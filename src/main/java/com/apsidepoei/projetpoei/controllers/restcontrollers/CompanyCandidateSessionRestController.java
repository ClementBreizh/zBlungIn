/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.CompanyCandidateSessionRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/validatecandidates")
public class CompanyCandidateSessionRestController {
  public CompanyCandidateSessionRestController(@Autowired CompanyCandidateSessionRepository repository) {
    super();
  }
}
