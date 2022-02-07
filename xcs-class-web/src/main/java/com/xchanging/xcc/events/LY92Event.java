package com.xchanging.xcc.events;

public class LY92Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String[] ORIG_CURR;
  private String[] SETT_CURR;
  private String[] TREASURY_RATE;
  private String REDUCE_OUTST_IND;


  public LY92Event(
      String[] ORIG_CURR,
      String[] SETT_CURR,
      String[] TREASURY_RATE,
      String REDUCE_OUTST_IND)
  {
    this.ORIG_CURR = ORIG_CURR;
    this.SETT_CURR = SETT_CURR;
    this.TREASURY_RATE = TREASURY_RATE;
    this.REDUCE_OUTST_IND = REDUCE_OUTST_IND;
  }


  public String getName() {
    return "java:comp/env/event/LY92Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY92CICSHandler";
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

  public String[] getORIG_CURR() {
    return ORIG_CURR;
  }

  public String[] getSETT_CURR() {
    return SETT_CURR;
  }

  public String[] getTREASURY_RATE() {
    return TREASURY_RATE;
  }

  public String getREDUCE_OUTST_IND() {
    return REDUCE_OUTST_IND;
  }

}