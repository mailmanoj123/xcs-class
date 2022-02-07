package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class RateOfExchangeAdjustmentModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  // Initialising these values- as there may only be 1 currency set to be populated. Hence
  // we set all the values to blank- and the readonly flags to true.
  private String origCcy1 ="";
  private String origCcy2 = "";
  private String origCcy3 = "";
  private String paidAmt1 = "";
  private String paidAmt2 = "";
  private String paidAmt3 = "";
  private String settCcy1 = "";
  private String settCcy2 = "";
  private String settCcy3 = "";
  private String origRExch1 = "";
  private String origRExch2 = "";
  private String origRExch3 = "";
  // are the settAmt's required?
  private String settAmt1 = "";
  private String settAmt2 = "";
  private String settAmt3 = "";
 //
  private String origSettAmt1 = "";
  private String origSettAmt2 = "";
  private String origSettAmt3 = "";
  private String revisedRExch1 = "";
  private String revisedRExch2 = "";
  private String revisedRExch3 = "";
  private String revisedRExch1Flag = "";
  private String revisedRExch2Flag = "";
  private String revisedRExch3Flag = "";
  private String revisedSettAmt1 = "";
  private String revisedSettAmt2 = "";
  private String revisedSettAmt3 = "";
  private String revisedSettAmt1Flag = "";
  private String revisedSettAmt2Flag = "";
  private String revisedSettAmt3Flag = "";

  public RateOfExchangeAdjustmentModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.RateOfExchangeAdjModelKey, this);
  }

  public void performUpdate() {
    origCcy1 ="";
    origCcy2 = "";
    origCcy3 = "";
    paidAmt1 = "";
    paidAmt2 = "";
    paidAmt3 = "";
    settCcy1 = "";
    settCcy2 = "";
    settCcy3 = "";
    origRExch1 = "";
    origRExch2 = "";
    origRExch3 = "";
    settAmt1 = "";
    settAmt2 = "";
    settAmt3 = "";
    origSettAmt1 = "";
    origSettAmt2 = "";
    origSettAmt3 = "";
    revisedRExch1 = "";
    revisedRExch2 = "";
    revisedRExch3 = "";
    revisedRExch1Flag = "";
    revisedRExch2Flag = "";
    revisedRExch3Flag = "";
    revisedSettAmt1 = "";
    revisedSettAmt2 = "";
    revisedSettAmt3 = "";
    revisedSettAmt1Flag = "";
    revisedSettAmt2Flag = "";
    revisedSettAmt3Flag = "";

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    Vector recordV = (Vector)(results).get(Keys.LY77_CURRENCY_DETAILS_Table);
    if (recordV==null)
      recordV = new Vector(0);

    for (int objInd = 0; objInd < recordV.size(); objInd++) {
         MappedRecord record = (MappedRecord)recordV.get(objInd);
         // Only retrieve those elements that actually contain results
         if (!(record.get(Keys.LY77_ORIG_CURR).equals(""))) {
           // This is a little tacky- however the JSP references an individual
           // getter for each of the three currencies- given that the screen
           // has been agreed to show all three currencies regardless of whether
           // there are 3 currencies we'll stick with the code below.
           // Enumerating the JSP and the code below would be nice-----
           switch (objInd){
             case 0:
               origCcy1  = (String) record.get(Keys.LY77_ORIG_CURR);
               paidAmt1  = (String) record.get(Keys.LY77_PAID_AMT);
               settCcy1  = (String) record.get(Keys.LY77_SETT_CURR);
               origRExch1 = (String) record.get(Keys.LY77_ORIG_RATE_EX);
               origSettAmt1 = (String) record.get(Keys.LY77_ORIG_SETT_AM);
               revisedRExch1 = (String) record.get(Keys.LY77_REV_RATE_EXC);
               revisedSettAmt1 = (String) record.get(Keys.LY77_REV_SETT_AMT);
               break;
             case 1:
               origCcy2  = (String) record.get(Keys.LY77_ORIG_CURR);
               paidAmt2  = (String) record.get(Keys.LY77_PAID_AMT);
               settCcy2  = (String) record.get(Keys.LY77_SETT_CURR);
               origRExch2 = (String) record.get(Keys.LY77_ORIG_RATE_EX);
               origSettAmt2 = (String) record.get(Keys.LY77_ORIG_SETT_AM);
               revisedRExch2 = (String) record.get(Keys.LY77_REV_RATE_EXC);
               revisedSettAmt2 = (String) record.get(Keys.LY77_REV_SETT_AMT);
               break;
             case 2:
               origCcy3  = (String) record.get(Keys.LY77_ORIG_CURR);
               paidAmt3  = (String) record.get(Keys.LY77_PAID_AMT);
               settCcy3  = (String) record.get(Keys.LY77_SETT_CURR);
               origRExch3 = (String) record.get(Keys.LY77_ORIG_RATE_EX);
               settAmt3 = (String) record.get(Keys.LY77_ORIG_SETT_AM);
               origSettAmt3 = (String) record.get(Keys.LY77_ORIG_SETT_AM);
               revisedRExch3 = (String) record.get(Keys.LY77_REV_RATE_EXC);
               revisedSettAmt3 = (String) record.get(Keys.LY77_REV_SETT_AMT);
               break;
           }

         }
      }

    Vector recordV2 = (Vector)(results).get(Keys.LY77_CURRENCY_ATTRS_Table);
    if (recordV2==null)
      recordV2 = new Vector(0);

    for (int objInd = 0; objInd < recordV2.size(); objInd++) {
         MappedRecord record2 = (MappedRecord)recordV2.get(objInd);
         // Only retrieve those elements that actually contain results
         if (!(record2.get(Keys.LY77_REV_ROE_ATTR).equals(""))) {
           switch (objInd){
             case 0:
                  revisedRExch1Flag = enabledStatus((String) record2.get(Keys.LY77_REV_ROE_ATTR));
                  revisedSettAmt1Flag = enabledStatus((String) record2.get(Keys.LY77_REV_AMT_ATTR));
                  break;
             case 1:
                  revisedRExch2Flag = enabledStatus((String) record2.get(Keys.LY77_REV_ROE_ATTR));
                  revisedSettAmt2Flag = enabledStatus((String) record2.get(Keys.LY77_REV_AMT_ATTR));
                  break;
             case 2:
                  revisedRExch3Flag = enabledStatus((String) record2.get(Keys.LY77_REV_ROE_ATTR));
                  revisedSettAmt3Flag = enabledStatus((String) record2.get(Keys.LY77_REV_AMT_ATTR));
                  break;
           }

         }
      }
  }


  public String getOrigCcy1() {
    return origCcy1;
  }
  public String getOrigCcy2() {
    return origCcy2;
  }
  public String getOrigCcy3() {
    return origCcy3;
  }
  public String getPaidAmt1() {
    return paidAmt1;
  }
  public String getPaidAmt2() {
    return paidAmt2;
  }
  public String getPaidAmt3() {
    return paidAmt3;
  }
  public String getSettCcy1() {
    return settCcy1;
  }
  public String getSettCcy2() {
    return settCcy2;
  }
  public String getSettCcy3() {
    return settCcy3;
  }
  public String getOrigRExch1() {
    return origRExch1;
  }
  public String getOrigRExch2() {
    return origRExch2;
  }
  public String getOrigRExch3() {
    return origRExch3;
  }
  public String getSettAmt1() {
    return settAmt1;
  }
  public String getSettAmt2() {
    return settAmt2;
  }
  public String getSettAmt3() {
    return settAmt3;
  }
  public String getOrigSettAmt1() {
    return origSettAmt1;
  }
  public String getOrigSettAmt2() {
    return origSettAmt2;
  }
  public String getOrigSettAmt3() {
    return origSettAmt3;
  }
  public String getRevisedRExch1() {
    return revisedRExch1;
  }
  public String getRevisedRExch2() {
    return revisedRExch2;
  }
  public String getRevisedRExch3() {
    return revisedRExch3;
  }
  public String getRevisedRExch1Flag() {
    return revisedRExch1Flag;
  }
  public String getRevisedRExch2Flag() {
    return revisedRExch2Flag;
  }
  public String getRevisedRExch3Flag() {
    return revisedRExch3Flag;
  }
  public String getRevisedSettAmt1() {
    return revisedSettAmt1;
  }
  public String getRevisedSettAmt2() {
    return revisedSettAmt2;
  }
  public String getRevisedSettAmt3() {
    return revisedSettAmt3;
  }
  public String getRevisedSettAmt1Flag() {
    return revisedSettAmt1Flag;
  }
  public String getRevisedSettAmt2Flag() {
    return revisedSettAmt2Flag;
  }
  public String getRevisedSettAmt3Flag() {
    return revisedSettAmt3Flag;
  }
}