package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
