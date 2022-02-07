package com.xchanging.xcc.events;

/**
 Commarea - C111 (LZ18)
 Program  - Associated Screen/Process:- 'Log-off button'
 */


public class LY04Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY04Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY04Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY04CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow- none needed
  */


}


