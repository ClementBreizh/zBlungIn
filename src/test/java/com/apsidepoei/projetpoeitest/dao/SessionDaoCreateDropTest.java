package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.apsidepoei.projetpoei.entities.Session;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

/**
 * 
 * @author benjamin-m
 *
 */
public class SessionDaoCreateDropTest {

	/**
	 *
	 * @throws SQLException Test the creation of the table
	 */
	 @Test
	    public void testGetEntrepriseDaoCreateTableMatchingFields() throws SQLException {
	        DbManager.getInstance().getSessionDao().drop();
	        DbManager.getInstance().getSessionDao().create();

	        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
	                .executeQuery("DESCRIBE " + SessionContract.TABLE);
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

	        if (SessionContract.COLS.length != describeQuery.size()) {
	            fail("not same number of lines");
	        }

	        for (int i = 0; i < describeQuery.size(); i++) {
	            if (!describeQuery.get(i).getField().equals(SessionContract.COLS[i])) {
	                fail("Column name do not match");
	            }
	        }
	    }

	 	/**
		 * Test the insert for a new session
		 */
	    @Test
	    public void testGetSessionDaoCreateTableInsertWorking() {
	        DbManager.getInstance().getSessionDao().drop();
	        DbManager.getInstance().getSessionDao().create();
	        try {
	            DbManager.getInstance().getSessionDao()
	                    .insert(new Session("Java Web", new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02")));
	        } catch (Exception e) {
	            fail("Insertion failure");
	        }
	    }

	    /**
		 *
		 * @throws SQLException Test the drop of the table
		 */
	    @Test
	    public void testGetSessionDaoDropTableRemoved() throws SQLException {
	        DbManager.getInstance().getSessionDao().drop();
	        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
	        while (rs.next()) {
	            if (rs.getString(1).equals(SessionContract.TABLE)) {
	                fail("Table already exists");
	            }
	        }
	    }

	    /**
		 *
		 * @throws SQLException
		 * @throws ParseException
		 * Test insert is not possible
		 */
	    @Test(expected = MySQLSyntaxErrorException.class)
	    public void testGetSessionDaoDropCannotInsert() throws SQLException, ParseException {
	        DbManager.getInstance().getSessionDao().drop();
	        DbManager.getInstance().getSessionDao()
	                .insert(new Session("Java Web", new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02")));
	    }

	    /**
		 * Test insert isn't possible give the good alert
	     * @throws ParseException 
		 */
	    @Test
	    public void testGetSessionDaoDropCannotInsertGoodMessage() throws ParseException {
	        DbManager.getInstance().getSessionDao().drop();
	        try {
	            DbManager.getInstance().getSessionDao()
	                    .insert(new Session("Java Web", new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02")));
	        } catch (SQLException e) {
	            assertTrue(e.getMessage().equals("Table 'zbleugin." + SessionContract.TABLE + "' doesn't exist"));
	        }
	    }
}
