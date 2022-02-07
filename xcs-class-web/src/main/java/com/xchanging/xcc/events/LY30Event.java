package com.xchanging.xcc.events;

public class LY30Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String XCR;
  private String UCR;
  private String TR;
  private String ORIG_REF_1;
  private String ORIG_REF_2;
  private String ORIG_REF_3;
  private String PEER_REV_IND;
  private String CURRENT_BKR;
  private String RISK_CODE;
  private String MARKET_CODE ;
  private String YEAR_OF_ACC;
  private String INTEREST;
  private String[] LIMIT_CURR;
  private String[] SI_LIMIT;
  private String[] EXCESS_LIMIT;
  private String SI_NARR_1;
  //private String SI_NARR_2;
  private String SLIP_ORDER_1;
  private String SLIP_ORDER_2;
  private String PERILS_CONDS;
  private String LOCATION_VOYAGE;
  private String BASIS_OF_LIMIT;
  private String POL_CERT_FROM;
  private String POL_CERT_TO;
  private String POL_CERT_QUAL;
  private String POL_PERIOD_NARR;
  private String COVER_LS_FROM;
  private String COVER_LS_TO;
  private String COVER_LS_QUAL;
  private String WAR_IND;
  private String SLIP_TYPE;
  private String UMR;

  public LY30Event(String XCR,
                   String UCR,
                   String TR,
                   String ORIG_REF_1,
                   String ORIG_REF_2,
                   String ORIG_REF_3,
                   String PEER_REV_IND,
                   String CURRENT_BKR,
                   String RISK_CODE,
                   String MARKET_CODE, /* CCN # N0030 - BA - 7/1/2002 */
                   String YEAR_OF_ACC,
                   String INTEREST,
                   String[] LIMIT_CURR,
                   String[] SI_LIMIT,
                   String[] EXCESS_LIMIT,
                   String SI_NARR_1,

              /*  CCN: N0047
                  Changed on: 11/12/02 (DH)
                  String SI_NARR_2,
               */
                   String SLIP_ORDER_1,
                   String SLIP_ORDER_2,
                   String PERILS_CONDS,
                   String LOCATION_VOYAGE,
                   String BASIS_OF_LIMIT,
                   String POL_CERT_FROM,
                   String POL_CERT_TO,
                   String POL_CERT_QUAL,
                   String POL_PERIOD_NARR,
                   String COVER_LS_FROM,
                   String COVER_LS_TO,
                   String COVER_LS_QUAL,
                   String WAR_IND,
                   String SLIP_TYPE,
                   String UMR /* CCN # N0039 - BA - 7/1/2002 */) {

    this.XCR = XCR;
    this.UCR = UCR;
    this.TR = TR;
    this.ORIG_REF_1 = ORIG_REF_1;
    this.ORIG_REF_2 = ORIG_REF_2;
    this.ORIG_REF_3 = ORIG_REF_3;
    this.PEER_REV_IND = PEER_REV_IND;
    this.CURRENT_BKR = CURRENT_BKR;
    this.RISK_CODE = RISK_CODE;
    /* CCN # N0030 - BA - 7/1/2002 */
    this.MARKET_CODE = MARKET_CODE;
    this.YEAR_OF_ACC = YEAR_OF_ACC;
    this.INTEREST = INTEREST;
    this.LIMIT_CURR = LIMIT_CURR;
    this.SI_LIMIT = SI_LIMIT;
    this.EXCESS_LIMIT = EXCESS_LIMIT;
    this.SI_NARR_1 = SI_NARR_1;
   // this.SI_NARR_2 = SI_NARR_2;
    this.SLIP_ORDER_1 = SLIP_ORDER_1;
    this.SLIP_ORDER_2 = SLIP_ORDER_2;
    this.PERILS_CONDS = PERILS_CONDS;
    this.LOCATION_VOYAGE = LOCATION_VOYAGE;
    this.BASIS_OF_LIMIT = BASIS_OF_LIMIT;
    this.POL_CERT_FROM = POL_CERT_FROM;
    this.POL_CERT_TO = POL_CERT_TO;
    this.POL_CERT_QUAL = POL_CERT_QUAL;
    this.POL_PERIOD_NARR = POL_PERIOD_NARR;
    this.COVER_LS_FROM = COVER_LS_FROM;
    this.COVER_LS_TO = COVER_LS_TO;
    this.COVER_LS_QUAL = COVER_LS_QUAL;
    this.WAR_IND = WAR_IND;
    this.SLIP_TYPE = SLIP_TYPE;
    /* CCN # N0039 - BA - 7/1/2002 */
    this.UMR = UMR;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY30Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY30CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String getBASIS_OF_LIMIT() {
    if (BASIS_OF_LIMIT==null)
      return "";
    else
      return BASIS_OF_LIMIT;
  }
  public String getCOVER_LS_FROM() {
    return COVER_LS_FROM;
  }
  public String getCOVER_LS_QUAL() {
    if (COVER_LS_QUAL==null)
      return "";
    else
      return COVER_LS_QUAL;
  }
  public String getCOVER_LS_TO() {
    return COVER_LS_TO;
  }
  public String[] getEXCESS_LIMIT() {
    return EXCESS_LIMIT;
  }
  public String getINTEREST() {
    return INTEREST;
  }
  public String[] getLIMIT_CURR() {
    for (int i=0; i<LIMIT_CURR.length; i++) {
      if (LIMIT_CURR[i]==null)
        LIMIT_CURR[i]="";
    }
    return LIMIT_CURR;
  }
  public String getLOCATION_VOYAGE() {
    return LOCATION_VOYAGE;
  }
  public String getCURRENT_BKR() {
    if (CURRENT_BKR==null)
      return "";
    else
      return CURRENT_BKR;
  }
  public String getORIG_REF_1() {
    return ORIG_REF_1;
  }
  public String getORIG_REF_2() {
    return ORIG_REF_2;
  }
  public String getORIG_REF_3() {
    return ORIG_REF_3;
  }
  public String getPEER_REV_IND() {
    if (PEER_REV_IND==null)
      return "";
    else
      return PEER_REV_IND;
  }
  public String getPERILS_CONDS() {
    return PERILS_CONDS;
  }
  public String getPOL_CERT_FROM() {
    return POL_CERT_FROM;
  }
  public String getPOL_CERT_QUAL() {
    if (POL_CERT_QUAL==null)
      return "";
    else
      return POL_CERT_QUAL;
  }
  public String getPOL_CERT_TO() {
    return POL_CERT_TO;
  }
  public String getPOL_PERIOD_NARR() {
    return POL_PERIOD_NARR;
  }
  public String getRISK_CODE() {
    return RISK_CODE;
  }
  /* CCN # N0030 - BA - 7/1/2002 */
  public String getMARKET_CODE() {
    if (MARKET_CODE==null)
      return "";
    else
      return MARKET_CODE;
  }
  public String[] getSI_LIMIT() {
    return SI_LIMIT;
  }
  public String getSI_NARR_1() {
    return SI_NARR_1;
  }
  public String getSLIP_ORDER_1() {
    return SLIP_ORDER_1;
  }
  public String getSLIP_ORDER_2() {
    return SLIP_ORDER_2;
  }
  public String getTR() {
    return TR;
  }
  public String getUCR() {
    return UCR;
  }
  public String getWAR_IND() {
    return WAR_IND;
  }
  /* CCN # N0030 - BA - 7/1/2002 */
  public String getUMR() {
    return UMR ;
  }
  public String getXCR() {
    return XCR;
  }
  public String getYEAR_OF_ACC() {
    return YEAR_OF_ACC;
  }

public String getSLIP_TYPE() {
        return SLIP_TYPE;
}
}