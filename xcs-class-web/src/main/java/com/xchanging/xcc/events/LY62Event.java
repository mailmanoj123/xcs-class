package com.xchanging.xcc.events;

/**
 Commarea - C062 (LY62)
 Program  - Associated Screen/Process:- Build Settlement Summary Screen
 Devo
 */


public class LY62Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY62Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY62Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY62CICSHandler";
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


