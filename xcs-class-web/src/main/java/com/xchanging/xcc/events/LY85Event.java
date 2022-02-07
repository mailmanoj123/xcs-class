package com.xchanging.xcc.events;

public class LY85Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY85Event()
  {
  }


  public String getName() {
    return "java:comp/env/event/LY85Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY85CICSHandler";
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
}