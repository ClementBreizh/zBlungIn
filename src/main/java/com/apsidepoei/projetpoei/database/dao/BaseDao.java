package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.BaseContract;
import com.apsidepoei.projetpoei.entities.EntityDb;


public abstract class BaseDao<T extends EntityDb> implements Dao<T> {

    private BaseContract contract;

    public BaseDao(BaseContract contract) {
        this.contract = contract;
    }

    @Override
    public void create() {
        PreparedStatement ps = null;
        try {
            ps = DbOpenHelper.getInstance().getConn().prepareStatement(contract.CREATE_TABLE);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void drop() {
        PreparedStatement ps = null;
        try {
            DbOpenHelper.getInstance().getConn().createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
            ps = DbOpenHelper.getInstance().getConn().prepareStatement(contract.DROP_TABLE);
            ps.execute();
            DbOpenHelper.getInstance().getConn().createStatement().execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public T insert(T item) throws SQLException {
        String request = contract.INSERT;
        PreparedStatement ps = null;
        try {
            ps = DbOpenHelper.getInstance().getConn().prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            if (item.getId() == null) {
                ps.setNull(1, java.sql.Types.INTEGER);
            }else {
                ps.setInt(1, item.getId());
            }

            javaToSqlInsert(item, ps);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return item;
    }

    @Override
    public Integer update(T item) throws SQLException {
        Integer nbTupleChanged = null;

        String request = contract.UPDATE;
        PreparedStatement ps = null;
        try {
            ps = DbOpenHelper.getInstance().getConn().prepareStatement(request);
            javaToSqlUpdate(item,ps);
            nbTupleChanged = ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return nbTupleChanged;
    }

    @Override
    public Integer delete(T item) {
        Integer nbTupleChanged = null;

        String request = contract.DELETE;
        PreparedStatement ps = null;
        try {
            ps = DbOpenHelper.getInstance().getConn().prepareStatement(request);
            ps.setInt(1, item.getId());
            nbTupleChanged = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nbTupleChanged;
    }

    @Override
    public List<T> select() {
        List<T> result = new ArrayList<T>();

        String request = contract.SELECTALL;
        PreparedStatement ps = null;
        try {
            ps = DbOpenHelper.getInstance().getConn()
                .prepareStatement(request);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(parseFromDbToJava(rs));
            }
            rs.close();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public T select(int id) {
        T result = null;

        String request = contract.SELECT;
        PreparedStatement ps = null;
        try {
            ps = DbOpenHelper.getInstance().getConn()
                .prepareStatement(request);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                T item = parseFromDbToJava(rs);
                result = item;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    protected abstract void javaToSqlInsert(T item, PreparedStatement ps) throws SQLException;
    protected abstract void javaToSqlUpdate(T item, PreparedStatement ps) throws SQLException;
    protected abstract T parseFromDbToJava(ResultSet rs) throws SQLException, ParseException;
}
