package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.
MattersContract;
import com.apsidepoei.projetpoei.entities.
Matters;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;


/** Test CREATE, DROP on database */
public class MattersDaoCreateDropTest {

    @Test
    /** creation de la table */
    public void testGetMattersDaoCreateTableMatchingFields() throws SQLException {

        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();

        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
                .executeQuery("DESCRIBE " + MattersContract.TABLE);
        List<DescribeQuery> describeQuery = new ArrayList<DescribeQuery>();
        while (rs.next()) {
            DescribeQuery desc = new DescribeQuery();
            desc.setField(rs.getString(1));
            desc.setType(rs.getString(2));
            desc.setNullable(rs.getString(3));
            desc.setKeyType(rs.getString(4));
            desc.setDefaultValue(rs.getString(5));
            desc.setExtra(rs.getString(6));
            describeQuery.add(desc);
        }

        if (MattersContract.COLS.length != describeQuery.size()) {
            fail("not same number of lines");
        }

        for (int i = 0; i < describeQuery.size(); i++) {
            if (!describeQuery.get(i).getField().equals(MattersContract.COLS[i])) {
                fail("Column name do not match");
            }
        }
    }

    @Test
    /** test insertion dans la table une fois creér */
    public void testGetMattersDaoCreateTableInsertWorking() {
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();
        try {
            DbManager.getInstance().getMattersDao()
                    .insert(new Matters("matters1"));
        } catch (Exception e) {
            fail("Insertion failure");
        }
    }

    @Test
    /** test du drop de la table avec vérification si elle existe toujours apres */
    public void testGetMattersDaoDropTableRemoved() throws SQLException {
        DbManager.getInstance().getMattersDao().drop();
        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
        while (rs.next()) {
            if (rs.getString(1).equals(MattersContract.TABLE)) {
                fail("Table already exists");
            }
        }
    }

    @Test(expected = MySQLSyntaxErrorException.class)
    /** test d'insetion alors que la table n'existe plus/pas */
    public void testGetMattersDaoDropCannotInsert() throws SQLException, ParseException {
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao()
                .insert(new Matters("matters1"));
    }
}

