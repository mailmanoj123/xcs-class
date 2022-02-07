package com.xchanging.xcc.events;

/**
 Commarea - C096 (LY96)
 Program  - Associated Screen/Process:- Set File Last Seen Date
 Devo
 */


public class LY96Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY96Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY96Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY96CICSHandler";
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


