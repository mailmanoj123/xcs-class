package com.xchanging.xcc.events;

/**
 Commarea - C032 (LY32)
 Program  - Associated Screen/Process:- Market Details Screen Validation
 Devo
 */
public class LY32Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String NO_SYNDICATES;
  private String TOTAL_LINE;
  private String MKT_SOURCE;
  private String[] SYNDICATE_NO;
  private String[] SYNDICATE_LINE;
  private String[] SYNDICATE_REF;
  private String[] DELETE_IND;

  public LY32Event(
      String NO_SYNDICATES,
      String TOTAL_LINE,
      String MKT_SOURCE,
      String[] SYNDICATE_NO,
      String[] SYNDICATE_LINE,
      String[] SYNDICATE_REF,
      String[] DELETE_IND)
  {
    this.NO_SYNDICATES = NO_SYNDICATES;
    this.TOTAL_LINE = TOTAL_LINE;
    this.MKT_SOURCE = MKT_SOURCE;
    this.SYNDICATE_NO = SYNDICATE_NO;
    this.SYNDICATE_LINE = SYNDICATE_LINE;
    this.SYNDICATE_REF = SYNDICATE_REF;
    this.DELETE_IND = DELETE_IND;
  }


  public String getName() {
    return "java:comp/env/event/LY32Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY32CICSHandler";
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
  public String getNO_SYNDICATES() {
    return NO_SYNDICATES;
  }
  public String getTOTAL_LINE() {
    return TOTAL_LINE;
  }
  public String getMKT_SOURCE() {
    return MKT_SOURCE;
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
  public String[] getDELETE_IND() {
    return DELETE_IND;
  }
}