///**
// *
// */
//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.database.DbOpenHelper;
//import com.apsidepoei.projetpoei.database.contracts.DegreeContract;
//import com.apsidepoei.projetpoei.entities.Degree;
//import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
//
///**
// * @author thomas This class test Dao
// */
//public class DegreeDaoCreateDropTest {
//
//	/**
//	 *
//	 * @throws SQLException Test the creation of the table
//	 */
//	@Test
//	public void testGetDegreeDaoCreateTableMatchingFields() throws SQLException {
//		DbManager.getInstance().getDegreeDao().drop();
//		DbManager.getInstance().getDegreeDao().create();
//
//		ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
//				.executeQuery("DESCRIBE " + DegreeContract.TABLE);
//		List<DescribeQuery> describeQuery = new ArrayList<DescribeQuery>();
//		while (rs.next()) {
//			DescribeQuery desc = new DescribeQuery();
//			desc.setField(rs.getString(1));
//			desc.setType(rs.getString(2));
//			desc.setNullable(rs.getString(3));
//			desc.setKeyType(rs.getString(4));
//			desc.setDefaultValue(rs.getString(5));
//			desc.setExtra(rs.getString(6));
//			describeQuery.add(desc);
//		}
//
//		if (DegreeContract.COLS.length != describeQuery.size()) {
//			fail("not same number of lines");
//		}
//
//		for (int i = 0; i < describeQuery.size(); i++) {
//			if (!describeQuery.get(i).getField().equals(DegreeContract.COLS[i])) {
//				fail("Column name do not match");
//			}
//		}
//	}
//
//	/**
//	 * Test the insert for a new degree
//	 */
//	@Test
//	public void testGetDegreeDaoCreateTableInsertWorking() {
//		DbManager.getInstance().getDegreeDao().drop();
//		DbManager.getInstance().getDegreeDao().create();
//		try {
//			DbManager.getInstance().getDegreeDao().insert(new Degree("Diplome 1", "Master"));
//		} catch (Exception e) {
//			fail("Insertion failure");
//		}
//	}
//
//	/**
//	 *
//	 * @throws SQLException Test the drop of the table
//	 */
//	@Test
//	public void testGetDegreeDaoDropTableRemoved() throws SQLException {
//		DbManager.getInstance().getDegreeDao().drop();
//		ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
//		while (rs.next()) {
//			if (rs.getString(1).equals(DegreeContract.TABLE)) {
//				fail("Table already exists");
//			}
//		}
//	}
//
//	/**
//	 *
//	 * @throws SQLException
//	 * @throws ParseException
//	 * Test insert is not possible
//	 */
//	@Test(expected = MySQLSyntaxErrorException.class)
//	public void testGetDegreeDaoDropCannotInsert() throws SQLException, ParseException {
//		DbManager.getInstance().getDegreeDao().drop();
//		DbManager.getInstance().getDegreeDao().insert(new Degree("Diplome 1", "Master"));
//	}
//
//	/**
//	 * Test insert isn't possible give the good alert
//	 */
//	@Test
//	public void testGetDegreeDaoDropCannotInsertGoodMessage() {
//		DbManager.getInstance().getDegreeDao().drop();
//		try {
//			DbManager.getInstance().getDegreeDao().insert(new Degree("Diplome 1", "Master"));
//		} catch (SQLException e) {
//			assertTrue(e.getMessage().equals("Table 'zbleugin." + DegreeContract.TABLE + "' doesn't exist"));
//		}
//	}
//
//}
