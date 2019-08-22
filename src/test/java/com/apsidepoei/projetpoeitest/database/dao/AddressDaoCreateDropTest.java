/**
 *
 */
package com.apsidepoei.projetpoeitest.database.dao;

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
import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.apsidepoei.projetpoei.entities.Address;

/**
 * @author vianney
 *
 */
public class AddressDaoCreateDropTest {

  @Test
  public void testGetAddressCreateTableMatchingFields() throws SQLException {

    DbManager.getInstance().getAddressDao().drop();
    DbManager.getInstance().getAddressDao().create();

    ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
        .executeQuery("DESCRIBE " + AddressContract.TABLE);
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

    if (AddressContract.COLS.length != describeQuery.size()) {
      fail("not same number of lines");
    }

    for (int i = 0; i < describeQuery.size(); i++) {
      if (!describeQuery.get(i).getField().equals(AddressContract.COLS[i])) {
        fail("Column name do not match");
      }
    }

  }

  @Test
  public void testgetAddressDaoCreateTableInsertWorking() {
    DbManager.getInstance().getAddressDao().drop();
    DbManager.getInstance().getAddressDao().create();
    try {
      DbManager.getInstance().getAddressDao().insert(new Address("Address1", "code1", "ville1"));
    } catch (Exception e) {
      fail("Insertion failure");
    }
  }

  @Test
  public void testgetAddressDaoDropTableRemoved() throws SQLException {
    DbManager.getInstance().getAddressDao().drop();
    ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
    while (rs.next()) {
      if (rs.getString(1).equals(AddressContract.TABLE)) {
        fail("Table already exists");
      }
    }
  }

  @Test(expected = MySQLSyntaxErrorException.class)
  public void testgetAddressDaoDropCannotInsert() throws SQLException, ParseException {
    DbManager.getInstance().getAddressDao().drop();
    DbManager.getInstance().getAddressDao().insert(new Address("Address1", "code1", "ville1"));
  }

  @Test
  public void testgetAddressDaoDropCannotInsertGoodMessage() {
    DbManager.getInstance().getAddressDao().drop();
    try {
      DbManager.getInstance().getAddressDao().insert(new Address("Address1", "code1", "ville1"));
    } catch (SQLException e) {
      assertTrue(e.getMessage().equals("Table 'zbleugin." + AddressContract.TABLE + "' doesn't exist"));
    }
  }

}
