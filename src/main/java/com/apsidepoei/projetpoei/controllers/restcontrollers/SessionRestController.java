package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.SessionRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/sessions")
public class SessionRestController {
  public SessionRestController(@Autowired SessionRepository repository) {
    super();
  }
}
