package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/appointments")
public class AppointmentRestController {
  public AppointmentRestController(@Autowired AppointmentRepository repository) {
    super();
  }
}
