package com.xchanging.xcc.events;

/**
 Commarea - C067 (LY67)
 Program  - Associated Screen/Process:- Build Conclusion of Bulk Screen
 Devo
 */


public class LY67Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY67Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY67Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY67CICSHandler";
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


