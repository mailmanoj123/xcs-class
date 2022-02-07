package com.xchanging.xcc.events;

/**
 Commarea - C059 (LY59)
 Program  - Associated Screen/Process:- Build Non-Settlement Summary Screen
 Devo
 */


public class LY59Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY59Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY59Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY59CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow- none are present
  */

}


