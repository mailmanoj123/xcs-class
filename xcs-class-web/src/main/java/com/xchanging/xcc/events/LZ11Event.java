package com.xchanging.xcc.events;

/**
 Commarea - C110 (LZ11)
 Program  - Associated Screen/Process:- 'Create Re-advice - Initial Validation'
 */


public class LZ11Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ11Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ11Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ11CICSHandler";
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


