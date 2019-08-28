package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.entities.Company;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/companies")
public class CompanyRestController extends BaseRestController<Company, Integer> {
  public CompanyRestController(@Autowired CompanyRepository repository) {
    super(repository);
  }
}
