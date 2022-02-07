package com.xchanging.xcc.events;

/**
 Commarea - C015 (LY15)
 Program  - Associated Screen/Process:- Create Non-Aggregate Group
 Devo
 */


public class LY15Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY15Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY15Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY15CICSHandler";
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


