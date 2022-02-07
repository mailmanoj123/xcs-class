package com.xchanging.xcc.events;

public class LY78Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String[] REV_RATE_EXCH;
  private String[] REV_SETT_AMT;

  public LY78Event(
      String[] REV_RATE_EXCH,
      String[] REV_SETT_AMT)
  {
    this.REV_RATE_EXCH = REV_RATE_EXCH;
    this.REV_SETT_AMT = REV_SETT_AMT;
  }


  public String getName() {
    return "java:comp/env/event/LY78Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY78CICSHandler";
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

  public String[] getREV_RATE_EXCH() {
    return REV_RATE_EXCH;
  }

  public String[] getREV_SETT_AMT() {
    return REV_SETT_AMT;
  }

}