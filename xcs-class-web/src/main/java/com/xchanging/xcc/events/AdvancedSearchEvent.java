package com.xchanging.xcc.events;

public class AdvancedSearchEvent extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String cor;
  private String query;
  private String direction;

  public AdvancedSearchEvent( String query) {
    this.query = query;
  }

  public AdvancedSearchEvent( String query, String cor, String direction ) {
    this.query = query;
    this.cor = cor;
    this.direction = direction;
  }

  public String getDirection() {
    if (direction == null) {
      direction = "";
    }
    return direction;
  }

  public String getQuery() {
    if (query == null) {
      query = "";
    }
    return query;
  }

  public String getCor() {
    if (cor == null) {
      cor = "";
    }
    return "'" + cor + "'";
  }

  public int getType() {
    return OTHER;
  }

  public boolean isOracleEvent() {
    return true;
  }

  public String getName() {
    return "java:comp/env/event/AdvancedSearchEvent";
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.jdbc.handlers.AdvancedSearchJDBCHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

}
