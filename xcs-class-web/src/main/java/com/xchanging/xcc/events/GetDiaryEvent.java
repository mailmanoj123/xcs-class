package com.xchanging.xcc.events;

public class GetDiaryEvent extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  public GetDiaryEvent() {
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/GetDiaryEvent";
  }

  public int getType() {
    return OTHER;
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.GetDiaryCICSHandler";
  }

}