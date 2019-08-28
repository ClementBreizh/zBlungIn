/**
 *
 */
package com.apsidepoei.projetpoei.controllers;

import java.text.ParseException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.entities.Appointment;

/**
 * Controller for appointment form.
 * @author thomas
 *
 */
@Controller
public class AppointmentFormController extends BaseRestController<Appointment, Integer> {

  /**
   * Constructor.
   * @param repository is the repository from BaseRestController.
   */
  public AppointmentFormController(JpaRepository<Appointment, Integer> repository) {
    super(repository);
  }

  /**
   * Routing for the form.
   *
   * @return the form page.
   */
  @GetMapping("/appointments/index")
  public String getIndex() {
    return "/appointments/index";
  }

  /**
   * Routing for posting a new appointment.
   *
   * @return the page form.
   */
  @PostMapping("/appointments/index")
  public String appointmentCreate(Appointment appointment) throws ParseException {
    repository.save(appointment);
    System.out.println(appointment);
    return "/appointments/index";
  }

}
