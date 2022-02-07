package com.xchanging.xcc.events;

/**
 * <p>Title: LY72Event</p>
 * <p>Description: LY72 Event Handler - Obtain Group Contents</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

public class LY72Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String GROUP_REF;
  private boolean ignoreErrors;

  public LY72Event(
      String GROUP_REF,
      boolean ignoreErrors
  ) {
    this.GROUP_REF = GROUP_REF;
    this.ignoreErrors = ignoreErrors;
  }

  public String getName() {
    return "java:comp/env/event/LY72Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY72CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getGROUP_REF() {
    return GROUP_REF;
  }

  public boolean ignoreErrors() {
    return ignoreErrors;
  }
}