package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY07Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindClaimModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  // All values are initialised to blank.
  // There are no values to extract from the Mapped Record detailed below.
  private String searchUcr = "";
  private String bkrUcr = "";
  private String searchTr = "";
  private String cor = "";
  private String osnd = "";
  private String tdn = "";
  private String groupRef = "";
  private String certNo = "";
  
  private String ly07Ucr = "";
  private String ly07Tr = "";
  private String ly07UcrTrSysRef = "";
  private String ly07CurrNo = "";
  private String ly07SdnNo = "";
  private String ly07StatSplitNo = "";
  private String ly07BreakdownNo = "";
  private String ly07NextProg = "";
  
  
  public FindClaimModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.FindClaimModelKey, this);
  }

  public void performUpdate() {

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY07Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
      ly07Ucr = (String)results.get(Keys.LY07_UCR);
      ly07Tr = (String)results.get(Keys.LY07_TR);
      ly07UcrTrSysRef = (String)results.get(Keys.LY07_UCR_TR_SYS_REF);
      ly07CurrNo = (String)results.get(Keys.LY07_CURR_NO);
      ly07SdnNo = (String)results.get(Keys.LY07_SDN_NO);
      ly07StatSplitNo = (String)results.get(Keys.LY07_STAT_SPLIT_NO);
      ly07BreakdownNo = (String)results.get(Keys.LY07_BREAKDOWN_NO);
      ly07NextProg = (String)results.get(Keys.LY07_NEXT_PROG);
    }

    // ****** NOTE: ******
    // As detailed in the spec- all the fields on this screen are blank-
    // Therefore there are no values to map into this bean.
    // All values are initialised to blank on entry to this bean.

    // The values typed into the Find Claim screen are in turn stored in
    // the relevant models called by either LY06, LY07 or LY08

  }

  public String getUcr() {
    return searchUcr;
  }
  public String getBkrUcr() {
    return bkrUcr;
  }
  public String getTr() {
    return searchTr;
  }
  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getCor() {
    return cor;
  }
  public String getOsnd() {
    return osnd;
  }
  public String getTdn() {
    return tdn;
  }
  public String getGroupRef() {
    return groupRef;
  }
  
  public void setCertNo(String certNo) {
      this.certNo = certNo;
    }

  public String getCertNo() {
      return certNo;
    }

  public String getLy07BreakdownNo() {
    return ly07BreakdownNo;
  }
  public String getLy07CurrNo() {
    return ly07CurrNo;
  }
  public String getLy07NextProg() {
    return ly07NextProg;
  }
  public String getLy07SdnNo() {
    return ly07SdnNo;
  }
  public String getLy07StatSplitNo() {
    return ly07StatSplitNo;
  }
  public String getLy07Tr() {
    return ly07Tr;
  }
  public String getLy07Ucr() {
    return ly07Ucr;
  }
  public String getLy07UcrTrSysRef() {
    return ly07UcrTrSysRef;
  }

}