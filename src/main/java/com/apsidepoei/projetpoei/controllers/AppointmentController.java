package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
