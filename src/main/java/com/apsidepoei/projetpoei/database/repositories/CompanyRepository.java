package com.apsidepoei.projetpoei.database.repositories;

import com.apsidepoei.projetpoei.entities.Company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

  @Query("SELECT e FROM #{#entityName} e "
      + "WHERE e.name LIKE %:name% "
      + "AND e.siret LIKE %:siret% "
      + "AND e.apeCode LIKE %:apeCode% ")
  Page<Company> findAll(Pageable pageable,
                        @Param("name") String name,
                        @Param("siret") String siret,
                        @Param("apeCode") String apeCode);
}
