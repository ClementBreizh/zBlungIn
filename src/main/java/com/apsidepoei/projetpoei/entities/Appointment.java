/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.Date;

/**
 * @author thomas
 * This class is the Appointment entity
 *
 */
public class Appointment extends EntityDb {

	private String informations;
	private Date dateTime;
	private String report;


	/**
	 *
	 * @return the informations
	 */
	public String getInformations() {
		return informations;
	}

	/**
	 *
	 * @param set the informations
	 */
	public void setInformations(String informations) {
		this.informations = informations;
	}

	/**
	 *
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 *
	 * @param set the dateTime
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 *
	 * @return the report
	 */
	public String getReport() {
		return report;
	}

	/**
	 *
	 * @param set the report
	 */
	public void setReport(String report) {
		this.report = report;
	}

	/**
	 *
	 * @param informations
	 * @param dateTime
	 * @param report
	 * Constructor for a new Appointment
	 */
	public Appointment(String informations, Date dateTime, String report) {
		super();
		this.informations = informations;
		this.dateTime = dateTime;
		this.report = report;
	}

	/**
	 *
	 * @param id
	 * @param informations
	 * @param dateTime
	 * @param report
	 * Constructor for a new Appointment
	 */
	public Appointment(int id, String informations, Date dateTime, String report) {
		super();
		this.setId(id);
		this.informations = informations;
		this.dateTime = dateTime;
		this.report = report;
	}

	/**
	 * empty constructor
	 */
	public Appointment() {

	}

	/**
	 * override toString() function
	 */
	@Override
	public String toString() {
		return "Rendez-vous [informations=" + informations + ", date=" + dateTime + ", report=" + report + ", getId()=" + getId() + "]";
	}
}
