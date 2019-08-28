package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {

}
