package com.xchanging.xcc.events;

/**
 * <p>Title: LY16Event</p>
 * <p>Description: LY16 Event Handler - Check Transaction Status</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY16Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String currentScreen;

  public LY16Event(String currentScreen) {
    this.currentScreen = currentScreen;
  }


  public String getName() {
    return "java:comp/env/event/LY16Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY16CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getCurrentScreen() {
    return currentScreen;
  }


  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */
}