package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.entities.Appointment;

/**
 * RestController for appointments.
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/appointments")
public class AppointmentRestController extends BaseRestController<Appointment, Integer> {
  public AppointmentRestController(@Autowired AppointmentRepository repository) {
    super(repository);
  }
}
