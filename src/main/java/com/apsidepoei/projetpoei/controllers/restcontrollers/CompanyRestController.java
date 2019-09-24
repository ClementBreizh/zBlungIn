package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("filtered")
  public Page<Company> getAllFiltered(
    final Pageable pageable,
    @RequestParam(defaultValue = "") final String name,
    @RequestParam(defaultValue = "") final String antennaName,
    @RequestParam(defaultValue = "") final String siret,
    @RequestParam(defaultValue = "") final String apeCode,
    @RequestParam(defaultValue = "") final String homePhone){
    return this.getRepository().findAll(pageable);
  }

  protected CompanyRepository getRepository() {
    return (CompanyRepository) this.repository;
  }
}
