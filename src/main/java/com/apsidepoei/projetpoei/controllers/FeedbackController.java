package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for feedback form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/feedbacks")
public class FeedbackController extends BaseController {

  /**
   * Constructor.
   */
  public FeedbackController() {
    super("/feedbacks");
  }
}
