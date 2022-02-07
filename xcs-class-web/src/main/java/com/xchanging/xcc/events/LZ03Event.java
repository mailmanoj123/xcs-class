package com.xchanging.xcc.events;

/**
 Commarea - C102 (LZ03)
 Program  - Associated Screen/Process:- Obtain Breakdown for Collection
 Devo
 */


public class LZ03Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String CURR_NO;
  private String SDN_NO;
  private String STAT_SPLIT_NO;

  // Constructor....
  public LZ03Event(
         String CURR_NO,
         String SDN_NO,
         String STAT_SPLIT_NO
                  )
  {
    this.CURR_NO = CURR_NO;
    this.SDN_NO = SDN_NO;
    this.STAT_SPLIT_NO = STAT_SPLIT_NO;
  }

  public String getName() {
    return "java:comp/env/event/LZ03Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ03CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow- none are present
  */

  public String getCURR_NO () {
    return CURR_NO ;
    }

  public String getSDN_NO () {
    return SDN_NO ;
    }

  public String getSTAT_SPLIT_NO () {
     return STAT_SPLIT_NO;
    }

}


