/**
 *
 */
package com.apsidepoei.projetpoei.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.entities.Appointment;

/**
 * @author thomas
 *
 */

@Controller
@RequestMapping("/appointments")
public class AppointmentFormController {

  @GetMapping("/index")
  public String getIndex() {
    return "/index";
  }

  @Autowired
  private AppointmentRepository repository;

  @RequestMapping(value = { "/insert" }, method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
  public ResponseEntity<Appointment> appointmentPost(@RequestBody Appointment appointment) {
    return new ResponseEntity<Appointment>(repository.save(appointment), HttpStatus.CREATED);
  }

  @RequestMapping(value = { "" }, method = RequestMethod.GET)
  public List<Appointment> appointmentGet() {
    return (List<Appointment>) repository.findAll();
  }

  @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
  public Optional<Appointment> appointmentGetById(@PathVariable(value = "id") Integer id) {
    return repository.findById(id);
  }

  @RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
  public void appointmentDelete(@PathVariable(value = "id") Integer id) {
    repository.deleteById(id);
  }

}
