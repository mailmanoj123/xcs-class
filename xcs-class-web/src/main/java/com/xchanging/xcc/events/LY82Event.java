package com.xchanging.xcc.events;

import java.util.Enumeration;

public class LY82Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private Enumeration ccys;
  private String holdReleaseCode;

  public LY82Event(String holdReleaseCode, Enumeration ccys) {
    this.holdReleaseCode = holdReleaseCode;
    this.ccys = ccys;
  }


  public String getName() {
    return "java:comp/env/event/LY82Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY82CICSHandler";
  }


  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public Enumeration getCcys() {
    return ccys;
  }
  public String getHoldReleaseCode() {
    return holdReleaseCode;
  }
}