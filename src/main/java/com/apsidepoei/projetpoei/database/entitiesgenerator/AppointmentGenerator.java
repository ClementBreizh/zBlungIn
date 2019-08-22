package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.github.javafaker.Faker;

/**
 *
 * @author thomas
 * This class generate fake data
 */
public class AppointmentGenerator {
	private AppointmentGenerator() {
	}

	private static AppointmentGenerator INSTANCE = null;

	/**
	 *
	 * @return an instance of the constructor
	 */
	public static AppointmentGenerator getInstance() {
		if (INSTANCE == null) {
			synchronized (AppointmentGenerator.class) {
				if (INSTANCE == null) {
					INSTANCE = new AppointmentGenerator();
				}
			}
		}
		return INSTANCE;
	}

	Faker faker = new Faker(Locale.FRENCH);
	private List<Appointment> datas = new ArrayList<Appointment>();

	/**
	 *
	 * @return
	 * @throws SQLException Generate fake data
	 * @throws ParseException
	 */
	public List<Appointment> generateDatas() throws SQLException, ParseException {
		return generateDatas(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @return
	 * @throws SQLException Generate n fake data
	 * @throws ParseException
	 */
	public List<Appointment> generateDatas(int nb) throws SQLException, ParseException {
		List<Appointment> result = new ArrayList<>();

	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Date mySqlDate = sdf.parse("2019-08-22 02:05:00");

		for (int i = 0; i < nb; i++) {
			Appointment appointment = new Appointment(faker.lorem().sentence(), mySqlDate, faker.lorem().sentence(4));
			result.add(appointment);
		}

		return result;
	}

	/**
	 *
	 * @throws SQLException Generate and insert datas
	 * @throws ParseException
	 */
	public void generateAndInsertDatas() throws SQLException, ParseException {
		generateAndInsertDatas(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @throws SQLException Generate and insert n datas
	 * @throws ParseException
	 */
	public void generateAndInsertDatas(int nb) throws SQLException, ParseException {
		for (Appointment appointment : generateDatas(nb)) {
			DbManager.getInstance().getAppointmentDao().insert(appointment);
			System.out.println(appointment);
			datas.add(appointment);
		}
	}

	/**
	 *
	 * @throws SQLException Drop, create table, generate and insert datas
	 * @throws ParseException
	 */
	public void generateAndInsertDatasDroppingTable() throws SQLException, ParseException {
		generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @throws SQLException Drop, create table, generate and insert n data
	 * @throws ParseException
	 */
	public void generateAndInsertDatasDroppingTable(int nb) throws SQLException, ParseException {
		DbManager.getInstance().getAppointmentDao().drop();
		DbManager.getInstance().getAppointmentDao().create();

		generateAndInsertDatas(nb);
	}

	/**
	 * delete datas
	 */
	public void deleteDatas() {
		for (Appointment appointment : datas) {
			DbManager.getInstance().getAppointmentDao().delete(appointment);
		}
	}
}
