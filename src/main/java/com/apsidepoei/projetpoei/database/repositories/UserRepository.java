package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  //  @Query("SELECT e FROM #{#entityName} e WHERE
  //  (:lastname is NULL OR e.lastname LIKE %:lastname%)")
  //  Page<User> findByLastname(Pageable pageable, @Param("lastname") String lastname);

  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE e.login LIKE %:login% "
      + "AND e.lastname LIKE %:lastname% "
      + "AND e.firstname LIKE %:firstname% "
      + "AND e.email LIKE %:email% "
      + "AND e.cellPhone LIKE %:cellPhone% "
      + "AND e.homePhone LIKE %:homePhone%")
  Page<User> findAll(Pageable pageable,
                     @Param("login") String login,
                     @Param("lastname") String lastname,
                     @Param("firstname") String firstname,
                     @Param("email") String email,
                     @Param("cellPhone") String cellPhone,
                     @Param("homePhone") String homePhone);
}
