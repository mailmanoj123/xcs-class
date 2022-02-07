package com.xchanging.xcc.events;

/**
 Commarea - C022 (LY22)
 Program  - Associated Screen/Process:- Contra Correction Initial Validation’
 Devo
 */


public class LY22Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String CURR_NO;
  // Empty constructor....
  public LY22Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY22Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY22CICSHandler";
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


