package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Matter;

public interface MatterRepository extends JpaRepository<Matter, Integer> {

}
