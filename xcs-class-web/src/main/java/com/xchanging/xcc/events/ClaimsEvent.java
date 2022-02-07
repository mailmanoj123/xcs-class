package com.xchanging.xcc.events;

import javax.servlet.http.HttpSession;

public abstract class ClaimsEvent  {

  public static final int OTHER = 0;
  public static final int BUILD = 1;
  public static final int VALIDATE = 2;
  public static final int UPDATE = 3;

  private HttpSession httpSession;
  private boolean ignoreWarnings;

  public abstract String getName();
  public abstract void setUserSession(int userSession);
  public abstract int getUserSession();
  public abstract String getHandlerName();
  public abstract int getType();

  public boolean isOracleEvent() {
    return false;
  }

  public void setHttpSession(HttpSession httpSession) {
    this.httpSession = httpSession;
  }

  public void setIgnoreWarnings(boolean b) {
    ignoreWarnings = b;
  }

  public boolean ignoreWarnings() {
    return ignoreWarnings;
  }

  public HttpSession getHttpSession() {
    return httpSession;
  }

  public void update() {

  }

}
