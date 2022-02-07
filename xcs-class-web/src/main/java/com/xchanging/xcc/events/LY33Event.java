package com.xchanging.xcc.events;

/**
 Commarea - C033 (LY33)
 Program  - Associated Screen/Process:- Market Details Screen D/B Updates’
 Devo
 */

public class LY33Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String TOTAL_LINE;
  private String[] SYNDICATE_NO;
  private String[] SYNDICATE_LINE;
  private String[] SYNDICATE_REF;
  private String[] BUREAU_LEAD;
  private String[] DELETE_IND;

  public LY33Event(
      String TOTAL_LINE,
      String[] SYNDICATE_NO,
      String[] SYNDICATE_LINE,
      String[] SYNDICATE_REF,
      String[] BUREAU_LEAD,
      String[] DELETE_IND)
  {
    this.TOTAL_LINE = TOTAL_LINE;
    this.SYNDICATE_NO = SYNDICATE_NO;
    this.SYNDICATE_LINE = SYNDICATE_LINE;
    this.SYNDICATE_REF = SYNDICATE_REF;
    this.BUREAU_LEAD = BUREAU_LEAD;
    this.DELETE_IND = DELETE_IND;
  }

  public String getName() {
    return "java:comp/env/event/LY33Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY33CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String[] getBUREAU_LEAD() {
    return BUREAU_LEAD;
  }
  public String[] getDELETE_IND() {
    return DELETE_IND;
  }
  public String[] getSYNDICATE_LINE() {
    return SYNDICATE_LINE;
  }
  public String[] getSYNDICATE_NO() {
    return SYNDICATE_NO;
  }
  public String[] getSYNDICATE_REF() {
    return SYNDICATE_REF;
  }
  public String getTOTAL_LINE() {
    return TOTAL_LINE;
  }


}


