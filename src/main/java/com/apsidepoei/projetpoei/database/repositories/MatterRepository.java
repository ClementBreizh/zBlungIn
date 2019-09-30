package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.Matter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatterRepository extends JpaRepository<Matter, Integer> {

}
