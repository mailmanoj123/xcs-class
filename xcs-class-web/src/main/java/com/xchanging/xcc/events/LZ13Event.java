package com.xchanging.xcc.events;

/**
 Commarea - C112 (LZ13)
 Program  - Associated Screen/Process:- 'Re-advice Screen Validation'
*/

public class LZ13Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String CURR_NARR_1;
  private String NARR_CODE_1;
  private String CURR_NARR_2A;
  private String NARR_CODE_2;
  private String CURR_NARR_2B;

  public LZ13Event(
      String CURR_NARR_1,
      String NARR_CODE_1,
      String CURR_NARR_2A,
      String NARR_CODE_2,
      String CURR_NARR_2B
      )
  {
    this.CURR_NARR_1 = CURR_NARR_1;
    this.NARR_CODE_1 = NARR_CODE_1;
    this.CURR_NARR_2A = CURR_NARR_2A;
    this.NARR_CODE_2 = NARR_CODE_2;
    this.CURR_NARR_2B = CURR_NARR_2B;
  }


  public String getName() {
    return "java:comp/env/event/LZ13Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ13CICSHandler";
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

  public String getCURR_NARR_1 () {
    return CURR_NARR_1;
  }

  public String getNARR_CODE_1 () {
    if (NARR_CODE_1==null)
      return "";
    else
      return NARR_CODE_1;
  }

  public String getCURR_NARR_2A () {
    return CURR_NARR_2A;
  }

  public String getNARR_CODE_2 () {
    if (NARR_CODE_2==null)
      return "";
    else
      return NARR_CODE_2;
  }

  public String getCURR_NARR_2B () {
    return CURR_NARR_2B;
  }

}