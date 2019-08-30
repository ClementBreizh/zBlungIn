package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for acquired matters form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/acquiredmatters")
public class AcquiredMattersController extends BaseController {

  /**
   * Constructor.
   */
  public AcquiredMattersController() {
    super("/acquiredmatters");
  }
}
