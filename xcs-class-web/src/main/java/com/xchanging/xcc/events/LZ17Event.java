package com.xchanging.xcc.events;

/**
 Commarea - C116 (LZ17)
 Program  - Associated Screen/Process:- 'Settlement Search Results'
 */


public class LZ17Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String C116_TAKE_DOWN_NO;
  private String C116_TAKE_DOWN_DATE;
  private String C116_VERSION_NO;

  // Empty constructor....
  public LZ17Event(  String C116_TAKE_DOWN_NO,
                     String C116_TAKE_DOWN_DATE,
                     String C116_VERSION_NO)
  {
    this.C116_TAKE_DOWN_NO    = C116_TAKE_DOWN_NO;
    this.C116_TAKE_DOWN_DATE  = C116_TAKE_DOWN_DATE;
    this.C116_VERSION_NO      = C116_VERSION_NO;
  }

  public String getName() {
    return "java:comp/env/event/LZ17Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ17CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getC116_TAKE_DOWN_DATE() {
    return C116_TAKE_DOWN_DATE;
  }
  public String getC116_TAKE_DOWN_NO() {
    return C116_TAKE_DOWN_NO;
  }
  public String getC116_VERSION_NO() {
    return C116_VERSION_NO;
  }

  /*
    All the getters now follow- none needed
  */


}


