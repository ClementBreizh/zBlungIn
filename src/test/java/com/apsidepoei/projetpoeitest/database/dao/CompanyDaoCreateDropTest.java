package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.entities.Company;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This class test Dao.
 * @author benjamin-m
 *
 */
public class CompanyDaoCreateDropTest {

  /**
   * Test the creation of the table.
   * @throws SQLException
   */
  @Test
  public void testGetCompanyDaoCreateTableMatchingFields() throws SQLException {
    DbManager.getInstance().getCompanyDao().drop();
    DbManager.getInstance().getCompanyDao().create();

    ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
        .executeQuery("DESCRIBE " + CompanyContract.TABLE);
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

    if (CompanyContract.COLS.length != describeQuery.size()) {
      fail("not same number of lines");
    }

    for (int i = 0; i < describeQuery.size(); i++) {
      if (!describeQuery.get(i).getField().equals(CompanyContract.COLS[i])) {
        fail("Column name do not match");
      }
    }
  }

  /**
   * Test the insert for a new business.
   */
  @Test
  public void testGetCompanyDaoCreateTableInsertWorking() {
    DbManager.getInstance().getCompanyDao().drop();
    DbManager.getInstance().getCompanyDao().create();
    try {
      DbManager.getInstance().getCompanyDao()
          .insert(new Company("company1", "antenne1", "53267126000018", "0000A"));
    } catch (Exception e) {
      fail("Insertion failure");
    }
  }

  /**
   * Test the drop of the table.
   * @throws SQLException
   */
  @Test
  public void testGetCompanyDaoDropTableRemoved() throws SQLException {
    DbManager.getInstance().getCompanyDao().drop();
    ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
        .executeQuery("SHOW TABLES");
    while (rs.next()) {
      if (rs.getString(1).equals(CompanyContract.TABLE)) {
        fail("Table already exists");
      }
    }
  }

  /**
   * Test insert is not possible.
   * @throws SQLException
   * @throws ParseException
   */
  @Test(expected = MySQLSyntaxErrorException.class)
  public void testGetCompanyDaoDropCannotInsert() throws SQLException, ParseException {
    DbManager.getInstance().getCompanyDao().drop();
    DbManager.getInstance().getCompanyDao()
        .insert(new Company("company1", "antenne1", "53267126000018", "0000A"));
  }

  /**
   * Test insert isn't possible give the good alert.
   */
  @Test
  public void testGetCompanyDaoDropCannotInsertGoodMessage() {
    DbManager.getInstance().getCompanyDao().drop();
    try {
      DbManager.getInstance().getCompanyDao()
          .insert(new Company("company1", "antenne1", "53267126000018", "0000A"));
    } catch (SQLException e) {
      assertTrue(
          e.getMessage().equals("Table 'zbleugin." + CompanyContract.TABLE + "' doesn't exist"));
    }
  }
}
