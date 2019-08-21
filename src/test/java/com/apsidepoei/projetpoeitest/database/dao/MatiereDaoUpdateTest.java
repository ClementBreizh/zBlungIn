package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matiere;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/** Test UPDATE function on database */
public class MatiereDaoUpdateTest {

    private static final String CHANGED_DATA = "toto";
    private List<Matiere> matieres = new ArrayList<Matiere>();

    // setup pour la mise en place des tests
    @Before
    public void setupTests() throws SQLException {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();

        matieres.clear();
        matieres.add(new Matiere(1,"matiere1"));
        matieres.add(new Matiere(2,"matiere2"));
        matieres.add(new Matiere(3,"matiere3"));

        for (Matiere matiere : matieres) {
            DbManager.getInstance().getMatiereDao().insert(matiere);
        }
    }

    /** Comparaison entre données update et attendues */
    @Test
    public void simpleUpdateCompare1() throws SQLException {
        Matiere matiere = matieres.get(0);
        matiere.setName(CHANGED_DATA);

        Matiere dbMatiere = (Matiere)DbManager.getInstance().getMatiereDao().select(1);
        DbManager.getInstance().getMatiereDao().update(matiere);
        Matiere dbMatiereUpdated = (Matiere)DbManager.getInstance().getMatiereDao().select(1);

        assertTrue(dbMatiere.getId() == dbMatiereUpdated.getId() && !dbMatiere.getName().equals(dbMatiereUpdated.getName()) && dbMatiereUpdated.getName().equals(CHANGED_DATA));
    }

    @Test
    public void simpleUpdateCompare2() throws SQLException {
        Matiere matiere = matieres.get(0);
        matiere.setName(CHANGED_DATA);

        DbManager.getInstance().getMatiereDao().update(matiere);
        Matiere dbMatiereUpdated = (Matiere)DbManager.getInstance().getMatiereDao().select(1);

        assertTrue(matiere.getId() == dbMatiereUpdated.getId() && matiere.getName().equals(dbMatiereUpdated.getName()));
    }

    @Test
    public void simpleUpdateCompare3() {
        Matiere matiere = matieres.get(0);
        Matiere dbMatiere = (Matiere)DbManager.getInstance().getMatiereDao().select(1);

        assertTrue(matiere.getId() == dbMatiere.getId() && matiere.getName().equals(dbMatiere.getName()));
    }

    /** Test sur le nombre de character saisie */
    @Test(expected = MysqlDataTruncation.class)
    public void updateMaxValExtended() throws SQLException {
        Matiere matiere = matieres.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            data.append("x");
        }
        matiere.setName(data.toString());

        DbManager.getInstance().getMatiereDao().update(matiere);
    }

    @Test
    public void updateMaxValOK() throws SQLException {
        Matiere matiere = matieres.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            data.append("x");
        }
        matiere.setName(data.toString());

        DbManager.getInstance().getMatiereDao().update(matiere);
    }

    @Test
    /** Test que l'on peut bien envoyée une chaine de string vide*/
    public void updateMinValOK() throws SQLException {
        Matiere matiere = matieres.get(0);
        matiere.setName("");

        DbManager.getInstance().getMatiereDao().update(matiere);
    }

    /** Test en cas de retour NULL */
    @Test(expected = MySQLIntegrityConstraintViolationException.class)
    public void updateNullValKO() throws SQLException {
        Matiere matiere = matieres.get(0);
        matiere.setName(null);

        DbManager.getInstance().getMatiereDao().update(matiere);
    }

    /** Test si ID erronée */
    @Test
    public void updateWrongId() throws SQLException {
        Matiere matiere = matieres.get(0);
        matiere.setId(4);
        matiere.setName(CHANGED_DATA);

        assertEquals(new Integer(0), DbManager.getInstance().getMatiereDao().update(matiere));
    }

    /** Test si ID correcte */
    @Test
    public void updateGoodId() throws SQLException {
        Matiere matiere = matieres.get(0);
        matiere.setName(CHANGED_DATA);

        assertEquals(new Integer(1), DbManager.getInstance().getMatiereDao().update(matiere));
    }
}
