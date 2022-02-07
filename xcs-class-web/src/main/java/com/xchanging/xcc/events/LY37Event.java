package com.xchanging.xcc.events;

/**
 * <p>Title: LY37Event</p>
 * <p>Description: LY37 Event Handler - Build Financial Details</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY37Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY37Event() {
  }

  public String getName() {
    return "java:comp/env/event/LY37Event";
  }

  public int getType() {
    return BUILD;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY37CICSHandler";
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