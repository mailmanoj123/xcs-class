package com.xchanging.xcc.events;

/**
 Commarea - C035 (LY35)
 Program  - Associated Screen/Process:- Claim Details Screen Validation
 Devo
 */

  public class LY36Event extends ClaimsEvent implements java.io.Serializable {

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
    private String BKR_CNTCT;
    private String BKR_CNTCT_PHONE;
    private String BKR_REF_1;
    private String BKR_REF_2;
    private String BROKER_UCR;
    private String ORIG_INSURED;
    private String INSURED;
    private String REINSURED;
    private String COVER_HOLDER;
    private String CLAIMANT;
    private String OTHER_NAME;
    private String LOSS_NAME;
    private String VESSEL_AIRCRAFT;
    private String LOSS_DATE_FROM;
    private String LOSS_DATE_TO;
    private String LOSS_DATE_QUAL;
    private String LOSS_DATE_NARR;
    private String DCM_DOD_FROM;
    private String DCM_DOD_TO;
    private String DCM_DOD_QUAL;
    private String LOSS_LOCATION;
    private String VOYAGE;
    private String CAT_CODE;
    private String PCS_CAT_CODE;
    private String CLM_RISK_TYPE;
    private String[] LOSS_DETAILS;
    private String ADJUSTER_NAME;
    private String ADJUSTER_REF;
    private String LAWYER_NAME;
    private String LAWYER_REF;
    private String CAUSE_CODE;
    private boolean showLossDetails;

    // CCN 21- all ref's to it relate to this ccn  devo   15/01/2003
    private String CoverHolderClmRef;

    private String CERT_INS_NOS[];

    public LY36Event(
        String XCR,
        String UCR,
        String TR,
        String ORIG_REF_1,
        String ORIG_REF_2,
        String ORIG_REF_3,
        String ORIG_BKR,
        String SIGNED_IND,
        String PEER_REV_IND,
        String BKR_CNTCT,
        String BKR_CNTCT_PHONE,
        String BKR_REF_1,
        String BKR_REF_2,
        String BROKER_UCR,
        String ORIG_INSURED,
        String INSURED,
        String REINSURED,
        String COVER_HOLDER,
        String CLAIMANT,
        String OTHER_NAME,
        String LOSS_NAME,
        String VESSEL_AIRCRAFT,
        String LOSS_DATE_FROM,
        String LOSS_DATE_TO,
        String LOSS_DATE_QUAL,
        String LOSS_DATE_NARR,
        String DCM_DOD_FROM,
        String DCM_DOD_TO,
        String DCM_DOD_QUAL,
        String LOSS_LOCATION,
        String VOYAGE,
        String CAT_CODE,
        String PCS_CAT_CODE,
        String CLM_RISK_TYPE,
        String[] LOSS_DETAILS,
        String ADJUSTER_NAME,
        String ADJUSTER_REF,
        String LAWYER_NAME,
        String LAWYER_REF,
        String CAUSE_CODE,
        String CoverHolderClmRef,
        boolean showLossDetails,
        String[] CERT_INS_NOS
      )
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
      this.BKR_CNTCT =	BKR_CNTCT;
      this.BKR_CNTCT_PHONE = BKR_CNTCT_PHONE;
      this.BKR_REF_1 = BKR_REF_1;
      this.BKR_REF_2 = BKR_REF_2;
      this.BROKER_UCR =	BROKER_UCR;
      this.ORIG_INSURED = ORIG_INSURED;
      this.INSURED = INSURED;
      this.REINSURED = REINSURED;
      this.COVER_HOLDER = COVER_HOLDER;
      this.CLAIMANT = CLAIMANT;
      this.OTHER_NAME =OTHER_NAME;
      this.LOSS_NAME = LOSS_NAME;
      this.VESSEL_AIRCRAFT = VESSEL_AIRCRAFT;
      this.LOSS_DATE_FROM = LOSS_DATE_FROM;
      this.LOSS_DATE_TO = LOSS_DATE_TO;
      this.LOSS_DATE_QUAL = LOSS_DATE_QUAL;
      this.LOSS_DATE_NARR = LOSS_DATE_NARR;
      this.DCM_DOD_FROM = DCM_DOD_FROM;
      this.DCM_DOD_TO = DCM_DOD_TO;
      this.DCM_DOD_QUAL = DCM_DOD_QUAL;
      this.LOSS_LOCATION = LOSS_LOCATION;
      this.VOYAGE = VOYAGE;
      this.CAT_CODE = CAT_CODE;
      this.PCS_CAT_CODE = PCS_CAT_CODE;
      this.CLM_RISK_TYPE = CLM_RISK_TYPE;
      this.LOSS_DETAILS = LOSS_DETAILS;
      this.ADJUSTER_NAME = ADJUSTER_NAME;
      this.ADJUSTER_REF = ADJUSTER_REF;
      this.LAWYER_NAME = LAWYER_NAME;
      this.LAWYER_REF =	LAWYER_REF;
      this.CAUSE_CODE = CAUSE_CODE;
      this.CoverHolderClmRef = CoverHolderClmRef;
      this.showLossDetails = showLossDetails;
      this.CERT_INS_NOS = CERT_INS_NOS;
    }

    public String getName() {
      return "java:comp/env/event/LY36Event";
    }

    public int getType() {
    return UPDATE;
  }

    public String getHandlerName() {
      return "com.xchanging.xcc.cics.handlers.LY36CICSHandler";
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
    public String getBROKER_UCR () {
      return BROKER_UCR;
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

    public String getOTHER_NAME () {
      return OTHER_NAME;
    }

    public String getLOSS_NAME () {
      return LOSS_NAME;
    }

    public String getVESSEL_AIRCRAFT () {
      return VESSEL_AIRCRAFT;
    }

    public String getLOSS_DATE_FROM () {
      return LOSS_DATE_FROM;
    }

    public String getLOSS_DATE_TO () {
      return LOSS_DATE_TO;
    }

    public String getLOSS_DATE_QUAL () {
      return LOSS_DATE_QUAL;
    }

    public String getLOSS_DATE_NARR () {
      return LOSS_DATE_NARR;
    }

    public String getDCM_DOD_FROM () {
      return DCM_DOD_FROM;
    }

    public String getDCM_DOD_TO () {
      return DCM_DOD_TO;
    }

    public String getDCM_DOD_QUAL () {
      return DCM_DOD_QUAL;
    }

    public String getLOSS_LOCATION () {
      return LOSS_LOCATION;
    }

    public String getVOYAGE () {
      return VOYAGE;
    }

    public String getCAT_CODE () {
      if (CAT_CODE == null) {
        CAT_CODE = "";
      }
      return CAT_CODE;
    }

    public String getPCS_CAT_CODE () {
      if (PCS_CAT_CODE == null) {
        PCS_CAT_CODE = "";
      }
      return PCS_CAT_CODE;
    }

    public String getCLM_RISK_TYPE () {
      return CLM_RISK_TYPE;
    }

    public String[] getLOSS_DETAILS () {
      return LOSS_DETAILS;
    }

    public String getADJUSTER_NAME () {
      return ADJUSTER_NAME;
    }

    public String getADJUSTER_REF () {
      return ADJUSTER_REF;
    }

    public String getLAWYER_NAME () {
      return LAWYER_NAME;
    }

    public String getLAWYER_REF () {
      return LAWYER_REF;
    }

    public String getCAUSE_CODE () {
        return CAUSE_CODE;
      }

    public String[] getCERT_INS_NOS () {
        return CERT_INS_NOS;
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
  public String getCoverHolderClmRef() {
    return CoverHolderClmRef;
  }
  public boolean showLossDetails() {
    return showLossDetails;
  }
}
