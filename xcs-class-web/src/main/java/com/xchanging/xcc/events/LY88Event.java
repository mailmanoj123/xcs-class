package com.xchanging.xcc.events;

/**
 Commarea - C088 (LY88)
 Program  - Associated Screen/Process:- Build Narrative Screen
 Devo
 */


public class LY88Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String Text_ID;
  private String firstCall;

  public LY88Event(String Text_ID, String firstCall) {
    this.Text_ID = Text_ID;
    this.firstCall = firstCall;
  }


  public String getName() {
    return "java:comp/env/event/LY88Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY88CICSHandler";
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

  public String getText_ID() {
    return Text_ID;
  }
  public String getFirstCall() {
    return firstCall;
  }

}


