package com.xchanging.xcc.events;

/**
 * <p>Title: LY10Event</p>
 * <p>Description: LY10 Event Handler - Update Session Record</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria UK</p>
 * @author Brian Ambrose
 * @version 1.0
 */

  public class LY10Event extends ClaimsEvent implements java.io.Serializable {

    private int userSession;

    private String UCR_TR_SYSREF ;
    private String CURR_NO ;
    private String SDN_NO ;
    private String STAT_SPLIT_NO ;
    private String BREAKDOWN_NO     ;
    private String RETURN_SCREEN ;

    public LY10Event(
        String UCR_TR_SYSREF,
        String CURR_NO,
        String SDN_NO,
        String STAT_SPLIT_NO,
        String BREAKDOWN_NO,
        String RETURN_SCREEN
      )
    {
      this.UCR_TR_SYSREF = UCR_TR_SYSREF ;
      this.CURR_NO = CURR_NO ;
      this.SDN_NO = SDN_NO ;
      this.STAT_SPLIT_NO = STAT_SPLIT_NO ;
      this.BREAKDOWN_NO = BREAKDOWN_NO ;
      this.RETURN_SCREEN = RETURN_SCREEN ;
    }

    public String getUCR_TR_SYSREF () {
      return UCR_TR_SYSREF ;
    }

    public String getCURR_NO () {
      return CURR_NO ;
    }

    public String getSDN_NO () {
      return SDN_NO ;
    }
    public String getSTAT_SPLIT_NO () {
      return STAT_SPLIT_NO ;
    }
    public String getBREAKDOWN_NO () {
      return BREAKDOWN_NO ;
    }
    public String getRETURN_SCREEN () {
      return RETURN_SCREEN ;
    }

    public String getName() {
      return "java:comp/env/event/LY10Event";
    }

    public int getType() {
    return OTHER;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY10CICSHandler";
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

}
