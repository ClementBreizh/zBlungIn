package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.Appointment;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE (:appointmentStart = NULL "
      + "OR e.appointmentDate BETWEEN :appointmentStart AND :appointmentEnd) "
      + "AND (e.organizer.firstname LIKE %:organizer% "
      + "OR e.organizer.lastname LIKE %:organizer%) ")
  Page<Appointment> findAll(
      Pageable pageable,
      @Param("appointmentStart") LocalDateTime appointmentStart,
      @Param("appointmentEnd")   LocalDateTime appointmentEnd,
      @Param("organizer") String organizer);

  /**
   * Return a list of appointment.
   * @param pageable pagniations informations.
   * @param appointmentDate date of the appointment.
   * @param organizer organizer of the appointment.
   * @return is a list of appointment, with pagination.
   */
  default Page<Appointment> findAll(Pageable pageable,
      @Param("appointmentDate") LocalDateTime appointmentDate,
      @Param("organizer") String organizer) {
    LocalDateTime start = null;
    LocalDateTime end = null;

    if (appointmentDate != null) {
      start = LocalDateTime.from(appointmentDate).toLocalDate().atStartOfDay();
      end = LocalDateTime.from(appointmentDate).toLocalDate().plusDays(1L).atStartOfDay()
          .minusSeconds(1L);
    }

    return this.findAll(pageable, start, end, organizer);
  }

}
