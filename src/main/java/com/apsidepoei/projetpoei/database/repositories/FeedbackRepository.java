package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
