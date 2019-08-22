/**
 *
 */
package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author vianney
 *
 */

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.entities.Address;

public class AddressDao extends BaseDao<Address> {

  public AddressDao() {
    super(new AddressContract());
  }

  @Override
  protected void javaToSqlInsert(Address item, PreparedStatement ps) throws SQLException {

    ps.setString(2, item.getAddress());
    ps.setString(3, item.getPostalCode());
    ps.setString(4, item.getTown());
  }

  @Override
  protected void javaToSqlUpdate(Address item, PreparedStatement ps) throws SQLException {

    ps.setString(1, item.getAddress());
    ps.setString(2, item.getPostalCode());
    ps.setString(3, item.getTown());
    ps.setInt(4, item.getId());
  }

  @Override
  protected Address parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
    Address item = new Address();
    item.setId(rs.getInt(rs.findColumn(AddressContract.COL_ID)));
    item.setAddress(rs.getString(rs.findColumn(AddressContract.COL_ADDRESS)));
    item.setPostalCode(rs.getString(rs.findColumn(AddressContract.COL_POSTAL_CODE)));
    item.setTown(rs.getString(rs.findColumn(AddressContract.COL_TOWN)));

    return item;
  }
}
