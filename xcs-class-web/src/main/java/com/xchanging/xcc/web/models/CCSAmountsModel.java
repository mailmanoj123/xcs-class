package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CCSAmountsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String origCcy ;
  private String settCcy ;
  private String ccsCurr ;
  private String outstRateExch ;
  private String orderAmountPTT ;
  private String settRate ;
  private String treasuryRate ;
  private String settAmountPTT ;
  private String orderAmountPTD ;
  private String settAmountPTD ;

  public CCSAmountsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.CCSAmountsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY81_FIELD_VALUES)).get(0);

    origCcy = (String)fieldValues.get(Keys.LY81_ORIG_CURR) ;
    settCcy = (String)fieldValues.get(Keys.LY81_SETT_CURR) ;
    ccsCurr = (String)fieldValues.get(Keys.LY81_CCS_CURR) ;
    outstRateExch = (String)fieldValues.get(Keys.LY81_OUTST_RATE_EXCH) ;

    orderAmountPTT = (String)fieldValues.get(Keys.LY81_PTT_AMT_ORIG) ;
    settRate = (String)fieldValues.get(Keys.LY81_RATE_EXCH) ;
    treasuryRate = (String)fieldValues.get(Keys.LY81_TREASURY_RATE) ;
    settAmountPTT = (String)fieldValues.get(Keys.LY81_CCS_SETT_AMT) ;

    orderAmountPTD = (String)fieldValues.get(Keys.LY81_PTD_AMT_ORIG) ;
    settAmountPTD = (String)fieldValues.get(Keys.LY81_PTD_CCS_AMT) ;
  }

  public String getCcsCurr() {
    return ccsCurr;
  }
  public String getOrderAmountPTD() {
    return orderAmountPTD;
  }
  public String getOrderAmountPTT() {
    return orderAmountPTT;
  }
  public String getOrigCcy() {
    return origCcy;
  }
  public String getOutstRateExch() {
    return outstRateExch;
  }
  public String getSettAmountPTD() {
    return settAmountPTD;
  }
  public String getSettAmountPTT() {
    return settAmountPTT;
  }
  public String getSettCcy() {
    return settCcy;
  }
  public String getSettRate() {
    return settRate;
  }
  public String getTreasuryRate() {
    return treasuryRate;
  }

}