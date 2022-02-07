package com.xchanging.xcc.events;

/**
 Commarea - C063 (LY63)
 Program  - Associated Screen/Process:- Assign Take Down Numbers
 Devo
 */


public class LY63Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY63Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY63Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY63CICSHandler";
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


