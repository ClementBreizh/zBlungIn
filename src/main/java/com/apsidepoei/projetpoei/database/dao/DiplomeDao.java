package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.contracts.DiplomeContract;
import com.apsidepoei.projetpoei.mysql.entities.Diplome;
import com.poei_juillet_2019.mysql.entities.Entreprise;

public class DiplomeDao extends BaseDao<Diplome> {

	public DiplomeDao() {
        super(new DiplomeContract());
    }

    @Override
    protected void javaToSqlInsert(Diplome item, PreparedStatement ps) throws SQLException {
        ps.setString(2, item.getName());
        ps.setString(3, item.getLevel());
    }

    @Override
    protected void javaToSqlUpdate(Diplome item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setString(2, item.getLevel());
        ps.setString(3, item.getId());
    }

    @Override
    protected Diplome parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
        Diplome item = new Diplome();

        item.setId(rs.getInt(rs.findColumn(DiplomeContract.COL_ID)));
        item.setName(rs.getString(rs.findColumn(DiplomeContract.COL_NAME)));
        item.setLevel(rs.getString(rs.findColumn(DiplomeContract.COL_LEVEL)));

        return item;
    }
}
