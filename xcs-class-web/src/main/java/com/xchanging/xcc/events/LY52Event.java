package com.xchanging.xcc.events;

/**
 * <p>Title: LY52Event</p>
 * <p>Description: LY52 Event Handler - Check for More Currencies</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY52Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY52Event() {
  }

  public String getName() {
    return "java:comp/env/event/LY52Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY52CICSHandler";
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