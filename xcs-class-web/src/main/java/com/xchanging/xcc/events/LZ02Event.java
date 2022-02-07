package com.xchanging.xcc.events;

/**
 Commarea - C101 (LZ02)
 Program  - Associated Screen/Process:- Create Skeleton Breakdown for an Initial
                                        CLASS for Lloyds Claim Transaction
 Devo
 */


public class LZ02Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ02Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ02Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ02CICSHandler";
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

}


