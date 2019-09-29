package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.entities.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  @Autowired AcquiredMattersRepository acquiredMattersRepository;

  @Override
  public Page<Candidate> getAll(Pageable pageable) {
    List<Candidate> array = new ArrayList<Candidate>();
    array.add(null);
    return new PageImpl<Candidate>(array);
  }

  @GetMapping("filtered")
  public Page<Candidate> getAllFiltered(
      final Pageable pageable,
      @RequestParam(defaultValue = "") final String lastname,
      @RequestParam(defaultValue = "") final String firstname,
      @RequestParam(defaultValue = "") final String email,
      @RequestParam(defaultValue = "") final String cellPhone,
      @RequestParam(defaultValue = "") final String homePhone) {

    Page<Candidate> candidates = this.getRepository().findAll(
        pageable,
        lastname,
        firstname,
        email,
        cellPhone,
        homePhone);

    List<Candidate> candidatesMat = new ArrayList<>();

    for (Candidate candidate : candidates.getContent()) {
      for (int i = 0; i < candidate.getMatters().size(); i++) {
        candidate.getMatters().get(i).setCandidate(null);
      }
      candidatesMat.add(candidate);
    }

    return new PageImpl<Candidate>(candidatesMat, PageRequest.of(candidates.getPageable().getPageNumber(), candidates.getSize()), candidates.getTotalElements());
  }

  @Override
  public Optional<Candidate> getById(@PathVariable(name = "id") Integer id) {
    return getOneFiltered(id);
  }

  public Optional<Candidate> getOneFiltered(Integer id) {

    Candidate candidate = this.getRepository().findById(id).get();
    Optional<Candidate> candidateFiltered = null;
    candidate.setMatters(this.acquiredMattersRepository.findByCandidate(candidate));
    for (int i = 0; i < candidate.getMatters().size(); i++) {
      candidate.getMatters().get(i).setCandidate(null);
    }
    candidateFiltered = Optional.of(candidate);

    return candidateFiltered;

  }

  protected CandidateRepository getRepository() {
    return (CandidateRepository) this.repository;
  }
}

