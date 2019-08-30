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
//import com.apsidepoei.projetpoei.database.contracts.FeedbackContract;
//import com.apsidepoei.projetpoei.entities.Feedback;
//import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
//
///**
// * @author vianney
// *
// */
//public class FeedbackDaoCreateDropTest {
//
//  @Test
//  public void testGetFeedbackCreateTableMatchingFields() throws SQLException {
//
//    DbManager.getInstance().getFeedbackDao().drop();
//    DbManager.getInstance().getFeedbackDao().create();
//
//    ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
//        .executeQuery("DESCRIBE " + FeedbackContract.TABLE);
//    List<DescribeQuery> describeQuery = new ArrayList<DescribeQuery>();
//    while (rs.next()) {
//      DescribeQuery desc = new DescribeQuery();
//      desc.setField(rs.getString(1));
//      desc.setType(rs.getString(2));
//      desc.setNullable(rs.getString(3));
//      desc.setKeyType(rs.getString(4));
//      desc.setDefaultValue(rs.getString(5));
//      desc.setExtra(rs.getString(6));
//      describeQuery.add(desc);
//    }
//
//    if (FeedbackContract.COLS.length != describeQuery.size()) {
//      fail("not same number of lines");
//    }
//
//    for (int i = 0; i < describeQuery.size(); i++) {
//      if (!describeQuery.get(i).getField().equals(FeedbackContract.COLS[i])) {
//        fail("Column name do not match");
//      }
//    }
//
//  }
//
//  @Test
//  public void testgetFeedbackDaoCreateTableInsertWorking() {
//    DbManager.getInstance().getFeedbackDao().drop();
//    DbManager.getInstance().getFeedbackDao().create();
//    try {
//      DbManager.getInstance().getFeedbackDao().insert(new Feedback("Feedback1", 1, "commentaire1"));
//    } catch (Exception e) {
//      fail("Insertion failure");
//    }
//  }
//
//  @Test
//  public void testgetFeedbackDaoDropTableRemoved() throws SQLException {
//    DbManager.getInstance().getFeedbackDao().drop();
//    ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
//        .executeQuery("SHOW TABLES");
//    while (rs.next()) {
//      if (rs.getString(1).equals(FeedbackContract.TABLE)) {
//        fail("Table already exists");
//      }
//    }
//  }
//
//  @Test(expected = MySQLSyntaxErrorException.class)
//  public void testgetFeedbackDaoDropCannotInsert() throws SQLException, ParseException {
//    DbManager.getInstance().getFeedbackDao().drop();
//    DbManager.getInstance().getFeedbackDao().insert(new Feedback("Feedback1", 1, "commentaire1"));
//  }
//
//  @Test
//  public void testgetFeedbackDaoDropCannotInsertGoodMessage() {
//    DbManager.getInstance().getFeedbackDao().drop();
//    try {
//      DbManager.getInstance().getFeedbackDao().insert(new Feedback("Feedback1", 1, "commentaire1"));
//    } catch (SQLException e) {
//      assertTrue(
//          e.getMessage().equals("Table 'zbleugin." + FeedbackContract.TABLE + "' doesn't exist"));
//    }
//  }
//
//}
