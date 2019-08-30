package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for matters form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/matters")
public class MatterController extends BaseController {

  /**
   * Constructor.
   */
  public MatterController() {
    super("/matters");
  }
}
