package com.xchanging.xcc.events;

/**
 Commarea - C009 (LY09)
 Program  - Associated Screen/Process:- Check for Security Notes
 Devo
 */

public class LY09Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String currentScreen;

  public LY09Event(String currentScreen)
  {
    this.currentScreen = currentScreen;
  }

  public String getName() {
    return "java:comp/env/event/LY09Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY09CICSHandler";
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
    All the getters now follow- none required
  */


}


