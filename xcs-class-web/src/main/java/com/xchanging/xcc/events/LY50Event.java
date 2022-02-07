package com.xchanging.xcc.events;

/**
 Commarea - C050 (LY50)
 Program  - Associated Screen/Process:- R/I Schedule Screen D/B Update
 Devo
 */


public class LY50Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY50Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY50Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY50CICSHandler";
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


