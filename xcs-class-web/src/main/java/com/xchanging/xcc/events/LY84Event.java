package com.xchanging.xcc.events;

public class LY84Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String ucr;
  private String tr;

  public LY84Event(String ucr, String tr)
  {
    this.ucr = ucr;
    this.tr = tr;
  }


  public String getName() {
    return "java:comp/env/event/LY84Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY84CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getTr() {
    return tr;
  }
  public String getUcr() {
    return ucr;
  }


  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */
}