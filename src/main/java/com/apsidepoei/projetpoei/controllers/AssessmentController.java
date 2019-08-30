package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for assessment form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/assessments")
public class AssessmentController extends BaseController {

  /**
   * Constructor.
   */
  public AssessmentController() {
    super("/assessments");
  }
}
