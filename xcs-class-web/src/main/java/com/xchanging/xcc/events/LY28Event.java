package com.xchanging.xcc.events;

/**
 Commarea - C028 (LY28)
 Program  - Associated Screen/Process:- Build Policy/Risk Details
 Devo
 */


public class LY28Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String CURR_NO;
  // Empty constructor....
  public LY28Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY28Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY28CICSHandler";
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


