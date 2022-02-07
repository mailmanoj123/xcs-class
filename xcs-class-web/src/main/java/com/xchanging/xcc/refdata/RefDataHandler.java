package com.xchanging.xcc.refdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.utils.Keys;

public class RefDataHandler {

  private static String SEPARATOR = ",";
  private int columns;

  public Vector readTable(String table) {

    String dir = System.getProperty("refdata.home",Keys.RefDataDir);
    File f;
    BufferedReader in = null;
    String row;

    Vector rows = new Vector();

    f = new File(dir + table);

    try {
      in = new BufferedReader(new FileReader(f));

      // Get column count and skip first line (the headers)
      row = in.readLine();
      columns = getColumnCount(row);

      // Read data from table and populate vector
      while ((row=in.readLine())!=null) {
        rows.add(parseRow(row));
      }
      return rows;
    }
    catch(FileNotFoundException fnf) {
      throw new GeneralFailureException("Reference Data table '" + table + "' not found.");
    }
    catch(IOException ioe) {
      throw new GeneralFailureException(ioe.getMessage());
    }
    finally {
      if (in!=null) {
        try {
          in.close();
        } catch (IOException e) {}
      }
    }
  }

  private TableRow parseRow(String s) {
    int pos=0;
    String cell;
    TableRow row = new TableRow(columns);

    for (int i=0;i<columns;i++) {
      if (s.indexOf(SEPARATOR,pos)>-1) {
        cell = s.substring(pos,s.indexOf(SEPARATOR,pos));
        pos = s.indexOf(SEPARATOR,pos) + 1;
      }
      else {
        cell = s.substring(pos);
        pos = s.length();
      }
      row.setColumn(i,cell.trim());
    }
    return row;
  }

  private int getColumnCount(String s) {
    int pos = 0;
    int cols = 1;
    while (s.indexOf(SEPARATOR,pos)>-1) {
      cols++;
      pos = s.indexOf(SEPARATOR,pos) + 1;
    }
    return cols;
  }
}