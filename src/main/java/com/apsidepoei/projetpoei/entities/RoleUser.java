package com.apsidepoei.projetpoei.entities;

/**
 * Rose enumeration for user.
 * @author vianney.
 *
 */
public enum RoleUser {

    ROLE_1("ADMIN"),
    ROLE_2("DEV"),
    ROLE_3("USER");

  public final String role;
  private RoleUser(String role) {
    this.role = role;
  }

}
