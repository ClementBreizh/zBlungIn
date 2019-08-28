/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateRestController {
  public CandidateRestController(@Autowired CandidateRepository repository) {
    super();
  }
}
