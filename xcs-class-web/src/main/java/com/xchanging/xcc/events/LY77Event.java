package com.xchanging.xcc.events;

public class LY77Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY77Event()  {
  }


  public String getName() {
    return "java:comp/env/event/LY77Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY77CICSHandler";
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