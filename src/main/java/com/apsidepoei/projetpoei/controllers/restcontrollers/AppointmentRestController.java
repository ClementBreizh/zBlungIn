package com.apsidepoei.projetpoei.controllers.restcontrollers;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.apsidepoei.projetpoei.entities.Person;

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

  @GetMapping("filtered")
  @DateTimeFormat
  public Page<Appointment> getAllFiltered(

      final Pageable pageable,
      @RequestParam(defaultValue = "")
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
      final LocalDateTime appointmentDate,

// http://localhost:1234/api/appointments/filtered?appointmentDate=2019-09-25T22:00:00.000Z&size=20
// http://localhost:1234/api/appointments/filtered?appointmentDate=2000-10-31T01:30:00.000Z&size=20
      @RequestParam(defaultValue = "") final String organizer,
      @RequestParam(defaultValue = "") final String appointmentType) {

      return this.getRepository().findAll(pageable, appointmentDate, organizer);}
     //return this.getRepository().findAll(pageable);}

  protected AppointmentRepository getRepository() {
    return (AppointmentRepository) this.repository;
  }
}
