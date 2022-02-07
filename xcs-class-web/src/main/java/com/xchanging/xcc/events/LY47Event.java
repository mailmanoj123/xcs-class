package com.xchanging.xcc.events;

/**
 Commarea - C047 (LY47)
 Program  - Associated Screen/Process:- Create New Breakdown
 Devo
 */


public class LY47Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;


  // Empty constructor....
  public LY47Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY47Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY47CICSHandler";
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


