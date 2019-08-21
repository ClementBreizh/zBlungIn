package com.apsidepoei.projetpoei.entities;

/**
 * @author thomas
 * This class is the Degree entity
 *
 */
public class Degree extends EntityDb {

	private String name;
	private String level;

	/**
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param set the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 *
	 * @param set the level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 *
	 * @param name
	 * @param level Constructor for a new degree
	 */
	public Degree(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param level Constructor with id for new degree
	 */
	public Degree(int id, String name, String level) {
		super();
		this.setId(id);
		this.name = name;
		this.level = level;
	}

	/**
	 * empty constructor
	 */
	public Degree() {

	}

	/**
	 * override toString() function
	 */
	@Override
	public String toString() {
		return "Diplome [Id = " + getId() + ", nom=" + name + ", niveau=" + level + "]";
	}
}
