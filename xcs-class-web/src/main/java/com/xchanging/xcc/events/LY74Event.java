package com.xchanging.xcc.events;

/**
 Commarea - C074 (LY74)
 Program  - Associated Screen/Process:- Update Group Details (Maintain Group Screen)
 Devo
 */

public class LY74Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String GROUP_REF;
  private String[] UCR_OSND;
  private String[] DELETE_IND;

  public LY74Event(
      String GROUP_REF,
      String[] UCR_OSND,
      String[] DELETE_IND)
  {
    this.GROUP_REF = GROUP_REF;
    this.UCR_OSND = UCR_OSND;
    this.DELETE_IND = DELETE_IND;
  }


  public String getName() {
    return "java:comp/env/event/LY74Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY74CICSHandler";
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

  public String getGROUP_REF() {
    return GROUP_REF;
  }

  public String[] getUCR_OSND () {
    return UCR_OSND;
  }

  public String[] getDELETE_IND () {
    return DELETE_IND;
  }


}