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
import com.apsidepoei.projetpoei.services.CompanyService;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/companies")
public class CompanyRestController extends BaseRestController<Company, Integer> {
  @Autowired
  private CompanyService service;

  public CompanyRestController(@Autowired CompanyRepository repository) {
    super(repository);
  }

  @GetMapping("filtered")
  public Page<Company> getAllFiltered(
      final Pageable pageable,
      @RequestParam(defaultValue = "") final String name,
      @RequestParam(defaultValue = "") final String siret,
      @RequestParam(defaultValue = "") final String apeCode){
    return this.getRepository().findAll(pageable, name, siret, apeCode);

  }

  protected CompanyRepository getRepository() {
    return (CompanyRepository) this.repository;
  }

  @Override
  protected Company save(final Company item) {
    return this.service.save(item);
  }
}
