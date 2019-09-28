package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

/**
 * This class is the business entity.
 *
 * @author vianney
 *
 */
@Entity
@ToString
@Table(name = CompanyContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanyContract.COL_ID))
public class Company extends EntityDb {

  @Column(name = CompanyContract.COL_NAME, nullable = false, length = 120)
  private String name;

  @Column(name = CompanyContract.COL_ANTENNANAME, nullable = true, length = 50)
  private String antennaName;

  @Column(name = CompanyContract.COL_SIRET, nullable = true, length = 14)
  private String siret;

  @Column(name = CompanyContract.COL_APECODE, nullable = true, length = 5)
  private String apeCode;

  @OneToMany(targetEntity = Person.class)
  private List<Person> contacts;

  @ManyToOne(targetEntity = Address.class, optional = true)
  @JoinColumn(name = CompanyContract.COL_FK_ID_ADDRESS,
      referencedColumnName = AddressContract.COL_ID)
  private Address address;


  /**
   * Empty constructor.
   */
  public Company() {
    super();
  }

  /**
   * Constructor for a new business.
   *
   * @param name        = the name
   */
  public Company(String name) {
    super();
    this.name = name;
  }

  /**
   * Constructor.
   * @param name Name of the company.
   * @param antennaName Name of the antenna.
   * @param siret Siret.
   * @param apeCode Ape code.
   * @param address Address.
   */
  public Company(String name, String antennaName, String siret, String apeCode,
      Address address) {
    super();
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
    this.address = address;
    this.contacts = new ArrayList<>();
  }


  /**
   * Constructor.
   * @param name Name of the company.
   * @param antennaName Name of the antenna.
   * @param siret Siret.
   * @param apeCode Ape code.
   * @param contacts Company's contacts.
   * @param address Address.
   */
  public Company(String name, String antennaName, String siret, String apeCode,
      List<Person> contacts, Address address) {
    super();
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
    this.contacts = contacts;
    this.address = address;
  }


  // GETTER/SETTER

  /**
   * Return the name.
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for the name.
   * @param name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Return the name of the antenna.
   * @return the antennaName.
   */
  public String getAntennaName() {
    return antennaName;
  }

  /**
   * Setter for the name of the antenna.
   * @param antennaName the antennaName to set.
   */
  public void setAntennaName(String antennaName) {
    this.antennaName = antennaName;
  }

  /**
   * Return the siret.
   * @return the siret.
   */
  public String getSiret() {
    return siret;
  }

  /**
   * Setter for the siret.
   * @param siret the siret to set.
   */
  public void setSiret(String siret) {
    this.siret = siret;
  }

  /**
   * Return the APE code.
   * @return the apeCode.
   */
  public String getApeCode() {
    return apeCode;
  }

  /**
   * Setter for the APE code.
   * @param apeCode the apeCode to set.
   */
  public void setApeCode(String apeCode) {
    this.apeCode = apeCode;
  }

  /**
   * Return a list of contacts.
   * @return the contacts.
   */
  public List<Person> getContacts() {
    return contacts;
  }

  /**
   * Setter for the contacts list.
   * @param contacts the contacts to set.
   */
  public void setContacts(List<Person> contacts) {
    this.contacts = contacts;
  }

  /**
   * Return the address.
   * @return the address.
   */
  public Address getAddress() {
    return address;
  }

  /**
   * Setter for the address.
   * @param address the address to set.
   */
  public void setAddress(Address address) {
    this.address = address;
  }

}
