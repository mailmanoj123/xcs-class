package com.xchanging.xcc.events;

/**
 Commarea - C114 (LZ15)
 Program  - Associated Screen/Process:- 'Build Settlement Search screen'
 */


public class LZ15Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ15Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ15Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ15CICSHandler";
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


