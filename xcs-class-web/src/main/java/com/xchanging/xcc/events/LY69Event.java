package com.xchanging.xcc.events;

public class LY69Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String NEXT_PRESSED;
  private String PREV_PRESSED;
  private String START_SYS_REF;

  public LY69Event(String NEXT_PRESSED, String PREV_PRESSED, String START_SYS_REF) {
    this.NEXT_PRESSED = NEXT_PRESSED;
    this.PREV_PRESSED = PREV_PRESSED;
    this.START_SYS_REF = START_SYS_REF;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY69Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY69CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getNEXT_PRESSED() {
    return NEXT_PRESSED;
  }
  public String getPREV_PRESSED() {
    return PREV_PRESSED;
  }
  public String getSTART_SYS_REF() {
    return START_SYS_REF;
  }
}