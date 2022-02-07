package com.xchanging.xcc.events;

/**
 Commarea - C099 (LY99)
 Program  - Associated Screen/Process:-  Store Selected/Deselected Components
 Devo
 */


public class LY99Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String[] compSysRef;
  private String[] includeInd;

  private String FILE_SEEN_IND;

  // Empty constructor....
  public LY99Event(String[] compSysRef, String[] includeInd)
  {
    this.compSysRef = compSysRef;
    this.includeInd = includeInd;
  }

  public String getName() {
    return "java:comp/env/event/LY99Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY99CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String[] getCompSysRef() {
    return compSysRef;
  }
  public String[] getIncludeInd() {
    return includeInd;
  }

  /*
    All the getters now follow- none are present
  */

}


