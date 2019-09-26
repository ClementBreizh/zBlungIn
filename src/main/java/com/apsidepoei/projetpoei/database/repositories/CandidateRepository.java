package com.apsidepoei.projetpoei.database.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsidepoei.projetpoei.entities.Candidate;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE e.lastname LIKE %:lastname% "
      + "AND e.firstname LIKE %:firstname% "
      + "AND e.email LIKE %:email% "
      + "AND e.cellPhone LIKE %:cellPhone% "
      + "AND e.homePhone LIKE %:homePhone%")
  Page<Candidate> findAll(Pageable pageable, @Param("lastname") String lastname, @Param("firstname") String firstname, @Param("email") String email, @Param("cellPhone") String cellPhone, @Param("homePhone") String homePhone);

//  @Query("SELECT e FROM #{#entityName} e "
//      + "LEFT JOIN FETCH e.appointments "
//      + "WHERE e.id = :id")
//  Optional<Candidate> findById(@Param("id") Integer id);

}

//select * from (select * from candidate) as candidate from (select * from candidate inner join appointment_persons on appointment_persons.id_person = candidate.id_person inner join appointment on appointment.id_appointment = appointment.id_appointment) as appointment where candidate.id_person = 2;



//select * from candidate inner join appointment_persons on appointment_persons.id_person = candidate.id_person inner join appointment on appointment.id_appointment = appointment.id_appointment where candidate.id_person = 2;
