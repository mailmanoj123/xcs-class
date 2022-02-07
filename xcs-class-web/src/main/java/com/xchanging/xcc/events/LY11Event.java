package com.xchanging.xcc.events;

public class LY11Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String prevProg;
  private String scmAdvCode;
  private String exitInd;

  public LY11Event(
      String prevProg,
      String scmAdvCode,
      String exitInd)
  {
    this.prevProg = prevProg;
    this.scmAdvCode = scmAdvCode;
    this.exitInd = exitInd;

  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */


  public String getPrevProg() {
    return prevProg;
  }

  public String getScmAdvCode() {
    return scmAdvCode;
  }

  public String getExitInd() {
    return exitInd;
  }

  public String getName() {
    return "java:comp/env/event/LY11Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY11CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

}