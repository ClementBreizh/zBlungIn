package com.apsidepoei.projetpoei.database.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apsidepoei.projetpoei.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

  List<Person> findAllByFirstnameAndLastname(String firstname, String lastname);

  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE e.type = 'Person' "
      + "AND e.lastname LIKE %:lastname% "
      + "AND e.firstname LIKE %:firstname% "
      + "AND e.email LIKE %:email% "
      + "AND e.cellPhone LIKE %:cellPhone% "
      + "AND (e.homePhone = NULL OR e.homePhone LIKE %:homePhone%)")
  Page<Person> findAll(Pageable pageable, @Param("lastname") String lastname, @Param("firstname") String firstname, @Param("email") String email, @Param("cellPhone") String cellPhone, @Param("homePhone") String homePhone);

  // @Query(value = "SELECT * FROM person WHERE type = 'person'", nativeQuery = true)
  @Query(value = "SELECT e FROM #{#entityName} e WHERE e.type = 'Person' ORDER BY e.id ASC")
  Page<Person> findAll(Pageable pageable);
}
