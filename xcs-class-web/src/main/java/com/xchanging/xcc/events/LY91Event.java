package com.xchanging.xcc.events;

/**
 Commarea - C091 (LY91)
 Program  - Associated Screen/Process:- Build Bulk/CCS Correction Window
 Devo
 */


public class LY91Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY91Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY91Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY91CICSHandler";
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


