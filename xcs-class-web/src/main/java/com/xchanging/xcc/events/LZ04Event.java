package com.xchanging.xcc.events;

/**
 Commarea - C103 (LZ04)
 Program  - Associated Screen/Process:- Delete Collections with no breakdown
 Devo
 */


public class LZ04Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ04Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ04Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ04CICSHandler";
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


