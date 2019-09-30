package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.controllers.restcontrollers.dtos.CreateMatterDto;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Candidate;

import com.apsidepoei.projetpoei.exceptions.NotFoundException;
import com.apsidepoei.projetpoei.services.CreateMatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Candidate rest controller.
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateRestController extends BaseRestController<Candidate, Integer> {
  private final CreateMatterService createMatterService;
  
  public CandidateRestController(@Autowired final CandidateRepository repository, @Autowired final CreateMatterService service) {
    super(repository);
    this.createMatterService = service;
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
  
  @PostMapping("/{id}/matter")
  public AcquiredMatters createAcquiredMatter(
      @PathVariable() int id,
      @Valid @RequestBody CreateMatterDto dto) throws NotFoundException {
    
    final Candidate candidate = this.getRepository().findById(id).orElseThrow(() -> new NotFoundException());
    
    final AcquiredMatters acquiredMatters = new AcquiredMatters(
        dto.getScore(),
        dto.getValidationDate(),
        null,
        candidate);
    
    System.out.println(this.createMatterService.create(dto.getName(), acquiredMatters));
    
    return this.createMatterService.create(dto.getName(), acquiredMatters);
  }

  protected CandidateRepository getRepository() {
    return (CandidateRepository) this.repository;
  }
}

