package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for degree form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/degrees")
public class DegreeController extends BaseController {

  /**
   * Constructor.
   */
  public DegreeController() {
    super("/degrees");
  }
}
