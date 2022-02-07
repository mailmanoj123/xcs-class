package com.xchanging.xcc.events;

public class LZ10Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LZ10Event() {
  }


  public String getName() {
    return "java:comp/env/event/LZ10Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ10CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
}