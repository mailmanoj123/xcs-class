package com.xchanging.xcc.events;

/**
 Commarea - C115 (LZ16)
 Program  - Associated Screen/Process:- 'Settlement Search Screen'- this event is fired off by the initial settlement search screen.
 */


public class LZ16Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String C115_INCLUDE_POST_IMPN_TDNS = "";
  private String C115_TAKE_DOWN_NO = "";
  private String C115_TAKE_DOWN_DATE = "";
  private String C115_ORIG_SIGNING_NO = "";
  private String C115_ORIG_SIGNING_DATE = "";
  private String C115_YEAR_OF_ACC = "";
  private String C115_PAYEE_BKR = "";
  private String C115_COMP_BTW_FROM = "";
  private String C115_COMP_BTW_TO = "";
  private String C115_NAME_1 = "";
  private String C115_NAME_1_PARTIAL_IND = "";
  private String C115_NAME_2 = "";
  private String C115_NAME_2_PARTIAL_IND = "";


  public LZ16Event(String C115_TAKE_DOWN_NO,
                   String C115_TAKE_DOWN_DATE,
                   String C115_ORIG_SIGNING_NO,
                   String C115_ORIG_SIGNING_DATE,
                   String C115_YEAR_OF_ACC,
                   String C115_PAYEE_BKR,
                   String C115_COMP_BTW_FROM,
                   String C115_COMP_BTW_TO,
                   String C115_NAME_1,
                   String C115_NAME_1_PARTIAL_IND,
                   String C115_NAME_2,
                   String C115_NAME_2_PARTIAL_IND)
  {
    // this value is hard-coded as it is only included for (potential) future use
    this.C115_INCLUDE_POST_IMPN_TDNS = "N";
    this.C115_TAKE_DOWN_NO = C115_TAKE_DOWN_NO;
    this.C115_TAKE_DOWN_DATE = C115_TAKE_DOWN_DATE;
    this.C115_ORIG_SIGNING_NO = C115_ORIG_SIGNING_NO;
    this.C115_ORIG_SIGNING_DATE = C115_ORIG_SIGNING_DATE;
    this.C115_YEAR_OF_ACC = C115_YEAR_OF_ACC;
    this.C115_PAYEE_BKR = C115_PAYEE_BKR;
    this.C115_COMP_BTW_FROM = C115_COMP_BTW_FROM;
    this.C115_COMP_BTW_TO = C115_COMP_BTW_TO;
    this.C115_NAME_1 = C115_NAME_1;
    this.C115_NAME_1_PARTIAL_IND = C115_NAME_1_PARTIAL_IND;
    this.C115_NAME_2 = C115_NAME_2;
    this.C115_NAME_2_PARTIAL_IND = C115_NAME_2_PARTIAL_IND;
  }

  public String getName() {
    return "java:comp/env/event/LZ16Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ16CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getC115_COMP_BTW_FROM() {
    return C115_COMP_BTW_FROM;
  }
  public String getC115_COMP_BTW_TO() {
     return C115_COMP_BTW_TO;
      }
  public String getC115_INCLUDE_POST_IMPN_TDNS() {
    return C115_INCLUDE_POST_IMPN_TDNS;
  }
  public String getC115_NAME_1() {
    return C115_NAME_1;
  }
  public String getC115_NAME_1_PARTIAL_IND() {
    return C115_NAME_1_PARTIAL_IND;
   }
  public String getC115_NAME_2() {
    return C115_NAME_2;
  }
  public String getC115_NAME_2_PARTIAL_IND() {
    return C115_NAME_2_PARTIAL_IND;
  }
  public String getC115_ORIG_SIGNING_DATE() {
    return C115_ORIG_SIGNING_DATE;
  }
  public String getC115_ORIG_SIGNING_NO() {
    return C115_ORIG_SIGNING_NO;
  }
  public String getC115_PAYEE_BKR() {
    return C115_PAYEE_BKR;
  }
  public String getC115_TAKE_DOWN_DATE() {
    return C115_TAKE_DOWN_DATE;
  }
  public String getC115_TAKE_DOWN_NO() {
    return C115_TAKE_DOWN_NO;
  }
  public String getC115_YEAR_OF_ACC() {
    return C115_YEAR_OF_ACC;
  }


}








