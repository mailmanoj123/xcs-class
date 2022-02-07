package com.xchanging.xcc.events;

public class LY79Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String REDUCE_OUTST_IND;

  public LY79Event(
      String REDUCE_OUTST_IND)
  {
    this.REDUCE_OUTST_IND = REDUCE_OUTST_IND;
  }


  public String getName() {
    return "java:comp/env/event/LY79Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY79CICSHandler";
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

  public String getREDUCE_OUTST_IND() {
    return REDUCE_OUTST_IND;
  }

}