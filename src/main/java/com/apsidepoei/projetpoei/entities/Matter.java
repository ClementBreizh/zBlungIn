package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.MatterContract;

import lombok.ToString;

@Entity
@ToString
@Table(name = MatterContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = MatterContract.COL_ID))
public class Matter extends EntityDb {

  @Column(name = MatterContract.COL_NAME, length = 50, nullable = false)
  private String name;

  /**
   * Empty constructor.
   */
  public Matter() {
    super();
  }

  /**
   * Name in parameter.
   */
  public Matter(String name) {
    super();
    this.name = name;
  }

  // GETTER/SETTER

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
}
