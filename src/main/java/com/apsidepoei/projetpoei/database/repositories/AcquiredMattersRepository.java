package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Candidate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AcquiredMattersRepository extends JpaRepository<AcquiredMatters, Integer> {

  List<AcquiredMatters> findByCandidate(Candidate candidate);
}
