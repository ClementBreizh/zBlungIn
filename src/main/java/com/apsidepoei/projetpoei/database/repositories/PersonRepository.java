package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apsidepoei.projetpoei.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

  @Query("SELECT e FROM #{#entityName} e WHERE (e.lastname LIKE %:lastname%) OR (e.firstname LIKE %:firstname%) OR (e.email LIKE %:email%) OR (e.cellPhone LIKE %:cellPhone%)")
  Page<Person> findAll(Pageable pageable,
      @Param("lastname") String lastname,
      @Param("firstname") String firstname,
      @Param("email") String email,
      @Param("cellPhone") String cellPhone);
}
