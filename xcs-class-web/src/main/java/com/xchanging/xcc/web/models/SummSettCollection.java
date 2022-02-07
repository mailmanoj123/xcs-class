package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;

public class SummSettCollection extends WebModel {

  // Extends web model just to gain access to convertToBoolean
  private String statSplitNo = "";
  private Vector breakdown = null ;
  private String tdn = "";
  private boolean tdnFlag ;
  private String pttSett = "";
  private String osAmtOrig = "";
  private String pttOrig = "";
  private String treasuryRateFlag = "";
  private String treasuryRate = "";

  public SummSettCollection(MappedRecord mrData) {
    statSplitNo = (String)mrData.get(Keys.LY62_STAT_SPLIT_NO_Field) ;
    tdn = (String)mrData.get(Keys.LY62_TDN_REF_Field) ;
    tdnFlag = convertToBoolean((String)mrData.get(Keys.LY62_TDN_ATTR_Field)) ;
    pttSett = (String)mrData.get(Keys.LY62_CLAIM_AMT_SETT_Field) ;
    osAmtOrig = (String)mrData.get(Keys.LY62_OUTST_AMT_Field) ;
    pttOrig =(String)mrData.get(Keys.LY62_PTT_AMT_Field) ;
    treasuryRate = (String)mrData.get(Keys.LY62_TREASURY_RATE_Field);
    treasuryRateFlag = enabledStatus((String)mrData.get(Keys.LY62_TREASURY_ATTR_Field));
  }

  public String getstatSplitNo() {
    return statSplitNo;
  }

  public void clearBreakdowns() {
    breakdown = null;
  }

  public boolean hasBreakdowns() {
    if (breakdown == null)
      return false ;
    else
      return true ;
  }

  public void addBreakdown(Vector vctData) {
    breakdown = new Vector();
    if (vctData == null) {
      vctData = new Vector();
    }
    for (int i=0; i<vctData.size(); i++) {
      SummSettBreakdown bdown = new SummSettBreakdown((MappedRecord)vctData.get(i));
      if (!bdown.getMvmtReg().equals(""))
        breakdown.add(bdown);
      else
        break;
    }
  }

  public Enumeration getBreakdowns() {
    if (breakdown == null) {
      return new Vector().elements();
    }
    else {
      return breakdown.elements();
    }
  }

  public String getTdn() {
    return tdn;
  }

  public boolean gettdnFlag() {
    return tdnFlag;
  }

  public String getPTTSett() {
    return pttSett;
  }

  public String getOSAmtOrig() {
    return osAmtOrig;
  }

  public String getPTTOrig() {
    return pttOrig;
  }

  public String getTreasuryRate() {
    return treasuryRate;
  }

  public String getTreasuryRateFlag() {
    return treasuryRateFlag;
  }
}