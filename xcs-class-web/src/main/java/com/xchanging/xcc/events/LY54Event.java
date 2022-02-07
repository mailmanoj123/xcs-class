package com.xchanging.xcc.events;

/**
 Commarea - C054 (LY54)
 Program  - Associated Screen/Process:- Binder Schedule Screen Validation
 Devo
 */


public class LY54Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LY54Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY54Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY54CICSHandler";
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


