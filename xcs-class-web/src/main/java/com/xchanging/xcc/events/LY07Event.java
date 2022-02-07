package com.xchanging.xcc.events;

/**
 Commarea - C007 (LY07)
 Program  - Associated Screen/Process:- Specific Claim Search
 Devo
 */

public class LY07Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String SEARCH_UCR;
  private String SEARCH_TR;
  private String SEARCH_COR;
  private String SEARCH_TDN;
  private String SEARCH_CERT_NO;

  // constructor....
  public LY07Event(
      String SEARCH_UCR,
      String SEARCH_TR,
      String SEARCH_COR,
      String SEARCH_TDN,
      String SEARCH_CERT_NO)
  {
    this.SEARCH_UCR = SEARCH_UCR;
    this.SEARCH_TR  = SEARCH_TR;
    this.SEARCH_COR = SEARCH_COR;
    this.SEARCH_TDN = SEARCH_TDN;
    this.SEARCH_CERT_NO = SEARCH_CERT_NO;
  }

  public String getName() {
    return "java:comp/env/event/LY07Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY07CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow-
  */

  public String getSEARCH_COR() {
    return SEARCH_COR;
  }
  public String getSEARCH_TDN() {
    return SEARCH_TDN;
  }
  public String getSEARCH_TR() {
    return SEARCH_TR;
  }
  public String getSEARCH_UCR() {
      return SEARCH_UCR;
    }

  public String getSEARCH_CERT_NO() {
      return SEARCH_CERT_NO;
    }


}


