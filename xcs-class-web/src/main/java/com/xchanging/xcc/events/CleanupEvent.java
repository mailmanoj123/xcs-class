package com.xchanging.xcc.events;

public class CleanupEvent  extends ClaimsEvent implements java.io.Serializable {

  public CleanupEvent() {
  }

  public int getUserSession() {
    return 1;
  }

  public void setUserSession(int x) {

  }

  public String getName() {
    return "";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "";
  }

}