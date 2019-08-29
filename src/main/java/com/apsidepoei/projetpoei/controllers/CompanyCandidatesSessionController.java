package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for candidates / list & session form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/candidBySessionAndCompany")
public class CompanyCandidatesSessionController extends BaseController {

  /**
   * Constructor.
   */
  public CompanyCandidatesSessionController() {
    super("/candidBySessionAndCompany");
  }
}

