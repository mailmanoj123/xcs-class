package com.xchanging.xcc.events;

/**
 Commarea - C018 (LY18)
 Program  - Associated Screen/Process:- Delete Claim Transaction
 Devo
 */


public class LY18Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY18Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY18Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY18CICSHandler";
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


