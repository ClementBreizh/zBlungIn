package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.SessionRepository;
import com.apsidepoei.projetpoei.entities.Session;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 * @author vianney.
 *
 */
@RestController
@RequestMapping("/api/sessions")
@Api(tags = "Sessions de formation")
public class SessionRestController extends BaseRestController<Session, Integer> {
  public SessionRestController(@Autowired SessionRepository repository) {
    super(repository);
  }
}
