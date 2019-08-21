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
import com.apsidepoei.projetpoei.entities.
Matters;

/** Test SELECT function on database */
public class MattersDaoTest {

    static List<Matters> matterss = new ArrayList<Matters>();

    @BeforeClass
    /** Mise en place  des variables avant test */
    public static void config() {
        Matters matters1 = new Matters("matters1");
        Matters matters2 = new Matters("matters2");
        Matters matters3 = new Matters("matters3");
        matters1.setId(1);
        matters2.setId(2);
        matters3.setId(3);
        matterss.add(matters1);
        matterss.add(matters2);
        matterss.add(matters3);
    }

    @Before
    /** Mise en place d'une table propre pour les tests */
    public void drop() throws Exception{
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();
        DbManager.getInstance().getMattersDao().insert(matterss.get(0));
        DbManager.getInstance().getMattersDao().insert(matterss.get(1));
        DbManager.getInstance().getMattersDao().insert(matterss.get(2));
    }

    @Test
    /**  */
    public void selectAll() throws Exception {
        assertNotNull(DbManager.getInstance().getMattersDao().select());
    }

    @Test
    /**  */
    public void selectAllCount() throws Exception {
        List<Matters> listObjects = DbManager.getInstance().getMattersDao().select();
        DbManager.getInstance().getMattersDao().select();
        assertEquals(3, listObjects.size());
    }

    @Test
    /** comparaison entre les datas saisies et présente en DB */
    public void dataCompare() throws Exception {
        List<Matters> listObjects = DbManager.getInstance().getMattersDao().select();

        assertTrue((matterss.get(0).getId() == ((Matters)listObjects.get(0)).getId()) && (matterss.get(0).getName().equals(((Matters)listObjects.get(0)).getName())));
    }
}

