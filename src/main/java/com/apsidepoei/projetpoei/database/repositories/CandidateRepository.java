package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsidepoei.projetpoei.entities.Candidate;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

//  @Query("SELECT e FROM #{#entityName} e WHERE (:lastname is NULL OR e.lastname LIKE %:lastname%)")
//  Page<Candidate> findAll(Pageable pageable, @Param("lastname") String lastname);


  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE e.lastname LIKE %:lastname% "
      + "AND e.firstname LIKE %:firstname%")
  Page<Candidate> findAll(Pageable pageable, @Param("lastname") String lastname, @Param("firstname") String firstname);
}
