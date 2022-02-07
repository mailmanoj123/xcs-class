package com.xchanging.xcc.events;

/**
 Commarea - C049 (LY49)
 Program  - Associated Screen/Process:- R/I Schedule Screen Validation
 Devo
 */

public class LY49Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;


  // Empty constructor....
  public LY49Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LY49Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY49CICSHandler";
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


