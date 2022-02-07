package com.xchanging.xcc.events;

/**
 Commarea - C040 (LY40)
 Program  - Associated Screen/Process:- Build Single Claim Loss Reserve Screen
 Devo
 */


public class LY40Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;


  // Empty constructor....
  public LY40Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY40Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY40CICSHandler";
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


