package com.xchanging.xcc.events;

/**
 Commarea - C061 (LY61)
 Program  - Associated Screen/Process:- Release Claim and create SCM Log Records
 Devo
 */


public class LY61Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String FILE_SEEN_IND;

  public LY61Event(
      String FILE_SEEN_IND)
  {
    this.FILE_SEEN_IND = FILE_SEEN_IND;
  }


  public String getName() {
    return "java:comp/env/event/LY61Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY61CICSHandler";
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

  public String getFILE_SEEN_IND() {
    return FILE_SEEN_IND;
  }

}


