package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.MatterRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/matters")
public class MatterRestController {
  public MatterRestController(@Autowired MatterRepository repository) {
    super();
  }
}
