package com.xchanging.xcc.events;

/**
 Commarea - C019 (LY19)
 Program  - Associated Screen/Process:- Currency Validation
 Devo
 */


public class LY19Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String CURR_NO;

  public LY19Event(String CURR_NO)
  {
    this.CURR_NO = CURR_NO;
  }

  public String getName() {
    return "java:comp/env/event/LY19Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY19CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow-
  */
  public String getCURR_NO() {
      return CURR_NO;
  }

}


