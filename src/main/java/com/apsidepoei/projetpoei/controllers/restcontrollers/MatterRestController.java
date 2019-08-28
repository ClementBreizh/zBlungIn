package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.entities.Matter;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/matters")
public class MatterRestController extends BaseRestController<Matter, Integer> {
  public MatterRestController(@Autowired MatterRepository repository) {
    super(repository);
  }
}
