package com.xchanging.xcc.events;

public class LY58Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String[] COR;
  private String[] DELETE_IND;
  private String[] STAT_SPLIT_NO;
  private String[] BREAKDOWN_NO;
  private String[] MOVE_REF;
  private String[] NAME_1;
  private String[] NAME_1_QUAL;
  private String[] NAME_2;
  private String[] NAME_2_QUAL;
  private String[] FIL_CODE;
  private String[] TF_CODE;
  private String[] STATE_CODE;
  private String[] LOSS_DATE_FROM;
  private String[] LOSS_DATE_TO;
  private String[] LOSS_DATE_QUAL;
  private String[] CAT_CODE;
  private String[] PCS_CAT_CODE;
  private String[] NAIC_CODE;
  private String[] NAIC_QUAL;
  private String[] PTT_AMT;
  private String[] OS_AMT;


  public LY58Event(
      String[] COR,
      String[] DELETE_IND,
      String[] STAT_SPLIT_NO,
      String[] BREAKDOWN_NO,
      String[] MOVE_REF,
      String[] NAME_1,
      String[] NAME_1_QUAL,
      String[] NAME_2,
      String[] NAME_2_QUAL,
      String[] FIL_CODE,
      String[] TF_CODE,
      String[] STATE_CODE,
      String[] LOSS_DATE_FROM,
      String[] LOSS_DATE_TO,
      String[] LOSS_DATE_QUAL,
      String[] CAT_CODE,
      String[] PCS_CAT_CODE,
      String[] NAIC_CODE,
      String[] NAIC_QUAL,
      String[] OS_AMT,
      String[] PTT_AMT)
  {
    this.COR             = COR;
    this.DELETE_IND      = DELETE_IND;
    this.STAT_SPLIT_NO   = STAT_SPLIT_NO;
    this.BREAKDOWN_NO    = BREAKDOWN_NO;
    this.MOVE_REF        = MOVE_REF;
    this.NAME_1          = NAME_1;
    this.NAME_1_QUAL     = NAME_1_QUAL;
    this.NAME_2          = NAME_2;
    this.NAME_2_QUAL     = NAME_2_QUAL;
    this.FIL_CODE        = FIL_CODE;
    this.TF_CODE         = TF_CODE;
    this.STATE_CODE      = STATE_CODE;
    this.LOSS_DATE_FROM  = LOSS_DATE_FROM;
    this.LOSS_DATE_TO    = LOSS_DATE_TO;
    this.LOSS_DATE_QUAL  = LOSS_DATE_QUAL;
    this.CAT_CODE        = CAT_CODE;
    this.PCS_CAT_CODE    = PCS_CAT_CODE;
    this.NAIC_CODE       = NAIC_CODE;
    this.NAIC_QUAL       = NAIC_QUAL;
    this.PTT_AMT         = PTT_AMT;
    this.OS_AMT          = OS_AMT;
  }


  public String getName() {
    return "java:comp/env/event/LY58Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY58CICSHandler";
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

  public String[] getCOR () {
    return COR;
  }

  public String[] getDELETE_IND () {
    return DELETE_IND;
  }

  public String[] getSTAT_SPLIT_NO () {
    return STAT_SPLIT_NO;
  }

  public String[] getBREAKDOWN_NO () {
    return BREAKDOWN_NO;
  }

  public String[] getMOVE_REF () {
    return MOVE_REF;
  }

  public String[] getNAME_1 () {
    return NAME_1;
  }

  public String[] getNAME_1_QUAL () {
    return NAME_1_QUAL;
  }

  public String[] getNAME_2 () {
    return NAME_2;
  }

  public String[] getNAME_2_QUAL () {
    return NAME_2_QUAL;
  }

  public String[] getFIL_CODE () {
    return FIL_CODE;
  }

  public String[] getTF_CODE () {
    return TF_CODE;
  }
  public String[] getSTATE_CODE () {
    return STATE_CODE;
  }
  public String[] getLOSS_DATE_FROM () {
    return LOSS_DATE_FROM;
  }
  public String[] getLOSS_DATE_TO () {
    return LOSS_DATE_TO;
  }
  public String[] getLOSS_DATE_QUAL () {
    return LOSS_DATE_QUAL;
  }
  public String[] getCAT_CODE () {
    return CAT_CODE;
  }
  public String[] getPCS_CAT_CODE () {
    return PCS_CAT_CODE;
  }
  public String[] getNAIC_CODE () {
    return NAIC_CODE;
  }
  public String[] getNAIC_QUAL () {
    return NAIC_QUAL;
  }
  public String[] getOS_AMT() {
    return OS_AMT;
  }
  public String[] getPTT_AMT() {
    return PTT_AMT;
  }

}