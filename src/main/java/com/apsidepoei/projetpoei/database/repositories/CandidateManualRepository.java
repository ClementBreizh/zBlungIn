package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apsidepoei.projetpoei.entities.Candidate;

@Repository
public class CandidateManualRepository {

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private AcquiredMattersRepository acquiredMattersRepository;

  public CandidateRepository getCandidateRepository() {
    return candidateRepository;
  }

  @Transactional(readOnly=true)
  public Candidate loadWithChildrens(Integer id) {
    Candidate result = this.candidateRepository.findById(id).get();
    result.setMatters(this.acquiredMattersRepository.findByCandidate(result));
    for (int i = 0; i < result.getMatters().size() - 1; i++) {
      result.getMatters().get(i).setCandidate(null);
    }

    return result;
  }
}
