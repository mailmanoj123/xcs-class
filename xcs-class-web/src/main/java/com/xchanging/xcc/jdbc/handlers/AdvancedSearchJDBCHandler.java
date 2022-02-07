package com.xchanging.xcc.jdbc.handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.AdvancedSearchEvent;
import com.xchanging.xcc.events.ClaimsEvent;

public class AdvancedSearchJDBCHandler extends JDBCHandler{

  private java.sql.Connection conn;
  private HashMap map;

  public void perform(ClaimsEvent ce, StateMachine sm) {

    ResultSet rset;
    AdvancedSearchEvent event = (AdvancedSearchEvent)ce;
    Connection con = sm.getJdbcConnection();
    map = new HashMap();

    String query = event.getQuery();

    if (!query.equals("")) {
      if (!event.getCor().equals("''")) {
        if (event.getDirection().equals("fwd")) {
          query += " and cor > " + event.getCor();
        }
        else {
          query += " and cor < " + event.getCor();
        }
      }
      query += " order by cor";

      if (event.getDirection().equals("back")) {
        query += " desc";
      }

      if (con != null) {

        try {
          Statement stmt;

          try {
            stmt = con.createStatement();
          } catch (SQLException e) {
            // try again - sometimes a connection closed error is thrown.
            con = sm.getJdbcConnection();
            stmt = con.createStatement();
          }
          /*
          Need to determine the max amount of rows possible for the
          given query. This value is then used to determine the status
          of the Prev and Next buttons.
          */
          String tmpQuery = "select count(*) " + query;
          ResultSet tmp = stmt.executeQuery(tmpQuery);
          tmp.next();
          Integer maxRows = new Integer(tmp.getInt(1));

          query = "select * " + query;
          stmt.setMaxRows(20);
          rset = stmt.executeQuery(query);
          map.put("RESULT_SET",rset);
          map.put("MAX_ROWS",maxRows);
        }
        catch (SQLException sqlE) {
          sqlE.printStackTrace();
        }
      }
    } else {
      // query not executed
    }

  }

  public HashMap getResults() {
    return map;
  }


}