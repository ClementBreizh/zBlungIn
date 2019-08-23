package com.apsidepoei.projetpoei.database.dao;

import com.apsidepoei.projetpoei.database.contracts.MatterContract;
import com.apsidepoei.projetpoei.entities.Matter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class MatterDao extends BaseDao<Matter> {

  /**
   * Constructor.
   */
  public MatterDao() {
    super(new MatterContract());
  }

  @Override
  protected void javaToSqlInsert(Matter item, PreparedStatement ps) throws SQLException {
    ps.setString(2, item.getName());
  }

  @Override
  protected void javaToSqlUpdate(Matter item, PreparedStatement ps) throws SQLException {
    ps.setString(1, item.getName());
    ps.setInt(2, item.getId());
  }

  @Override
  protected Matter parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {

    Matter item = new Matter();
    item.setId(rs.getInt(rs.findColumn(MatterContract.COL_ID)));
    item.setName(rs.getString(rs.findColumn(MatterContract.COL_NAME)));
    return item;
  }
}
