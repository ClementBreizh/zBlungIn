package com.apsidepoei.projetpoei.database.dao;

import java.sql.SQLException;
import java.util.List;

import com.apsidepoei.projetpoei.entities.EntityDb;

public interface Dao<T extends EntityDb> {
    public void create();

    public void drop();

    public T insert(T item) throws SQLException;

    public Integer update(T item) throws SQLException;

    public Integer delete(T item);

    public List<T> select();

    public T select(int id);
}
