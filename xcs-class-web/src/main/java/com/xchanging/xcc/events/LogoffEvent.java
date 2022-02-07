package com.xchanging.xcc.events;

public class LogoffEvent extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private boolean primarySession;

  public LogoffEvent(boolean primarySession) {
    this.primarySession = primarySession;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LogoffEvent";
  }

  public int getType() {
    return OTHER;
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LogoffCICSHandler";
  }

  public boolean isPrimarySession() {
    return primarySession;
  }
}