package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
