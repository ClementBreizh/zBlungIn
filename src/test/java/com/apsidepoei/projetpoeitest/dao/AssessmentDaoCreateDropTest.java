//package com.apsidepoei.projetpoeitest.dao;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.database.DbOpenHelper;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
//
//public class AssessmentDaoCreateDropTest {
//
//    @Test
//    public void testGetAssessmentDaoCreateTableMatchingFields() throws SQLException {
//        DbManager.getInstance().getAssessmentDao().drop();
//        DbManager.getInstance().getAssessmentDao().create();
//
//        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
//                .executeQuery("DESCRIBE " + AssessmentContract.TABLE);
//        List<DescribeQuery> describeQuery = new ArrayList<DescribeQuery>();
//        while (rs.next()) {
//            DescribeQuery desc = new DescribeQuery();
//            desc.setField(rs.getString(1));
//            desc.setType(rs.getString(2));
//            desc.setNullable(rs.getString(3));
//            desc.setKeyType(rs.getString(4));
//            desc.setDefaultValue(rs.getString(5));
//            desc.setExtra(rs.getString(6));
//            describeQuery.add(desc);
//        }
//
//        if (AssessmentContract.COLS.length != describeQuery.size()) {
//            fail("not same number of lines");
//        }
//
//        for (int i = 0; i < describeQuery.size(); i++) {
//            if (!describeQuery.get(i).getField().equals(AssessmentContract.COLS[i])) {
//                fail("Column name do not match");
//            }
//        }
//    }
//
//    @Test
//    public void testGetAssessmentDaoCreateTableInsertWorking() {
//        DbManager.getInstance().getAssessmentDao().drop();
//        DbManager.getInstance().getAssessmentDao().create();
//        try {
//            DbManager.getInstance().getAssessmentDao()
//                    .insert(new Assessment("JAVA et SQL", new SimpleDateFormat("yyyy/mm/dd").parse("2019/08/18")));
//        } catch (Exception e) {
//            fail("Insertion failure");
//        }
//    }
//
//    @Test
//    public void testGetAssessmentDaoDropTableRemoved() throws SQLException {
//        DbManager.getInstance().getAssessmentDao().drop();
//        ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
//        while (rs.next()) {
//            if (rs.getString(1).equals(AssessmentContract.TABLE)) {
//                fail("Table already exists");
//            }
//        }
//    }
//
//    @Test(expected = MySQLSyntaxErrorException.class)
//    public void testGetAssessmentDaoDropCannotInsert() throws SQLException, ParseException {
//        DbManager.getInstance().getAssessmentDao().drop();
//        DbManager.getInstance().getAssessmentDao()
//                .insert(new Assessment("JAVA et SQL", new SimpleDateFormat("yyyy/mm/dd").parse("2019/08/18")));
//    }
//
//    @Test
//    public void testGetAssessmentDaoDropCannotInsertGoodMessage() {
//        DbManager.getInstance().getAssessmentDao().drop();
//        try {
//            DbManager.getInstance().getAssessmentDao()
//                    .insert(new Assessment("JAVA et SQL", new SimpleDateFormat("yyyy/mm/dd").parse("2019/08/18")));
//        } catch (SQLException | ParseException e) {
//            assertTrue(e.getMessage().equals("Table 'zbleugin." + AssessmentContract.TABLE + "' doesn't exist"));
//        }
//    }
//}
