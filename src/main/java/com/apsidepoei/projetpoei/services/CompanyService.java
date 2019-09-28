package com.apsidepoei.projetpoei.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.entities.Company;

@Service
public class CompanyService {
  @Autowired
  private CompanyRepository repository;

  @Autowired
  private AddressRepository addressRepository;

  @Transactional
  public Company save(final Company company) {
    this.addressRepository.save(company.getAddress());

    return this.repository.save(company);
  }
}
