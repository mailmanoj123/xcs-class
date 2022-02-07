package com.xchanging.xcc.refdata;


public class TableRow {
  String[] columns;

  public TableRow(int columnCount) {
    columns = new String[columnCount];
  }

  void setColumn(int column, String text) {
    columns[column] = text;
  }

  public String getColumn(int i) {
    return columns[i];
  }

  public int size() {
    return columns.length;
  }
}