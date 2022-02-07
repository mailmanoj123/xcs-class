package com.xchanging.xcc.events;

import java.util.Enumeration;
import java.util.Vector;

public class LY44Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String  CURR_NO_VAL;
  private String  SDN_NO_VAL;
  private String  BDOWN_NO_VAL;
  private String  CLM_REF_REC;
  private String  ORIG_CURR;
  private String  SETT_CURR;
  private String  EXCH_RATE;
  private String  PTD_LOSS;
  private String  PTD_EXP;
  private String  PTD_FEE;
  private String  PTD_TOTAL;
  private String  PTT_LOSS;
  private String  PTT_EXP;
  private String  PTT_FEE;
  private String  PTT_TOTAL;
  private String  OUTST_LOSS;
  private String  OUTST_LOSS_QUAL;
  private String  OUTST_EXP;
  private String  OUTST_FEE;
  private String  OUTST_FEE_QUAL;
  private String  OUTST_TOT;
  private String  OUTST_TOT_QUAL;
  private String  PTD_SETT_AMT;
  private String  CLAIM_AMT_SETT;
  private String  BUREAU_LINE;
  private String  BUR_PROP_AMT;
  private String  HPC_VAT_AMT;
  private String[] VAT_RATE;
  private String[] VAT_AMT;
  private String  WAR_AMT;
  private String  NARR_CODE_1;
  private String  NARR_CODE_2;
  private String  SETT_NARR_1;
  private String  SETT_NARR_2;
  private String  SETT_NARR_3;
  private String  SUBROGATION;
  private String  XCS_REC_REF;
  private String  HIGHEST_EST;
  private String  INCURRED_AMT;
  private String  RATE_EXCH_OUTST;
  private String  FINDER_CODE_1;
  private String  FINDER_CODE_2;
  private String  FINDER_CODE_3;
  private String  ATTACHMENT_IND;
//  private String  CASH_COR;
  private String  BKR_CNTCT;
  private String  BKR_CNTCT_PHONE;
  private String  BKR_REF_1;
  private String  BKR_REF_2;
  private String  CNTRY_OF_ORIGIN;
  private String  ORIG_INSURED;
  private String  INSURED;
  private String  REINSURED;
  private String  COVER_HOLDER;
  private String  CLAIMANT;
  private String  VESSEL_AIRCRAFT;
  private String  OTHER_NAME;
  private String  POL_CERT_FROM;
  private String  POL_CERT_TO;
  private String  POL_CERT_QUAL;
  private String  LOSS_DATE_FROM;
  private String  LOSS_DATE_TO;
  private String  LOSS_DATE_QUAL;
  private String  LOSS_DATE_NARR;
  private String  CLAIM_DATE_FROM;
  private String  CLAIM_DATE_TO;
  private String  CLAIM_DATE_QUAL;
  private String  CAT_CODE;
  private String  PCS_CAT_CODE;
  private String  LIMIT_CURR;
  private String  SI_LIMIT;
  private String  EXCESS_AMT;
  private String  PERILS_CONDS;
  private String  LOSS_LOCATION;
  private String  VOYAGE;
  private String  LOSS_NAME;
  private String[]  CLAIM_DETAILS;
  private String  LAWYER_NAME;
  private String  LAWYER_REF;
  private String  LAWYER_CODE;
  private String  ADJUSTER_NAME;
  private String  ADJUSTER_REF;
  private String  ADJUSTER_CODE;
  private String  SCHEME_CODE;
  private String  TF_CODE;
  private String  STATE_CODE;
  private String  NAIC_CODE;
  private String  NAIC_QUAL;
  private String  WAR_IND;
  private String  FIL_CODE_1;
  private String  FIL_CODE_2;
  private String  OTHER_TF_CODE;
  private String  DTI_CODE;
  private String  USA_CAN_IND;
  private String  COUNTY_CODE;

  // CCN #N0031 and N0021 - BA - 15/01/2003
  private String LF_ENTRY_IND = "" ;
  private String LF_ADVANCED_IND = "" ;
  private String BLOCK_IND = "" ;
  
  private String DIRECT_REPORT_IND = "" ; //SIR:150695 ECF Phase 6 changes
  private String LITIGATION_IND = "" ; //SIR:150695 ECF Phase 6 changes
  private String SERVICE_TYPE = "" ;

// TP866603 -Changes for barcode field 

  private String BARCODE = "";
  private Vector expertFeeBreakDownDetails;
  private String expertCount;
  
  public LY44Event(
      String CURR_NO_VAL,
      String SDN_NO_VAL,
      String BDOWN_NO_VAL,
      String CLM_REF_REC,
      String ORIG_CURR,
      String SETT_CURR,
      String EXCH_RATE,
      String PTD_LOSS,
      String PTD_EXP,
      String PTD_FEE,
      String PTD_TOTAL,
      String PTT_LOSS,
      String PTT_EXP,
      String PTT_FEE,
      String PTT_TOTAL,
      String OUTST_LOSS,
      String OUTST_LOSS_QUAL,
      String OUTST_EXP,
      String OUTST_FEE,
      String OUTST_FEE_QUAL,
      String OUTST_TOT,
      String OUTST_TOT_QUAL,
      String PTD_SETT_AMT,
      String CLAIM_AMT_SETT,
      String BUREAU_LINE,
      String BUR_PROP_AMT,
      String HPC_VAT_AMT,
      String[] VAT_RATE,
      String[] VAT_AMT,
      String WAR_AMT,
      String NARR_CODE_1,
      String NARR_CODE_2,
      String SETT_NARR_1,
      String SETT_NARR_2,
      String SETT_NARR_3,
      String SUBROGATION,
      String XCS_REC_REF,
      String HIGHEST_EST,
      String INCURRED_AMT,
      String RATE_EXCH_OUTST,
      String FINDER_CODE_1,
      String FINDER_CODE_2,
      String FINDER_CODE_3,
      String ATTACHMENT_IND,
//      String CASH_COR,
      String BKR_CONTACT,
      String BKR_CONTACT_PHONE,
      String BKR_REF_1,
      String BKR_REF_2,
      String CNTRY_OF_ORIGIN,
      String ORIG_INSURED,
      String INSURED,
      String REINSURED,
      String COVER_HOLDER,
      String CLAIMANT,
      String VESSEL_AIRCRAFT,
      String OTHER_NAME,
      String POL_CERT_FROM,
      String POL_CERT_TO,
      String POL_CERT_QUAL,
      String LOSS_DATE_FROM,
      String LOSS_DATE_TO,
      String LOSS_DATE_QUAL,
      String LOSS_DATE_NARR,
      String CLAIM_DATE_FROM,
      String CLAIM_DATE_TO,
      String CLAIM_DATE_QUAL,
      String CAT_CODE,
      String PCS_CAT_CODE,
      String LIMIT_CURR,
      String SI_LIMIT,
      String EXCESS_AMT,
      String PERILS_CONDS,
      String LOSS_LOCATION,
      String VOYAGE,
      String LOSS_NAME,
      String[] CLAIM_DETAILS,
      String LAWYER_NAME,
      String LAWYER_REF,
      String LAWYER_CODE,
      String ADJUSTER_NAME,
      String ADJUSTER_REF,
      String ADJUSTER_CODE,
      String SCHEME_CODE,
      String TF_CODE,
      String STATE_CODE,
      String NAIC_CODE,
      String NAIC_QUAL,
      String WAR_IND,
      String FIL_CODE_1,
      String FIL_CODE_2,
      String OTHER_TF_CODE,
      String DTI_CODE,
      String USA_CAN_IND,

      String LF_ENTRY_IND,   /* CCN #N0031 and N0021 - BA - 15/01/2003 */
      String LF_ADVANCED_IND, /* CCN #N0031 and N0021 - BA - 15/01/2003 */
      String BLOCK_IND, /* CCN #N0031 and N0021 - BA - 15/01/2003 */
      String DIRECT_REPORT_IND, //SIR:150695 ECF Phase 6 changes
      String LITIGATION_IND, //SIR:150695 ECF Phase 6 changes
      String SERVICE_TYPE,
      Vector expertFeeBreakDownDetails0,
      String expertCount0,
      String COUNTY_CODE,
      String BARCODE // TP866603 -Changes for barcode field
  )
  {
    this.CURR_NO_VAL = CURR_NO_VAL;
    this.SDN_NO_VAL = SDN_NO_VAL;
    this.BDOWN_NO_VAL = BDOWN_NO_VAL;
    this.CLM_REF_REC = CLM_REF_REC;
    this.ORIG_CURR = ORIG_CURR;
    this.SETT_CURR = SETT_CURR;
    this.EXCH_RATE = EXCH_RATE;
    this.PTD_LOSS = PTD_LOSS;
    this.PTD_EXP = PTD_EXP;
    this.PTD_FEE = PTD_FEE;
    this.PTD_TOTAL = PTD_TOTAL;
    this.PTT_LOSS = PTT_LOSS;
    this.PTT_EXP = PTT_EXP;
    this.PTT_FEE = PTT_FEE;
    this.PTT_TOTAL = PTT_TOTAL;
    this.OUTST_LOSS = OUTST_LOSS;
    this.OUTST_LOSS_QUAL = OUTST_LOSS_QUAL;
    this.OUTST_EXP = OUTST_EXP;
    this.OUTST_FEE = OUTST_FEE;
    this.OUTST_FEE_QUAL = OUTST_FEE_QUAL;
    this.OUTST_TOT = OUTST_TOT;
    this.OUTST_TOT_QUAL = OUTST_TOT_QUAL;
    this.PTD_SETT_AMT = PTD_SETT_AMT;
    this.CLAIM_AMT_SETT = CLAIM_AMT_SETT;
    this.BUREAU_LINE = BUREAU_LINE;
    this.BUR_PROP_AMT = BUR_PROP_AMT;
    this.HPC_VAT_AMT = HPC_VAT_AMT;

    if (HPC_VAT_AMT!= null && (HPC_VAT_AMT.trim().equals("") || Double.parseDouble(HPC_VAT_AMT)==0)) {
      this.VAT_RATE = new String[] {"","","","","",""};
      this.VAT_AMT = new String[] {"","","","","",""};
    } else {
      this.VAT_RATE = VAT_RATE;
      this.VAT_AMT = VAT_AMT;
    }

    this.WAR_AMT = WAR_AMT;
    this.NARR_CODE_1 = NARR_CODE_1;
    this.NARR_CODE_2 = NARR_CODE_2;
    this.SETT_NARR_1 = SETT_NARR_1;
    this.SETT_NARR_2 = SETT_NARR_2;
    this.SETT_NARR_3 = SETT_NARR_3;
    this.SUBROGATION = SUBROGATION;
    this.XCS_REC_REF = XCS_REC_REF;
    this.HIGHEST_EST = HIGHEST_EST;
    this.INCURRED_AMT = INCURRED_AMT;
    this.RATE_EXCH_OUTST = RATE_EXCH_OUTST;
    this.FINDER_CODE_1 = FINDER_CODE_1;
    this.FINDER_CODE_2 = FINDER_CODE_2;
    this.FINDER_CODE_3 = FINDER_CODE_3;
    this.ATTACHMENT_IND = ATTACHMENT_IND;
   // this.CASH_COR = CASH_COR;
    this.BKR_CNTCT = BKR_CONTACT;
    this.BKR_CNTCT_PHONE = BKR_CONTACT_PHONE;
    this.BKR_REF_1 = BKR_REF_1;
    this.BKR_REF_2 = BKR_REF_2;
    this.CNTRY_OF_ORIGIN = CNTRY_OF_ORIGIN;
    this.ORIG_INSURED = ORIG_INSURED;
    this.INSURED = INSURED;
    this.REINSURED = REINSURED;
    this.COVER_HOLDER = COVER_HOLDER;
    this.CLAIMANT = CLAIMANT;
    this.VESSEL_AIRCRAFT = VESSEL_AIRCRAFT;
    this.OTHER_NAME = OTHER_NAME;
    this.POL_CERT_FROM = POL_CERT_FROM;
    this.POL_CERT_TO = POL_CERT_TO;
    this.POL_CERT_QUAL = POL_CERT_QUAL;
    this.LOSS_DATE_FROM = LOSS_DATE_FROM;
    this.LOSS_DATE_TO = LOSS_DATE_TO;
    this.LOSS_DATE_QUAL = LOSS_DATE_QUAL;
    this.LOSS_DATE_NARR = LOSS_DATE_NARR;
    this.CLAIM_DATE_FROM = CLAIM_DATE_FROM;
    this.CLAIM_DATE_TO = CLAIM_DATE_TO;
    this.CLAIM_DATE_QUAL = CLAIM_DATE_QUAL;
    this.CAT_CODE = CAT_CODE;
    this.PCS_CAT_CODE = PCS_CAT_CODE;
    this.LIMIT_CURR = LIMIT_CURR;
    this.SI_LIMIT = SI_LIMIT;
    this.EXCESS_AMT = EXCESS_AMT;
    this.PERILS_CONDS = PERILS_CONDS;
    this.LOSS_LOCATION = LOSS_LOCATION;
    this.VOYAGE = VOYAGE;
    this.LOSS_NAME = LOSS_NAME;
    this.CLAIM_DETAILS = CLAIM_DETAILS;
    this.LAWYER_NAME = LAWYER_NAME;
    this.LAWYER_REF = LAWYER_REF;
    this.LAWYER_CODE = LAWYER_CODE;
    this.ADJUSTER_NAME = ADJUSTER_NAME;
    this.ADJUSTER_REF = ADJUSTER_REF;
    this.ADJUSTER_CODE = ADJUSTER_CODE;
    this.SCHEME_CODE = SCHEME_CODE;
    this.TF_CODE = TF_CODE;
    this.STATE_CODE = STATE_CODE;
    this.NAIC_CODE = NAIC_CODE;
    this.NAIC_QUAL = NAIC_QUAL;
    this.WAR_IND = WAR_IND;
    this.FIL_CODE_1 = FIL_CODE_1;
    this.FIL_CODE_2 = FIL_CODE_2;
    this.OTHER_TF_CODE = OTHER_TF_CODE;
    this.DTI_CODE = DTI_CODE;
    this.USA_CAN_IND = USA_CAN_IND;

    // CCN #N0031 and N0021 - BA - 15/01/2003
    this.LF_ENTRY_IND = LF_ENTRY_IND ;
    this.LF_ADVANCED_IND = LF_ADVANCED_IND ;
    this.BLOCK_IND = BLOCK_IND ;
    
    this.DIRECT_REPORT_IND = DIRECT_REPORT_IND; //SIR:150695 ECF Phase 6 changes
    this.LITIGATION_IND = LITIGATION_IND; //SIR:150695 ECF Phase 6 changes
    this.SERVICE_TYPE = SERVICE_TYPE;
    this.expertFeeBreakDownDetails = expertFeeBreakDownDetails0;
    this.expertCount = expertCount0;
    this.COUNTY_CODE = COUNTY_CODE;
    this.BARCODE = BARCODE;    // TP866603 -Changes for barcode field
  }


  public String getName() {
    return "java:comp/env/event/LY44Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY44CICSHandler";
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

  public String getCURR_NO_VAL () {
    if (CURR_NO_VAL == null) {
      return "";
    }
    return CURR_NO_VAL;
  }

  public String getSDN_NO_VAL () {
    if (SDN_NO_VAL == null) {
      return "";
    }
    return SDN_NO_VAL;
  }

  public String getBDOWN_NO_VAL () {
    if (BDOWN_NO_VAL == null) {
      return "";
    }
    return BDOWN_NO_VAL;
  }

  public String getCLM_REF_REC () {
    if (CLM_REF_REC == null) {
      return "";
    }
    return CLM_REF_REC;
  }

  public String getORIG_CURR () {
    if (ORIG_CURR == null) {
      return "";
    }
    return ORIG_CURR;
  }

  public String getSETT_CURR () {
    if (SETT_CURR == null) {
      return "";
    }
    return SETT_CURR;
  }

  public String getEXCH_RATE () {
    if (EXCH_RATE == null) {
      return "";
    }
    return EXCH_RATE;
  }

  public String getPTD_LOSS () {
    if (PTD_LOSS == null) {
      return "";
    }
    return PTD_LOSS;
  }

  public String getPTD_EXP () {
    if (PTD_EXP == null) {
      return "";
    }
    return PTD_EXP;
  }

  public String getPTD_FEE () {
    if (PTD_FEE == null) {
      return "";
    }
    return PTD_FEE;
  }

  public String getPTD_TOTAL () {
    if (PTD_TOTAL == null) {
      return "";
    }
    return PTD_TOTAL;
  }

  public String getPTT_LOSS () {
    if (PTD_LOSS == null) {
      return "";
    }
    return PTT_LOSS;
  }

  public String getPTT_EXP () {
    if (PTT_EXP == null) {
      return "";
    }
    return PTT_EXP;
  }

  public String getPTT_FEE () {
    if (PTT_FEE == null) {
      return "";
    }
    return PTT_FEE;
  }

  public String getPTT_TOTAL () {
    if (PTT_TOTAL == null) {
      return "";
    }
    return PTT_TOTAL;
  }

  public String getOUTST_LOSS () {
    if (OUTST_LOSS == null) {
      return "";
    }
    return OUTST_LOSS;
  }

  public String getOUTST_LOSS_QUAL () {
    if (OUTST_LOSS_QUAL == null) {
      return "";
    }
    return OUTST_LOSS_QUAL;
  }

  public String getOUTST_EXP () {
    if (OUTST_EXP == null) {
      return "";
    }
    return OUTST_EXP;
  }

  public String getOUTST_FEE () {
    if (OUTST_FEE == null) {
      return "";
    }
    return OUTST_FEE;
  }

  public String getOUTST_FEE_QUAL () {
    if (OUTST_FEE_QUAL == null) {
      return "";
    }
    return OUTST_FEE_QUAL;
  }

  public String getOUTST_TOT () {
    if (OUTST_TOT == null) {
      return "";
    }
    return OUTST_TOT;
  }

  public String getOUTST_TOT_QUAL () {
    if (OUTST_TOT_QUAL == null) {
      return "";
    }
    return OUTST_TOT_QUAL;
  }

  public String getPTD_SETT_AMT () {
    if (PTD_SETT_AMT == null) {
      return "";
    }
    return PTD_SETT_AMT;
  }

  public String getCLAIM_AMT_SETT () {
    if (CLAIM_AMT_SETT == null) {
      return "";
    }
    return CLAIM_AMT_SETT;
  }

  public String getBUREAU_LINE () {
    if (BUREAU_LINE == null) {
      return "";
    }
    return BUREAU_LINE;
  }

  public String getBUR_PROP_AMT () {
    if (BUR_PROP_AMT == null) {
      return "";
    }
    return BUR_PROP_AMT;
  }

  public String getHPC_VAT_AMT () {
    if (HPC_VAT_AMT == null) {
      return "";
    }
    return HPC_VAT_AMT;
  }

  public String[] getVAT_RATE () {
    for (int i=0; i<VAT_RATE.length; i++) {
      if (VAT_RATE[i]==null)
        VAT_RATE[i]="";
    }
    return VAT_RATE;
  }

  public String[] getVAT_AMT () {
    for (int i=0; i<VAT_AMT.length; i++) {
      if (VAT_AMT[i]==null)
        VAT_AMT[i]="";
    }
    return VAT_AMT;
  }

  public String getWAR_AMT () {
    return WAR_AMT;
  }

  public String getNARR_CODE_1 () {
    if (NARR_CODE_1==null)
      return "";
    else
      return NARR_CODE_1;
  }

  public String getNARR_CODE_2 () {
    if (NARR_CODE_2==null)
      return "";
    else
      return NARR_CODE_2;
  }

  public String getSETT_NARR_1 () {
    return SETT_NARR_1;
  }

  public String getSETT_NARR_2 () {
    return SETT_NARR_2;
  }

  public String getSETT_NARR_3 () {
    return SETT_NARR_3;
  }

  public String getSUBROGATION () {
    return SUBROGATION;
  }

  public String getXCS_REC_REF () {
    return XCS_REC_REF;
  }

  public String getHIGHEST_EST () {
    return HIGHEST_EST;
  }

  public String getINCURRED_AMT () {
    return INCURRED_AMT;
  }

  public String getRATE_EXCH_OUTST () {
    return RATE_EXCH_OUTST;
  }

  public String getFINDER_CODE_1 () {
    return FINDER_CODE_1;
  }

  public String getFINDER_CODE_2 () {
    return FINDER_CODE_2;
  }

  public String getFINDER_CODE_3 () {
    return FINDER_CODE_3;
  }

  public String getATTACHMENT_IND () {
    return ATTACHMENT_IND;
  }

  public String getBKR_CNTCT () {
    return BKR_CNTCT;
  }

  public String getBKR_CNTCT_PHONE () {
    return BKR_CNTCT_PHONE;
  }

  public String getBKR_REF_1 () {
    return BKR_REF_1;
  }

  public String getBKR_REF_2 () {
    return BKR_REF_2;
  }

  public String getCNTRY_OF_ORIGIN () {
    return (CNTRY_OF_ORIGIN!=null)?CNTRY_OF_ORIGIN:"";
  }

  public String getORIG_INSURED () {
    return ORIG_INSURED;
  }

  public String getINSURED () {
    return INSURED;
  }

  public String getREINSURED () {
    return REINSURED;
  }

  public String getCOVER_HOLDER () {
    return COVER_HOLDER;
  }

  public String getCLAIMANT () {
    return CLAIMANT;
  }

  public String getVESSEL_AIRCRAFT () {
    return VESSEL_AIRCRAFT;
  }

  public String getOTHER_NAME () {
    return OTHER_NAME;
  }

  public String getPOL_CERT_FROM () {
    return POL_CERT_FROM;
  }

  public String getPOL_CERT_TO () {
    return POL_CERT_TO;
  }

  public String getPOL_CERT_QUAL () {
    if (POL_CERT_QUAL==null)
      return "";
    else
      return POL_CERT_QUAL;
  }

  public String getLOSS_DATE_FROM () {
    return LOSS_DATE_FROM;
  }

  public String getLOSS_DATE_TO () {
    return LOSS_DATE_TO;
  }

  public String getLOSS_DATE_QUAL () {
    if (LOSS_DATE_QUAL==null)
      return "";
    else
      return LOSS_DATE_QUAL;
  }

  public String getCLAIM_DATE_FROM () {
    return CLAIM_DATE_FROM;
  }

  public String getCLAIM_DATE_TO () {
    return CLAIM_DATE_TO;
  }

  public String getCLAIM_DATE_QUAL () {
    if (CLAIM_DATE_QUAL==null)
      return "";
    else
      return CLAIM_DATE_QUAL;
  }

  public String getCAT_CODE () {
    if (CAT_CODE==null)
      return "";
    else
      return CAT_CODE;
  }

  public String getPCS_CAT_CODE () {
    if (PCS_CAT_CODE==null)
      return "";
    else
      return PCS_CAT_CODE;
  }

  public String getLIMIT_CURR () {
    if (LIMIT_CURR==null)
      return "";
    else
      return LIMIT_CURR;
  }

  public String getSI_LIMIT () {
    return SI_LIMIT;
  }

  public String getEXCESS_AMT () {
    return EXCESS_AMT;
  }

  public String getPERILS_CONDS () {
    return PERILS_CONDS;
  }

  public String getLOSS_LOCATION () {
    return LOSS_LOCATION;
  }

  public String getVOYAGE () {
    return VOYAGE;
  }

  public String getLOSS_NAME () {
    return LOSS_NAME;
  }

  public String[] getCLAIM_DETAILS () {
    return CLAIM_DETAILS;
  }

  public String getLAWYER_NAME () {
    if (LAWYER_NAME==null)
      return "";
    else
      return LAWYER_NAME;
  }

  public String getLAWYER_REF () {
    return LAWYER_REF;
  }

  public String getLAWYER_CODE () {
    return LAWYER_CODE;
  }

  public String getADJUSTER_NAME () {
    if (ADJUSTER_NAME==null)
      return "";
    else
      return ADJUSTER_NAME;
  }

  public String getADJUSTER_REF () {
    return ADJUSTER_REF;
  }

  public String getADJUSTER_CODE () {
    return ADJUSTER_CODE;
  }

  public String getSCHEME_CODE () {
    if (SCHEME_CODE==null)
      return "";
    else
      return SCHEME_CODE;
  }

  public String getTF_CODE () {
    if (TF_CODE==null)
      return "";
    else
      return TF_CODE;
  }

  public String getSTATE_CODE () {
    if (STATE_CODE == null) {
      return "";
    }
    return STATE_CODE;
  }

  public String getNAIC_CODE () {
    if (NAIC_CODE==null)
      return "";
    else
      return NAIC_CODE;
  }

  public String getNAIC_QUAL () {
    if (NAIC_QUAL==null)
      return "";
    else
      return NAIC_QUAL;
  }

  public String getWAR_IND () {
    return WAR_IND;
  }

  public String getFIL_CODE_1 () {
    if (FIL_CODE_1==null)
      return "";
    else
      return FIL_CODE_1;
  }

  public String getFIL_CODE_2 () {
    if (FIL_CODE_2==null)
      return "";
    else
      return FIL_CODE_2;
  }

  public String getOTHER_TF_CODE () {
    if (OTHER_TF_CODE==null)
      return "";
    else
      return OTHER_TF_CODE;
  }

  public String getDTI_CODE () {
    if (DTI_CODE==null)
      return "";
    else
      return DTI_CODE;
  }

  public String getUSA_CAN_IND() {
    return USA_CAN_IND;
  }
  public String getLOSS_DATE_NARR() {
    return LOSS_DATE_NARR;
  }

  // CCN #N0031 and N0021 - BA - 15/01/2003
  public String getLF_ENTRY_IND() {
    return LF_ENTRY_IND ;
  }
  public String getLF_ADVANCED_IND() {
    return LF_ADVANCED_IND ;
  }
  public String getBLOCK_IND() {
    return BLOCK_IND ;
  }

//SIR:150695 ECF Phase 6 changes
public String getDIRECT_REPORT_IND() {
	return DIRECT_REPORT_IND;
}

//SIR:150695 ECF Phase 6 changes
public String getLITIGATION_IND() {
	return LITIGATION_IND;
}

public Vector getExpertFeeBreakDownDetails()
{
    return expertFeeBreakDownDetails;
}

public String getExpertCount()
{
    return expertCount;
}


public String getCOUNTY_CODE() {
	return COUNTY_CODE;
}



public String getSERVICE_TYPE()
{
    if(SERVICE_TYPE == null){
        SERVICE_TYPE = "";
    }
    return SERVICE_TYPE;
}
// TP866603 -Changes for barcode field 
public String getBARCODE()
{
    if(BARCODE == null){
        BARCODE = "";
    }
    return BARCODE;
}
}
