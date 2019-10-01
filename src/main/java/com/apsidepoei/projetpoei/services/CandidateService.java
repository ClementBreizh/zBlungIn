package com.apsidepoei.projetpoei.services;

import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class CandidateService {
  
  @Autowired
  private EntityManager em;
  
  @Autowired
  private CandidateRepository repository;
  
  
  public Candidate update(Integer id, Candidate item) throws NotFoundException {
    if (!repository.existsById(id)) {
      throw new NotFoundException();
    }
    
    item.setId(id);
    
    repository.saveAndFlush(item);
    
    return item;
  }
}
