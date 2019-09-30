package com.apsidepoei.projetpoei.services;

import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CompanyService {
  @Autowired
  private CompanyRepository repository;

  @Autowired
  private AddressRepository addressRepository;

  /**
   * Save a company.
   * @param company is an object.
   * @return the action.
   */
  @Transactional
  public Company save(final Company company) {
    this.addressRepository.save(company.getAddress());

    return this.repository.save(company);
  }
}
