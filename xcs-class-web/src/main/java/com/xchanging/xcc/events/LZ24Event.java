package com.xchanging.xcc.events;

public class LZ24Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LZ24Event()
  {
  }


  public String getName() {
    return "java:comp/env/event/LZ24Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ24CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
}