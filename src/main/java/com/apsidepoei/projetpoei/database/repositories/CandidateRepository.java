package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
