package com.apsidepoei.projetpoei.database.dao;

import com.apsidepoei.projetpoei.entities.EntityDb;

import java.sql.SQLException;

import java.util.List;



public interface Dao<T extends EntityDb> {

  /**
   * Create.
   */
  public void create();

  /**
   * Drop.
   */
  public void drop();

  /**
   * Insert.
   */
  public T insert(T item) throws SQLException;

  /**
   * Update.
   */
  public Integer update(T item) throws SQLException;

  /**
   * Delete.
   */
  public Integer delete(T item);

  /**
   * Select List.
   */
  public List<T> select();

  /**
   * Select T by Id.
   */
  public T select(int id);
}
