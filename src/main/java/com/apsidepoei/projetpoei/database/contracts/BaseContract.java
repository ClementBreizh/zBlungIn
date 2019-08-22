package com.apsidepoei.projetpoei.database.contracts;

public class BaseContract {

  public final String tables;

  public final String columnId;

  public final String aliasColumnId;

  public final String[] columns;

  public final String[] aliasCols;

  public final String insert;

  public final String update;

  public final String delete;

  public final String selectAll;

  public final String select;

  public final String createTable;

  public final String dropTable;

  /**
   * Setup for basecontract.
   */
  public BaseContract(String table, String colId, String[] cols, String createtable) {
    tables = table;
    columnId = colId;
    columns = cols;
    createTable = createtable;
    aliasColumnId = table + "." + columnId;
    dropTable = "DROP table IF EXISTS " + table;

    aliasCols = aliasedcols();
    insert = insert();
    update = update();
    delete = delete();
    selectAll = selectAll();
    select = select();
  }

  private String[] aliasedcols() {
    String[] result = new String[columns.length];
    for (int i = 0; i < columns.length; i++) {
      result[i] = tables + "." + columns[i];
    }
    return result;
  }

  private String insert() {
    StringBuilder result = new StringBuilder();
    result.append("insert INTO " + tables + "(");

    int j = 0;
    for (; j < columns.length - 1; j++) {
      result.append(columns[j] + ",");
    }
    result.append(columns[j]);

    result.append(") VALUES(");

    for (int i = 0; i < columns.length - 1; i++) {
      result.append("?,");
    }
    result.append("?");

    result.append(")");
    return result.toString();
  }

  private String update() {
    StringBuilder result = new StringBuilder();
    result.append("update " + tables + " SET ");

    int j = 1;
    for (; j < columns.length - 1; j++) {
      result.append(columns[j] + " = ?,");
    }
    result.append(columns[j] + " = ? ");

    result.append(" WHERE " + columnId + " = ?");

    return result.toString();
  }

  private String delete() {
    StringBuilder result = new StringBuilder();

    result.append("delete FROM " + tables + " WHERE " + columnId + " = ?");

    return result.toString();
  }

  private String selectAll() {
    StringBuilder result = selectBase();

    return result.toString();
  }

  private String select() {
    StringBuilder result = selectBase();
    result.append(" WHERE " + columnId + " = ?");

    return result.toString();
  }

  private StringBuilder selectBase() {
    StringBuilder result = new StringBuilder();
    result.append("select ");

    int j = 0;
    for (; j < columns.length - 1; j++) {
      result.append(columns[j] + ",");
    }
    result.append(columns[j]);
    result.append(" FROM " + tables);
    return result;
  }

}
