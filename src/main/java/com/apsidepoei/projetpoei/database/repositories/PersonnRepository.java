package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Personn;

public interface PersonnRepository extends JpaRepository<Personn, Integer> {

}
