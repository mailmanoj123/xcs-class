package com.xchanging.xcc.events;

/**
 Commarea - C055 (LY55)
 Program  - Associated Screen/Process:- Binder Schedule Screen D/B Update
 Devo
 */


public class LY55Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY55Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY55Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY55CICSHandler";
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


