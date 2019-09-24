package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apsidepoei.projetpoei.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//  @Query("SELECT e FROM #{#entityName} e WHERE (:lastname is NULL OR e.lastname LIKE %:lastname%)")
//  Page<User> findByLastname(Pageable pageable, @Param("lastname") String lastname);

  @Query("SELECT e FROM #{#entityName} e WHERE (:login is NULL OR e.login LIKE %:login%)")
  Page<User> findByLastname(Pageable pageable, @Param("login") String login);
}
