package com.xchanging.xcc.events;

/**
 Commarea - C070 (LY70)
 Program  - Associated Screen/Process:- Build Movement History Screen
 Devo
 */

  public class LY70Event extends ClaimsEvent implements java.io.Serializable {

    private int userSession;

    private String NEXT_PRESSED;
    private String PREV_PRESSED;
    private String START_SYS_REF;
    private String START_CURR_NO;
    private String START_SDN_NO;
    private String START_SPLIT_NO;
    private String START_BDOWN_NO;

    public LY70Event(
        String NEXT_PRESSED,
        String PREV_PRESSED,
        String START_SYS_REF,
        String START_CURR_NO,
        String START_SDN_NO,
        String START_SPLIT_NO,
        String START_BDOWN_NO
      )
    {
      this.NEXT_PRESSED = NEXT_PRESSED;
      this.PREV_PRESSED = PREV_PRESSED;
      this.START_SYS_REF = START_SYS_REF;
      this.START_CURR_NO = START_CURR_NO;
      this.START_SDN_NO = START_SDN_NO;
      this.START_SPLIT_NO = START_SPLIT_NO;
      this.START_BDOWN_NO = START_BDOWN_NO;
    }

    public String getName() {
      return "java:comp/env/event/LY70Event";
    }

    public int getType() {
    return BUILD;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY70CICSHandler";
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

    public String getNEXT_PRESSED () {
      return NEXT_PRESSED;
    }

    public String getPREV_PRESSED () {
      return PREV_PRESSED;
    }

    public String getSTART_SYS_REF () {
      return START_SYS_REF;
    }

   public String getSTART_CURR_NO () {
     return START_CURR_NO;
    }

    public String getSTART_SDN_NO () {
     return START_SDN_NO;
    }

    public String getSTART_SPLIT_NO () {
     return START_SPLIT_NO;
    }

    public String getSTART_BDOWN_NO () {
     return START_BDOWN_NO;
    }
}
