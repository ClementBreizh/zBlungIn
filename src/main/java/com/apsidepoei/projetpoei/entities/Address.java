/**
 *
 */
package com.apsidepoei.projetpoei.entities;

/**
 * This class is the Degree entity.
 * @author vianney
 *
 */
public class Address extends EntityDb {

  private String address;
  private String postalCode;
  private String town;

  /**
   * Empty constructor.
   */
  public Address() {
  }

  /**
   * Constructor with id for new Address.
   * @param address    = the address
   * @param postalCode  = the postalCode
   * @param town = the town
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
   * @return
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set the address.
   * @param address = the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * The postalCode.
   * @return
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * Set the postalCode.
   * @param postalCode = the postalCode
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * The town.
   * @return
   */
  public String getTown() {
    return town;
  }

  /**
   * Set the town.
   * @param town = the town
   */
  public void setTown(String town) {
    this.town = town;
  }

}
