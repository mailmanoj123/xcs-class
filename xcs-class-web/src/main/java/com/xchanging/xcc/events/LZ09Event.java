package com.xchanging.xcc.events;

public class LZ09Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String compSysRef;

  public LZ09Event(String compSysRef)
  {
    this.compSysRef = compSysRef;
  }

  public String getName() {
    return "java:comp/env/event/LZ09Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ09CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getCompSysRef() {
    return compSysRef;
  }
}


