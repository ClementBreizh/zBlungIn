package com.apsidepoei.projetpoei.entities;

/**
 * Rose enumeration for user.
 * @author vianney.
 *
 */
public enum RoleUser {

    ROLE_1("ROLE_ADMIN"),
    ROLE_2("ROLE_DEV"),
    ROLE_3("ROLE_USER");

  public final String role;
  private RoleUser(String role) {
    this.role = role;
  }

}
