package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.MatterContract;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = MatterContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = MatterContract.COL_ID))
public class Matter extends EntityDb {

  @JsonProperty(value = MatterContract.COL_NAME)
  @Column(name = MatterContract.COL_NAME, nullable = false)
  private String name;

  /**
   * the name.
   */
  public String getName() {
    return name;
  }

  /**
   * name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Name in parameter.
   */
  public Matter(String name) {
    super();
    this.name = name;
  }

  /**
   * constructor woth id and name.
   */
  public Matter(int id, String name) {
    super();
    this.setId(id);
    this.name = name;
  }

  /**
   * construtor.
   */
  public Matter() {
    super();
  }

  @Override
  public String toString() {
    return "Matter [Id = " + getId() + ", name= " + name + "]";
  }

}
