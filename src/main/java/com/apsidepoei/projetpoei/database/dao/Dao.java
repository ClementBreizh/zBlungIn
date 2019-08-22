package com.apsidepoei.projetpoei.database.dao;

import com.apsidepoei.projetpoei.entities.EntityDb;
import java.sql.SQLException;
import java.util.List;



public interface Dao<T extends EntityDb> {
  public void create();

  public void drop();

  public T insert(T item) throws SQLException;

  public Integer update(T item) throws SQLException;

  public Integer delete(T item);

  public List<T> select();

  public T select(int id);
}
