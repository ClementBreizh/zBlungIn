package com.apsidepoei.projetpoei.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Candidate;

public interface AcquiredMattersRepository extends JpaRepository<AcquiredMatters, Integer> {

  List<AcquiredMatters> findByCandidate(Candidate candidate);
}
