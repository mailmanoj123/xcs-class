package com.xchanging.xcc.events;

/**
 Commarea - C098 (LY98)
 Program  - Associated Screen/Process:- Delete Breakdown
 Devo
 */


public class LY98Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY98Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY98Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY98CICSHandler";
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


