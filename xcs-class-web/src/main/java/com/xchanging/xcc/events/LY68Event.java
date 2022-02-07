package com.xchanging.xcc.events;

/**
 Commarea - C068 (LY68)
 Program  - Associated Screen/Process:- Set up History Session Record
 Devo
 */


public class LY68Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String currentScreen;

  // Empty constructor....
  public LY68Event(String currentScreen)
  {
    this.currentScreen = currentScreen;
  }

  public String getName() {
    return "java:comp/env/event/LY68Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY68CICSHandler";
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

  /*
    All the getters now follow- none are present
  */

}


