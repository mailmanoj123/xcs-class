package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LZ03Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SummarySettlementModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String xcr = "" ;
  private String ucr = "" ;
  private String tr = "";
  private String origBkr = "" ;
  private String paidByCheque = "";

  private Vector currencies;

  private boolean releaseFlag ;
  private boolean holdFlag ;
  private boolean deleteFlag ;
  private boolean exitFlag ;
  private boolean hideRate;

  private boolean ccvcFlag ;

  public SummarySettlementModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SummarySettlementModelKey, this);
  }

  public void performUpdate() {
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY62Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      String screenMode = (String)results.get(Keys.LY62_SCREEN_MODE);
      mm.getUserWebModel().setUpdateMode(screenMode);

      MappedRecord mrFieldValues = (MappedRecord)((Vector)results.get(Keys.LY62_FIELD_VALUES_Table)).get(0) ;
      xcr = (String)mrFieldValues.get(Keys.LY62_XCR_Field) ;
      ucr = (String)mrFieldValues.get(Keys.LY62_UCR_Field) ;
      tr = (String)mrFieldValues.get(Keys.LY62_TR_Field) ;
      origBkr = (String)mrFieldValues.get(Keys.LY62_PAYEE_BKR_Field) ;
      paidByCheque = (String)mrFieldValues.get(Keys.LY62_PAID_BY_CHEQUE_Field);

      Vector vctCurrencyDetails = (Vector)mrFieldValues.get(Keys.LY62_CURRENCY_DETAILS_Table ) ;
      if (vctCurrencyDetails == null)
        vctCurrencyDetails = new Vector(0);
      currencies = new Vector() ;
      for (int i = 0; i<vctCurrencyDetails.size(); i++) {
        SummSettCurrency ssc = new SummSettCurrency((MappedRecord)vctCurrencyDetails.get(i));
        if (!ssc.getOrigCurr().trim().equals(""))
          currencies.add(ssc);
        else
          break;
      }

      MappedRecord mrCommandAttributes = (MappedRecord)((Vector)results.get(Keys.LY62_COMMAND_ATTRIBUTES_Table)).get(0) ;
      releaseFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY62_RELEASE_ATTR_Field)) ;
      holdFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY62_HOLD_ATTR_Field)) ;
      deleteFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY62_DELETE_ATTR_Field)) ;
      exitFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY62_EXIT_ATTR_Field)) ;
      hideRate = ((String)mrCommandAttributes.get(Keys.LY62_HIDE_RATE_Field)).equals("Y");

      ccvcFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY62_CCVC_ATTR_Field)) ;

    } else if (event instanceof LZ03Event) {

      // The LZ03 event will occur when the user clicks a more link next to a
      // specific Collection detail.  The LZ03 contains the collection detail
      // breakdown.  Add it to the appropriate part of the model.

      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      // Get the key of the collection to add a breakdown to
      String keyCurrNo = (String)results.get(Keys.LZ03_CURR_NO_Field) ;
      String keySDNNo = (String)results.get(Keys.LZ03_SDN_NO_Field) ;
      String keyStatSplitNo = (String)results.get(Keys.LZ03_STAT_SPLIT_NO_Field) ;

      // Get the vector of breakdown data
      Vector vctBreakdownDets = (Vector)results.get(Keys.LZ03_BREAKDOWN_DETS_Table) ;

      // Find the collection to update
      int currLoop = 0 ;
      boolean currMore = true ;
      while ((currMore) && (currLoop < currencies.size())) {
        SummSettCurrency ccurr = (SummSettCurrency)currencies.get(currLoop);
        if ((ccurr.getCurrNo().equals(keyCurrNo)) && (ccurr.getSdnNo().equals(keySDNNo))) {
          // The currency has been found
          Enumeration collections = ccurr.getCollections() ;
          while (collections.hasMoreElements()) {
            SummSettCollection ccoll = (SummSettCollection)collections.nextElement() ;
            //ccoll.clearBreakdowns();
            if (ccoll.getstatSplitNo().equals(keyStatSplitNo)) {
              ccoll.addBreakdown(vctBreakdownDets);
            }
          }

          currMore = false ;
        }
        // Increment the counter for the next currency
        currLoop ++;
      }
    }
  }

  public String getXcr() {
    return xcr;
  }
  public String getUcr() {
    return ucr;
  }
  public String getTr() {
    return tr;
  }
  public String getOrigBkr() {
    return origBkr;
  }
  public Enumeration getCurrencies() {
    if (currencies == null) {
      return new Vector().elements();
    }
    else {
      return currencies.elements();
    }
  }

  public boolean getReleaseButtonFlag() {
    return releaseFlag;
  }
  public boolean getHoldButtonFlag() {
    return holdFlag;
  }
  public boolean getDeleteButtonFlag() {
    return deleteFlag;
  }
  public boolean getExitButtonFlag() {
      return exitFlag;
    }
  public boolean getCCVCButtonFlag() {
      return ccvcFlag;
    }
  public boolean hasEditableTdns() {
    for (int i=0; i<currencies.size(); i++) {
      SummSettCurrency curr =  (SummSettCurrency)currencies.get(i);
      Enumeration colls = curr.getCollections();
      while (colls.hasMoreElements()) {
        SummSettCollection coll = (SummSettCollection)colls.nextElement();
        if (!coll.gettdnFlag())
          return true;
      }
    }
    return false;
  }

  public boolean hasTreasuryRates() {
    return !hideRate;
  }
  public String getPaidByCheque() {
    return paidByCheque;
  }
}