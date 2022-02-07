package com.xchanging.xcc.events;

public class LY86Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String diaryDate;

  public LY86Event(String diaryDate)
  {
    this.diaryDate = diaryDate;
  }


  public String getName() {
    return "java:comp/env/event/LY86Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY86CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getDiaryDate() {
    return diaryDate;
  }


  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */


}