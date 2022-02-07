package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;
import com.xchanging.xcc.web.models.reference.TrustFundList;

public class MarketsModel extends WebModel implements ModelUpdateListener {
  private String progStatus;

  private String osnds[];
  private String apsnds[];

  private String lidsSyndicateNo[];
  private String lidsSyndicateLine[];
  private String lidsSyndicateRef[];

  private String[] origBkrCode;
  private String[] origBkrCurr;
  private String[] origSettCurr;
  private String[] filCode1;
  private String[] filCode2;
  private String[] tfCode;
  private String[] stateCode;
  private String[] naicCode;
  private String[] naicQual;
  private String[] warInd;
  private String[] dtiCode;

  private String[] nonUSTFCode; // ref data
  private String[] cntryCode;   // ref data

  private String date[];
  private String noOfSyndicates[];
  private String bureauShareTotalLine[];
  private String marketNarrative[];
  private String versionNo[];
  private int marketsCount;
  private int valueCount;
  private int syndicatesCount;
  private int marketSelected;

  private String riskCode;
  private String yearOfAcc;
  private String umr;
  private String slipOrder1;
  private String slipOrder2;
  private String slipType;
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

  private HashMap map;
  private ModelManager mm;

  public MarketsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.MarketsModelKey, this);
  }

  public void setMarketSelected(int marketSelected) {
    this.marketSelected = marketSelected;
  }

  public int getSelectedMarket() {
    if (marketsCount <= 1) {
      setMarketSelected(0);
    }
    return marketSelected;
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    progStatus = (String)results.get(Keys.LY94ProgStatusField);

    Vector sndTable = (Vector)results.get("#C094_SND_TABLE[]");
    if (sndTable==null)
      sndTable = new Vector(0);
    osnds = new String[sndTable.size()];
    apsnds = new String[sndTable.size()];
    for (int i=0;i<sndTable.size(); i++) {
      MappedRecord snd = (MappedRecord)sndTable.get(i);
      osnds[i] = (String)snd.get(Keys.LY94OrigRefField);
      apsnds[i] = (String)snd.get(Keys.LY94ApRefField);
    }

    Vector availableMarkets = (Vector)results.get(Keys.LY94AvailableMarkets);
    MappedRecord marketRecords = (MappedRecord)availableMarkets.get(0);

    /**
     * Get the amount of Markets
     */
    marketsCount = Integer.decode((String)marketRecords.get(Keys.LY94LIDSMarketCountField)).intValue();
    map = new HashMap(marketsCount);

    bureauShareTotalLine = new String[5];
    versionNo            = new String[5];
    date                 = new String[5];
    marketNarrative      = new String[5];
    noOfSyndicates       = new String[5];

    for (int x = 0; x < 5; x++) {
      bureauShareTotalLine[x] = "";
      versionNo[x]            = "";
      date[x]                 = "";
      marketNarrative[x]      = "";
      noOfSyndicates[x]       = "";
    }

    Vector lidsMarkets      = (Vector)marketRecords.get(Keys.LY94LIDSMarketTable);
    for (int x = 0; x < marketsCount; x++) {
      MappedRecord record = (MappedRecord)lidsMarkets.get(x);
      versionNo[x]            =     (String)record.get(Keys.LY94VersionNoField);
      bureauShareTotalLine[x] =     (String)record.get(Keys.LY94BureauLineField);
      date[x]                 =     (String)record.get(Keys.LY94EffectiveDateField);
      marketNarrative[x]      =     (String)record.get(Keys.LY94MarketNarrField);
      noOfSyndicates[x]       =     (String)record.get(Keys.LY94MarketLineCountField);

      /**
       * Get the amount of Syndicates for this Market
       */
      syndicatesCount = Integer.decode((String)record.get(Keys.LY94MarketLineCountField)).intValue();

      lidsSyndicateNo      = new String[syndicatesCount];
      lidsSyndicateLine    = new String[syndicatesCount];
      lidsSyndicateRef     = new String[syndicatesCount];

      Vector lidsMarketLines = (Vector)record.get("#C094_LIDS_MKT_LINE[]");
      for (int y = 0; y < syndicatesCount; y++) {
        MappedRecord record2 = (MappedRecord)lidsMarketLines.get(y);
        lidsSyndicateNo[y]   =  (String)record2.get("@C094_LIDS_SYND_NO");
        lidsSyndicateLine[y] =  (String)record2.get("@C094_LIDS_SYND_LINE");
        lidsSyndicateRef[y]  =  (String)record2.get("@C094_LIDS_SYND_REF");
      }
      map.put(String.valueOf(x),new SyndicateDetails(lidsSyndicateNo,lidsSyndicateRef,lidsSyndicateLine));
    }

    Vector keyValues = (Vector)results.get(Keys.LY94KeyValuesField);
    MappedRecord valueRecords = (MappedRecord)keyValues.get(0);

    riskCode         = (String)valueRecords.get(Keys.LY94RiskCodeField);
    yearOfAcc        = (String)valueRecords.get(Keys.LY94YearOfAccField);
    umr              = (String)valueRecords.get(Keys.LY94UmrField);
    slipOrder1       = (String)valueRecords.get(Keys.LY94SlipOrder1Field);
    slipOrder2       = (String)valueRecords.get(Keys.LY94SlipOrder2Field);
    slipType         = (String)valueRecords.get(Keys.LY94SlipTypeField);
    lineSlipCh       = (String)valueRecords.get(Keys.LY94LineSlipCHField);
    insured          = (String)valueRecords.get(Keys.LY94InsuredField);
    reinsured        = (String)valueRecords.get(Keys.LY94ReinsuredField);
    vesselAircraft   = (String)valueRecords.get(Keys.LY94VesselAircraft);
    interest         = (String)valueRecords.get(Keys.LY94InterestField);
    siLimit          = (String)valueRecords.get(Keys.LY94SiLimitField);
    excessLimit      = (String)valueRecords.get(Keys.LY94ExcessLimitField);
    siCurr           = (String)valueRecords.get(Keys.LY94SiCurrField);
    perilsConds      = (String)valueRecords.get(Keys.LY94PerilsCondsField);
    policyPeriodFrom = (String)valueRecords.get(Keys.LY94PolicyPeriodFromField);
    policyPeriodTo   = (String)valueRecords.get(Keys.LY94PolicyPeriodToField);

    valueCount = Integer.decode((String)valueRecords.get(Keys.LY94ValueCount)).intValue();

    origBkrCode   =   new String[valueCount];
    origBkrCurr   =   new String[valueCount];
    origSettCurr  =   new String[valueCount];
    filCode1      =   new String[valueCount];
    filCode2      =   new String[valueCount];
    tfCode        =   new String[valueCount];
    stateCode     =   new String[valueCount];
    naicCode      =   new String[valueCount];
    naicQual      =   new String[valueCount];
    nonUSTFCode   =   new String[valueCount];
    cntryCode     =   new String[valueCount];
    warInd        =   new String[valueCount];
    dtiCode       =   new String[valueCount];

    Vector valueOccurrence = (Vector)valueRecords.get("#C094_VALUE_OCCURRENCE[]");

    for (int z = 0; z < valueCount; z++) {
      MappedRecord record3 = (MappedRecord)valueOccurrence.get(z);
      origBkrCode[z]   = (String) record3.get("@C094_ORIG_BKR_CODE");
      origBkrCurr[z]   = (String) record3.get("@C094_ORIG_CURR");
      origSettCurr[z]  = (String) record3.get("@C094_SETT_CURR");
      filCode1[z]      = (String) record3.get("@C094_FIL_CODE_1");
      filCode2[z]      = (String) record3.get("@C094_FIL_CODE_2");
      tfCode[z]        = (String) record3.get("@C094_TF_CODE");
      stateCode[z]     = (String) record3.get("@C094_STATE_CODE");
      naicCode[z]      = (String) record3.get("@C094_NAIC_CODE");
      naicQual[z]      = (String) record3.get("@C094_NAIC_QUAL");
      nonUSTFCode[z]   = (String) record3.get("@C094_NON_US_TF_CODE");
      cntryCode[z]     = (String) record3.get("@C094_CNTRY_CODE");
      warInd[z]        = (String) record3.get("@C094_WAR_IND");
      dtiCode[z]       = (String) record3.get("@C094_DTI_CODE");
    }

    ClaimTransactionCreationModel ctcModel =  mm.getClaimTransactionCreationModel();
    ctcModel.updateValues(riskCode,yearOfAcc,umr,slipOrder1,
                          slipOrder2,slipType,lineSlipCh,insured,
                          reinsured,vesselAircraft,interest,
                          siLimit,excessLimit,siCurr,perilsConds,
                          policyPeriodFrom,policyPeriodTo,String.valueOf(valueCount));
  }

  public Enumeration getNonUSTFCodes() {

    if (nonUSTFCode != null) {
      TrustFundList list = new TrustFundList();
      list.createTrustFund("   ");
      for (int x = 0; x < nonUSTFCode.length; x++) {
        list.createTrustFund(nonUSTFCode[x]);
      }
      return list.getTrustFunds();
    }
    return new Vector().elements();
  }

  /* CCN 31/01/03
  public Enumeration getCntryCodes() {

    if (cntryCode != null && cntryCode.length > 0)  {
      CountryCodeList list = new CountryCodeList();
      list.createCountryCode("   ","   ");
      CountryCodeList csvList = (CountryCodeList)session.getServletContext().getAttribute(Keys.RefCountryCodeList);
      for (int x = 0; x < cntryCode.length; x++) {
        if (list.getDescription(cntryCode[x]).equals("unknown")) { // not in the list
          list.createCountryCode(cntryCode[x],csvList.getDescription(cntryCode[x]));
        }
      }
      return list.getCountryCodes();
    }
    return new Vector().elements();
  }*/

  public String[] getLidsSyndicateNo(int aMarket) {
    if (map==null) return new String[0];
    SyndicateDetails syndicate = (SyndicateDetails)map.get(String.valueOf(aMarket));
    return syndicate==null?new String[0]:syndicate.getLidsSyndicateNo();
  }
  public String[] getLidsSyndicateLine(int aMarket) {
    if (map==null) return new String[0];
    SyndicateDetails syndicate = (SyndicateDetails)map.get(String.valueOf(aMarket));
    return syndicate==null?new String[0]:syndicate.getLidsSyndicateLine();
  }
  public String[] getLidsSyndicateRef(int aMarket) {
    if (map==null) return new String[0];
    SyndicateDetails syndicate = (SyndicateDetails)map.get(String.valueOf(aMarket));
    return syndicate==null?new String[0]:syndicate.getLidsSyndicateRef();
  }


  public class SyndicateDetails extends WebModel {
    private String[] lidsSyndicateNo;
    private String[] lidsSyndicateRef;
    private String[] lidsSyndicateLine;

    SyndicateDetails( String[] lidsSyndicateNo,
                      String[] lidsSyndicateRef,
                      String[] lidsSyndicateLine) {

      this.lidsSyndicateNo = lidsSyndicateNo;
      this.lidsSyndicateRef = lidsSyndicateRef;
      this.lidsSyndicateLine = lidsSyndicateLine;

    }

    public String[] getLidsSyndicateNo() {
      return lidsSyndicateNo;
    }
    public String[] getLidsSyndicateRef() {
      return lidsSyndicateRef;
    }
    public String[] getLidsSyndicateLine() {
      return lidsSyndicateLine;
    }
  }


  public String[] getNoOfSyndicates() {
    return noOfSyndicates;
  }

  public String[] getVersionNo() {
    if (versionNo==null)
      return new String[] {""};
    else
      return versionNo;
  }

  public String getNoOfSyndicates(int i) {
    if (noOfSyndicates==null || i>=noOfSyndicates.length)
      return "";
    else
      return noOfSyndicates[i];
  }

  public String[] getDate() {
    return date;
  }

  public String[] getBureauShareTotalLine() {
    return bureauShareTotalLine;
  }

  public String[] getMarketNarrative() {
    return marketNarrative;
  }

  public int getMarketsCount() {
    return marketsCount;
  }

  public String getDate(int i) {
    return date[i];
  }

  public String getBureauShareTotalLine(int i) {
    if (bureauShareTotalLine==null || i>=bureauShareTotalLine.length)
      return "";
    else
      return bureauShareTotalLine[i];
  }

  public String getMarketNarrative(int i) {
    return marketNarrative[i];
  }


  public String getMarketNarrativeFlag(int i) {
    return "DISABLED";
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
  public String getSlipOrder1() {
    return slipOrder1;
  }
  public String getSlipOrder2() {
    return slipOrder2;
  }
  public String getSlipType() {
    return slipType;
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
  public String getValueCount() {
    return new String().valueOf(valueCount);
  }
  public String[] getFilCode1() {
    return filCode1;
  }
  public String[] getFilCode2() {
    return filCode2;
  }
  public String[] getNaicCode() {
    return naicCode;
  }
  public String[] getNaicQual() {
    return naicQual;
  }
  public String[] getNonUSTFCode() {
    return nonUSTFCode;
  }
  public String[] getOrigBkrCode() {
    return origBkrCode;
  }
  public String[] getOrigBkrCurr() {
    return origBkrCurr;
  }
  public String[] getOrigSettCurr() {
    return origSettCurr;
  }
  public String[] getStateCode() {
    return stateCode;
  }
  public String[] getTfCode() {
    return tfCode;
  }
  public String[] getWarInd() {
    return warInd;
  }
  public String[] getCntryCode() {
    return cntryCode;
  }
  public String[] getDtiCode() {
    return dtiCode;
  }
  public String[] getApsnds() {
    return apsnds;
  }
  public String[] getOsnds() {
    return osnds;
  }
  public String getProgStatus() {
    if (progStatus==null)
      return "";
    else
      return progStatus;
  }

  private String getLidsValue(String[] array) {
    if ((array==null) || (array.length==0))
      return "";
    else if (array.length==1)
      return array[0];
    else {
      for (int i=1; i<array.length; i++) {
        if (!array[i].equals(array[i-1])) {
          return "";
        }
      }
      return array[0];
    }
  }

  public String getLidsOrigBkrCode() {
    return getLidsValue(origBkrCode);
  }

  public String getLidsOrigBkrCurr() {
    return getLidsValue(origBkrCurr);
  }

  public String getLidsOrigSettCurr() {
    return getLidsValue(origSettCurr);
  }

  public String getLidsFilCode1() {
    return getLidsValue(filCode1);
  }

  public String getLidsFilCode2() {
    return getLidsValue(filCode2);
  }

  public String getLidsTfCode() {
    return getLidsValue(tfCode);
  }

  public String getLidsStateCode() {
    return getLidsValue(stateCode);
  }

  public String getLidsNaicCode() {
    return getLidsValue(naicCode);
  }

  public String getLidsNaicQual() {
    return getLidsValue(naicQual);
  }

  public String getLidsNonUSTFCode() {
    return getLidsValue(nonUSTFCode);
  }

  public String getLidsCntryCode() {
    return getLidsValue(cntryCode);
  }

  public String getLidsWarInd() {
    return getLidsValue(warInd);
  }

  public String getLidsDtiCode() {
    return getLidsValue(dtiCode);
  }
}