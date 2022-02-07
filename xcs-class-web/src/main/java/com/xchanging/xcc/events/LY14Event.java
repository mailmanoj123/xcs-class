package com.xchanging.xcc.events;

/**
 Commarea - C014 (LY14)
 Program  - Associated Screen/Process:- Add OSND(s) to Aggregate Group
 Devo
 */


public class LY14Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY14Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY14Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY14CICSHandler";
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


