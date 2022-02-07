package com.xchanging.xcc.events;

public class LY27Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String[] osnd;
  private String[] apsnd;
  private String[] currency;
  private String versionNo;
  private String settAdv;
  private String nonScmAdvised;
  private String bulkInd;
  private String riskUnsigned;
  private String treaty;
  private String ecfClaim;
  private String ecfClass;
  private String lossReserve;
  private String loc;
  private String lossFund;
  private String payByCheque;
  private String chargeType;
  private String nonChargeableInd;
  private String prevAdvNonNet;
  private String prevPaidInd;

  // CCN# N0058 - BA - 09/01/2003
  private String locDrawingInd ;

  // CCN# ????? - S.Caine - 03/12/2003
  private String SpecPymtInd;

  // CCN 21 - devo 15/01/2003 - all other references to scheme Canada Ind (etc) are part of this ccn.
  private String schemeCanInd;
  private String cpaInd;
  private String dirLStockInd;
  private String simRi;


  private String presDate;
  private String riskCode;
  private String yearOfAcc;
  private String umr;
  private String slipOrder1;
  private String slipOrder2;
  private String lineSlipCh;
  private String insured;
  private String reinsured;
  private String vesselAircraft;
  private String interest;
  private String siLimit;
  private String excessLimit;
  private String siCurr;
  private String perilsConds;
  private String policyPeriodFrom;
  private String policyPeriodTo;
  private String noOfSyndicates;
  private String totalLine;
  private String[] lidsSyndicateNo;
  private String[] lidsSyndicateLine;
  private String[] lidsSyndicateRef;
  private String lidsOrigBkr;
  private String lidsOrigCurr;
  private String lidsSettCurr;
  private String lidsFilCode1;
  private String lidsFilCode2;
  private String lidsTfCode;
  private String lidsStateCode;
  private String lidsNaicCode;
  private String lidsNaicQual;
  private String lidsNonUsTfCode;
  private String lidsCountryCode;
  private String lidsWarInd;
  private String lidsDtiCode;
  /* Release 3a enhancements */
  private String slipType;

  public LY27Event(
      String[] osnd,
      String[] apsnd,
      String[] currency,
      String versionNo,
      String settAdv,
      String nonScmAdvised,
      String bulkInd,
      String riskUnsigned,
      String treaty,
      String ecfClaim,
      String ecfClass,
      String lossReserve,
      String loc,
      String lossFund,
      String payByCheque,
      String chargeType,
      String nonChargeableInd,
      String prevAdvNonNet,
      String prevPaidInd,
      String locDrawingInd,
      String SpecPymtInd,     /* CCN# ????? - S.Caine - 03/12/2003 */
      String presDate,
      String riskCode,
      String yearOfAcc,
      String umr,
      String slipOrder1,
      String slipOrder2,
      String lineSlipCh,
      String insured,
      String reinsured,
      String vesselAircraft,
      String interest,
      String siLimit,
      String excessLimit,
      String siCurr,
      String perilsConds,
      String policyPeriodFrom,
      String policyPeriodTo,
      String noOfSyndicates,
      String totalLine,
      String[] lidsSyndicateNo,
      String[] lidsSyndicateLine,
      String[] lidsSyndicateRef,
      String schemeCanInd,
      String cpaInd,
      String dirLStockInd,
      String simRi,
      String lidsOrigBkr,
      String lidsOrigCurr,
      String lidsSettCurr,
      String lidsFilCode1,
      String lidsFilCode2,
      String lidsTfCode,
      String lidsStateCode,
      String lidsNaicCode,
      String lidsNaicQual,
      String lidsNonUsTfCode,
      String lidsCountryCode,
      String lidsWarInd,
      String lidsDtiCode,
      String slipType)
  {
    this.osnd = osnd;
    this.apsnd = apsnd;
    this.currency = currency;
    this.versionNo = versionNo;
    this.settAdv = settAdv;
    this.nonScmAdvised = nonScmAdvised;
    this.bulkInd = bulkInd;
    this.riskUnsigned = riskUnsigned;
    this.treaty = treaty;
	this.ecfClaim = ecfClaim;
        this.ecfClass = ecfClass;
    this.lossReserve = lossReserve;
    this.loc = loc;
    this.lossFund = lossFund;
    this.payByCheque = payByCheque;
    this.chargeType = chargeType;
    this.nonChargeableInd = nonChargeableInd;
    this.prevAdvNonNet = prevAdvNonNet;
    this.prevPaidInd = prevPaidInd;

    // CCN# N0058 - BA - 09/01/2003
    this.locDrawingInd = locDrawingInd ;

    // CCN# ????? - S.Caine - 03/12/2003
    this.SpecPymtInd = SpecPymtInd ;

    // CCN 21.
    this.schemeCanInd = schemeCanInd;
    this.cpaInd = cpaInd;
    this.dirLStockInd = dirLStockInd;
    this.simRi = simRi;


    this.presDate = presDate;
    this.riskCode = riskCode;
    this.yearOfAcc = yearOfAcc;
    this.umr = umr;
    this.slipOrder1 = slipOrder1;
    this.slipOrder2 = slipOrder2;
    this.lineSlipCh = lineSlipCh;
    this.insured = insured;
    this.reinsured = reinsured;
    this.vesselAircraft = vesselAircraft;
    this.interest = interest;
    this.siLimit = siLimit;
    this.excessLimit = excessLimit;
    this.siCurr = siCurr;
    this.perilsConds = perilsConds;
    this.policyPeriodFrom = policyPeriodFrom;
    this.policyPeriodTo = policyPeriodTo;
    this.noOfSyndicates = noOfSyndicates;
    this.totalLine = totalLine;
    this.lidsSyndicateNo = lidsSyndicateNo;
    this.lidsSyndicateLine = lidsSyndicateLine;
    this.lidsSyndicateRef = lidsSyndicateRef;
    this.lidsOrigBkr = lidsOrigBkr;
    this.lidsOrigCurr = lidsOrigCurr;
    this.lidsSettCurr = lidsSettCurr;
    this.lidsFilCode1 = lidsFilCode1;
    this.lidsFilCode2 = lidsFilCode2;
    this.lidsTfCode = lidsTfCode;
    this.lidsStateCode = lidsStateCode;
    this.lidsNaicCode = lidsNaicCode;
    this.lidsNaicQual = lidsNaicQual;
    this.lidsNonUsTfCode = lidsNonUsTfCode;
    this.lidsCountryCode = lidsCountryCode;
    this.lidsWarInd = lidsWarInd;
    this.lidsDtiCode = lidsDtiCode;
    this.slipType = slipType;
  }

  public String getName() {
    return "java:comp/env/event/LY27Event";
  }

  public int getType() {
    return UPDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY27CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String[] getLidsSyndicateNo() {
    return lidsSyndicateNo;
  }
  public String[] getLidsSyndicateLine() {
    return lidsSyndicateLine;
  }
  public String[] getLidsSyndicateRef() {
    return lidsSyndicateRef;
  }

  public String[] getOsnd() {
    return osnd;
  }
  public String[] getApsnd() {
    return apsnd;
  }
  public String[] getCurrency() {
    for (int i=0; i<currency.length; i++)
      if (currency[i]==null)
        currency[i] = "";
    return currency;
  }
  public String getVersionNo() {
    return versionNo;
  }
  public String getSettAdv() {
    if (settAdv==null)
      return "";
    return settAdv;
  }
  public String getNonScmAdvised() {
    return nonScmAdvised;
  }
  public String getBulkInd() {
    return bulkInd;
  }
  public String getRiskUnsigned() {
    return riskUnsigned;
  }
  public String getTreaty() {
    return treaty;
  }
  public String getEcfClaim() {
    return ecfClaim;
  }
  public String getLossReserve() {
    return lossReserve;
  }
  public String getLoc() {
    return loc;
  }
  public String getLossFund() {
    return lossFund;
  }
  public String getPayByCheque() {
    return payByCheque;
  }
  public String getChargeType() {
    if (chargeType==null)
      return "";
    return chargeType;
  }
  public String getNonChargeableInd() {
    return nonChargeableInd;
  }
  public String getPrevAdvNonNet() {
    return prevAdvNonNet;
  }
  public String getPrevPaidInd() {
    return prevPaidInd;
  }

  // CCN# N0058 - BA - 09/01/2003
  public String getLocDrawingInd() {
    return locDrawingInd;
  }

  // CCN# ????? - S.Caine - 03/12/2003
  public String getSpecPymtInd() {
    return SpecPymtInd ;
  }

  public String getPresDate() {
    return presDate;
  }
  public String getRiskCode() {
    return riskCode;
  }
  public String getYearOfAcc() {
    return yearOfAcc;
  }
  public String getUmr() {
    return umr;
  }
  public String  getSlipOrder1() {
    return slipOrder1;
  }
  public String getSlipOrder2() {
    return slipOrder2;
  }
  public String getLineSlipCh() {
    return lineSlipCh;
  }
  public String getInsured() {
    return insured;
  }
  public String getReinsured() {
    return reinsured;
  }
  public String getVesselAircraft() {
    return vesselAircraft;
  }
  public String getInterest() {
    return interest;
  }
  public String getSiLimit() {
    return siLimit;
  }
  public String getExcessLimit() {
    return excessLimit;
  }
  public String getSiCurr() {
    return siCurr;
  }
  public String getPerilsConds() {
    return perilsConds;
  }
  public String getPolicyPeriodFrom() {
    return policyPeriodFrom;
  }
  public String getPolicyPeriodTo() {
    return policyPeriodTo;
  }
  public String getNoOfSyndicates() {
    return noOfSyndicates;
  }
  public String getTotalLine() {
    return totalLine;
  }
  public String getCpaInd() {
    return cpaInd;
  }
  public String getDirLStockInd() {
    return dirLStockInd;
  }
  public String getSchemeCanInd() {
    return schemeCanInd;
  }
  public String getSimRi() {
    return simRi;
  }
  public String getLidsCountryCode() {
    return lidsCountryCode;
  }
  public String getLidsDtiCode() {
    return lidsDtiCode;
  }
  public String getLidsFilCode1() {
    return lidsFilCode1;
  }
  public String getLidsFilCode2() {
    return lidsFilCode2;
  }
  public String getLidsNaicCode() {
    return lidsNaicCode;
  }
  public String getLidsNaicQual() {
    return lidsNaicQual;
  }
  public String getLidsNonUsTfCode() {
    return lidsNonUsTfCode;
  }
  public String getLidsOrigBkr() {
    return lidsOrigBkr;
  }
  public String getLidsOrigCurr() {
    return lidsOrigCurr;
  }
  public String getLidsSettCurr() {
    return lidsSettCurr;
  }
  public String getLidsStateCode() {
    return lidsStateCode;
  }
  public String getLidsTfCode() {
    return lidsTfCode;
  }
  public String getLidsWarInd() {
    return lidsWarInd;
  }
  public String getSlipType() {
	    return slipType;
	  }


public String getEcfClass()
{
    return ecfClass;
}

}