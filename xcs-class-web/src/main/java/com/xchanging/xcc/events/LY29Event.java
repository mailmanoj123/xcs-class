package com.xchanging.xcc.events;

public class LY29Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String PEER_REV_IND;
  private String CURRENT_BKR;
  private String RISK_CODE;

  // CCN # N0030 - BA - 7/1/2002
  private String MARKET_CODE ;

  private String YEAR_OF_ACC;
  private String INTEREST;
  private String[] LIMIT_CURR;
  private String[] SI_LIMIT;
  private String[] EXCESS_LIMIT;
  private String SI_NARR_1;
  private String SI_NARR_2;
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
  private String UMR;
  private String UMR_LIDS;
  private String SLIP_TYPE;

  public LY29Event(String PEER_REV_IND,
                   String CURRENT_BKR,
                   String RISK_CODE,
                   String MARKET_CODE,   /* CCN # N0030 - BA - 7/1/2002 */
                   String YEAR_OF_ACC,
                   String INTEREST,
                   String[] LIMIT_CURR,
                   String[] SI_LIMIT,
                   String[] EXCESS_LIMIT,
                   String SLIP_ORDER_1,
                   String SLIP_ORDER_2,
                   String PERILS_CONDS,
                   String LOCATION_VOYAGE,
                   String BASIS_OF_LIMIT,
                   String POL_CERT_FROM,
                   String POL_CERT_TO,
                   String POL_CERT_QUAL,
                   String COVER_LS_FROM,
                   String COVER_LS_TO,
                   String COVER_LS_QUAL,
                   String WAR_IND,
                   String SLIP_TYPE,
                   String UMR,
                   String UMR_LIDS) {

    this.PEER_REV_IND = PEER_REV_IND;
    this.CURRENT_BKR = CURRENT_BKR;
    this.RISK_CODE = RISK_CODE;

    // CCN # N0030 - BA - 7/1/2002
    this.MARKET_CODE = MARKET_CODE ;
    this.YEAR_OF_ACC = YEAR_OF_ACC;
    this.INTEREST = INTEREST;
    this.LIMIT_CURR = LIMIT_CURR;
    this.SI_LIMIT = SI_LIMIT;
    this.EXCESS_LIMIT = EXCESS_LIMIT;
    this.SLIP_ORDER_1 = SLIP_ORDER_1;
    this.SLIP_ORDER_2 = SLIP_ORDER_2;
    this.PERILS_CONDS = PERILS_CONDS;
    this.LOCATION_VOYAGE = LOCATION_VOYAGE;
    this.BASIS_OF_LIMIT = BASIS_OF_LIMIT;
    this.POL_CERT_FROM = POL_CERT_FROM;
    this.POL_CERT_TO = POL_CERT_TO;
    this.POL_CERT_QUAL = POL_CERT_QUAL;
    this.COVER_LS_FROM = COVER_LS_FROM;
    this.COVER_LS_TO = COVER_LS_TO;
    this.COVER_LS_QUAL = COVER_LS_QUAL;
    this.WAR_IND = WAR_IND;
    this.SLIP_TYPE = SLIP_TYPE;
    this.UMR = UMR;
    this.UMR_LIDS = UMR_LIDS;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY29Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY29CICSHandler";
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
    return CURRENT_BKR;
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

  // CCN # N0030 - BA - 7/1/2002
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
  public String getSI_NARR_2() {
    return SI_NARR_2;
  }
  public String getSLIP_ORDER_1() {
    return SLIP_ORDER_1;
  }
  public String getSLIP_ORDER_2() {
    return SLIP_ORDER_2;
  }
  public String getWAR_IND() {
    return WAR_IND;
  }
  public String getYEAR_OF_ACC() {
    return YEAR_OF_ACC;
  }
  public String getUMR() {
    return UMR;
  }
  public String getUMR_LIDS() {
    return UMR_LIDS;
  }

public String getSLIP_TYPE() {
        return SLIP_TYPE;
}
}