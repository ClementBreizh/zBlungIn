package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Entreprise;
import com.github.javafaker.Faker;

/**
 * 
 * @author benjamin-m
 *
 */
public class EntrepriseGenerator {
	private EntrepriseGenerator() {
	}

	private static EntrepriseGenerator INSTANCE = null;

	/**
	 *
	 * @return an instance of the constructor
	 */
	public static EntrepriseGenerator getInstance() {
		if (INSTANCE == null) {
			synchronized (EntrepriseGenerator.class) {
				if (INSTANCE == null) {
					INSTANCE = new EntrepriseGenerator();
				}
			}
		}
		return INSTANCE;
	}

	Faker faker = new Faker(Locale.FRENCH);
	private List<Entreprise> datas = new ArrayList<Entreprise>();

	/**
	 *
	 * @return
	 * @throws SQLException
	 * Generate fake data
	 */
	public List<Entreprise> generateDatas() throws SQLException {
		return generateDatas(faker.random().nextInt(100));
	}

	/**
	 *
	 * @param nb
	 * @return
	 * @throws SQLException
	 * Generate n fake data
	 */
	public List<Entreprise> generateDatas(int nb) throws SQLException {
		List<Entreprise> result = new ArrayList<>();
		List<String> entreprises = new ArrayList<String>();

		int i = 0;
		while (i < nb) {
			String ent = faker.company().name();
			if (!entreprises.contains(ent)) {
				entreprises.add(ent);

				Entreprise entreprise = new Entreprise(ent, ent  + faker.address().city(), faker.number().digits(14), faker.letterify(faker.number().digits(4) + "?") );
				result.add(entreprise);

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
		for (Entreprise entreprise : generateDatas(nb)) {
			DbManager.getInstance().getEntrepriseDao().insert(entreprise);
			System.out.println(entreprise);
			datas.add(entreprise);
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
		DbManager.getInstance().getEntrepriseDao().drop();
		DbManager.getInstance().getEntrepriseDao().create();

		generateAndInsertDatas(nb);
	}

	/**
	 * delete datas
	 */
	public void deleteDatas() {
		for (Entreprise entreprise : datas) {
			DbManager.getInstance().getEntrepriseDao().delete(entreprise);
		}
	}
}
