package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Degree;
import com.github.javafaker.Faker;

/**
 *
 * @author thomas
 *	This class generate fake data
 */
public class DegreeGenerator {
	private DegreeGenerator() {
	}

	private static DegreeGenerator INSTANCE = null;

	/**
	 *
	 * @return an instance of the constructor
	 */
	public static DegreeGenerator getInstance() {
		if (INSTANCE == null) {
			synchronized (DegreeGenerator.class) {
				if (INSTANCE == null) {
					INSTANCE = new DegreeGenerator();
				}
			}
		}
		return INSTANCE;
	}

	Faker faker = new Faker(Locale.FRENCH);
	private List<Degree> datas = new ArrayList<Degree>();

	/**
	 *
	 * @return
	 * @throws SQLException
	 * Generate fake data
	 */
	public List<Degree> generateDatas() throws SQLException {
		return generateDatas(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @return
	 * @throws SQLException
	 * Generate n fake data
	 */
	public List<Degree> generateDatas(int nb) throws SQLException {
		List<Degree> result = new ArrayList<>();
		List<String> degrees = new ArrayList<String>();

		int i = 0;
		while (i < nb) {
			String deg = faker.educator().course();
			if (!degrees.contains(deg)) {
				degrees.add(deg);

				Degree degree = new Degree(deg, "BAC + " + faker.number().digit());
				result.add(degree);

				i++;
			}
		}
		return result;
	}

	/**
	 *
	 * @throws SQLException
	 * Generate and insert datas
	 */
	public void generateAndInsertDatas() throws SQLException {
		generateAndInsertDatas(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @throws SQLException
	 * Generate and insert n datas
	 */
	public void generateAndInsertDatas(int nb) throws SQLException {
		for (Degree degree : generateDatas(nb)) {
			DbManager.getInstance().getDegreeDao().insert(degree);
			System.out.println(degree);
			datas.add(degree);
		}
	}

	/**
	 *
	 * @throws SQLException
	 * Drop, create table, generate and insert datas
	 */
	public void generateAndInsertDatasDroppingTable() throws SQLException {
		generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @throws SQLException
	 * Drop, create table, generate and insert n data
	 */
	public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
		DbManager.getInstance().getDegreeDao().drop();
		DbManager.getInstance().getDegreeDao().create();

		generateAndInsertDatas(nb);
	}

	/**
	 * delete datas
	 */
	public void deleteDatas() {
		for (Degree degree : datas) {
			DbManager.getInstance().getDegreeDao().delete(degree);
		}
	}
}
