package com.xchanging.xcc.events;

/**
 * <p>Title: LY20Event</p>
 * <p>Description: LY20 Event Handler - Create Subsequent Advice</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY20Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String transType;

  public LY20Event(String transType) {
    this.transType = transType;
  }

  public String getName() {
    return "java:comp/env/event/LY20Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY20CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getTransType() {
    return transType;
  }


  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */
}