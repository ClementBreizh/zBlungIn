package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.
Matters;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/** Test UPDATE function on database */
public class MattersDaoUpdateTest {

    private static final String CHANGED_DATA = "toto";
    private List<Matters> matterss = new ArrayList<Matters>();

    // setup pour la mise en place des tests
    @Before
    public void setupTests() throws SQLException {
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();

        matterss.clear();
        matterss.add(new Matters(1,"matters1"));
        matterss.add(new Matters(2,"matters2"));
        matterss.add(new Matters(3,"matters3"));

        for (Matters matters : matterss) {
            DbManager.getInstance().getMattersDao().insert(matters);
        }
    }

    /** Comparaison entre données update et attendues */
    @Test
    public void simpleUpdateCompare1() throws SQLException {
        Matters matters = matterss.get(0);
        matters.setName(CHANGED_DATA);

        Matters dbMatters = (Matters)DbManager.getInstance().getMattersDao().select(1);
        DbManager.getInstance().getMattersDao().update(matters);
        Matters dbMattersUpdated = (Matters)DbManager.getInstance().getMattersDao().select(1);

        assertTrue(dbMatters.getId() == dbMattersUpdated.getId() && !dbMatters.getName().equals(dbMattersUpdated.getName()) && dbMattersUpdated.getName().equals(CHANGED_DATA));
    }

    @Test
    public void simpleUpdateCompare2() throws SQLException {
        Matters matters = matterss.get(0);
        matters.setName(CHANGED_DATA);

        DbManager.getInstance().getMattersDao().update(matters);
        Matters dbMattersUpdated = (Matters)DbManager.getInstance().getMattersDao().select(1);

        assertTrue(matters.getId() == dbMattersUpdated.getId() && matters.getName().equals(dbMattersUpdated.getName()));
    }

    @Test
    public void simpleUpdateCompare3() {
        Matters matters = matterss.get(0);
        Matters dbMatters = (Matters)DbManager.getInstance().getMattersDao().select(1);

        assertTrue(matters.getId() == dbMatters.getId() && matters.getName().equals(dbMatters.getName()));
    }

    /** Test sur le nombre de character saisie */
    @Test(expected = MysqlDataTruncation.class)
    public void updateMaxValExtended() throws SQLException {
        Matters matters = matterss.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            data.append("x");
        }
        matters.setName(data.toString());

        DbManager.getInstance().getMattersDao().update(matters);
    }

    @Test
    public void updateMaxValOK() throws SQLException {
        Matters matters = matterss.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            data.append("x");
        }
        matters.setName(data.toString());

        DbManager.getInstance().getMattersDao().update(matters);
    }

    @Test
    /** Test que l'on peut bien envoyée une chaine de string vide*/
    public void updateMinValOK() throws SQLException {
        Matters matters = matterss.get(0);
        matters.setName("");

        DbManager.getInstance().getMattersDao().update(matters);
    }

    /** Test en cas de retour NULL */
    @Test(expected = MySQLIntegrityConstraintViolationException.class)
    public void updateNullValKO() throws SQLException {
        Matters matters = matterss.get(0);
        matters.setName(null);

        DbManager.getInstance().getMattersDao().update(matters);
    }

    /** Test si ID erronée */
    @Test
    public void updateWrongId() throws SQLException {
        Matters matters = matterss.get(0);
        matters.setId(4);
        matters.setName(CHANGED_DATA);

        assertEquals(new Integer(0), DbManager.getInstance().getMattersDao().update(matters));
    }

    /** Test si ID correcte */
    @Test
    public void updateGoodId() throws SQLException {
        Matters matters = matterss.get(0);
        matters.setName(CHANGED_DATA);

        assertEquals(new Integer(1), DbManager.getInstance().getMattersDao().update(matters));
    }
}
