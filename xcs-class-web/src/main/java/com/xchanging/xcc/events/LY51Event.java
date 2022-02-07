package com.xchanging.xcc.events;

/**
 * <p>Title: LY51Event</p>
 * <p>Description: LY51 Event Handler - Create New Breakdown</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY51Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY51Event() {
  }

  public String getName() {
    return "java:comp/env/event/LY51Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY51CICSHandler";
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