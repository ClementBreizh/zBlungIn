package com.apsidepoei.projetpoei.database.dao;

import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.apsidepoei.projetpoei.entities.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *  This class define the tools for data access object.
 * @author benjamin-m
 *
 */
public class SessionDao extends BaseDao<Session> {
  /**
   * Constructor.
   */
  public SessionDao() {
    super(new SessionContract());
  }

  /**
   * Override the function in order to insert a new session.
   */
  @Override
  protected void javaToSqlInsert(Session item, PreparedStatement ps) throws SQLException {
    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String mySqlDate = sdf.format(item.getDateStart());
    String mySqlDate1 = sdf.format(item.getDateEnd());

    ps.setString(2, item.getName());
    ps.setString(3, mySqlDate);
    ps.setString(4, mySqlDate1);
  }

  /**
   * Override the function in order to update session.
   */
  @Override
  protected void javaToSqlUpdate(Session item, PreparedStatement ps) throws SQLException {
    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String mySqlDateStart = sdf.format(item.getDateStart());
    String mySqlDateEnd = sdf.format(item.getDateEnd());

    ps.setString(1, item.getName());
    ps.setString(2, mySqlDateStart);
    ps.setString(3, mySqlDateEnd);
    ps.setInt(4, item.getId());
  }

  /**
   * Override the function to parse session from the database.
   */
  @Override
  protected Session parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
    Session item = new Session();

    item.setId(rs.getInt(rs.findColumn(SessionContract.COL_ID)));
    item.setName(rs.getString(rs.findColumn(SessionContract.COL_NAME)));

    String dateStart = rs.getString(rs.findColumn(SessionContract.COL_DATESTART));
    dateStart = dateStart.substring(0, 10);

    item.setDateStart(new SimpleDateFormat("yyyy-MM-dd").parse(dateStart));

    String dateEnd = rs.getString(rs.findColumn(SessionContract.COL_DATEEND));
    dateEnd = dateEnd.substring(0, 10);

    item.setDateStart(new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd));

    return item;
  }
}
