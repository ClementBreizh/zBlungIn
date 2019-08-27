package com.apsidepoei.projetpoei.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apsidepoei.projetpoei.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
