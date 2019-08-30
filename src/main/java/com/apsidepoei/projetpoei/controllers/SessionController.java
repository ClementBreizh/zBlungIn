package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for session form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/sessions")
public class SessionController extends BaseController {

  /**
   * Constructor.
   */
  public SessionController() {
    super("/sessions");
  }
}
