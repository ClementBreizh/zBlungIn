package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for appointment form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/appointments")
public class AppointmentController extends BaseController {

  /**
   * Constructor.
   */
  public AppointmentController() {
    super("/appointments");
  }
}
