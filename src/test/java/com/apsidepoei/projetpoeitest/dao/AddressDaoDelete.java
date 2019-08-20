/**
 *
 */
package com.apsidepoei.projetpoeitest.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.apsidepoei.projetpoei.entities.Address;

/**
 * @author vianney
 *
 */
public class AddressDaoDelete {


    @Before
    public void dropCreate() {
        DbManager.getInstance().getAdressDao().drop();
        DbManager.getInstance().getAdressDao().create();
    }

    @Test
    public void testAdressDaoDeleteSimple() throws SQLException, ParseException {
        Address Adress = new Address("AdressTest", "Test", "villeTest");
        DbManager.getInstance().getAdressDao().insert(Adress);

        Adress.setId(1);
        DbManager.getInstance().getAdressDao().delete(Adress);

        assertNull(DbManager.getInstance().getAdressDao().select(1));
    }

    @Test
    public void testAdressDaoDeleteMultiple() throws SQLException, ParseException {
        boolean statut = false;

        for (int i = 1; i <= 10; i++) {
            Address Adress = new Address("Adress" + i, "cod" + i, "ville" + i);
            Adress.setId(i);
            DbManager.getInstance().getAdressDao().insert(Adress);

            if (i == 5) {
                DbManager.getInstance().getAdressDao().delete(Adress);
            }
        }

        for (int i = 1; i <= 10; i++) {
            if (i == 5 && DbManager.getInstance().getAdressDao().select(i) == null) {
                statut = true;
            }
        }

        assertTrue(statut);
    }

    @Test
    public void testAdressDaoDeleteMultiple2() throws SQLException, ParseException {
        boolean statut = false;

        for (int i = 17; i <= 102; i += 17) {
            Address Adress = new Address("Adress" + i, "" + i, "ville" + i);
            Adress.setId(i);
            DbManager.getInstance().getAdressDao().insert(Adress);

            if (i == 51) {
                DbManager.getInstance().getAdressDao().delete(Adress);
            }
        }

        for (int i = 17; i <= 102; i += 17) {
            if (i == 51 && DbManager.getInstance().getAdressDao().select(i) == null) {
                statut = true;
            }
        }

        assertTrue(statut);
    }

    @Test
    public void testAdressDaoDeleteNullMultiple() throws SQLException, ParseException {
        int statut = 0;

        for (int i = 17; i <= 102; i += 17) {
            Address Adress = new Address("Adress" + i, "" + i, "ville" + i);
            Adress.setId(i);
            DbManager.getInstance().getAdressDao().insert(Adress);

            if (i == 102) {
              DbManager.getInstance().getAdressDao().delete(Adress);
              statut = DbManager.getInstance().getAdressDao().delete(Adress);
            }
        }

        assertEquals(0, statut);
    }

    @AfterClass
    public static void dropAfter() {
        DbManager.getInstance().getAdressDao().drop();
        DbManager.getInstance().getAdressDao().create();
    }
}
