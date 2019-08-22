package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matters;
import com.github.javafaker.Faker;

public class MattersGenerator {

    private MattersGenerator() {
    }

    private static MattersGenerator INSTANCE = null;

    public static MattersGenerator getInstance() {
        if (INSTANCE == null) {
            synchronized (MattersGenerator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MattersGenerator();
                }
            }
        }
        return INSTANCE;
    }

    private Faker faker = new Faker(Locale.FRENCH);
    private List<Matters> datas = new ArrayList<Matters>();

    public List<Matters> generateDatas() throws SQLException {
        return generateDatas(faker.random().nextInt(100));
    }

    public List<Matters> generateDatas(int nb) throws SQLException {
        List<Matters> result = new ArrayList<>();
        List<String> matters = new ArrayList<String>();

        int i = 0;
        while (i < nb) {
            String matterss = faker.book().title();
            if (!matters.contains(matterss)) {

                matters.add(matterss);

                Matters mat = new Matters(matterss);
                result.add(mat);

                i++;
            }
        }
        return result;
    }

    public void generateAndInsertDatas() throws SQLException {
        generateAndInsertDatas(faker.random().nextInt(100));
    }

    public void generateAndInsertDatas(int nb) throws SQLException {
        for (Matters matters : generateDatas(nb)) {
            DbManager.getInstance().getMattersDao().insert(matters);
            datas.add(matters);
        }
    }

    public void generateAndInsertDatasDroppingTable() throws SQLException {
        generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
    }

    public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();

        generateAndInsertDatas(nb);
    }

    public void deleteDatas() {
        for (Matters matters : datas) {
            DbManager.getInstance().getMattersDao().delete(matters);
        }
    }
}
