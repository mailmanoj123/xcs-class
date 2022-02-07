package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCcsCorrectionModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  // Note:- the screen that has been agreed shows three sets of currency data- regardless of
  // whether there is 1,2 or 3 sets of currency data to populate the fields.
  // Hence we initialise all the values on entry- setting the readonly flags to true.

  // Note:- The 'treasuryRatex' field is entered by the user- hence we will keep this
  // blank.
  private String origCcy1 = "";
  private String settCcy1 = "";
  private String treasuryRate1Flag = "";
  private String treasuryRate1 = "";

  private String origCcy2 = "";
  private String settCcy2 = "";
  private String treasuryRate2Flag = "";
  private String treasuryRate2 = "";

  private String origCcy3 = "";
  private String settCcy3 = "";
  private String treasuryRate3Flag = "";
  private String treasuryRate3 = "";

  public BulkCcsCorrectionModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.BulkCcsCorrectionModelKey, this);
  }


  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    Vector recordV2 = (Vector)(results).get(Keys.LY91_CURRENCY_TABLE);

    treasuryRate1Flag = enabledStatus("P");
    treasuryRate2Flag = enabledStatus("P");
    treasuryRate3Flag = enabledStatus("P");

    for (int objInd = 0; objInd < recordV2.size(); objInd++) {
         MappedRecord record2 = (MappedRecord)recordV2.get(objInd);
         // Only retrieve those elements that actually contain results
         if (!(record2.get(Keys.LY91_ORIG_CURR_Field).equals(""))) {
           switch (objInd){
             case 0:
                  treasuryRate1Flag = enabledStatus((String) record2.get(Keys.LY91_TREASURY_ATTR_Field));
                  origCcy1 = (String) record2.get(Keys.LY91_ORIG_CURR_Field);
                  settCcy1 = (String) record2.get(Keys.LY91_SETT_CURR_Table);
                  break;
             case 1:
                  treasuryRate2Flag = enabledStatus((String) record2.get(Keys.LY91_TREASURY_ATTR_Field));
                  origCcy2 = (String) record2.get(Keys.LY91_ORIG_CURR_Field);
                  settCcy2 = (String) record2.get(Keys.LY91_SETT_CURR_Table);
                  break;
             case 2:
                  treasuryRate2Flag = enabledStatus((String) record2.get(Keys.LY91_TREASURY_ATTR_Field));
                  origCcy2 = (String) record2.get(Keys.LY91_ORIG_CURR_Field);
                  settCcy2 = (String) record2.get(Keys.LY91_SETT_CURR_Table);
                  break;
           }

         }
      }
  }

  public String getOrigCcy1() {
    return origCcy1;
  }
  public String getSettCcy1() {
    return settCcy1;
  }
  public String getOrigCcy1Flag() {
    return enabledStatus("P");
  }
  public String getSettCcy1Flag() {
    return enabledStatus("P");
  }
  public String getTreasuryRate1Flag() {
    return treasuryRate1Flag;
  }
  public String getTreasuryRate1() {
    return treasuryRate1;
  }
  public String getOrigCcy2() {
    return origCcy2;
  }
  public String getSettCcy2() {
    return settCcy2;
  }
  public String getOrigCcy2Flag() {
    return enabledStatus("P");
  }
  public String getSettCcy2Flag() {
    return enabledStatus("P");
  }
  public String getTreasuryRate2() {
    return treasuryRate2;
  }
  public String getOrigCcy3() {
    return origCcy3;
  }
  public String getSettCcy3() {
    return settCcy3;
  }
  public String getOrigCcy3Flag() {
    return enabledStatus("P");
  }
  public String getSettCcy3Flag() {
    return enabledStatus("P");
  }
  public String getTreasuryRate3() {
    return treasuryRate3;
  }
  public String getTreasuryRate2Flag() {
    return treasuryRate2Flag;
  }
  public String getTreasuryRate3Flag() {
    return treasuryRate3Flag;
  }
}