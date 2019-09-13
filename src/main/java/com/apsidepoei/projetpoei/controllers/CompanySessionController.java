package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for company by session form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/companyBySession")
public class CompanySessionController extends BaseController {

  /**
   * Constructor.
   */
  public CompanySessionController() {
    super("/companyBySession");
  }
}
