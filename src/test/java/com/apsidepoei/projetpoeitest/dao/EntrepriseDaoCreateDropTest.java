package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.EntrepriseContract;
import com.apsidepoei.projetpoei.entities.Entreprise;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;


public class EntrepriseDaoCreateDropTest {
	 @Test
	    public void testGetEntrepriseDaoCreateTableMatchingFields() throws SQLException {
	        DbManager.getInstance().getEntrepriseDao().drop();
	        DbManager.getInstance().getEntrepriseDao().create();

	        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
	                .executeQuery("DESCRIBE " + EntrepriseContract.TABLE);
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

	        if (EntrepriseContract.COLS.length != describeQuery.size()) {
	            fail("not same number of lines");
	        }

	        for (int i = 0; i < describeQuery.size(); i++) {
	            if (!describeQuery.get(i).getField().equals(EntrepriseContract.COLS[i])) {
	                fail("Column name do not match");
	            }
	        }
	    }

	    @Test
	    public void testGetEntrepriseDaoCreateTableInsertWorking() {
	        DbManager.getInstance().getEntrepriseDao().drop();
	        DbManager.getInstance().getEntrepriseDao().create();
	        try {
	            DbManager.getInstance().getEntrepriseDao()
	                    .insert(new Entreprise("entreprise1", "antenne1", "53267126000018", "0000A"));
	        } catch (Exception e) {
	            fail("Insertion failure");
	        }
	    }

	    @Test
	    public void testGetEntrepriseDaoDropTableRemoved() throws SQLException {
	        DbManager.getInstance().getEntrepriseDao().drop();
	        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
	        while (rs.next()) {
	            if (rs.getString(1).equals(EntrepriseContract.TABLE)) {
	                fail("Table already exists");
	            }
	        }
	    }

	    @Test(expected = MySQLSyntaxErrorException.class)
	    public void testGetEntrepriseDaoDropCannotInsert() throws SQLException, ParseException {
	        DbManager.getInstance().getEntrepriseDao().drop();
	        DbManager.getInstance().getEntrepriseDao()
	                .insert(new Entreprise("entreprise1", "antenne1", "53267126000018", "0000A"));
	    }

	    @Test
	    public void testGetEntrepriseDaoDropCannotInsertGoodMessage() {
	        DbManager.getInstance().getEntrepriseDao().drop();
	        try {
	            DbManager.getInstance().getEntrepriseDao()
	                    .insert(new Entreprise("entreprise1", "antenne1", "53267126000018", "0000A"));
	        } catch (SQLException e) {
	            assertTrue(e.getMessage().equals("Table 'zbleugin." + EntrepriseContract.TABLE + "' doesn't exist"));
	        }
	    }
}
