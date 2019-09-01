package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for persons form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/persons")
public class PersonController extends BaseController {

  /**
   * Constructor.
   */
  public PersonController() {
    super("/persons");
    System.out.println("test");
  }
}
