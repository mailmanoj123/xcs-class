package com.xchanging.xcc.events;

public class LZ01Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String osnd = "";
  private String apsnd = "";

  public LZ01Event(String osnd, String apsnd) {
    this.osnd = osnd;
    this.apsnd = apsnd;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LZ01Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ01CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getOsnd() {
    return osnd;
  }

  public String getApsnd() {
    return apsnd;
  }

}