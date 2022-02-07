package com.xchanging.xcc.events;

/**
 Commarea - C105 (LZ06)
 Program  - Associated Screen/Process:- Reset Claim Transaction
 Devo
 */

public class LZ06Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  // Empty constructor....
  public LZ06Event()
  {
  }

  public String getName() {
    return "java:comp/env/event/LZ06Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ06CICSHandler";
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


