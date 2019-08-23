package com.apsidepoei.projetpoei.database.dao;

import com.apsidepoei.projetpoei.database.contracts.AssessmentContract;
import com.apsidepoei.projetpoei.entities.Assessment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * This class define the tools for data access object.
 *
 * @author clemb
 */
public class AssessmentDao extends BaseDao<Assessment> {

  /**
   * Constructor.
   */
  public AssessmentDao() {
    super(new AssessmentContract());
  }

  /**
   * Override the function in order to insert a new appointment.
   */
  @Override
  protected void javaToSqlInsert(Assessment item, PreparedStatement ps) throws SQLException {
    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String mySqlDate = sdf.format(item.getDateTime());

    ps.setString(2, item.getCategory());
    ps.setString(3, mySqlDate);
  }

  /**
   * Override the function in order to update a appointment.
   */
  @Override
  protected void javaToSqlUpdate(Assessment item, PreparedStatement ps) throws SQLException {
    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String mySqlDate = sdf.format(item.getDateTime());

    ps.setString(1, item.getCategory());
    ps.setString(2, mySqlDate);
    ps.setInt(3, item.getId());
  }

  /**
   * Override the function to parse a appointment from the database.
   */
  @Override
  protected Assessment parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
    Assessment item = new Assessment();

    item.setId(rs.getInt(rs.findColumn(AssessmentContract.COL_ID)));
    item.setCategory(rs.getString(rs.findColumn(AssessmentContract.COL_CATEGORY)));

    String date = rs.getString(rs.findColumn(AssessmentContract.COL_DATE));
    date = date.substring(0, 10);

    item.setDateTime(new SimpleDateFormat("yyy-MM-dd").parse(date));

    return item;
  }
}

