package com.apsidepoei.projetpoei.controllers;

import java.text.ParseException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.apsidepoei.projetpoei.controllers.restcontrollers.AppointmentRestController;
import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.entities.Appointment;

/**
 * Controller for appointment form.
 * @author thomas
 *
 */
@Controller
public class AppointmentController {

  /**
   * Routing for the form.
   *
   * @return the form page.
   */
  @GetMapping("/appointments/index")
  public String getIndex() {
    return "/appointments/index";
  }

}
