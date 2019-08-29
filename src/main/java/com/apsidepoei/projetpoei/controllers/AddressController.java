package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for adress form.
 * @author thomas
 *
 */
@Controller
@RequestMapping("/addresses")
public class AddressController extends BaseController {

  /**
   * Constructor.
   */
  public AddressController() {
    super("/addresses");
  }
}
