package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY38Event;
import com.xchanging.xcc.events.LY39Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FinancialDetailsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String screenMode = "";
  private String ucr = "";
  private String xcr = "";
  private String tr = "";
  private String cor = "";
  private String osnd1 = "";
  private String osnd2 = "";
  private String osnd3 = "";
  private String origBkr = "";
  private String signed = "";
  private String peerReview = "";
  private boolean peerReviewFlag  ;
  private String payeeBroker = "";
  private String payeeBrokerFlag;
  private String payeeBrokerPseud = "";
  private String payeeBrokerPseudFlag;
  private String redenomInd = "";
  private String redenomsFlag;
  public  String origCcy = "";
  private boolean origCcyFlag;
  private String pTDTotal = "";
  private String pTDTotalFlag;
  private String pTTTotal = "";
  private String pTTTotalFlag;
  private String osTotal = "";
  private String osTotalFlag;
  private String osTotalQual = "";
  private boolean osTotalQualFlag;
  private String settCcy = "";
  private boolean settCcyFlag;
  private String settRateOfExch = "";
  private String settRateOfExchFlag;
  private String settledInSettCcy = "";
  private String settledInSettCcyFlag;
  private String totalLine = "";
  private String totalLineFlag;
  private String bureauPpnAmt = "";
  private String bureauPpnAmtFlag;
  private String vatAmt = "";
  private String vatAmtFlag;
  private String warAmount = "";
  private String warAmountFlag;
  private String incurred = "";
  private String incurredFlag;
  /* Removed prevSettled for CCN #41
  private String prevSettled = "";
  private String prevSettledFlag;
  */
  private String settCcyInd;
  private String settCcyIndFlag;
  private String NV_settCcyInd;
  
//SIR:150695 -ECF Phase 6 changes - start*/
  private String brokerTr = "";
  private String brokerTrFlag;
  private String brokerTrQual = "";
  private boolean brokerTrQualFlag;  
//SIR:150695 -ECF Phase 6 changes - end*/


  // Error Flags
  private boolean payeeBrokerErr;
  private boolean payeeBrokerPseudErr;
  private boolean redenomErr;
  private boolean peerReviewErr;
  private boolean origCcyErr;
  private boolean pTDTotalErr;
  private boolean pTTTotalErr;
  private boolean osTotalErr;
  private boolean osTotalQualErr;
  private boolean settCcyErr;
  private boolean settRateOfExchErr;
  private boolean settledInSettCcyErr;
  private boolean totalLineErr;
  private boolean bureauPpnAmtErr;
  private boolean vatAmtErr;
  private boolean warAmountErr;
  private boolean incurredErr;
  /* Removed prevSettledErr for CCN #41
  private boolean prevSettledErr;
  */
  
//SIR:150695 -ECF Phase 6 changes - Start*/
  private boolean brokerTrErr; 
  private boolean brokerTrQualErr;
//SIR:150695 -ECF Phase 6 changes - End*/
  
  
  private boolean saveButtonFlag;
  
  /*Binders Attributes */
 
  private String individualUCR="";
  private String individualUCRFlag;
  private String individualTR="";
  private String individualTRFlag;
  
  public FinancialDetailsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.FinancialDetailsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute((Keys.WebEventKey));

    if (event instanceof LY37Event) {

      screenMode = (String)results.get(Keys.LY37_SCREEN_MODE);
      mm.getUserWebModel().setUpdateMode(screenMode);

      if (screenMode.equals("E"))
          {saveButtonFlag = true;}
      else {saveButtonFlag = false;}


      MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY37_FIELD_VALUES)).get(0);

      xcr = (String)fieldValues.get(Keys.LY37_XCR);
      ucr = (String)fieldValues.get(Keys.LY37_UCR);
      tr = (String)fieldValues.get(Keys.LY37_TR);
      osnd1 = (String)fieldValues.get(Keys.LY37_ORIG_REF_1);
      osnd2 = (String)fieldValues.get(Keys.LY37_ORIG_REF_2);  //extra value
      osnd3 = (String)fieldValues.get(Keys.LY37_ORIG_REF_3);  //extra value

      /**
       * LOOK!!! EXPECTED COR FROM COMMAREA BUT NOT RETUNED. LEFT BLANK.
       */
      cor = "";

      origBkr = (String)fieldValues.get(Keys.LY37_ORIG_BKR);
      signed = (String)fieldValues.get(Keys.LY37_SIGNED_IND);
      
      peerReview = (String)fieldValues.get(Keys.LY37_PEER_REV_IND);

      payeeBroker = (String)fieldValues.get(Keys.LY37_PAYEE_BKR_CODE);
      payeeBrokerPseud = (String)fieldValues.get(Keys.LY37_PAYEE_BKR_PSEUD);
      redenomInd = (String)fieldValues.get(Keys.LY37_REDENOM_IND);
      origCcy = (String)fieldValues.get(Keys.LY37_ORIG_CURR);
      settCcy = (String)fieldValues.get(Keys.LY37_SETT_CURR);
      settRateOfExch = (String)fieldValues.get(Keys.LY37_EXCH_RATE);
      pTDTotal = (String)fieldValues.get(Keys.LY37_PAYED_TO_DATE);
      pTTTotal = (String)fieldValues.get(Keys.LY37_PAYED_THIS_TIME);
      osTotal = (String)fieldValues.get(Keys.LY37_OUTST_AMT);
      osTotalQual = (String)fieldValues.get(Keys.LY37_OUTST_QUAL);
      settledInSettCcy = (String)fieldValues.get(Keys.LY37_CLAIM_AMT_SETT);  //is this mapping correct??
      totalLine = (String)fieldValues.get(Keys.LY37_TOTAL_LINE);
      bureauPpnAmt = (String)fieldValues.get(Keys.LY37_BUR_PROP_AMT);
      vatAmt = (String)fieldValues.get(Keys.LY37_HPC_VAT_AMT);
      warAmount = (String)fieldValues.get(Keys.LY37_WAR_AMT);
      incurred = (String)fieldValues.get(Keys.LY37_INCURRED_AMT);
      /* Removed prevSettled for CCN #41
      prevSettled = (String)fieldValues.get(Keys.LY37_PREV_AMT_SETT);
      */
      NV_settCcyInd = (String)fieldValues.get(Keys.LY37_SETT_IND);
      settCcyInd =  checkBoxStatus((String)fieldValues.get(Keys.LY37_SETT_IND));
      
      brokerTrQual = (String)fieldValues.get(Keys.LY37_BKR_TR_QUAL); //SIR:150695 -ECF Phase 6 changes
      brokerTr = (String)fieldValues.get(Keys.LY37_BKR_TR);  						//SIR:150695 -ECF Phase 6 changes

      //Binders changes
     
      individualUCR = (String)fieldValues.get(Keys.LY37_INDV_UCR);
      individualTR = (String)fieldValues.get(Keys.LY37_INDV_TR);
      
      MappedRecord AttrValues = (MappedRecord)((Vector)results.get(Keys.LY37_FIELD_ATTRIBUTES)).get(0);

      payeeBrokerFlag      = enabledStatus((String)AttrValues.get(Keys.LY37_PAYEE_BKR_ATTR));
      payeeBrokerPseudFlag = enabledStatus((String)AttrValues.get(Keys.LY37_PAY_BKR_PSD_ATTR));
      redenomsFlag         = enabledStatus((String)AttrValues.get(Keys.LY37_REDENOM_ATTR));
      
      peerReviewFlag       = convertToBoolean((String)AttrValues.get(Keys.LY37_PEER_REV_ATTR));
      
      origCcyFlag          = convertToBoolean((String)AttrValues.get(Keys.LY37_ORIG_CURR_ATTR));
      settCcyFlag          = convertToBoolean((String)AttrValues.get(Keys.LY37_SETT_CURR_ATTR));
      settRateOfExchFlag   = enabledStatus((String)AttrValues.get(Keys.LY37_EXCH_RATE_ATTR));
      settledInSettCcyFlag = enabledStatus((String)AttrValues.get(Keys.LY37_CLM_AMT_SETT_ATTR));
      pTDTotalFlag         = enabledStatus((String)AttrValues.get(Keys.LY37_PTD_ATTR));
      pTTTotalFlag         = enabledStatus((String)AttrValues.get(Keys.LY37_PTT_ATTR));
      osTotalFlag          = enabledStatus((String)AttrValues.get(Keys.LY37_OUTST_AMT_ATTR));
      osTotalQualFlag      = convertToBoolean((String)AttrValues.get(Keys.LY37_OUTST_QUAL_ATTR));
      totalLineFlag        = enabledStatus((String)AttrValues.get(Keys.LY37_TOTAL_LINE_ATTR));
      bureauPpnAmtFlag     = enabledStatus((String)AttrValues.get(Keys.LY37_BUR_PROP_ATTR));
      vatAmtFlag           = enabledStatus((String)AttrValues.get(Keys.LY37_VAT_AMT_ATTR));
      warAmountFlag        = enabledStatus((String)AttrValues.get(Keys.LY37_WAR_AMT_ATTR));
      incurredFlag         = enabledStatus((String)AttrValues.get(Keys.LY37_INCURRED_ATTR));
      /* Removed prevSettledFlag for CCN #41
      prevSettledFlag      = enabledStatus((String)AttrValues.get(Keys.LY37_PREV_SETT_ATTR));
      */
      settCcyIndFlag       = enabledStatusCheckbox((String)AttrValues.get(Keys.LY37_SETT_IND_ATTR));
      
      brokerTrFlag =  enabledStatus((String)AttrValues.get(Keys.LY37_BKR_TR_ATTR));			//SIR:150695 -ECF Phase 6 changes
      brokerTrQualFlag = convertToBoolean((String)AttrValues.get(Keys.LY37_BKR_TR_QUAL_ATTR));   //SIR:150695 -ECF Phase 6 changes
      
      //Binders changes
     
     
      individualUCRFlag = enabledStatus((String)AttrValues.get(Keys.LY37_INDV_UCR_ATTR));
      individualTRFlag = enabledStatus((String)AttrValues.get(Keys.LY37_INDV_TR_ATTR));
      

    } else if (event instanceof LY38Event) {

      MappedRecord fieldErrors = (MappedRecord)((Vector)results.get(Keys.LY38_FIELD_ERRORS)).get(0);

      payeeBrokerErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_PAYEE_BKR_ERR));
      payeeBrokerPseudErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_PAY_BKR_PSD_ERR));
      redenomErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_REDENOM_ERR));
      peerReviewErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_PEER_REV_ERR));
      origCcyErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_ORIG_CURR_ERR));
      pTDTotalErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_PTD_ERR));
      pTTTotalErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_PTT_ERR));
      osTotalErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_OUTST_AMT_ERR));
      osTotalQualErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_OUTST_QUAL_ERR));
      settCcyErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_SETT_CURR_ERR));
      settRateOfExchErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_EXCH_RATE_ERR));
      settledInSettCcyErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_CLM_AMT_SETT_ERR));
      totalLineErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_TOTAL_LINE_ERR));
      bureauPpnAmtErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_BUR_PROP_ERR));
      vatAmtErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_VAT_AMT_ERR));
      warAmountErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_WAR_AMT_ERR));
      incurredErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_INCURRED_ERR));
      /* Removed prevSettledErr for CCN #41
      prevSettledErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_PREV_SETT_ERR));
      */
      
      brokerTrErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_BKR_TR_ERR));       //SIR:150695 -ECF Phase 6 changes
      brokerTrQualErr = convertToBoolean((String)fieldErrors.get(Keys.LY38_BKR_TR_QUAL_ERR));//SIR:150695 -ECF Phase 6 changes
      
      
      
       
      
      convertToBoolean((String)fieldErrors.get(Keys.LY38_INDV_UCR_ERR)); 
      convertToBoolean((String)fieldErrors.get(Keys.LY38_INDV_TR_ERR));
      

    } else if (event instanceof LY39Event) {

      MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY39_FIELD_VALUES)).get(0);

      xcr = (String)fieldValues.get(Keys.LY39_XCR);
      ucr = (String)fieldValues.get(Keys.LY39_UCR);
      tr = (String)fieldValues.get(Keys.LY39_TR);
      osnd1 = (String)fieldValues.get(Keys.LY39_ORIG_REF_1);
      osnd2 = (String)fieldValues.get(Keys.LY39_ORIG_REF_2);  //extra value
      osnd3 = (String)fieldValues.get(Keys.LY39_ORIG_REF_3);  //extra value

      /**
       * LOOK!!! EXPECTED COR FROM COMMAREA BUT NOT RETUNED. LEFT BLANK.
       */
      cor = "";

      origBkr = (String)fieldValues.get(Keys.LY39_ORIG_BKR);
      signed = (String)fieldValues.get(Keys.LY39_SIGNED_IND);
      peerReview = (String)fieldValues.get(Keys.LY39_PEER_REV_IND);
      payeeBroker = (String)fieldValues.get(Keys.LY39_PAYEE_BKR_CODE);
      payeeBrokerPseud = (String)fieldValues.get(Keys.LY39_PAYEE_BKR_PSEUD);
      redenomInd = (String)fieldValues.get(Keys.LY39_REDENOM_IND);
      origCcy = (String)fieldValues.get(Keys.LY39_ORIG_CURR);
      settCcy = (String)fieldValues.get(Keys.LY39_SETT_CURR);
      settRateOfExch = (String)fieldValues.get(Keys.LY39_EXCH_RATE);
      pTDTotal = (String)fieldValues.get(Keys.LY39_PAYED_TO_DATE);
      pTTTotal = (String)fieldValues.get(Keys.LY39_PAYED_THIS_TIME);
      osTotal = (String)fieldValues.get(Keys.LY39_OUTST_AMT);
      osTotalQual = (String)fieldValues.get(Keys.LY39_OUTST_QUAL);
      settledInSettCcy = (String)fieldValues.get(Keys.LY39_CLAIM_AMT_SETT);  //is this mapping correct??
      totalLine = (String)fieldValues.get(Keys.LY39_TOTAL_LINE);
      bureauPpnAmt = (String)fieldValues.get(Keys.LY39_BUR_PROP_AMT);
      vatAmt = (String)fieldValues.get(Keys.LY39_HPC_VAT_AMT);
      warAmount = (String)fieldValues.get(Keys.LY39_WAR_AMT);
      incurred = (String)fieldValues.get(Keys.LY39_INCURRED_AMT);

      NV_settCcyInd = (String)fieldValues.get(Keys.LY39_SETT_IND);
      settCcyInd =  checkBoxStatus((String)fieldValues.get(Keys.LY39_SETT_IND));
      
      brokerTr = (String)fieldValues.get(Keys.LY39_BKR_TR);	//SIR:150695 -ECF Phase 6 changes
      brokerTrQual = (String)fieldValues.get(Keys.LY39_BKR_TR_QUAL); //SIR:150695 -ECF Phase 6 changes
      
    //Binders changes
      
      individualUCR = (String)fieldValues.get(Keys.LY38_INDV_UCR);
      individualTR = (String)fieldValues.get(Keys.LY38_INDV_TR);
    }

  }

  public String getSettCcyInd() {
    return settCcyInd;
  }

  public String getSettCcyIndFlag() {
    return settCcyIndFlag;
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


  public String getCor() {
    return cor;
  }

  public String getPayeeBroker() {
    return payeeBroker;
  }

  public String getPayeeBrokerFlag() {
    return payeeBrokerFlag;
  }

  public String getPayeeBrokerPseud() {
    return payeeBrokerPseud;
  }

  public String getPayeeBrokerPseudFlag() {
    return payeeBrokerPseudFlag;
  }

  public String getRedenomInd() {
    return redenomInd;
  }

  public String getRedenomsFlag() {
    return redenomsFlag;
  }

  public String getOrigCcy() {
    return origCcy;
  }

  public boolean getOrigCcyFlag() {
      return origCcyFlag;
    }

  public boolean getPeerReviewFlag() {
      return peerReviewFlag;
    }


  public String getPTDTotalFlag() {
    return pTDTotalFlag;
  }


  public String getOsTotal() {
    Double d = new Double(osTotal);
    String str = Long.toString(d.longValue());
    return removeDecimals(str);
  }

  public String getOsTotalFlag() {
    return osTotalFlag;
  }

  public String getOsTotalQual() {
    return osTotalQual;
  }

  public boolean getOsTotalQualFlag() {
    return osTotalQualFlag;
  }

  public String getSettCcy() {
    return settCcy;
  }

  public boolean getSettCcyFlag() {
    return settCcyFlag;
  }

  public String getSettRateOfExch() {
    return settRateOfExch;
  }

  public String getSettRateOfExchFlag() {
    return settRateOfExchFlag;
  }

  public String getSettledInSettCcy() {
    return settledInSettCcy;
  }

  public String getSettledInSettCcyFlag() {
    return settledInSettCcyFlag;
  }

  public String getTotalLine() {
    return totalLine;
  }

  public String getTotalLineFlag() {
    return totalLineFlag;
  }

  public String getBureauPpnAmt() {
    return bureauPpnAmt;
  }

  public String getBureauPpnAmtFlag() {
    return bureauPpnAmtFlag;
  }

  public String getVatAmt() {
    return vatAmt;
  }

  public String getVatAmtFlag() {
    return vatAmtFlag;
  }

  public String getWarAmount() {
    return warAmount;
  }

  public String getWarAmountFlag() {
    return warAmountFlag;
  }

  public String getIncurred() {
    return incurred;
  }

  public String getIncurredFlag() {
    return incurredFlag;
  }
  /* Removed prevSettled for CCN #41
  public String getPrevSettled() {
    return prevSettled;
  }
  */

  /* Removed prevSettledFlag for CCN #41
  public String getPrevSettledFlag() {
    return prevSettledFlag;
  }
  */

  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }

  public String getOrigBkr() {
    return origBkr;
  }
  public String getPeerReview() {
    return peerReview;
  }
  public String getSigned() {
    return signed;
  }
  public String getOsnd1() {
    return osnd1;
  }
  public String getOsnd2() {
    return osnd2;
  }
  public String getOsnd3() {
    return osnd3;
  }
  public String getScreenMode() {
    return screenMode;
  }
  public String getPTDTotal() {
    return pTDTotal;
  }
  public String getPTTTotal() {
    return pTTTotal;
  }
  public String getPTTTotalFlag() {
    return pTTTotalFlag;
  }
  public boolean isBureauPpnAmtErr() {
    return bureauPpnAmtErr;
  }
  public boolean isIncurredErr() {
    return incurredErr;
  }
  public boolean isOrigCcyErr() {
      return origCcyErr;
    }
  public boolean isPeerRevErr() {
      return peerReviewErr;
    }
  public boolean isOsTotalErr() {
    return osTotalErr;
  }
  public boolean isOsTotalQualErr() {
    return osTotalQualErr;
  }
  public boolean isPayeeBrokerErr() {
    return payeeBrokerErr;
  }
  public boolean isPayeeBrokerPseudErr() {
    return payeeBrokerPseudErr;
  }
  /* Removed prevSettledErr for CCN #41
  public boolean isPrevSettledErr() {
    return prevSettledErr;
  } */
  public boolean isPTDTotalErr() {
    return pTDTotalErr;
  }
  public boolean isPTTTotalErr() {
    return pTTTotalErr;
  }
  public boolean isRedenomErr() {
    return redenomErr;
  }
  public boolean isSettCcyErr() {
    return settCcyErr;
  }
  public boolean isSettledInSettCcyErr() {
    return settledInSettCcyErr;
  }
  public boolean isSettRateOfExchErr() {
    return settRateOfExchErr;
  }
  public boolean isTotalLineErr() {
    return totalLineErr;
  }
  public boolean isVatAmtErr() {
    return vatAmtErr;
  }
  public boolean isWarAmountErr() {
    return warAmountErr;
  }
  public String getNV_settCcyInd() {
    return NV_settCcyInd;
  }

//SIR:150695 -ECF Phase 6 changes - start
  
public String getBrokerTr() {
	return brokerTr;
}

public void setBrokerTr(String brokerTr) {
	this.brokerTr = brokerTr;
}

public String getBrokerTrFlag() {
	return brokerTrFlag;
}

public void setBrokerTrFlag(String brokerTrFlag) {
	this.brokerTrFlag = brokerTrFlag;
}

public String getBrokerTrQual() {
	return brokerTrQual;
}

public void setBrokerTrQual(String brokerTrQual) {
	this.brokerTrQual = brokerTrQual;
}

public boolean getBrokerTrQualFlag() {
	return brokerTrQualFlag;
}

public void setBrokerTrQualFlag(boolean brokerTrQualFlag) {
	this.brokerTrQualFlag = brokerTrQualFlag;
}

public boolean isBrokerTrErr() {
	return brokerTrErr;
}

public void setBrokerTrErr(boolean brokerTrErr) {
	this.brokerTrErr = brokerTrErr;
}

public boolean isBrokerTrQualErr() {
	return brokerTrQualErr;
}

public void setBrokerTrQualErr(boolean brokerTrQualErr) {
	this.brokerTrQualErr = brokerTrQualErr;
}



public String getIndividualUCR() {
	return individualUCR;
}

public String getIndividualUCRFlag() {
	return individualUCRFlag;
}

public String getIndividualTR() {
	return individualTR;
}

public String getIndividualTRFlag() {
	return individualTRFlag;
}

//SIR:150695 -ECF Phase 6 changes - End 



}