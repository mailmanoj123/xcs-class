package com.xchanging.xcc.events;

public class ChangePasswordEvent extends ClaimsEvent implements java.io.Serializable {

  private String newPassword;
  private int userSession;

  public ChangePasswordEvent(String newPassword) {
    this.newPassword = newPassword;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getNewPassword() {
    return newPassword;
  }

  public String getName() {
    return "java:comp/env/event/ChangePasswordEvent";
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
    return "com.xchanging.xcc.cics.handlers.ChangePasswordCICSHandler";
  }

}