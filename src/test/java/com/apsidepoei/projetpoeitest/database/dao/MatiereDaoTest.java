package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matiere;

/** Test SELECT function on database */
public class MatiereDaoTest {

    static List<Matiere> matieres = new ArrayList<Matiere>();

    @BeforeClass
    /** Mise en place  des variables avant test */
    public static void config() {
        Matiere matiere1 = new Matiere("matiere1");
        Matiere matiere2 = new Matiere("matiere2");
        Matiere matiere3 = new Matiere("matiere3");
        matiere1.setId(1);
        matiere2.setId(2);
        matiere3.setId(3);
        matieres.add(matiere1);
        matieres.add(matiere2);
        matieres.add(matiere3);
    }

    @Before
    /** Mise en place d'une table propre pour les tests */
    public void drop() throws Exception{
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();
        DbManager.getInstance().getMatiereDao().insert(matieres.get(0));
        DbManager.getInstance().getMatiereDao().insert(matieres.get(1));
        DbManager.getInstance().getMatiereDao().insert(matieres.get(2));
    }

    @Test
    /**  */
    public void selectAll() throws Exception {
        assertNotNull(DbManager.getInstance().getMatiereDao().select());
    }

    @Test
    /**  */
    public void selectAllCount() throws Exception {
        List<Matiere> listObjects = DbManager.getInstance().getMatiereDao().select();
        DbManager.getInstance().getMatiereDao().select();
        assertEquals(3, listObjects.size());
    }

    @Test
    /** comparaison entre les datas saisies et présente en DB */
    public void dataCompare() throws Exception {
        List<Matiere> listObjects = DbManager.getInstance().getMatiereDao().select();

        assertTrue((matieres.get(0).getId() == ((Matiere)listObjects.get(0)).getId()) && (matieres.get(0).getName().equals(((Matiere)listObjects.get(0)).getName())));
    }
}

