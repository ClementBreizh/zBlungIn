package com.apsidepoei.projetpoei.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsidepoei.projetpoei.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

  @Query("SELECT c FROM #{#entityName} c LEFT JOIN FETCH c.companySession s")
  List<Candidate> toto();

}
