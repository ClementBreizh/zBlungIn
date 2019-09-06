package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the Address entity.
 *
 * @author vianney
 *
 */
@Entity
@Table(name = AddressContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AddressContract.COL_ID))
public class Address extends EntityDb {

  @JsonProperty(value = AddressContract.COL_STREET)
  @Column(name = AddressContract.COL_STREET, nullable = false)
  private String street;

  @JsonProperty(value = AddressContract.COL_POSTAL_CODE)
  @Column(name = AddressContract.COL_POSTAL_CODE, nullable = false, length = 5)
  private String postalCode;

  @JsonProperty(value = AddressContract.COL_CITY)
  @Column(name = AddressContract.COL_CITY, nullable = false)
  private String city;

  @JsonProperty(value = AddressContract.COL_COMPANIES)
  @OneToMany(targetEntity = Company.class)
  private List<Company> companies = new ArrayList<>();

  @JsonProperty(value = AddressContract.COL_CANDIDATES)
  @OneToMany(targetEntity = Candidate.class)
//  @OneToMany(mappedBy = "address")
  private List<Candidate> candidates = new ArrayList<>();

  /**
   * Empty constructor.
   */
  public Address() {
    super();
  }

  /**
   * Constructor with id for new Address.
   *
   * @param street    = the street
   * @param postalCode = the postalCode
   * @param city       = the city
   */
  public Address(String street, String postalCode, String city) {
    super();
    this.street = street;
    this.postalCode = postalCode;
    this.city = city;
  }

  /**
   * Constructor with id for new Address.
   *
   * @param address    = the address
   * @param postalCode = the postalCode
   * @param town       = the town
   */
  public Address(String address, String postalCode, String town, List<Company> companies, List<Candidate> candidates) {
    super();
    this.address = address;
    this.postalCode = postalCode;
    this.town = town;
    this.companies = companies;
    this.candidates = candidates;
  }


  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Adresse [Id = " + getId() + ", adresse postale = " + street + ", code postal = "
        + postalCode + ", ville = " + city + "]";
  }


  // GETTER/SETTER

  /**
   * The street.
   *
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * Set the street.
   *
   * @param street = the street
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * The postalCode.
   *
   * @return the postal code
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * Set the postalCode.
   *
   * @param postalCode = the postalCode
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * The city.
   *
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * Set the city.
   *
   * @param city = the city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the companies
   */
  public List<Company> getCompanies() {
    return companies;
  }

  /**
   * @param companies the companies to set
   */
  public void setCompanies(List<Company> companies) {
    this.companies = companies;
  }

  /**
   * @return the candidates
   */
  public List<Candidate> getCandidates() {
    return candidates;
  }

  /**
   * @param candidates the candidates to set
   */
  public void setCandidates(List<Candidate> candidates) {
    this.candidates = candidates;
  }


}
