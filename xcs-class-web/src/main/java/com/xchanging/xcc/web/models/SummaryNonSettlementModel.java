package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SummaryNonSettlementModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String ucr = "";
  private String xcr = "";
  private String tr = "";
  private String origBkr = "";
  private Vector currencies;
  private boolean releaseFlag;
  private boolean holdFlag;
  private boolean deleteFlag;
  private boolean exitFlag;

  public SummaryNonSettlementModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SummaryNonSettlementModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    String screenMode = (String)results.get(Keys.LY59_SCREEN_MODE_Field);
    mm.getUserWebModel().setUpdateMode(screenMode);

    // First get the Field-Values table (only occurs once).
    Vector v1 = (Vector) results.get(Keys.LY59_FIELD_VALUES_Table);
    MappedRecord subResults = (MappedRecord) v1.get(0);

    // Now get all the Field-Values level data
    ucr = (String) subResults.get(Keys.LY59_UCR_Field);
    xcr = (String) subResults.get(Keys.LY59_XCR_Field);
    tr = (String) subResults.get(Keys.LY59_TR_Field);
    origBkr = (String) subResults.get(Keys.LY59_ORIG_BKR_Field);

    Vector v2 = (Vector) subResults.get(Keys.LY59_CURRENCY_DETAILS_Table);
    if (v2==null)
      v2 = new Vector(0);
    currencies = new Vector(v2.size());
    for (int x=0; x<v2.size();x++){
      MappedRecord record = (MappedRecord) v2.get(x);
      if (!(record.get(Keys.LY59_ORIG_CURR_Field).equals(""))) {
         currencies.add(new SummNonSettCurrency(record));
      }
    }

    MappedRecord mrCommandAttributes = (MappedRecord)((Vector)results.get(Keys.LY59_COMMAND_ATTRIBUTES_Table)).get(0) ;
    releaseFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY59_RELEASE_ATTR_Field)) ;
    holdFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY59_HOLD_ATTR_Field)) ;
    deleteFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY59_DELETE_ATTR_Field)) ;
    exitFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY59_EXIT_ATTR_Field)) ;
  }

   public String getUcr() {
    return ucr;
  }

  public String getXcr() {
    return xcr;
  }

  public String getTr() {
    return tr;
  }

  public String getOrigBkr() {
    return origBkr;
  }

  public Enumeration getCurrencies() {
    return currencies.elements();
  }

  public boolean getReleaseButtonFlag() {
    return releaseFlag;
  }

  public boolean getDeleteButtonFlag() {
    return deleteFlag;
  }

  public boolean getHoldButtonFlag() {
    return holdFlag;
  }

  public boolean getExitButtonFlag() {
    return exitFlag;
  }

}