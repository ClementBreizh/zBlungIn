package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
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
  @Column(name = AddressContract.COL_POSTAL_CODE, nullable = false)
  private String postalCode;

  @JsonProperty(value = AddressContract.COL_TOWN)
  @Column(name = AddressContract.COL_TOWN, nullable = false)
  private String town;

  /**
   * Empty constructor.
   */
  public Address() {
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

}
