package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE e.firstname LIKE %:firstname% "
      + "AND e.lastname LIKE %:lastname% "
      + "AND e.email LIKE %:email% "
      + "AND e.cellPhone LIKE %:cellPhone% "
      + "AND (e.homePhone = NULL OR e.homePhone LIKE %:homePhone%) "
      + "AND e.login LIKE %:login%")
  Page<User> findAll(Pageable pageable, @Param("firstname") String firstname, @Param("lastname") String lastname, @Param("email") String email, @Param("cellPhone") String cellPhone, @Param("homePhone") String homePhone, @Param("login") String login);

}
