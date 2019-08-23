package com.apsidepoei.projetpoei.database.dao;

import com.apsidepoei.projetpoei.database.contracts.EntrepriseContract;
import com.apsidepoei.projetpoei.database.dao.BaseDao;
import com.apsidepoei.projetpoei.entities.Entreprise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * This class define the tools for data access object.
 * @author benjamin-m 
 */
public class EntrepriseDao extends BaseDao<Entreprise> {
  /**
   * Constructor.
   */
  public EntrepriseDao() {
    super(new EntrepriseContract());
  }
    
    /**
     * Override the function in order to insert a new business.
     */
  @Override
    protected void javaToSqlInsert(Entreprise item, PreparedStatement ps) throws SQLException {
    ps.setString(2, item.getNom());
    ps.setString(3, item.getNomAntenne());
    ps.setString(4, item.getSiret());
    ps.setString(5, item.getCodeApe());
  }
    
    /**
     * Override the function in order to update a business.
     */
  @Override
    protected void javaToSqlUpdate(Entreprise item, PreparedStatement ps) throws SQLException {
    ps.setString(1, item.getNom());
    ps.setString(2, item.getNomAntenne());
    ps.setString(3, item.getSiret());
    ps.setString(4, item.getCodeApe());
    ps.setInt(5, item.getId());
  }
    
    /**
     * Override the function to parse a business from the database.
     */
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
