package com.xchanging.xcc.events;

public class LY94Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String[] osnd;
  private String[] apsnd;
  private String[] currencies;
  private String settAdv;
  private String nonScmAdvised;
  private String bulkInd;
  private String riskUnsigned;
  private String treaty;
  private String ecfClaim;
  private String ecfClass;
  private String simRi;
  private String lossReserve;
  private String loc;
  private String lossFund;
  private String payByCheque;
  private String chargeType;
  private String noChargeableInd;
  private String prevAdvNoNet;
  private String prevPaidInd;
  private String schemeCanInd;
  private String cpaInd;
  private String dirLStockInd;
  private String origCcys[];
  private String locDrawingInd;
  private String presDate;
  private String slipType;
  private String riskCode;

  public LY94Event(String[] osnd,
                   String[] apsnd,
                   String[] curr,
                   String riskCode,
                   String settAdv,
                   String nonScmAdvised,
                   String bulkInd,
                   String riskUnsigned,
                   String treaty,
                   String ecfClaim,
                   String ecfClass,
                   String simRi,
                   String lossReserve,
                   String loc,
                   String lossFund,
                   String payByCheque,
                   String chargeType,
                   String noChargeableInd,
                   String prevAdvNoNet,
                   String prevPaidInd,
                   String locDrawingInd,
                   String presDate,
                   String slipType,
                   String schemeCanInd,
                   String cpaInd,
                   String dirLStockInd,
                   String[] origCcys) {


    this.osnd            = osnd;
    this.apsnd           = apsnd;
    this.currencies      = curr;
    this.riskCode        = riskCode;
    this.settAdv         = settAdv;
    this.nonScmAdvised   = nonScmAdvised;
    this.bulkInd         = bulkInd;
    this.riskUnsigned    = riskUnsigned;
    this.treaty          = treaty;
	this.ecfClaim        = ecfClaim;
        this.ecfClass        = ecfClass;
    this.simRi           = simRi;
    this.lossReserve     = lossReserve;
    this.loc             = loc;
    this.lossFund        = lossFund;
    this.payByCheque     = payByCheque;
    this.chargeType      = chargeType;
    this.noChargeableInd = noChargeableInd;
    this.prevAdvNoNet    = prevAdvNoNet;
    this.prevPaidInd     = prevPaidInd;
    this.presDate        = presDate;

    // CCN# N0058 - BA - 09/01/2003
    this.locDrawingInd = locDrawingInd ;

    this.slipType        = slipType;

    this.schemeCanInd = schemeCanInd;
    this.cpaInd = cpaInd;
    this.dirLStockInd = dirLStockInd;
    this.origCcys = origCcys;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY94Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY94CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String[] getOsnd() {
    return osnd;
  }

  public String[] getApsnd() {
    return apsnd;
  }
  public String getBulkInd() {
    return bulkInd;
  }
  public String getChargeType() {
    return chargeType;
  }
  public String getCpaInd() {
    return cpaInd;
  }
  public String[] getCurrencies() {
    return currencies;
  }
  public String getDirLStockInd() {
    return dirLStockInd;
  }
  public String getLoc() {
    return loc;
  }
  public String getLossFund() {
    return lossFund;
  }
  public String getLocDrawingInd() {
    return locDrawingInd;
  }
  public String getLossReserve() {
    return lossReserve;
  }
  public String getNoChargeableInd() {
    return noChargeableInd;
  }
  public String getNonScmAdvised() {
    return nonScmAdvised;
  }
  public String[] getOrigCcys() {
    return origCcys;
  }
  public String getPayByCheque() {
    return payByCheque;
  }
  public String getPresDate() {
    return presDate;
  }
  public String getPrevAdvNoNet() {
    return prevAdvNoNet;
  }
  public String getPrevPaidInd() {
    return prevPaidInd;
  }
  public String getRiskCode() {
    return riskCode;
  }
  public String getRiskUnsigned() {
    return riskUnsigned;
  }
  public String getSchemeCanInd() {
    return schemeCanInd;
  }
  public String getSettAdv() {
    return settAdv;
  }
  public String getSimRi() {
    return simRi;
  }
  public String getSlipType() {
    return slipType;
  }
  public String getTreaty() {
    return treaty;
  }
  public String getEcfClaim() {
    return ecfClaim;
  }


public String getEcfClass()
{
    return ecfClass;
}
}