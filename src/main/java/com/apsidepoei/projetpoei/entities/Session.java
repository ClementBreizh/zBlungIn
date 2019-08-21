package com.apsidepoei.projetpoei.entities;

import java.util.Date;

public class Session extends EntityDb {
	private String name;
	private Date dateStart;
	private Date dateEnd;


	/**
	 *
	 * @return the informations
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
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}

	/**
	 *
	 * @param set the dateStart
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 *
	 * @return the dateEnd
	 */
	public Date getDateEnd() {
		return dateEnd;
	}

	/**
	 *
	 * @param set the dateEnd
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 *
	 * @param name
	 * @param dateStart
	 * @param dateEnd
	 * Constructor for a new Appointment
	 */
	public Session(String name, Date dateStart, Date dateEnd) {
		super();
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param dateStart
	 * @param dateEnd
	 * Constructor for a new Appointment
	 */
	public Session(int id, String name, Date dateStart, Date dateEnd) {
		super();
		this.setId(id);
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	/**
	 * empty constructor
	 */
	public Session() {

	}

	/**
	 * override toString() function
	 */
	@Override
	public String toString() {
		return "Session [name=" + name + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", getId()=" + getId() + "]";
	}
}
