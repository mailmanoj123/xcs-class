package com.xchanging.xcc.events;

/**
 Commarea - C064 (LY64)
 Program  - Associated Screen/Process:- Build Bulk Component Selection Screen
 Devo
 */

  public class LY64Event extends ClaimsEvent implements java.io.Serializable {

    private int userSession;

    private String PREV_PRESSED;
    private String NEXT_PRESSED;
    private String START_UCR;
    private String START_SYS_REF;


    public LY64Event(
        String PREV_PRESSED,
        String NEXT_PRESSED,
        String START_UCR,
        String START_SYS_REF
      )
    {
      this.PREV_PRESSED = PREV_PRESSED;
      this.NEXT_PRESSED = NEXT_PRESSED;
      this.START_UCR = START_UCR;
      this.START_SYS_REF = START_SYS_REF;
    }

    public String getName() {
      return "java:comp/env/event/LY64Event";
    }

    public int getType() {
    return BUILD;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY64CICSHandler";
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

    public String getPREV_PRESSED () {
      return PREV_PRESSED;
    }

    public String getNEXT_PRESSED () {
      return NEXT_PRESSED;
    }

    public String getSTART_UCR () {
      return START_UCR;
    }

   public String getSTART_SYS_REF () {
     return START_SYS_REF;
    }
}
