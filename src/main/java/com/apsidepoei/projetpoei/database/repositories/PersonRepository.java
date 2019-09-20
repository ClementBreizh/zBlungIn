package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apsidepoei.projetpoei.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

  @Query("SELECT e FROM #{#entityName} e WHERE (:lastname is NULL OR e.lastname LIKE %:lastname%)")
  Page<Person> findAll(Pageable pageable, @Param("lastname") String lastname);
}
