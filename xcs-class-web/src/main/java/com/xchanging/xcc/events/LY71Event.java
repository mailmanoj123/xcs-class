package com.xchanging.xcc.events;

/**
 * <p>Title: LY71Event</p>
 * <p>Description: LY71 Event Handler - Set up Grouping Session Record</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY71Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String GROUP_SCREEN;

  public LY71Event(
      String GROUP_SCREEN)
  {
    this.GROUP_SCREEN = GROUP_SCREEN ;
  }


  public String getName() {
    return "java:comp/env/event/";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY71CICSHandler";
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

  public String getGROUP_SCREEN() {
    return GROUP_SCREEN;
  }
}