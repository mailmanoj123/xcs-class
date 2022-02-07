package com.xchanging.xcc.events;

public class LY12Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String currentScreen;

  public LY12Event(String currentScreen) {
    this.currentScreen = currentScreen;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY12Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY12CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getCurrentScreen() {
    return currentScreen;
  }

}