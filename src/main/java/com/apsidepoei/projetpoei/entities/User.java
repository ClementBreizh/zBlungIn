/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.UserContract;
import com.apsidepoei.projetpoei.entities.RoleUser;
import com.apsidepoei.projetpoei.entities.Person;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

/**
 * @author vianney
 *
 */
@Entity
@DiscriminatorValue("User")
@ToString
@Table(name = UserContract.TABLE)
public class User extends Person {

  @JsonProperty(value = UserContract.COL_NAME)
  @Column(name = UserContract.COL_NAME, length = 50, unique = true, nullable = false)
  private String login;

  @JsonProperty(value = UserContract.COL_PASSWORD)
  @Column(name = UserContract.COL_PASSWORD, nullable = false, length = 50)
  private String password;

  @JsonProperty(value = UserContract.COL_ROLE)
  @Column(name = UserContract.COL_ROLE)
  private RoleUser role = RoleUser.ROLE_3;


  /**
   * Empty constructor.
   */
  public User() {
    super();
  }

  /**
   * @param firstname
   * @param lastname
   * @param email
   * @param cellPhone
   * @param login
   * @param password
   */
  public User(String firstname, String lastname, String email, String cellPhone, String login, String password) {
    super(firstname, lastname, email, cellPhone);
    this.login = login;
    this.password = password;
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param login     = the login
   * @param password  = the password
   * @param firstname = the firstname
   * @param lastname  = the lastname
   * @param email     = the email
   * @param cellPhone = the cellPhone
   * @param role      = the role

   */
  public User(String firstname, String lastname, String email, String cellPhone, String homePhone, String commentary, Boolean mainContact, String login, String password, RoleUser role) {
    super(firstname, lastname, email, cellPhone, homePhone, commentary, mainContact);
    this.login = login;
    this.password = password;
    this.role = role;
  }

  // GETTER/SETTER


  /**
   * @return the name
   */
  public String getLogin() {
    return login;
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
