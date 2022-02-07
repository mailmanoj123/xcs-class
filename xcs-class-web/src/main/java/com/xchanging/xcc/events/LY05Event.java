package com.xchanging.xcc.events;

public class LY05Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String osnd;
  private String apsnd;

  public LY05Event(String osnd, String apsnd) {
    this.osnd = osnd;
    this.apsnd = apsnd;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY05Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY05CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getOsnd() {
    if (osnd == null) {
      osnd = " ";
    }
    return osnd;
  }

  public String getApsnd() {
    if (apsnd == null) {
      apsnd = " ";
    }
    return apsnd;
  }
}