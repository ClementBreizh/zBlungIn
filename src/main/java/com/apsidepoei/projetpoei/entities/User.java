/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.UserContract;
import com.apsidepoei.projetpoei.entities.RoleUser;
import com.apsidepoei.projetpoei.entities.Person;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author vianney
 *
 */
@Entity
@Table(name = UserContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = UserContract.COL_ID))
public class User extends Person {

  @JsonProperty(value = UserContract.COL_NAME)
  @Column(name = UserContract.COL_NAME, nullable = false, length = 50)
  protected String login;

  @JsonProperty(value = UserContract.COL_PASSWORD)
  @Column(name = UserContract.COL_PASSWORD, nullable = false, length = 50)
  protected String password;

  @JsonProperty(value = UserContract.COL_ROLE)
  @Column(name = UserContract.COL_ROLE, nullable = true)
  private RoleUser role;


  /**
   * Empty constructor.
   */
  public User() {
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param login      = the login
   * @param password  = the password
   * @param firstname = the firstname
   * @param lastname  = the lastname
   * @param email     = the email
   * @param cellPhone = the cellPhone
   */
  public User(String login, String password, String firstname, String lastname, String email, String cellPhone) {
    super();
    this.login = login;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.cellPhone = cellPhone;
    this.role = RoleUser.ROLE_3;
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param login      = the login
   * @param password  = the password
   * @param firstname = the firstname
   * @param lastname  = the lastname
   * @param email     = the email
   * @param cellPhone = the cellPhone
   */
  public User(String login, String password, String firstname, String lastname, String email, String cellPhone, RoleUser role) {
    super();
    this.login = login;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.cellPhone = cellPhone;
    this.role = role;
  }

  /**
   * Override toString() function.
   */



  // GETTER/SETTER


  /**
   * @return the name
   */
  public String getLogin() {
    return login;
  }



  @Override
  public String toString() {
    return "User [login=" + login + ", password=" + password + ", role=" + role + ", firstname=" + firstname
        + ", lastname=" + lastname + ", email=" + email + ", cellPhone=" + cellPhone + ", homePhone=" + homePhone
        + ", commentary=" + commentary + ", mainContact=" + mainContact + ", address=" + address + ", getId()="
        + getId() + "]";
  }

  /**
   * @param name the name to set
   */
  public void setLogin(String login) {
    this.login = login;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the role
   */
  public RoleUser getRole() {
    return role;
  }

  /**
   * @return the role label
   */
  public String getRoleLabel() {
    return role.role;
  }

  /**
   * @param role is the role to set
   */
  public void setRole(RoleUser role) {
    this.role = role;
  }


}
