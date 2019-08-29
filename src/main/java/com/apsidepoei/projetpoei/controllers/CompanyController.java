package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for companies form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/companies")
public class CompanyController extends BaseController {

  /**
   * Constructor.
   */
  public CompanyController() {
    super("/companies");
  }
}
