package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/companies")
public class CompanyRestController {
  public CompanyRestController(@Autowired CompanyRepository repository) {
    super();
  }
}
