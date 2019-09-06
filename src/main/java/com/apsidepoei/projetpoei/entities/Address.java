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

  @JsonProperty(value = AddressContract.COL_ADDRESS)
  @Column(name = AddressContract.COL_ADDRESS, nullable = false)
  private String address;

  @JsonProperty(value = AddressContract.COL_POSTAL_CODE)
  @Column(name = AddressContract.COL_POSTAL_CODE, nullable = false, length = 5)
  private String postalCode;

  @JsonProperty(value = AddressContract.COL_TOWN)
  @Column(name = AddressContract.COL_TOWN, nullable = false)
  private String town;

  @JsonProperty(value = AddressContract.COL_COMPANIES)
  @OneToMany(targetEntity = Company.class)
  private List<Company> companies = new ArrayList<>();

  @JsonProperty(value = AddressContract.COL_CANDIDATES)
  @OneToMany(targetEntity = Candidate.class)
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
   * @param address    = the address
   * @param postalCode = the postalCode
   * @param town       = the town
   */
  public Address(String address, String postalCode, String town) {
    super();
    this.address = address;
    this.postalCode = postalCode;
    this.town = town;
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
    return "Adresse [Id = " + getId() + ", adresse postale = " + address + ", code postal = "
        + postalCode + ", ville = " + town + "]";
  }


  // GETTER/SETTER

  /**
   * The address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set the address.
   *
   * @param address = the address
   */
  public void setAddress(String address) {
    this.address = address;
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
   * The town.
   *
   * @return the town
   */
  public String getTown() {
    return town;
  }

  /**
   * Set the town.
   *
   * @param town = the town
   */
  public void setTown(String town) {
    this.town = town;
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
