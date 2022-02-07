package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY44Event;
import com.xchanging.xcc.events.LY45Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class VATRatesModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String totalPercentVATAmount = "";
  private Vector vatRateTable = new Vector(6);


  public VATRatesModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.VATRatesModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY45Event) {
      MappedRecord mrFieldValues = (MappedRecord)((Vector)results.get(Keys.LY45_FIELD_VALUES)).get(0) ;

      Vector vctVATRateTable = (Vector)mrFieldValues.get(Keys.LY45_VAT_RATE_TABLE) ;
      vatRateTable = new Vector(6) ;
      for (int i = 0; i < 6; i++) {
        MappedRecord mrVATRate = (MappedRecord)vctVATRateTable.get(i) ;
        vatRateTable.add(new VATRate(
                                     (String)mrVATRate.get(Keys.LY45_VAT_RATE),
                                     (String)mrVATRate.get(Keys.LY45_VAT_AMT)));
      }
    } else if (event instanceof LY44Event) {
      MappedRecord mrFieldValues = (MappedRecord)((Vector)results.get(Keys.LY44_FIELD_VALUES)).get(0) ;

      Vector vctVATRateTable = (Vector)mrFieldValues.get(Keys.LY44_VAT_RATE_TABLE) ;
      vatRateTable = new Vector(6) ;
      for (int i = 0; i < 6; i++) {
        MappedRecord mrVATRate = (MappedRecord)vctVATRateTable.get(i) ;
        vatRateTable.add(new VATRate(
                                     (String)mrVATRate.get(Keys.LY44_VAT_RATE),
                                     (String)mrVATRate.get(Keys.LY44_VAT_AMT)));
      }
    } else if (event instanceof LY43Event) {
      MappedRecord mrFieldValues = (MappedRecord)((Vector)results.get(Keys.LY43_FIELD_VALUES)).get(0) ;
      MappedRecord mrFieldAttributes = (MappedRecord)((Vector)results.get(Keys.LY43_FIELD_ATTRIBUTES)).get(0);

      Vector vctVATRateTable = (Vector)mrFieldValues.get(Keys.LY43_VAT_RATE_TABLE) ;
      Vector vctVATRateFlags = (Vector)mrFieldAttributes.get(Keys.LY43_VAT_RATE_ATTRS) ;

      vatRateTable = new Vector(6) ;
      for (int i = 0; i < 6; i++) {
        MappedRecord mrVATRate = (MappedRecord)vctVATRateTable.get(i) ;
        MappedRecord mrVATRateFlags = (MappedRecord)vctVATRateFlags.get(i) ;

        VATRate rate = new VATRate((String)mrVATRate.get(Keys.LY43_VAT_RATE),
                                   (String)mrVATRate.get(Keys.LY43_VAT_AMT));

        rate.addFlags(convertToBoolean((String)mrVATRateFlags.get(Keys.LY43_VAT_RATE_ATTR)),
                      enabledStatus((String)mrVATRateFlags.get(Keys.LY43_VAT_ATTR)));

        vatRateTable.add(rate);
      }
    }
  }
  public Enumeration getVatRates() {
    return vatRateTable.elements();
  }

  public String[] getRates() {
    String[] array = new String[6];
    for (int i=0; i<vatRateTable.size(); i++) {
      array[i] = ((VATRate)vatRateTable.elementAt(i)).getVatRate();
    }

    return array;
  }

  public String[] getAmts() {
    String[] array = new String[6];
    for (int i=0; i<vatRateTable.size(); i++) {
      array[i] = ((VATRate)vatRateTable.elementAt(i)).getVatAmt();
    }

    return array;
  }

  public void setVatRates(String rate1, String amt1,
                          String rate2, String amt2,
                          String rate3, String amt3,
                          String rate4, String amt4,
                          String rate5, String amt5,
                          String rate6, String amt6) {

    vatRateTable = new Vector(6);
    vatRateTable.add(new VATRate(rate1,amt1));
    vatRateTable.add(new VATRate(rate2,amt2));
    vatRateTable.add(new VATRate(rate3,amt3));
    vatRateTable.add(new VATRate(rate4,amt4));
    vatRateTable.add(new VATRate(rate5,amt5));
    vatRateTable.add(new VATRate(rate6,amt6));
  }

  // Inner class for VAT Rates
  public class VATRate {
    private String vatRate = "" ;
    private String vatAmt = "" ;
    private boolean vatRateFlag ;
    private String vatAmtFlag ;

    public VATRate(String sVATRate, String sVATAmt) {
      this.vatRate = sVATRate!=null?sVATRate:"";
      this.vatAmt = sVATAmt!=null?sVATAmt:"";
    }
    public void addFlags(boolean bVATRate, String bVATAmt) {
      this.vatRateFlag = bVATRate ;
      this.vatAmtFlag = bVATAmt ;
    }

    public String getVatRate() {
      int point = vatRate.indexOf(".");
      if (point < 0) {
        vatRate = vatRate + ".00";
      }
      else {
        String temp = vatRate.substring(point+1,vatRate.length());
        if (temp.length() < 2) {
          vatRate = vatRate + "0";
        }
      }
      return vatRate ;
    }

    public String getVatAmt() {
      return vatAmt ;
    }

    public boolean getVatRateFlag() {
      return vatRateFlag ;
    }

    public String getVatAmtFlag() {
      return vatAmtFlag ;
    }
  }
}
