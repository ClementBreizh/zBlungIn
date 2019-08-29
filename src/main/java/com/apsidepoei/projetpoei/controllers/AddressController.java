package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for adress form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/adresses")
public class AddressController extends BaseController {

  /**
   * Constructor.
   */
  public AddressController(String entityPath) {
    super("/adresses");
  }
}
