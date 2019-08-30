package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for validated candidates by company & session form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/valCandidBySessionAndCompany")
public class CompanyValidatedCandidatesSessionController extends BaseController {

  /**
   * Constructor.
   */
  public CompanyValidatedCandidatesSessionController() {
    super("/valCandidBySessionAndCompany");
  }
}
