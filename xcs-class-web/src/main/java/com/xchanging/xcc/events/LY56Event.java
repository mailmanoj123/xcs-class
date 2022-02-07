package com.xchanging.xcc.events;

/**
 * <p>Title: LY56Event</p>
 * <p>Description: LY56 Event Handler - Build Subsequent Advice Schedule Screen</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY56Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String PREV_PRESSED ;
  private String NEXT_PRESSED ;
  private String START_BDOWN_NO ;

  public LY56Event(
      String PREV_PRESSED,
      String NEXT_PRESSED,
      String START_BDOWN_NO
  ) {
    this.PREV_PRESSED = PREV_PRESSED ;
    this.NEXT_PRESSED = NEXT_PRESSED ;
    this.START_BDOWN_NO = START_BDOWN_NO ;
  }

  public String getName() {
    return "java:comp/env/event/LY56Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY56CICSHandler";
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
  public String getPREV_PRESSED() {
    return PREV_PRESSED;
  }

  public String getNEXT_PRESSED() {
    return NEXT_PRESSED;
  }

  public String getSTART_BDOWN_NO() {
    return START_BDOWN_NO;
  }
}