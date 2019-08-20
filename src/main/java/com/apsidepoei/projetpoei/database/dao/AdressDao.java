/**
 *
 */
package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author vianney
 *
 */

import com.apsidepoei.projetpoei.database.contracts.AdressContract;
import com.apsidepoei.projetpoei.entities.Adress;

public class AdressDao extends BaseDao<Adress>{

    public AdressDao() {
        super(new AdressContract());
    }

    @Override
    protected void javaToSqlInsert(Adress item, PreparedStatement ps) throws SQLException {

        ps.setString(2, item.getAdress());
        ps.setString(3, item.getPostalCode());
        ps.setString(4, item.getTown());
    }

    @Override
    protected void javaToSqlUpdate(Adress item, PreparedStatement ps) throws SQLException {

        ps.setString(1, item.getAdress());
        ps.setString(2, item.getPostalCode());
        ps.setString(3, item.getTown());
        ps.setInt(4, item.getId());
    }

    @Override
    protected Adress parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
        Adress item = new Adress();
        item.setId(rs.getInt(rs.findColumn(AdressContract.COL_ID)));
        item.setAdress(rs.getString(rs.findColumn(AdressContract.COL_ADRESS)));
        item.setPostalCode(rs.getString(rs.findColumn(AdressContract.COL_POSTAL_CODE)));
        item.setTown(rs.getString(rs.findColumn(AdressContract.COL_TOWN)));

        return item;
    }
}
