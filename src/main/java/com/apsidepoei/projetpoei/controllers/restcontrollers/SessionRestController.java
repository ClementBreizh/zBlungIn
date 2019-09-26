package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.LearnSessionRepository;
import com.apsidepoei.projetpoei.entities.Session;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/sessions")
public class SessionRestController extends BaseRestController<Session, Integer> {
  public SessionRestController(@Autowired LearnSessionRepository repository) {
    super(repository);
  }
}
