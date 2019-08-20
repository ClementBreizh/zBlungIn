/**
 *
 */
package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Adress;

/**
 * @author vianney
 *
 */
public class AdressDaoSelect {

    static List<Adress> adresses = new ArrayList<Adress>();

    @BeforeClass
    public static void config() {
        Adress adress1 = new Adress("adress1", "code1", "ville1");
        Adress adress2 = new Adress("adress2", "code2", "ville2");
        Adress adress3 = new Adress("adress3", "code3", "ville3");
        adress1.setId(1);
        adress2.setId(2);
        adress3.setId(3);
        adresses.add(adress1);
        adresses.add(adress2);
        adresses.add(adress3);
    }

    @Before
    public void drop() throws Exception{
        DbManager.getInstance().getAdressDao().drop();
        DbManager.getInstance().getAdressDao().create();
        DbManager.getInstance().getAdressDao().insert(adresses.get(0));
        DbManager.getInstance().getAdressDao().insert(adresses.get(1));
        DbManager.getInstance().getAdressDao().insert(adresses.get(2));
    }

    @Test
    public void selectAll() throws Exception {
        assertNotNull(DbManager.getInstance().getAdressDao().select());
    }

    @Test
    public void selectAllCount() throws Exception {
        List<Adress> listObjects = DbManager.getInstance().getAdressDao().select();
        DbManager.getInstance().getAdressDao().select();
        assertEquals(3, listObjects.size());
    }

    @Test
    public void dataCompare() throws Exception {
        List<Adress> listObjects = DbManager.getInstance().getAdressDao().select();

        assertTrue(
                (adresses.get(0).getId() == (listObjects.get(0).getId()) &&
                (adresses.get(0).getAdress().equals(listObjects.get(0).getAdress()) &&
                (adresses.get(0).getPostalCode().equals(listObjects.get(0).getPostalCode()) &&
                (adresses.get(0).getTown().equals(listObjects.get(0).getTown()))))));
    }















}
