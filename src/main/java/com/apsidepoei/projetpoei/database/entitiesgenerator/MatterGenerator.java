package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matter;
import com.github.javafaker.Faker;

public class MatterGenerator {

    private MatterGenerator() {
    }

    private static MatterGenerator INSTANCE = null;

    public static MatterGenerator getInstance() {
        if (INSTANCE == null) {
            synchronized (MatterGenerator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MatterGenerator();
                }
            }
        }
        return INSTANCE;
    }

    private Faker faker = new Faker(Locale.FRENCH);
    private List<Matter> datas = new ArrayList<Matter>();

    public List<Matter> generateDatas() throws SQLException {
        return generateDatas(faker.random().nextInt(100));
    }

    public List<Matter> generateDatas(int nb) throws SQLException {
        List<Matter> result = new ArrayList<>();
        List<String> matters = new ArrayList<String>();

        int i = 0;
        while (i < nb) {
            String matterss = faker.book().title();
            if (!matters.contains(matterss)) {

                matters.add(matterss);

                Matter mat = new Matter(matterss);
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
        for (Matter matters : generateDatas(nb)) {
            DbManager.getInstance().getMatterDao().insert(matters);
            datas.add(matters);
        }
    }

    public void generateAndInsertDatasDroppingTable() throws SQLException {
        generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
    }

    public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
        DbManager.getInstance().getMatterDao().drop();
        DbManager.getInstance().getMatterDao().create();

        generateAndInsertDatas(nb);
    }

    public void deleteDatas() {
        for (Matter matters : datas) {
            DbManager.getInstance().getMatterDao().delete(matters);
        }
    }
}
