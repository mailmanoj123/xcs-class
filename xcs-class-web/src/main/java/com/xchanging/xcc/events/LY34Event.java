package com.xchanging.xcc.events;

/**
 Commarea - C034 (LY34)
 Program  - Associated Screen/Process:- Build Claim Details
 Devo
 */


public class LY34Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private boolean showLossDetails;

  public LY34Event()
  {

  }

  public String getName() {
    return "java:comp/env/event/LY34Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY34CICSHandler";
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


