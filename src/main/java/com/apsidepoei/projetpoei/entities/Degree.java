package com.apsidepoei.projetpoei.entities;

/**
 * This class is the Degree entity.
 * @author thomas
 *
 */
public class Degree extends EntityDb {

  private String name;
  private String level;

  /**
   * The name.
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   * @param name = the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The level.
   * @return the name.
   */
  public String getLevel() {
    return level;
  }

  /**
   * Set the level.
   * @param level = the level
   */
  public void setLevel(String level) {
    this.level = level;
  }

  /**
   * Constructor for a new degree.
   * @param name  = the name
   * @param level = the level
   */
  public Degree(String name, String level) {
    super();
    this.name = name;
    this.level = level;
  }

  /**
   * Constructor with id for new degree.
   * @param id    = the id
   * @param name  = the name
   * @param level = the level
   */
  public Degree(int id, String name, String level) {
    super();
    this.setId(id);
    this.name = name;
    this.level = level;
  }

  /**
   * Empty constructor.
   */
  public Degree() {
    super();
  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Diplome [Id = " + getId() + ", nom=" + name + ", niveau=" + level + "]";
  }
}
