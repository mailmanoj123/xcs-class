package com.xchanging.xcc.events;

/**
 * <p>Title: LY17Event</p>
 * <p>Description: LY17 Event Handler - Validate Claim Transaction</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY17Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public LY17Event() {
  }


  public String getName() {
    return "java:comp/env/event/LY17Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY17CICSHandler";
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