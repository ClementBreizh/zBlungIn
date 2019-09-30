package com.apsidepoei.projetpoei.controllers.restcontrollers;


import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Candidate rest controller.
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateRestController extends BaseRestController<Candidate, Integer> {

  public CandidateRestController(@Autowired CandidateRepository repository) {
    super(repository);
  }

  @GetMapping("filtered")
  public Page<Candidate> getAllFiltered(
      final Pageable pageable,
      @RequestParam(defaultValue = "") final String lastname,
      @RequestParam(defaultValue = "") final String firstname,
      @RequestParam(defaultValue = "") final String email,
      @RequestParam(defaultValue = "") final String cellPhone,
      @RequestParam(defaultValue = "") final String homePhone) {
    return this.getRepository().findAll(pageable, lastname, firstname, email, cellPhone, homePhone);
  }

  protected CandidateRepository getRepository() {
    return (CandidateRepository) this.repository;
  }
}

