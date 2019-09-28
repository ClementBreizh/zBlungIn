package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.entities.Appointment;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      @RequestParam(defaultValue = "") final String organizer,
      @RequestParam(defaultValue = "") final String appointmentType) {
    return this.getRepository().findAll(pageable, appointmentDate, organizer);
  }

  protected AppointmentRepository getRepository() {
    return (AppointmentRepository) this.repository;
  }
}
