package com.xchanging.xcc.events;

/**
 Commarea - C089 (LY89)
 Program  - Associated Screen/Process:- Update Narrative Details
 Devo
 */

public class LY89Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String TEXT_ID;
  private String[] TEXT_LINE;
  private String CALL_NUMBER;

  public LY89Event(String TEXT_ID, String CALL_NUMBER, String[] TEXT_LINE) {
    this.TEXT_ID = TEXT_ID;
    this.CALL_NUMBER = CALL_NUMBER;
    this.TEXT_LINE = TEXT_LINE;
  }


  public String getName() {
    return "java:comp/env/event/LY89Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY89CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }


  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getTEXT_ID() {
    return TEXT_ID;
  }

  public String[] getTEXT_LINE () {
    return TEXT_LINE;
  }
  public String getCALL_NUMBER() {
    return CALL_NUMBER;
  }


}