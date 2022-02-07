package com.xchanging.xcc.events;

/**
 Commarea - C046 (LY46)
 Program - Associated Screen/Process:- Check whether Currency/Transaction
                                        Validation Required
 Devo
 */


public class LY46Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String NEW_UCR_TR_SYS_REF;
  private String NEW_CURR_NO;
  private String NEW_SDN_NO;
  private String NEW_STAT_SPLIT_NO;
  private String NEW_BREAKDOWN_NO;
  private String NEXT_PROGRAM;

  public LY46Event(
      String NEW_UCR_TR_SYS_REF,
      String NEW_CURR_NO,
      String NEW_SDN_NO,
      String NEW_STAT_SPLIT_NO,
      String NEW_BREAKDOWN_NO,
      String NEXT_PROGRAM)
  {
    this.NEW_UCR_TR_SYS_REF = NEW_UCR_TR_SYS_REF;
    this.NEW_CURR_NO = NEW_CURR_NO;
    this.NEW_SDN_NO = NEW_SDN_NO;
    this.NEW_STAT_SPLIT_NO = NEW_STAT_SPLIT_NO;
    this.NEW_BREAKDOWN_NO = NEW_BREAKDOWN_NO;
    this.NEXT_PROGRAM = NEXT_PROGRAM;
  }


  public String getName() {
    return "java:comp/env/event/LY46Event";
  }

  // S253 - Broker Ref CCN
  public int getType() {
    // return VALIDATE;
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY46CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  /*
    All the getters now follow
  */

  public String getNEW_UCR_TR_SYS_REF() {
    return NEW_UCR_TR_SYS_REF;
  }

  public String getNEW_CURR_NO() {
      return NEW_CURR_NO;
  }

  public String getNEW_SDN_NO() {
      return NEW_SDN_NO;
  }

  public String getNEW_STAT_SPLIT_NO() {
      return NEW_STAT_SPLIT_NO;
  }
  public String getNEW_BREAKDOWN_NO() {
      return NEW_BREAKDOWN_NO;
  }

  public String getNEXT_PROGRAM() {
      return NEXT_PROGRAM;
  }

}


