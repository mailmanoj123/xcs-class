package com.xchanging.xcc.events;

/**
 Commarea - C090 (LY90)
 Program  - Associated Screen/Process:- Bulk/CCS Correction Initial Validation
 Devo
 */


public class LY90Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY90Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY90Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY90CICSHandler";
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


