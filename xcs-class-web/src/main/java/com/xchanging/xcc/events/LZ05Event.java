package com.xchanging.xcc.events;

/**
 Commarea - C104 (LZ05)
 Program  - Associated Screen/Process:- Assign Claims Office References
 Devo
 */


public class LZ05Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String MARKET_CODE;
  private String ORIG_CURR;

  // Constructor....
  public LZ05Event(
         String MARKET_CODE,
         String ORIG_CURR
                  )
  {
    this.MARKET_CODE = MARKET_CODE;
    this.ORIG_CURR = ORIG_CURR;
  }

  public String getName() {
    return "java:comp/env/event/LZ05Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ05CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow
  */

  public String getMARKET_CODE () {
    return MARKET_CODE ;
    }

  public String getORIG_CURR () {
    return ORIG_CURR ;
    }


}


