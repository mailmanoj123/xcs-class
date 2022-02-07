package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ17Event;
import com.xchanging.xcc.events.LZ18Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementSearchResultsDetailsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  // this is the only field that is retrieved from LY18 (if that is the event which is calling this method)
  private String C117_NEXT_PROGRAM;

  //***** start of the first string of fields in the mapped record.

  // Fields defined as input keys
  private String C116_TAKE_DOWN_NO;
  private String C116_TAKE_DOWN_DATE;
  private String C116_VERSION_NO;

  // Fields defined as output keys
  private String C116_OSND_NO;
  private String C116_OSND_DATE;
  private String C116_ORIG_BKR;
  private String C116_ORIG_BKR_PSEUD;
  private String C116_YEAR_OF_ACC;
  private String C116_COR;
  private String C116_CLAIM_STATUS;
  private String C116_PAID_BY_CHEQUE;
  private String C116_CLM_REF;
  private String C116_PAYEE_BKR;
  private String C116_PAYEE_BKR_PSEUD;
  private String C116_BKR_REF_1;
  private String C116_BKR_REF_2;
  private String C116_DTI_CODE;
  private String C116_RISK_CODE;
  private String C116_MARKET_CODE;
  private String C116_FIL_CODE_1;
  private String C116_FIL_CODE_2;
  private String C116_FIL_CODE_3;
  private String C116_TRUST_FUND_CODE;
  private String C116_SCHEME_CODE;
  private String C116_ATTACHMENTS_IND;
  private String C116_SETT_PERIOD;
  private String C116_ACTUAL_PAYMENT_DATE;
  private String C116_CONTRA_APD;
  private String C116_LCO_CAT_CODE;
  private String C116_NON_SCM_ADV_IND;
  private String C116_BULK_IND;
  private String C116_COMPLETED_DATE;
  private String C116_CREATED_BY_USER;
  private String C116_NAME_1;
  private String C116_NAME_1_QUAL;
  private String C116_NAME_2;
  private String C116_NAME_2_QUAL;
  private String C116_ORIG_CCY;
  private String C116_SETT_CCY;
  private String C116_REDENOM_IND;
  private String C116_HPC_ORDER_AMOUNT;
  private String C116_RATE_EXCH;
  private String C116_HPC_SETT_AMOUNT;
  private String C116_TOTAL_LINE;
  private String C116_BUREAU_SHARE_AMOUNT;
  private String C116_HPC_VAT_AMOUNT;
  private String C116_WAR_AMOUNT;
  private String C116_FIL_1_AMOUNT;
  private String C116_FIL_2_AMOUNT;
  private String C116_CCS_DETAILS_IND;

  private String C116_CCS_DETAILS;
  private String C116_CCS_ORIG_CCY;
  private String C116_CCS_SETT_CCY ;
  private String C116_CCS_HPC_ORDER_AMOUNT;
  private String C116_ROE_TO_GBP;
  private String C116_TREASURY_RATE;
  private String C116_CCS_TOT_SETT_GBP;

  private String C116_VAT_COUNT;
  private String C116_NARRATIVE_COUNT;
  private String C116_LEAD_UWR;
  private String C116_LEAD_UWR_PC;
  private String C116_CLAIM_TOTAL_LINE;
  private String C116_LIDS_TOTAL_LINE;
  private String C116_NO_OF_LIDS_LINES;
  private String C116_NO_OF_CLAIM_LINES;

  private String C116_NARRATIVE_LINE;


  //***** end of first string of fields in the mapped record.

  // This vector will contain all the search results details- this can range from zero, up to a max of 170 returned records.
  private Vector vAllMarketDetails;
  // This vector will contain all the VAT rate details- this can range from zero, up to a max of 6 returned records.
  private Vector vatRateTable;


  // All values are initialised to blank.
  // There are no values to extract from the Mapped Record detailed below.

  public FindSettlementSearchResultsDetailsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SettSearchDetailedResultsScreenModelKey, this);
  }

  public void performUpdate() {

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LZ17Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      MappedRecord mpr = (MappedRecord) ((Vector) results.get(Keys.C116_SELECTED_VALUES)).get(0);

      C116_TAKE_DOWN_NO          = (String) mpr.get(Keys.C116_TAKE_DOWN_NO);
      C116_TAKE_DOWN_DATE        = (String) mpr.get(Keys.C116_TAKE_DOWN_DATE);
      C116_VERSION_NO            = (String) mpr.get(Keys.C116_VERSION_NO);

      MappedRecord mp1 = (MappedRecord) ((Vector) results.get(Keys.C116_SETTLEMENT_DETAILS)).get(0);

      C116_OSND_NO               = (String) mp1.get(Keys.C116_OSND_NO);
      C116_OSND_DATE             = (String) mp1.get(Keys.C116_OSND_DATE);
      C116_ORIG_BKR              = (String) mp1.get(Keys.C116_ORIG_BKR);
      C116_ORIG_BKR_PSEUD        = (String) mp1.get(Keys.C116_ORIG_BKR_PSEUD);
      C116_YEAR_OF_ACC           = (String) mp1.get(Keys.C116_YEAR_OF_ACC);
      C116_COR                   = (String) mp1.get(Keys.C116_COR);
      C116_CLAIM_STATUS          = (String) mp1.get(Keys.C116_CLAIM_STATUS);
      C116_PAID_BY_CHEQUE        = (String) mp1.get(Keys.C116_PAID_BY_CHEQUE);
      C116_CLM_REF               = (String) mp1.get(Keys.C116_CLM_REF);
      C116_PAYEE_BKR             = (String) mp1.get(Keys.C116_PAYEE_BKR);
      C116_PAYEE_BKR_PSEUD       = (String) mp1.get(Keys.C116_PAYEE_BKR_PSEUD);
      C116_BKR_REF_1             = (String) mp1.get(Keys.C116_BKR_REF_1);
      C116_BKR_REF_2             = (String) mp1.get(Keys.C116_BKR_REF_2);
      C116_DTI_CODE              = (String) mp1.get(Keys.C116_DTI_CODE);
      C116_RISK_CODE             = (String) mp1.get(Keys.C116_RISK_CODE);
      C116_MARKET_CODE           = (String) mp1.get(Keys.C116_MARKET_CODE);
      C116_FIL_CODE_1            = (String) mp1.get(Keys.C116_FIL_CODE_1);
      C116_FIL_CODE_2            = (String) mp1.get(Keys.C116_FIL_CODE_2);
      C116_FIL_CODE_3            = (String) mp1.get(Keys.C116_FIL_CODE_3);
      C116_TRUST_FUND_CODE       = (String) mp1.get(Keys.C116_TRUST_FUND_CODE);
      C116_SCHEME_CODE           = (String) mp1.get(Keys.C116_SCHEME_CODE);
      C116_ATTACHMENTS_IND       = (String) mp1.get(Keys.C116_ATTACHMENTS_IND);
      C116_SETT_PERIOD           = (String) mp1.get(Keys.C116_SETT_PERIOD);
      C116_ACTUAL_PAYMENT_DATE   = (String) mp1.get(Keys.C116_ACTUAL_PAYMENT_DATE);
      C116_CONTRA_APD            = (String) mp1.get(Keys.C116_CONTRA_APD);
      C116_LCO_CAT_CODE          = (String) mp1.get(Keys.C116_LCO_CAT_CODE);
      C116_NON_SCM_ADV_IND       = (String) mp1.get(Keys.C116_NON_SCM_ADV_IND);
      C116_BULK_IND              = (String) mp1.get(Keys.C116_BULK_IND);
      C116_COMPLETED_DATE        = (String) mp1.get(Keys.C116_COMPLETED_DATE);
      C116_CREATED_BY_USER       = (String) mp1.get(Keys.C116_CREATED_BY_USER);
      C116_NAME_1                = (String) mp1.get(Keys.C116_NAME_1);
      C116_NAME_1_QUAL           = (String) mp1.get(Keys.C116_NAME_1_QUAL);
      C116_NAME_2                = (String) mp1.get(Keys.C116_NAME_2);
      C116_NAME_2_QUAL           = (String) mp1.get(Keys.C116_NAME_2_QUAL);
      C116_ORIG_CCY              = (String) mp1.get(Keys.C116_ORIG_CCY);
      C116_SETT_CCY              = (String) mp1.get(Keys.C116_SETT_CCY);
      C116_REDENOM_IND           = (String) mp1.get(Keys.C116_REDENOM_IND);
      C116_HPC_ORDER_AMOUNT      = (String) mp1.get(Keys.C116_HPC_ORDER_AMOUNT);
      C116_RATE_EXCH             = (String) mp1.get(Keys.C116_RATE_EXCH);
      C116_HPC_SETT_AMOUNT       = (String) mp1.get(Keys.C116_HPC_SETT_AMOUNT);
      C116_TOTAL_LINE            = (String) mp1.get(Keys.C116_TOTAL_LINE);
      C116_BUREAU_SHARE_AMOUNT   = (String) mp1.get(Keys.C116_BUREAU_SHARE_AMOUNT);
      C116_HPC_VAT_AMOUNT        = (String) mp1.get(Keys.C116_HPC_VAT_AMOUNT);
      C116_WAR_AMOUNT            = (String) mp1.get(Keys.C116_WAR_AMOUNT);
      C116_FIL_1_AMOUNT          = (String) mp1.get(Keys.C116_FIL_1_AMOUNT);
      C116_FIL_2_AMOUNT          = (String) mp1.get(Keys.C116_FIL_2_AMOUNT);
      C116_CCS_DETAILS_IND       = (String) mp1.get(Keys.C116_CCS_DETAILS_IND);

      MappedRecord mp2 = (MappedRecord) ((Vector) mp1.get(Keys.C116_CCS_DETAILS)).get(0);
      C116_CCS_ORIG_CCY          = (String) mp2.get(Keys.C116_CCS_ORIG_CCY);
      C116_CCS_SETT_CCY          = (String) mp2.get(Keys.C116_CCS_SETT_CCY);
      C116_CCS_HPC_ORDER_AMOUNT  = (String) mp2.get(Keys.C116_CCS_HPC_ORDER_AMOUNT);
      C116_ROE_TO_GBP            = (String) mp2.get(Keys.C116_ROE_TO_GBP);
      C116_TREASURY_RATE         = (String) mp2.get(Keys.C116_TREASURY_RATE);
      C116_CCS_TOT_SETT_GBP      = (String) mp2.get(Keys.C116_CCS_TOT_SETT_GBP);

      C116_VAT_COUNT             = (String) mp1.get(Keys.C116_VAT_COUNT);
      C116_NARRATIVE_COUNT       = (String) mp1.get(Keys.C116_NARRATIVE_COUNT);
      C116_LEAD_UWR              = (String) mp1.get(Keys.C116_LEAD_UWR);
      C116_LEAD_UWR_PC           = (String) mp1.get(Keys.C116_LEAD_UWR_PC);
      C116_CLAIM_TOTAL_LINE      = (String) mp1.get(Keys.C116_CLAIM_TOTAL_LINE);
      C116_LIDS_TOTAL_LINE       = (String) mp1.get(Keys.C116_LIDS_TOTAL_LINE);
      C116_NO_OF_LIDS_LINES      = (String) mp1.get(Keys.C116_NO_OF_LIDS_LINES);
      C116_NO_OF_CLAIM_LINES     = (String) mp1.get(Keys.C116_NO_OF_CLAIM_LINES);

      C116_NARRATIVE_LINE = "";
      Vector claimDetails = (Vector)mp1.get(Keys.C116_NARRATIVE_DETAILS);
      if (claimDetails == null) {
        claimDetails = new Vector();
      }
      for (int i=0; i<claimDetails.size(); i++) {
        MappedRecord DetLine = (MappedRecord)claimDetails.elementAt(i);
        if (i>0)
          C116_NARRATIVE_LINE += "\n";
        C116_NARRATIVE_LINE += (String)DetLine.get(Keys.C116_NARRATIVE_LINE);
      }

      //** Start of Extract the market details lines from the Mapped Record.
      int iMarketDetailsTableSize = new Integer(C116_NO_OF_CLAIM_LINES).intValue();
      if (iMarketDetailsTableSize > 0) {
        Vector vmarketDetails =  (Vector) mp1.get(Keys.C116_MARKET_DETAILS);
        vAllMarketDetails = new Vector();
        for (int i=0; i<iMarketDetailsTableSize; i++) {
          MappedRecord mpSingleSearch = (MappedRecord)vmarketDetails.get(i);
          if (((String)mpSingleSearch.get(Keys.C115_VERSION_NO)).equals("0")) break;

          vAllMarketDetails.add(new singleMarketDetail(
              (String)mpSingleSearch.get(Keys.C116_SIGNED_LINE_PC),
              (String)mpSingleSearch.get(Keys.C116_SYND_NO),
              (String)mpSingleSearch.get(Keys.C116_SYND_REF)
          ));
        }
      }
      //** End of Extract the market details lines from the Mapped Record.

      //** Start of Extract the vat rate lines from the Mapped Record.
      int  iVATRateTableSize = new Integer(C116_VAT_COUNT).intValue() ;
      if (iVATRateTableSize > 0) {
        Vector vctVATRateTable = (Vector)mp1.get(Keys.C116_VAT_DETAILS) ;
        vatRateTable = new Vector(iVATRateTableSize) ;
        for (int i = 0; i < iVATRateTableSize; i++) {
          MappedRecord mrVATRate = (MappedRecord)vctVATRateTable.get(i) ;
          vatRateTable.add(new VATRate(
          (String)mrVATRate.get(Keys.C116_VAT_RATE),
          (String)mrVATRate.get(Keys.C116_VAT_AMOUNT)
          ));
        }
      }
      //** End of Extract the vat rate lines from the Mapped Record.

    } else  if (event instanceof LZ18Event) {
      MappedRecord results18 = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
      C117_NEXT_PROGRAM               = (String) results18.get(Keys.C117_NEXT_PROGRAM);
      }

  }

  // This getter returns all the elements within the vector. This will be called by the calling JSP only.
  public Enumeration getVAllMarketDetails() {
    return vAllMarketDetails.elements();
  }
  // This getter returns all the elements within the vector. This will be called by the calling JSP only.
  public Enumeration getVatRateTable() {
    return vatRateTable.elements();
  }
  public String getC116_ACTUAL_PAYMENT_DATE() {
    return C116_ACTUAL_PAYMENT_DATE;
  }
  public String getC116_ATTACHMENTS_IND() {
    return C116_ATTACHMENTS_IND;
  }
  public String getC116_BKR_REF_1() {
    return C116_BKR_REF_1;
  }
  public String getC116_BKR_REF_2() {
    return C116_BKR_REF_2;
  }
  public String getC116_BULK_IND() {
    return C116_BULK_IND;
  }
  public String getC116_BUREAU_SHARE_AMOUNT() {
    return C116_BUREAU_SHARE_AMOUNT;
  }
  public String getC116_CCS_DETAILS() {
    return C116_CCS_DETAILS;
  }
  public String getC116_CCS_DETAILS_IND() {
    return C116_CCS_DETAILS_IND;
  }
  public String getC116_CCS_HPC_ORDER_AMOUNT() {
    return C116_CCS_HPC_ORDER_AMOUNT;
  }
  public String getC116_CCS_ORIG_CCY() {
    return C116_CCS_ORIG_CCY;
  }
  public String getC116_CCS_SETT_CCY() {
    return C116_CCS_SETT_CCY;
  }
  public String getC116_CCS_TOT_SETT_GBP() {
    return C116_CCS_TOT_SETT_GBP;
  }
  public String getC116_CLAIM_STATUS() {
    return C116_CLAIM_STATUS;
  }
  public String getC116_CLAIM_TOTAL_LINE() {
    return C116_CLAIM_TOTAL_LINE;
  }
  public String getC116_CLM_REF() {
    return C116_CLM_REF;
  }
  public String getC116_COMPLETED_DATE() {
    return C116_COMPLETED_DATE;
  }
  public String getC116_CONTRA_APD() {
    return C116_CONTRA_APD;
  }
  public String getC116_COR() {
    return C116_COR;
  }
  public String getC116_CREATED_BY_USER() {
    return C116_CREATED_BY_USER;
  }
  public String getC116_DTI_CODE() {
    return C116_DTI_CODE;
  }
  public String getC116_FIL_1_AMOUNT() {
    return C116_FIL_1_AMOUNT;
  }
  public String getC116_FIL_2_AMOUNT() {
    return C116_FIL_2_AMOUNT;
  }
  public String getC116_FIL_CODE_1() {
    return C116_FIL_CODE_1;
  }
  public String getC116_FIL_CODE_2() {
    return C116_FIL_CODE_2;
  }
  public String getC116_FIL_CODE_3() {
    return C116_FIL_CODE_3;
  }
  public String getC116_HPC_ORDER_AMOUNT() {
    return C116_HPC_ORDER_AMOUNT;
  }
  public String getC116_HPC_SETT_AMOUNT() {
    return C116_HPC_SETT_AMOUNT;
  }
  public String getC116_HPC_VAT_AMOUNT() {
    return C116_HPC_VAT_AMOUNT;
  }
  public String getC116_LCO_CAT_CODE() {
    return C116_LCO_CAT_CODE;
  }
  public String getC116_LEAD_UWR() {
    return C116_LEAD_UWR;
  }
  public String getC116_LEAD_UWR_PC() {
    return C116_LEAD_UWR_PC;
  }
  public String getC116_LIDS_TOTAL_LINE() {
    return C116_LIDS_TOTAL_LINE;
  }
  public String getC116_MARKET_CODE() {
    return C116_MARKET_CODE;
  }
  public String getC116_NAME_1() {
    return C116_NAME_1;
  }
  public String getC116_NAME_1_QUAL() {
    return C116_NAME_1_QUAL;
  }
  public String getC116_NAME_2() {
    return C116_NAME_2;
  }
  public String getC116_NAME_2_QUAL() {
    return C116_NAME_2_QUAL;
  }
  public String getC116_NARRATIVE_COUNT() {
    return C116_NARRATIVE_COUNT;
  }
  public String getC116_NO_OF_CLAIM_LINES() {
    return C116_NO_OF_CLAIM_LINES;
  }
  public String getC116_NARRATIVE_LINE() {
    return C116_NARRATIVE_LINE;
  }
  public String getC116_NO_OF_LIDS_LINES() {
    return C116_NO_OF_LIDS_LINES;
  }
  public String getC116_NON_SCM_ADV_IND() {
    return C116_NON_SCM_ADV_IND;
  }
  public String getC116_ORIG_BKR() {
    return C116_ORIG_BKR;
  }
  public String getC116_ORIG_BKR_PSEUD() {
    return C116_ORIG_BKR_PSEUD;
  }
  public String getC116_ORIG_CCY() {
    return C116_ORIG_CCY;
  }
  public String getC116_YEAR_OF_ACC() {
    return C116_YEAR_OF_ACC;
  }
  public String getC116_WAR_AMOUNT() {
    return C116_WAR_AMOUNT;
  }
  public String getC116_VAT_COUNT() {
    return C116_VAT_COUNT;
  }
  // Required to return the VAT_COUNT to the JSP page so that the JSP does
  // not try to access an object that dosnt exist
  public int getC116_INT_VAT_COUNT() {
     int  iIntVATRateTableSize = new Integer(C116_VAT_COUNT).intValue() ;
    return iIntVATRateTableSize;
  }
  public String getC116_TRUST_FUND_CODE() {
    return C116_TRUST_FUND_CODE;
  }
  public String getC116_TREASURY_RATE() {
    return C116_TREASURY_RATE;
  }
  public String getC116_TOTAL_LINE() {
    return C116_TOTAL_LINE;
  }
  public String getC116_SETT_PERIOD() {
    return C116_SETT_PERIOD;
  }
  public String getC116_SCHEME_CODE() {
    return C116_SCHEME_CODE;
  }
  public String getC116_SETT_CCY() {
    return C116_SETT_CCY;
  }
  public String getC116_ROE_TO_GBP() {
    return C116_ROE_TO_GBP;
  }
  public String getC116_RISK_CODE() {
    return C116_RISK_CODE;
  }
  public String getC116_REDENOM_IND() {
    return C116_REDENOM_IND;
  }
  public String getC116_RATE_EXCH() {
    return C116_RATE_EXCH;
  }
  public String getC116_PAYEE_BKR_PSEUD() {
    return C116_PAYEE_BKR_PSEUD;
  }
  public String getC116_PAYEE_BKR() {
    return C116_PAYEE_BKR;
  }
  public String getC116_PAID_BY_CHEQUE() {
    return C116_PAID_BY_CHEQUE;
  }
  public String getC116_OSND_NO() {
    return C116_OSND_NO;
  }
  public String getC116_OSND_DATE() {
    return C116_OSND_DATE;
  }
  public String getC117_NEXT_PROGRAM() {
    return C117_NEXT_PROGRAM;
  }
  public String getC116_TAKE_DOWN_NO() {
    return C116_TAKE_DOWN_NO;
  }
  public String getC116_TAKE_DOWN_DATE() {
    return C116_TAKE_DOWN_DATE;
  }
  public String getC116_VERSION_NO() {
    return C116_VERSION_NO;
  }

// This inner class is used to store all the information stored in each line of
// the market details.

  public class singleMarketDetail {
    private String C116_SIGNED_LINE_PC= "";
    private String C116_SYND_NO = "";
    private String C116_SYND_REF = "";

    public singleMarketDetail(String C116_SIGNED_LINE_PC,
                              String C116_SYND_NO,
                              String C116_SYND_REF){

      this.C116_SIGNED_LINE_PC = C116_SIGNED_LINE_PC;
      this.C116_SYND_NO = C116_SYND_NO;
      this.C116_SYND_REF = C116_SYND_REF;
    }

    public String getC116_SIGNED_LINE_PC() {
      return C116_SIGNED_LINE_PC;
    }
    public String getC116_SYND_NO() {
      return C116_SYND_NO;
    }
    public String getC116_SYND_REF() {
      return C116_SYND_REF;
    }

  }


  // Inner class for VAT Rates
  public class VATRate {
    private String vatRate = "" ;
    private String vatAmt = "" ;

    public VATRate(String sVATRate, String sVATAmt) {
      this.vatRate = sVATRate!=null?sVATRate:"";
      this.vatAmt = sVATAmt!=null?sVATAmt:"";
    }


    // the getters
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

  }



}
