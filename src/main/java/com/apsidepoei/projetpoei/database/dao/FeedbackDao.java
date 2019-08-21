/**
 *
 */
package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.contracts.FeedbackContract;
import com.apsidepoei.projetpoei.entities.Feedback;

/**
 * @author vianney
 *
 */
public class FeedbackDao extends BaseDao<Feedback>{

    public FeedbackDao() {
        super(new FeedbackContract());
    }

    @Override
    protected void javaToSqlInsert(Feedback item, PreparedStatement ps) throws SQLException {

        ps.setString(2, item.getTypeOfContract());
        ps.setInt(3, item.getDurationOfContract());
        ps.setString(4, item.getComment());
    }

    @Override
    protected void javaToSqlUpdate(Feedback item, PreparedStatement ps) throws SQLException {

        ps.setString(1, item.getTypeOfContract());
        ps.setInt(2, item.getDurationOfContract());
        ps.setString(3, item.getComment());
        ps.setInt(4, item.getId());
    }

    @Override
    protected Feedback parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
        Feedback item = new Feedback();
        item.setId(rs.getInt(rs.findColumn(FeedbackContract.COL_ID)));
        item.setTypeOfContract(rs.getString(rs.findColumn(FeedbackContract.COL_TYPE_OF_CONTRACT)));
        item.setDurationOfContract(rs.getInt(rs.findColumn(FeedbackContract.COL_DURATION_OF_CONTRACT)));
        item.setComment(rs.getString(rs.findColumn(FeedbackContract.COL_COMMENT)));

        return item;
    }
}
