package com.xchanging.xcc.events;

public class LY41Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String XCR;
  private String UCR;
  private String TR;
  private String ORIG_REF;
  private String ORIG_BKR;
  private String SIGNED_IND;
  private String PEER_REV_IND;
  private String ORIG_CURR;
  private String COR;
  private String LOC_IND;
  private String MOVE_REF;
  private String LR_ADJ_DATE;
  private String LR_REFUNDED;
  private String LR_PAID_CLAIM;
  private String LR_ADVANCED;
  private String LR_INTEREST;
  private String LR_TAX;
  private String LR_NET_AMT;
  private String LR_OUTST_AMT;
  private String LR_OUTST_QUAL;

  public LY41Event(
      String XCR,
      String UCR,
      String TR,
      String ORIG_REF,
      String ORIG_BKR,
      String SIGNED_IND,
      String PEER_REV_IND,
      String ORIG_CURR,
      String COR,
      String LOC_IND,
      String MOVE_REF,
      String LR_ADJ_DATE,
      String LR_REFUNDED,
      String LR_PAID_CLAIM,
      String LR_ADVANCED,
      String LR_INTEREST,
      String LR_TAX,
      String LR_NET_AMT,
      String LR_OUTST_AMT,
      String LR_OUTST_QUAL)
  {
    this.XCR = XCR;
    this.UCR = UCR;
    this.TR = TR;
    this.ORIG_REF = ORIG_REF;
    this.ORIG_BKR = ORIG_BKR;
    this.SIGNED_IND = SIGNED_IND;
    this.PEER_REV_IND = PEER_REV_IND;
    this.ORIG_CURR = ORIG_CURR;
    this.COR = COR;
    this.LOC_IND = LOC_IND;
    this.MOVE_REF = MOVE_REF;
    this.LR_ADJ_DATE = LR_ADJ_DATE;
    this.LR_REFUNDED = LR_REFUNDED;
    this.LR_PAID_CLAIM = LR_PAID_CLAIM;
    this.LR_ADVANCED = LR_ADVANCED;
    this.LR_INTEREST = LR_INTEREST;
    this.LR_TAX = LR_TAX;
    this.LR_NET_AMT = LR_NET_AMT;
    this.LR_OUTST_AMT = LR_OUTST_AMT;
    this.LR_OUTST_QUAL = LR_OUTST_QUAL;
  }


  public String getName() {
    return "java:comp/env/event/LY41Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY41CICSHandler";
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

  public String getXCR () {
    return XCR;
  }

  public String getUCR () {
    return UCR;
  }

  public String getTR () {
    return TR;
  }

  public String getORIG_REF () {
    return ORIG_REF;
  }

  public String getORIG_BKR () {
    return ORIG_BKR;
  }

  public String getSIGNED_IND () {
    return SIGNED_IND;
  }

  public String getPEER_REV_IND () {
    return PEER_REV_IND;
  }

  public String getORIG_CURR () {
    return ORIG_CURR;
  }

  public String getCOR () {
    return COR;
  }
  public String getLOC_IND () {
    return LOC_IND;
  }
  public String getMOVE_REF () {
    return MOVE_REF;
  }
  public String getLR_ADJ_DATE () {
    return LR_ADJ_DATE;
  }
  public String getLR_REFUNDED () {
    return LR_REFUNDED;
  }
  public String getLR_PAID_CLAIM () {
    return LR_PAID_CLAIM;
  }
  public String getLR_ADVANCED () {
    return LR_ADVANCED;
  }
  public String getLR_INTEREST () {
    return LR_INTEREST;
  }
  public String getLR_TAX () {
    return LR_TAX;
  }
  public String getLR_NET_AMT () {
    return LR_NET_AMT;
  }
  public String getLR_OUTST_AMT () {
    return LR_OUTST_AMT;
  }
  public String getLR_OUTST_QUAL () {
    return LR_OUTST_QUAL;
  }

}