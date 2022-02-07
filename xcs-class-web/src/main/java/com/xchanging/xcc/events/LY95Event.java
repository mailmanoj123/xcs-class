package com.xchanging.xcc.events;

/**
 Commarea - C095 (LY95)
 Program  - Associated Screen/Process:- Delete Deselected Bulk Components
 Devo
 */


public class LY95Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY95Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY95Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY95CICSHandler";
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


