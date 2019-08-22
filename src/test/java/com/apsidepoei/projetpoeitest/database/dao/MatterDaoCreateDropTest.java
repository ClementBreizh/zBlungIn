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
MatterContract;
import com.apsidepoei.projetpoei.entities.
Matter;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;


/** Test CREATE, DROP on database */
public class MatterDaoCreateDropTest {

    @Test
    /** creation de la table */
    public void testGetMatterDaoCreateTableMatchingFields() throws SQLException {

        DbManager.getInstance().getMatterDao().drop();
        DbManager.getInstance().getMatterDao().create();

        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
                .executeQuery("DESCRIBE " + MatterContract.TABLE);
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

        if (MatterContract.COLS.length != describeQuery.size()) {
            fail("not same number of lines");
        }

        for (int i = 0; i < describeQuery.size(); i++) {
            if (!describeQuery.get(i).getField().equals(MatterContract.COLS[i])) {
                fail("Column name do not match");
            }
        }
    }

    @Test
    /** test insertion dans la table une fois creér */
    public void testGetMatterDaoCreateTableInsertWorking() {
        DbManager.getInstance().getMatterDao().drop();
        DbManager.getInstance().getMatterDao().create();
        try {
            DbManager.getInstance().getMatterDao()
                    .insert(new Matter("matters1"));
        } catch (Exception e) {
            fail("Insertion failure");
        }
    }

    @Test
    /** test du drop de la table avec vérification si elle existe toujours apres */
    public void testGetMatterDaoDropTableRemoved() throws SQLException {
        DbManager.getInstance().getMatterDao().drop();
        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
        while (rs.next()) {
            if (rs.getString(1).equals(MatterContract.TABLE)) {
                fail("Table already exists");
            }
        }
    }

    @Test(expected = MySQLSyntaxErrorException.class)
    /** test d'insetion alors que la table n'existe plus/pas */
    public void testGetMatterDaoDropCannotInsert() throws SQLException, ParseException {
        DbManager.getInstance().getMatterDao().drop();
        DbManager.getInstance().getMatterDao()
                .insert(new Matter("matters1"));
    }
}

