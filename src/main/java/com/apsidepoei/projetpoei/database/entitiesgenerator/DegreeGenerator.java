package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Degree;
import com.github.javafaker.Faker;

public class DegreeGenerator {
	private DegreeGenerator() {
	}

	private static DegreeGenerator INSTANCE = null;

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

	public List<Degree> generateDatas() throws SQLException {
		return generateDatas(faker.random().nextInt(100));
	}

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

	public void generateAndInsertDatas() throws SQLException {
		generateAndInsertDatas(faker.random().nextInt(100));
	}

	public void generateAndInsertDatas(int nb) throws SQLException {
		for (Degree degree : generateDatas(nb)) {
			DbManager.getInstance().getDegreeDao().insert(degree);
			System.out.println(degree);
			datas.add(degree);
		}
	}

	public void generateAndInsertDatasDroppingTable() throws SQLException {
		generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
	}

	public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
		DbManager.getInstance().getDegreeDao().drop();
		DbManager.getInstance().getDegreeDao().create();

		generateAndInsertDatas(nb);
	}

	public void deleteDatas() {
		for (Degree degree : datas) {
			DbManager.getInstance().getDegreeDao().delete(degree);
		}
	}
}
