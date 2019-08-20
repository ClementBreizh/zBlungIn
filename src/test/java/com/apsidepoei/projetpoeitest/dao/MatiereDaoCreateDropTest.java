package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.MatiereContract;
import com.apsidepoei.projetpoei.entities.Matiere;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;



public class MatiereDaoCreateDropTest {

    @Test
    public void testGetMatiereDaoCreateTableMatchingFields() throws SQLException {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();

        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
                .executeQuery("DESCRIBE " + MatiereContract.TABLE);
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

        if (MatiereContract.COLS.length != describeQuery.size()) {
            fail("not same number of lines");
        }

        for (int i = 0; i < describeQuery.size(); i++) {
            if (!describeQuery.get(i).getField().equals(MatiereContract.COLS[i])) {
                fail("Column name do not match");
            }
        }
    }

    @Test
    public void testGetMatiereDaoCreateTableInsertWorking() {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();
        try {
            DbManager.getInstance().getMatiereDao()
                    .insert(new Matiere("matiere1"));
        } catch (Exception e) {
            fail("Insertion failure");
        }
    }

    @Test
    public void testGetMatiereDaoDropTableRemoved() throws SQLException {
        DbManager.getInstance().getMatiereDao().drop();
        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
        while (rs.next()) {
            if (rs.getString(1).equals(MatiereContract.TABLE)) {
                fail("Table already exists");
            }
        }
    }

    @Test(expected = MySQLSyntaxErrorException.class)
    public void testGetMatiereDaoDropCannotInsert() throws SQLException, ParseException {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao()
                .insert(new Matiere("matiere1"));
    }

    @Test
    public void testGetMatiereDaoDropCannotInsertGoodMessage() {
        DbManager.getInstance().getMatiereDao().drop();
        try {
            DbManager.getInstance().getMatiereDao()
                    .insert(new Matiere("matiere1"));
        } catch (SQLException e) {
            assertTrue(e.getMessage().equals("Table 'zblungi." + MatiereContract.TABLE + "' doesn't exist"));
        }
    }
}

