package com.xchanging.xcc.events;

/**
 * <p>Title: LY76Event</p>
 * <p>Description: LY76 Event Handler - Add Claim to Non-Aggregate Group</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY76Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String groupRef;

  public LY76Event(String groupRef) {
    this.groupRef = groupRef;
  }

  public String getName() {
    return "java:comp/env/event/LY76Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY76CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getGroupRef() {
    return groupRef;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */
}