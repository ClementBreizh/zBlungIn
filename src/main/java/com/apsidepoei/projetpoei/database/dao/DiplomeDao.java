package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.contracts.DegreeContract;
import com.apsidepoei.projetpoei.mysql.entities.Degree;

public class DegreeDao extends BaseDao<Degree> {

	public DegreeDao() {
        super(new DegreeContract());
    }

    @Override
    protected void javaToSqlInsert(Degree item, PreparedStatement ps) throws SQLException {
        ps.setString(2, item.getName());
        ps.setString(3, item.getLevel());
    }

    @Override
    protected void javaToSqlUpdate(Degree item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setString(2, item.getLevel());
        ps.setString(3, item.getId());
    }

    @Override
    protected Degree parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
    	Degree item = new Degree();

        item.setId(rs.getInt(rs.findColumn(DegreeContract.COL_ID)));
        item.setName(rs.getString(rs.findColumn(DegreeContract.COL_NAME)));
        item.setLevel(rs.getString(rs.findColumn(DegreeContract.COL_LEVEL)));

        return item;
    }
}
