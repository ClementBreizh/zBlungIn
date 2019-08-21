package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matiere;
import com.github.javafaker.Faker;

public class MatiereGenerator {

    private MatiereGenerator()
    {}

    private static MatiereGenerator INSTANCE = null;

    public static MatiereGenerator getInstance()
    {
        if (INSTANCE == null)
        {
            synchronized(MatiereGenerator.class)
            {
                if (INSTANCE == null)
                {   INSTANCE = new MatiereGenerator();
                }
            }
        }
        return INSTANCE;
    }

    private Faker faker = new Faker(Locale.FRENCH);
    private List<Matiere> datas = new ArrayList<Matiere>();

    public List<Matiere> generateDatas() throws SQLException
    {
        return generateDatas(faker.random().nextInt(100));
    }

    public List<Matiere> generateDatas(int nb) throws SQLException
    {
        List<Matiere> result = new ArrayList<>();
        List<String> matiere = new ArrayList<String>();

        int i = 0;
        while (i < nb) {
            String matieres = faker.book().title();
            if (!matiere.contains(matieres)) {
                matiere.add(matieres);

                Matiere mat = new Matiere(matieres);
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
        for (Matiere matiere : generateDatas(nb)) {
            DbManager.getInstance().getMatiereDao().insert(matiere);
            datas.add(matiere);
        }
    }

    public void generateAndInsertDatasDroppingTable() throws SQLException {
        generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
    }

    public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();

        generateAndInsertDatas(nb);
    }

    public void deleteDatas() {
        for (Matiere matiere : datas) {
            DbManager.getInstance().getMatiereDao().delete(matiere);
        }
    }
}
