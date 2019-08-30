package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for obtained assessments form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/hasdone")
public class HasDoneAssessmentController extends BaseController {

  /**
   * Constructor.
   */
  public HasDoneAssessmentController() {
    super("/hasdone");
  }
}
