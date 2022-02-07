package com.xchanging.xcc.events;


public class LoginEvent extends ClaimsEvent implements java.io.Serializable {

  private String account;
  private String username;
  private String password;
  private String section;

  public LoginEvent(String account, String username, String password, String section) {

    this.account = account;
    this.username = username;
    this.password = password;
    this.section = section;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public int getType() {
    return OTHER;
  }

  public String getAccount() {
    return account;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getSection() {
    return section;
  }

  public String getName() {
    return "java:comp/env/event/LoginEvent";
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LoginCICSHandler";
  }

  public int getUserSession() {return 0;}
  public void setUserSession(int userSession) {}

}