package com.xchanging.xcc.events;

/**
 Commarea - C039 (LY39)
 Program  - Associated Screen/Process:- Financial Details Screen Validation
 Devo
 */

  public class LY39Event extends ClaimsEvent implements java.io.Serializable {

    private int userSession;

    private String XCR;
    private String UCR;
    private String TR;
    private String ORIG_REF_1;
    private String ORIG_REF_2;
    private String ORIG_REF_3;
    private String ORIG_BKR;
    private String SIGNED_IND;
    private String PEER_REV_IND;
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
    
    //Binders changes
    
    private String individualUCR;
    private String individualTR;

    
    public LY39Event(
        String XCR,
        String UCR,
        String TR,
        String ORIG_REF_1,
        String ORIG_REF_2,
        String ORIG_REF_3,
        String ORIG_BKR,
        String SIGNED_IND,
        String PEER_REV_IND,
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
        String BKR_TR_QL,
        //Binders changes
      
        String individualUCR,
        String individualTR
        ) //SIR:150695 ECF Phase 6 changes)
    {
      this.XCR = XCR;
      this.UCR = UCR;
      this.TR = TR;
      this.ORIG_REF_1 = ORIG_REF_1;
      this.ORIG_REF_2 = ORIG_REF_2;
      this.ORIG_REF_3 = ORIG_REF_3;
      this.ORIG_BKR = ORIG_BKR;
      this.SIGNED_IND = SIGNED_IND;
      this.PEER_REV_IND = PEER_REV_IND;
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
    
      this.individualUCR = individualUCR;
      this.individualTR = individualTR;
    }

    public String getName() {
      return "java:comp/env/event/LY39Event";
    }

    public int getType() {
    return UPDATE;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY39CICSHandler";
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
  public String getREDENOM_IND() {
    return REDENOM_IND;
  }
  public String getSETT_CURR() {
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
  public String getORIG_BKR() {
    return ORIG_BKR;
  }
  public String getORIG_REF_1() {
    return ORIG_REF_1;
  }
  public String getORIG_REF_2() {
    return ORIG_REF_2;
  }
  public String getORIG_REF_3() {
    return ORIG_REF_3;
  }
  public String getPEER_REV_IND() {
    return PEER_REV_IND;
  }
  public String getSIGNED_IND() {
    return SIGNED_IND;
  }
  public String getTR() {
    return TR;
  }
  public String getUCR() {
    return UCR;
  }
  public String getXCR() {
    return XCR;
  }

//SIR:150695 ECF Phase 6 changes: Start
  public String getBKR_TR() {
  	return BKR_TR;
  }

  public String getBKR_TR_QL() {
  	return BKR_TR_QL;
  }

	
	
	public String getIndividualUCR() {
		return individualUCR;
	}
	
	public String getIndividualTR() {
		return individualTR;
	}

//  SIR:150695 ECF Phase 6 changes - end
  
  
}
