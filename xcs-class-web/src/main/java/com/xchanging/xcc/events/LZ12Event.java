package com.xchanging.xcc.events;

/**
 Commarea - C111 (LZ12)
 Program  - Associated Screen/Process:- 'Build Re-advice Screen'
 */


public class LZ12Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ12Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ12Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ12CICSHandler";
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


