package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.Matter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatterRepository extends JpaRepository<Matter, Integer> {
  
  Optional<Matter> findByName(String name);
}
