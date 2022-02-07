package com.xchanging.xcc.events;

/**
 Commarea - C038 (LY38)
 Program  - Associated Screen/Process:- Financial Details Screen Validation
 Devo
 */

  public class LY38Event extends ClaimsEvent implements java.io.Serializable {

    private int userSession;

    private String PAYEE_BKR_CODE;
    private String PAYEE_BKR_PSEUD;
    private String REDENOM_IND;
    private String ORIG_CURR;
    private String SETT_CURR;
    private String SETT_IND;
    private String EXCH_RATE;
    private String PAYED_TO_DATE;
    private String PAYED_THIS_TIME;
    private String OUTST_AMT;
    private String OUTST_QUAL;
    private String CLAIM_AMT_SETT;
    private String TOTAL_LINE;
    private String BUR_PROP_AMT;
    private String HPC_VAT_AMT;
    private String WAR_AMT;
    private String INCURRED_AMT;
    private String BKR_TR; //SIR:150695 ECF Phase 6 changes
    private String BKR_TR_QL; //SIR:150695 ECF Phase 6 changes
    /* Removed PREV_AMT_SETT for CCN #41
    private String PREV_AMT_SETT;
    */
    private String PEER_REV_IND;
    
   
    private String individualUCR;
    private String individualTR;

    public LY38Event(
        String PAYEE_BKR_CODE,
        String PAYEE_BKR_PSEUD,
        String REDENOM_IND,
        String ORIG_CURR,
        String SETT_CURR,
        String SETT_IND,
        String EXCH_RATE,
        String PAYED_TO_DATE,
        String PAYED_THIS_TIME,
        String OUTST_AMT,
        String OUTST_QUAL,
        String CLAIM_AMT_SETT,
        String TOTAL_LINE,
        String BUR_PROP_AMT,
        String HPC_VAT_AMT,
        String WAR_AMT,
        String INCURRED_AMT,
        
        String BKR_TR, //SIR:150695 ECF Phase 6 changes
        String BKR_TR_QL, //SIR:150695 ECF Phase 6 changes
        /* Removed PREV_AMT_SETT for CCN #41
        String PREV_AMT_SETT
        */
        String PEER_REV_IND
        ,
     
        String individualUCR,
        String individualTR
        )
    {
      this.PAYEE_BKR_CODE = PAYEE_BKR_CODE;
      this.PAYEE_BKR_PSEUD = PAYEE_BKR_PSEUD;
      this.REDENOM_IND = REDENOM_IND;
      this.ORIG_CURR = ORIG_CURR;
      this.SETT_CURR = SETT_CURR;
      this.SETT_IND = SETT_IND;
      this.EXCH_RATE = EXCH_RATE;
      this.PAYED_TO_DATE = PAYED_TO_DATE;
      this.PAYED_THIS_TIME = PAYED_THIS_TIME;
      this.OUTST_AMT = OUTST_AMT;
      this.OUTST_QUAL = OUTST_QUAL;
      this.CLAIM_AMT_SETT = CLAIM_AMT_SETT;
      this.TOTAL_LINE = TOTAL_LINE;
      this.BUR_PROP_AMT = BUR_PROP_AMT;
      this.HPC_VAT_AMT = HPC_VAT_AMT;
      this.WAR_AMT = WAR_AMT;
      this.INCURRED_AMT = INCURRED_AMT;
      
      this.BKR_TR = BKR_TR; //SIR:150695 ECF Phase 6 changes
      this.BKR_TR_QL=BKR_TR_QL; //SIR:150695 ECF Phase 6 changes
      /* Removed PREV_AMT_SETT for CCN #41
      this.PREV_AMT_SETT = PREV_AMT_SETT;
      */
      this.PEER_REV_IND = PEER_REV_IND;
  
      this.individualUCR = individualUCR;
      this.individualTR = individualTR;
    }

    public String getName() {
      return "java:comp/env/event/LY38Event";
    }

    public int getType() {
    return VALIDATE;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY38CICSHandler";
    }

    public int getUserSession() {
      return userSession;
    }

    public void setUserSession(int userSession) {
      this.userSession = userSession;
    }

    /*
      Need to add getters as the CICS Handler needs to get the data out of the
      event
    */

  public String getBUR_PROP_AMT() {
    return BUR_PROP_AMT;
  }
  public String getCLAIM_AMT_SETT() {
    return CLAIM_AMT_SETT;
  }
  public String getEXCH_RATE() {
    return EXCH_RATE;
  }
  public String getHPC_VAT_AMT() {
    return HPC_VAT_AMT;
  }
  public String getINCURRED_AMT() {
    return INCURRED_AMT;
  }
  public String getORIG_CURR() {
    if (ORIG_CURR==null)
      return "";
    else
      return ORIG_CURR;
  }
  public String getOUTST_AMT() {
    return OUTST_AMT;
  }
  public String getOUTST_QUAL() {
    return OUTST_QUAL;
  }
  public String getPAYED_THIS_TIME() {
    return PAYED_THIS_TIME;
  }
  public String getPAYED_TO_DATE() {
    return PAYED_TO_DATE;
  }
  public String getPAYEE_BKR_CODE() {
    return PAYEE_BKR_CODE;
  }
  public String getPAYEE_BKR_PSEUD() {
    return PAYEE_BKR_PSEUD;
  }
  /* Removed PREV_AMT_SETT for CCN #41
  public String getPREV_AMT_SETT() {
    return PREV_AMT_SETT;
  }
  */
  public String getREDENOM_IND() {
    return REDENOM_IND;
  }
  public String getSETT_CURR() {
    if (SETT_CURR==null)
      return "";
    else
      return SETT_CURR;
  }
  public String getSETT_IND() {
    return SETT_IND;
  }
  public String getTOTAL_LINE() {
    return TOTAL_LINE;
  }
  public String getWAR_AMT() {
    return WAR_AMT;
  }

//SIR:150695 ECF Phase 6 changes: Start
public String getBKR_TR() {
	return BKR_TR;
}

public String getBKR_TR_QL() {
        return BKR_TR_QL;
}

public String getPEER_REV_IND() {
        return PEER_REV_IND;
}


//SIR:150695 ECF Phase 6 changes - end

//Binders fields


public String getIndividualUCR() {
	return individualUCR;
}

public String getIndividualTR() {
	return individualTR;
}
//Binders field end

}
