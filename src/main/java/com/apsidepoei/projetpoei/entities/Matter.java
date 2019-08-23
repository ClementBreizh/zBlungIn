package com.apsidepoei.projetpoei.entities;

public class Matter extends EntityDb {

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
