/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.CompanyCandidatesSessionRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/candidBySessionAndCompany")
public class CompanyCandidatesSessionRestController {
  public CompanyCandidatesSessionRestController(@Autowired CompanyCandidatesSessionRepository repository) {
    super();
  }
}
