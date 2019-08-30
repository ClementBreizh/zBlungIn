package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for candidate form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/candidates")
public class CandidateController extends BaseController {

  /**
   * Constructor.
   */
  public CandidateController() {
    super("/acquiredmatters");
  }
}
