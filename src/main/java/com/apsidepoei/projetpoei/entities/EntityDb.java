package com.apsidepoei.projetpoei.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityDb {

  @Id
  private Integer id;

  /**
   * getter.
   */
  public Integer getId() {
    return id;
  }

  /**
   * setter.
   */
  public void setId(Integer id) {
    this.id = id;
  }

}
