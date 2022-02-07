package com.xchanging.xcc.events;

/**
 Commarea - C111 (LZ18)
 Program  - Associated Screen/Process:- '
 */


public class LZ18Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ18Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ18Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ18CICSHandler";
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


