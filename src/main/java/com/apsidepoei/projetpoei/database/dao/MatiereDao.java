package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.contracts.MatiereContract;
import com.apsidepoei.projetpoei.entities.Matiere;

public class MatiereDao extends BaseDao<Matiere> {

    public MatiereDao() {
        super(new MatiereContract());
    }

    @Override
    protected void javaToSqlInsert(Matiere item, PreparedStatement ps) throws SQLException {
        ps.setString(2, item.getName());
    }

    @Override
    protected void javaToSqlUpdate(Matiere item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setInt(2, item.getId());
    }

    @Override
    protected Matiere parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
        Matiere item = new Matiere();
        item.setId(rs.getInt(rs.findColumn(MatiereContract.COL_ID)));
        item.setName(rs.getString(rs.findColumn(MatiereContract.COL_NAME)));
        return item;
    }
}

