package com.xchanging.xcc.events;

/**
 Commarea - C066 (LY66)
 Program  - Associated Screen/Process:- Set up Bulk Component Session Record
 Devo
 */


public class LY66Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String COMP_SYS_REF;

  public LY66Event(
      String COMP_SYS_REF)
  {
    this.COMP_SYS_REF = COMP_SYS_REF;
  }


  public String getName() {
    return "java:comp/env/event/LY66Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY66CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow
  */

  public String getCOMP_SYS_REF() {
    return COMP_SYS_REF;
  }

}


