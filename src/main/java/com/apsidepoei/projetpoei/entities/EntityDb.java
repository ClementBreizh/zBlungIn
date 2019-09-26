package com.apsidepoei.projetpoei.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityDb implements ResourceDb<Integer> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  // GETTER/SETTER

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
