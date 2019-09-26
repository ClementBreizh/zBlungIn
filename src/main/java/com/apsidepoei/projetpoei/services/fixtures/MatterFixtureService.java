package com.apsidepoei.projetpoei.services.fixtures;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Matter;

@Service
@Transactional
public class MatterFixtureService {

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private MatterRepository matterRepository;

  @Autowired
  private AcquiredMattersRepository acquiredMattersRepository;



  public void make() {

    Candidate c = candidateRepository.findById(3).get();
    Matter m = matterRepository.findById(1).get();

    System.out.println(c.toString());
    System.out.println(m.toString());
    AcquiredMatters matters = new AcquiredMatters(m, c);
    acquiredMattersRepository.saveAndFlush(matters);
    System.out.println("AcquiredMatters ok");
//    c.addMatter(matters);
//    candidateRepository.saveAndFlush(c);
  }
}
