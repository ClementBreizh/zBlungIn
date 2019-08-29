package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for user form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

  /**
   * Constructor.
   */
  public UserController() {
    super("/users");
  }
}
