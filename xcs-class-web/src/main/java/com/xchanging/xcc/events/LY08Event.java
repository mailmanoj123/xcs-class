package com.xchanging.xcc.events;

/**
 Commarea - C008 (LY08)
 Program  - Associated Screen/Process:- Group Claim Search
 Devo
 */


public class LY08Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String SEARCH_GRP_REF;
  private String SEARCH_BKR_UCR;
  private String FIRST_SYS_REF;
  private String FIRST_CURR_NO;
  private String FIRST_SDN_NO;
  private String FIRST_SPLIT_NO;
  private String FIRST_BDOWN_NO;
  private String LAST_SYS_REF;
  private String LAST_CURR_NO;
  private String LAST_SDN_NO;
  private String LAST_SPLIT_NO;
  private String LAST_BDOWN_NO;


  // Empty constructor....
  public LY08Event(String SEARCH_GRP_REF,
                   String SEARCH_BKR_UCR,
                   String FIRST_SYS_REF,
                   String FIRST_CURR_NO,
                   String FIRST_SDN_NO,
                   String FIRST_SPLIT_NO,
                   String FIRST_BDOWN_NO,
                   String LAST_SYS_REF,
                   String LAST_CURR_NO,
                   String LAST_SDN_NO,
                   String LAST_SPLIT_NO,
                   String LAST_BDOWN_NO) {

    this.SEARCH_GRP_REF = SEARCH_GRP_REF;
    this.SEARCH_BKR_UCR = SEARCH_BKR_UCR;
    this.FIRST_SYS_REF = FIRST_SYS_REF;
    this.FIRST_CURR_NO = FIRST_CURR_NO;
    this.FIRST_SDN_NO = FIRST_SDN_NO;
    this.FIRST_SPLIT_NO = FIRST_SPLIT_NO;
    this.FIRST_BDOWN_NO = FIRST_BDOWN_NO;
    this.LAST_SYS_REF = LAST_SYS_REF;
    this.LAST_CURR_NO = LAST_CURR_NO;
    this.LAST_SDN_NO = LAST_SDN_NO;
    this.LAST_SPLIT_NO = LAST_SPLIT_NO;
    this.LAST_BDOWN_NO = LAST_BDOWN_NO;
  }
  public String getName() {
    return "java:comp/env/event/LY08Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY08CICSHandler";
  }


  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getSEARCH_BKR_UCR() {
    return SEARCH_BKR_UCR;
  }
  public String getSEARCH_GRP_REF() {
    return SEARCH_GRP_REF;
  }
  public String getFIRST_BDOWN_NO() {
    return FIRST_BDOWN_NO;
  }
  public String getFIRST_SDN_NO() {
    return FIRST_SDN_NO;
  }
  public String getFIRST_CURR_NO() {
    return FIRST_CURR_NO;
  }
  public String getFIRST_SPLIT_NO() {
    return FIRST_SPLIT_NO;
  }
  public String getFIRST_SYS_REF() {
    return FIRST_SYS_REF;
  }
  public String getLAST_BDOWN_NO() {
    return LAST_BDOWN_NO;
  }
  public String getLAST_CURR_NO() {
    return LAST_CURR_NO;
  }
  public String getLAST_SDN_NO() {
    return LAST_SDN_NO;
  }
  public String getLAST_SPLIT_NO() {
    return LAST_SPLIT_NO;
  }
  public String getLAST_SYS_REF() {
    return LAST_SYS_REF;
  }

  /*
    All the getters now follow- none are present
  */


}


