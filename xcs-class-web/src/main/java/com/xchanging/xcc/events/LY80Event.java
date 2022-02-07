package com.xchanging.xcc.events;

public class LY80Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY80Event()  {
  }


  public String getName() {
    return "java:comp/env/event/LY80Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY80CICSHandler";
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