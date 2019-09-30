package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CandidateManualRepository {

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private AcquiredMattersRepository acquiredMattersRepository;

  public CandidateRepository getCandidateRepository() {
    return candidateRepository;
  }

  /**
   * Load a candidate.
   * @param id is the candidate id.
   * @return is a candidate.
   */
  @Transactional(readOnly = true)
  public Candidate loadWithChildrens(Integer id) {
    Candidate result = this.candidateRepository.findById(id).get();
    result.setMatters(this.acquiredMattersRepository.findByCandidate(result));
    for (int i = 0; i < result.getMatters().size() - 1; i++) {
      result.getMatters().get(i).setCandidate(null);
    }

    return result;
  }
}
