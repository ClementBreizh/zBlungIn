package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.contracts.EntrepriseContract;
import com.apsidepoei.projetpoei.entities.Entreprise;
import com.apsidepoei.projetpoei.database.dao.BaseDao;

public class EntrepriseDao extends BaseDao<Entreprise> {
    public EntrepriseDao() {
        super(new EntrepriseContract());
    }

    @Override
    protected void javaToSqlInsert(Entreprise item, PreparedStatement ps) throws SQLException {
        ps.setString(2, item.getNom());
        ps.setString(3, item.getNomAntenne());
        ps.setString(4, item.getSiret());
        ps.setString(5, item.getCodeApe());
    }

    @Override
    protected void javaToSqlUpdate(Entreprise item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getNom());
        ps.setString(2, item.getNomAntenne());
        ps.setString(3, item.getSiret());
        ps.setString(4, item.getCodeApe());
        ps.setInt(5, item.getId());
    }

    @Override
    protected Entreprise parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
        Entreprise item = new Entreprise();

        item.setId(rs.getInt(rs.findColumn(EntrepriseContract.COL_ID)));
        item.setNom(rs.getString(rs.findColumn(EntrepriseContract.COL_NOM)));
        item.setNomAntenne(rs.getString(rs.findColumn(EntrepriseContract.COL_NOM_ANTENNE)));
        item.setSiret(rs.getString(rs.findColumn(EntrepriseContract.COL_SIRET)));
        item.setCodeApe(rs.getString(rs.findColumn(EntrepriseContract.COL_CODE_APE)));
        return item;
    }
}
