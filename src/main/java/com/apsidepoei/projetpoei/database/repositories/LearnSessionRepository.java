package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Session;

public interface LearnSessionRepository extends JpaRepository<Session, Integer> {

}
