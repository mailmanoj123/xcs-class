package com.xchanging.xcc.events;

/**
 Commarea - C023 (LY23)
 Program  - Associated Screen/Process:- Add TDN Initial Validation
 Devo
 */


public class LY23Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String CURR_NO;
  // Empty constructor....
  public LY23Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY23Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY23CICSHandler";
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


