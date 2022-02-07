package com.xchanging.xcc.events;

/**
 Commarea - C075 (LY75)
 Program  - Associated Screen/Process:- Build Group Enquiry Screen
 Devo
 */

  public class LY75Event extends ClaimsEvent implements java.io.Serializable {

    private int userSession;

    private String GROUP_REF;

    public LY75Event(
                     String GROUP_REF)
    {
      this.GROUP_REF = GROUP_REF;
    }

    public String getName() {
      return "java:comp/env/event/LY75Event";
    }

    public int getType() {
    return BUILD;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY75CICSHandler";
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

    public String getGROUP_REF () {
      return GROUP_REF;
    }

}
