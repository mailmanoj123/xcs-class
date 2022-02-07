package com.xchanging.xcc.events;

/**
 * <p>Title: LY24Event</p>
 * <p>Description: LY24 Event Handler - Copy Facility Initial Validation</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY24Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY24Event() {
  }

  public String getName() {
    return "java:comp/env/event/LY24Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY24CICSHandler";
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