/**
 *
 */
package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.github.javafaker.Faker;

/**
 * @author vianney
 * This class generate fake data
 */
public class FeedbackGenerator {

    private FeedbackGenerator() {
    }

    private static FeedbackGenerator INSTANCE = null;

    /**
     *
     * @return an instance of the constructor
     */
    public static FeedbackGenerator getInstance() {
        if (INSTANCE == null) {
            synchronized (FeedbackGenerator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FeedbackGenerator();
                }
            }
        }
        return INSTANCE;
    }

    Faker faker = new Faker(Locale.FRENCH);
    private List<Feedback> datas = new ArrayList<Feedback>();

    /**
     *
     * @return
     * @throws SQLException
     * Generate fake data
     */
    public List<Feedback> generateDatas() throws SQLException {
        return generateDatas(faker.random().nextInt(100));
    }

    /**
     *
     * @param nb
     * @return
     * @throws SQLException
     * Generate n fake data
     */
    public List<Feedback> generateDatas(int nb) throws SQLException {
        List<Feedback> result = new ArrayList<>();
        List<String> feedbacks = new ArrayList<String>();

        int i = 0;
        while (i <  nb) {
            String typeOfContract1 = "CDI";
            Integer durationOfContract1 = 0;
            String comment1 = "" + faker.company();

            if (!feedbacks.contains(typeOfContract1)) {
                feedbacks.add(typeOfContract1);

                Feedback feedback = new Feedback(typeOfContract1, durationOfContract1, comment1);
                result.add(feedback);
            }
        }
        while (i <  (nb / 3)) {
            String typeOfContract2 = "CDD";
            Integer durationOfContract2 = faker.random().nextInt(6, 24);
            String comment2 = faker.company().name();

            if (!feedbacks.contains(typeOfContract2)) {
                feedbacks.add(typeOfContract2);

                Feedback feedback = new Feedback(typeOfContract2, durationOfContract2, comment2);
                result.add(feedback);
            }
        }
        while (i <  (nb / 3)) {
            String typeOfContract2 = "Intérim";
            Integer durationOfContract2 = faker.random().nextInt(6, 24);
            String comment2 = faker.company().name();

            if (!feedbacks.contains(typeOfContract2)) {
                feedbacks.add(typeOfContract2);

                Feedback feedback = new Feedback(typeOfContract2, durationOfContract2, comment2);
                result.add(feedback);

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
        for (Feedback feedback : generateDatas(nb)) {
            DbManager.getInstance().getFeedbackDao().insert(feedback);
            System.out.println(feedback);
            datas.add(feedback);
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
        DbManager.getInstance().getFeedbackDao().drop();
        DbManager.getInstance().getFeedbackDao().create();

        generateAndInsertDatas(nb);
    }

    /**
     * delete datas
     */
    public void deleteDatas() {
        for (Feedback feedback: datas) {
            DbManager.getInstance().getFeedbackDao().delete(feedback);
        }
    }
}
