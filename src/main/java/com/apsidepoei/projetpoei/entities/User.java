package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.UserContract;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.ToString;

/**
 * User entity.
 * @author vianney
 *
 */
@Entity
@DiscriminatorValue("User")
@ToString
@Table(name = UserContract.TABLE)
public class User extends Person {

  @Column(name = UserContract.COL_NAME, length = 50, unique = true, nullable = false)
  private String login;

  @Column(name = UserContract.COL_PASSWORD, nullable = false, length = 50)
  private String password;

  @Column(name = UserContract.COL_ROLE)
  private RoleUser role = RoleUser.ROLE_3;


  /**
   * Empty constructor.
   */
  public User() {
    super();
  }

  /**
   * Constructor.
   * @param firstname is a string.
   * @param lastname is a string.
   * @param email is a string.
   * @param cellPhone is a string.
   * @param login is the string.
   * @param password is the string.
   */
  public User(String firstname, String lastname, String email, String cellPhone,
              String login, String password) {
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
  public User(String firstname, String lastname, String email, String cellPhone,
              String homePhone,String commentary, Boolean mainContact, String login,
              String password, RoleUser role) {
    super(firstname, lastname, email, cellPhone, homePhone, commentary, mainContact);
    this.login = login;
    this.password = password;
    this.role = role;
  }

  // GETTER/SETTER


  /**
   * Getter.
   * @return the name
   */
  public String getLogin() {
    return login;
  }

  /**
   * Setter.
   * @param login the name to set
   */
  public void setLogin(String login) {
    this.login = login;
  }

  /**
   * Getter.
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter.
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter.
   * @return the role
   */
  public RoleUser getRole() {
    return role;
  }

  /**
   * Setter.
   * @return the role label
   */
  public String getRoleLabel() {
    return role.role;
  }

  /**
   * Getter.
   * @param role is the role to set
   */
  public void setRole(RoleUser role) {
    this.role = role;
  }
}
