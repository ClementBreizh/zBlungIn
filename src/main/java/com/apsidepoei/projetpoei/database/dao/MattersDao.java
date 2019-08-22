package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.contracts.MattersContract;
import com.apsidepoei.projetpoei.entities.Matters;

public class MattersDao extends BaseDao<Matters> {

    public MattersDao() {
        super(new MattersContract());
    }

    @Override
    protected void javaToSqlInsert(Matters item, PreparedStatement ps) throws SQLException {
        ps.setString(2, item.getName());
    }

    @Override
    protected void javaToSqlUpdate(Matters item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setInt(2, item.getId());
    }

    @Override
    protected Matters parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {

        Matters item = new Matters();
        item.setId(rs.getInt(rs.findColumn(MattersContract.COL_ID)));
        item.setName(rs.getString(rs.findColumn(MattersContract.COL_NAME)));
        return item;
    }
}
