package com.xchanging.xcc.events;

/**
 Commarea - C065 (LY65)
 Program  - Associated Screen/Process:- Validate Bulk Components
 Devo
 */


public class LY65Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private boolean ignoreErrors;
  private String ucrTrSysRef;
  private String currNo;
  private String sdnNo;
  private String statSplitNo;
  private String breakdownNo;
  private String currentScreen;
  private String screenId;
  private String processInd;

  // Empty constructor....
  public LY65Event(boolean ignoreErrors, String ucrTrSysRef, String currNo, String sdnNo, String statSplitNo, String breakdownNo, String currentScreen, String screenId, String processInd)
  {
    this.ignoreErrors = ignoreErrors;
    this.ucrTrSysRef = ucrTrSysRef;
    this.currNo = currNo;
    this.sdnNo = sdnNo;
    this.statSplitNo = statSplitNo;
    this.breakdownNo = breakdownNo;
    this.currentScreen = currentScreen;
    this.screenId = screenId;
    this.processInd = processInd;
  }

  public String getName() {
    return "java:comp/env/event/LY65Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY65CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public boolean ignoreErrors() {
    return ignoreErrors;
  }
  public String getBreakdownNo() {
    return breakdownNo;
  }
  public String getCurrentScreen() {
    return currentScreen;
  }
  public String getCurrNo() {
    return currNo;
  }
  public String getScreenId() {
    return screenId;
  }
  public String getSdnNo() {
    return sdnNo;
  }
  public String getStatSplitNo() {
    return statSplitNo;
  }
  public String getUcrTrSysRef() {
    return ucrTrSysRef;
  }
  public String getProcessInd() {
    return processInd;
  }
}


