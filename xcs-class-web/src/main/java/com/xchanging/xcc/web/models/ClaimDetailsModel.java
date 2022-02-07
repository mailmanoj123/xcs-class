package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY34Event;
import com.xchanging.xcc.events.LY36Event;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimDetailsModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private String screenMode = "";

  private String ucr = "";
  private String ucrFlag;
  private String xcr = "";
  private String xcrFlag;
  private String tr = "";
  private String trFlag;
  private String osnd1 = "";
  private String osnd1Flag;
  private String osnd2 = "";
  private String osnd2Flag;
  private String osnd3 = "";
  private String osnd3Flag;
  private String peerReview = "";
  private String peerReviewFlag;
  private String origBroker = "";
  private String origBrokerFlag;
  private String signedInd = "";
  private String signedIndFlag;
  private String bkrContact = "";
  private String bkrContactFlag;
  private String bkrPhoneNo = "";
  private String bkrPhoneNoFlag;
  private String bkrClaimRef1 = "";
  private String bkrClaimRef1Flag;
  private String bkrClaimRef2 = "";
  private String bkrClaimRef2Flag;
  private String bkrUcr = "";
  private boolean bkrUcrFlag;
  private String origInsured = "";
  private String bkrOrigInsuredFlag;
  private String insured = "";
  private String insuredFlag;
  private String reinsured = "";
  private String reinsuredFlag;
  private String coverholder = "";
  private String coverholderFlag;
  private String claimant = "";
  private String claimantFlag;
  private String vesselAircraft = "";
  private String vesselAircraftFlag;
  private String lossName = "";
  private String lossNameFlag;
  private String otherName = "";
  private String otherNameFlag;
  private String dolFrom = "";
  private boolean dolFromFlag;
  private String dolTo = "";
  private boolean dolToFlag;
  private String dolQual = "";
  private boolean dolQualFlag;
  private String dcmFrom = "";
  private boolean dcmFromFlag;
  private String dcmTo = "";
  private boolean dcmToFlag;
  private String dcmQual = "";
  private boolean dcmQualFlag;
  private String dolNarrative = "";
  private String dolNarrativeFlag;
  private String lossLocation = "";
  private String lossLocationFlag;
  private String voyage = "";
  private String voyageFlag;
  private String catCode = "";
  private boolean catCodeFlag;
  private String pcsCat = "";
  private boolean pcsCatFlag;
  private String claimRiskType = "";
  private boolean claimRiskTypeFlag;

  private boolean showLossDetails;

  // This is represented by the LOSS_DETAILS in the COMMAREA
  private String claimNarrative = "";
  private String claimNarrativeFlag;

  private String adjSurvName = "";
  private boolean adjSurvNameFlag;

  //NOTE:__________________________________________________________
  // The lawyer codes ARE NOT detailed in the COMMAREA!!!!!!!!!
  private String adjSurvCode = "";
  private String adjSurvCodeFlag;
  //_______________________________________________________________

  private String adjSurvRef = "";
  private String adjSurvRefFlag;
  private String lawyerName = "";
  private boolean lawyerNameFlag;

  //NOTE:__________________________________________________________
  // The lawyer codes ARE NOT detailed in the COMMAREA!!!!!!!!!
  private String lawyerCode = "";
  private String lawyerCodeFlag;
  //_______________________________________________________________

  private String lawyerRef = "";
  private String lawyerRefFlag;
  private String causeCode = "";
  private boolean causeCodeFlag;

  //NOTE:__________________________________________________________
  // The finder codes ARE NOT detailed in the COMMAREA!!!!!!!!!
  private String finderCode1 = "";
  private String finderCode1Flag;
  private String finderCode2 = "";
  private String finderCode2Flag;
  private String finderCode3 = "";
  private String finderCode3Flag;
  //______________________________________________________________
  
  
  private String C034_ADJ_NAME_ATTR = "";
  private String C034_ADJ_REF_ATTR  = "";
  private String C034_LAW_NAME_ATTR = "";
  private String C034_LAW_REF_ATTR  = "";


 // CCN 21    devo    15/01/2001
 private String chClmRef = "";
 private String chClmRefFlag = "";

  private boolean saveBtnFlag;

  //____________________________________________________________
  
  /*Csertificate of insurance no, XCC3.0 R3B
   * Sachin Goyal*/
  private String certInsNo1 = "";
  private String certInsNo1Flag;
  private String certInsNo2 = "";
  private String certInsNo2Flag;
  private String certInsNo3 = "";
  private String certInsNo3Flag;
  private String certInsNo4 = "";
  private String certInsNo4Flag;
  private String certInsNo5 = "";
  private String certInsNo5Flag;
  
 // Binders fields
  private String bindClass;
  private boolean bindClassFlag;

  
  //____________________________________________________________
  
  
  public ClaimDetailsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.ClaimDetailsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY34Event) {

      showLossDetails = false;
      screenMode = (String) results.get(Keys.LY34_SCREEN_MODE_Field);
      mm.getUserWebModel().setUpdateMode(screenMode);
      // If screen mode is enquiry then we want to pass back true which will in turn hide the button.
      if (screenMode.equalsIgnoreCase("e")){
        saveBtnFlag = true;
      }
      else { saveBtnFlag = false;}

      // MappedRecord for the field values table
      MappedRecord mp1 = (MappedRecord) ((Vector) results.get(Keys.LY34_FIELD_VALUES_Table)).get(0);
      // MappedRecord for the field attributes table.
      MappedRecord mp2 = (MappedRecord) ((Vector) results.get(Keys.LY34_FIELD_ATTRIBUTES_Table)).get(0);

      // Note extract the values (from mp1 MappedRecord) and their respective attribute flags (from mp2 MappedRecord).
      ucr = (String) mp1.get(Keys.LY34_UCR_Field);
      ucrFlag = enabledStatus((String) mp2.get(Keys.LY34_UCR_ATTR_Field));
      xcr = (String) mp1.get(Keys.LY34_XCR_Field);
      xcrFlag = enabledStatus((String) mp2.get(Keys.LY34_XCR_ATTR_Field));
      tr = (String) mp1.get(Keys.LY34_TR_Field);
      trFlag= enabledStatus((String) mp2.get(Keys.LY34_TR_ATTR_Field));
      osnd1 = (String) mp1.get(Keys.LY34_ORIG_REF_1_Field);
      osnd1Flag = enabledStatus((String) mp2.get(Keys.LY34_ORIG_REF_ATTR1_Field));
      osnd2 = (String) mp1.get(Keys.LY34_ORIG_REF_2_Field);
      osnd2Flag = enabledStatus((String) mp2.get(Keys.LY34_ORIG_REF_ATTR2_Field));
      osnd3 = (String) mp1.get(Keys.LY34_ORIG_REF_3_Field);
      osnd3Flag = enabledStatus((String) mp2.get(Keys.LY34_ORIG_REF_ATTR3_Field));

      peerReview = (String) mp1.get(Keys.LY34_PEER_REV_IND_Field);
      peerReviewFlag = enabledStatus((String) mp2.get(Keys.LY34_PEER_REV_ATTR_Field));
      origBroker = (String) mp1.get(Keys.LY34_ORIG_BKR_Field);
      origBrokerFlag =  enabledStatus((String) mp2.get(Keys.LY34_ORIG_BKR_ATTR_Field));
      signedInd = (String) mp1.get(Keys.LY34_SIGNED_IND_Field);
      signedIndFlag =  enabledStatus((String) mp2.get(Keys.LY34_SIGN_IND_ATTR_Field));
      bkrContact = (String) mp1.get(Keys.LY34_BKR_CNTCT_Field);
      bkrContactFlag =  enabledStatus((String) mp2.get(Keys.LY34_BKR_CNTCT_ATTR_Field));
      bkrPhoneNo = (String) mp1.get(Keys.LY34_BKR_CNTCT_PHONE_Field);
      bkrPhoneNoFlag =  enabledStatus((String) mp2.get(Keys.LY34_BKR_PHONE_ATTR_Field));
      bkrClaimRef1 = (String) mp1.get(Keys.LY34_BKR_REF_1_Field);
      bkrClaimRef1Flag =  enabledStatus((String) mp2.get(Keys.LY34_BKR_REF_ATTR1_Field));
      bkrClaimRef2 = (String) mp1.get(Keys.LY34_BKR_REF_2_Field);
      bkrClaimRef2Flag =  enabledStatus((String) mp2.get(Keys.LY34_BKR_REF_ATTR2_Field));
      bkrUcr = (String) mp1.get(Keys.LY34_BROKER_UCR_Field);
      bkrUcrFlag =  convertToBoolean((String) mp2.get(Keys.LY34_BROKER_UCR_ATTR_Field));
      origInsured = (String) mp1.get(Keys.LY34_ORIG_INSURED_Field);
      bkrOrigInsuredFlag =  enabledStatus((String) mp2.get(Keys.LY34_ORIG_INS_ATTR_Field));

      insured = (String) mp1.get(Keys.LY34_INSURED_Field);
      insuredFlag=  enabledStatus((String) mp2.get(Keys.LY34_INSURED_ATTR_Field));
      reinsured = (String) mp1.get(Keys.LY34_REINSURED_Field);
      reinsuredFlag=  enabledStatus((String) mp2.get(Keys.LY34_REINSURED_ATTR_Field));
      coverholder = (String) mp1.get(Keys.LY34_COVER_HOLDER_Field);
      coverholderFlag=  enabledStatus((String) mp2.get(Keys.LY34_COV_HOLD_ATTR_Field));
      claimant = (String) mp1.get(Keys.LY34_CLAIMANT_Field);
      claimantFlag=  enabledStatus((String) mp2.get(Keys.LY34_CLAIMANT_ATTR_Field));
      vesselAircraft = (String) mp1.get(Keys.LY34_VESSEL_AIRCRAFT_Field);
      vesselAircraftFlag=  enabledStatus((String) mp2.get(Keys.LY34_VESS_AIR_ATTR_Field));
      lossName = (String) mp1.get(Keys.LY34_LOSS_NAME_Field);
      lossNameFlag=  enabledStatus((String) mp2.get(Keys.LY34_LOSS_NAME_ATTR_Field));
      otherName = (String) mp1.get(Keys.LY34_OTHER_NAME_Field);
      otherNameFlag=  enabledStatus((String) mp2.get(Keys.LY34_OTHER_NAME_ATTR_Field));
      dolFrom = (String) mp1.get(Keys.LY34_LOSS_DATE_FROM_Field);
      dolFromFlag=  convertToBoolean((String) mp2.get(Keys.LY34_DOL_FROM_ATTR_Field));
      dolTo = (String) mp1.get(Keys.LY34_LOSS_DATE_TO_Field);
      dolToFlag=  convertToBoolean((String) mp2.get(Keys.LY34_DOL_TO_ATTR_Field));
      dolQual = (String) mp1.get(Keys.LY34_LOSS_DATE_QUAL_Field);
      dolQualFlag=  convertToBoolean((String) mp2.get(Keys.LY34_DOL_QUAL_ATTR_Field));
      dcmFrom = (String) mp1.get(Keys.LY34_DCM_DOD_FROM_Field);
      dcmFromFlag=  convertToBoolean((String) mp2.get(Keys.LY34_DCM_FROM_ATTR_Field));
      dcmTo = (String) mp1.get(Keys.LY34_DCM_DOD_TO_Field);
      dcmToFlag=  convertToBoolean((String) mp2.get(Keys.LY34_DCM_TO_ATTR_Field));
      dcmQual = (String) mp1.get(Keys.LY34_DCM_DOD_QUAL_Field);
      dcmQualFlag=  convertToBoolean((String) mp2.get(Keys.LY34_DOL_QUAL_ATTR_Field));
      dolNarrative = (String) mp1.get(Keys.LY34_LOSS_DATE_NARR_Field);
      dolNarrativeFlag=  enabledStatus((String) mp2.get(Keys.LY34_DOL_NARR_ATTR_Field));
      lossLocation = (String) mp1.get(Keys.LY34_LOSS_LOCATION_Field);
      lossLocationFlag=  enabledStatus((String) mp2.get(Keys.LY34_LOSS_LOC_ATTR_Field));
      voyage = (String) mp1.get(Keys.LY34_VOYAGE_Field);
      voyageFlag=  enabledStatus((String) mp2.get(Keys.LY34_VOYAGE_ATTR_Field));
      catCode = (String) mp1.get(Keys.LY34_CAT_CODE_Field);
      catCodeFlag=  convertToBoolean((String) mp2.get(Keys.LY34_CAT_ATTR_Field));
      pcsCat = (String) mp1.get(Keys.LY34_PCS_CAT_CODE_Field);
      pcsCatFlag=  convertToBoolean((String) mp2.get(Keys.LY34_PCS_CAT_ATTR_Field));
      claimRiskType = (String) mp1.get(Keys.LY34_CLM_RISK_TYPE_Field);
      claimRiskTypeFlag=  convertToBoolean((String) mp2.get(Keys.LY34_CLM_RISK_ATTR_Field));

      // CCN 21    DEVO   15/01/2003
      chClmRef     = (String) mp1.get(Keys.LY34_CH_CLM_REF);
      chClmRefFlag =  enabledStatus((String) mp2.get(Keys.LY34_CH_CLM_REF_ATTR));

     
      bindClass     = (String) mp1.get(Keys.LY34_BND_CLASS);
      bindClassFlag =  convertToBoolean((String) mp2.get(Keys.LY34_BND_CLASS_ATTR));
      
      
      claimNarrative = "";
      Vector claimDetails = (Vector)mp1.get("#C034_LOSS_DETAILS[]");
      for (int i=0; i<claimDetails.size(); i++) {
        MappedRecord claimDetLine = (MappedRecord)claimDetails.elementAt(i);
        if (i>0)
          claimNarrative += "\n";

        claimNarrative += (String)claimDetLine.get("@C034_LOSS_DET_LINE");
      }
      while ((claimNarrative.length()>0) && (claimNarrative.lastIndexOf("\n")==claimNarrative.length()-1)) {
        claimNarrative = claimNarrative.substring(0,claimNarrative.length()-1);
      }
      claimNarrativeFlag= enabledStatusTextarea((String) mp2.get(Keys.LY34_LOSS_DETS_ATTR_Field));

      adjSurvName = (String) mp1.get(Keys.LY34_ADJUSTER_NAME_Field);
      adjSurvNameFlag = convertToBoolean((String) mp2.get(Keys.LY34_ADJ_NAME_ATTR_Field));
      adjSurvRef = (String) mp1.get(Keys.LY34_ADJUSTER_REF_Field);
      adjSurvRefFlag =enabledStatus((String) mp2.get(Keys.LY34_ADJ_REF_ATTR_Field));

      lawyerName = (String) mp1.get(Keys.LY34_LAWYER_NAME_Field);
      lawyerNameFlag = convertToBoolean((String) mp2.get(Keys.LY34_LAW_NAME_ATTR_Field));
      lawyerRef = (String) mp1.get(Keys.LY34_LAWYER_REF_Field);
      lawyerRefFlag = enabledStatus((String) mp2.get(Keys.LY34_LAW_REF_ATTR_Field));
      
     /*
      * clintonj [SIR 37546] [10/03/2004]
      * Functions added to fix adjuster/lawyer 20 char issue.
      */      
      C034_ADJ_NAME_ATTR = (String)mp2.get(Keys.LY34_ADJ_NAME_ATTR_Field);      
      C034_ADJ_REF_ATTR  = (String)mp2.get(Keys.LY34_ADJ_REF_ATTR_Field);
      C034_LAW_NAME_ATTR = (String)mp2.get(Keys.LY34_LAW_NAME_ATTR_Field);
      C034_LAW_REF_ATTR  = (String)mp2.get(Keys.LY34_LAW_REF_ATTR_Field);  
      
      
      causeCode = (String) mp1.get(Keys.LY34_CAUSE_CODE_Field);
      causeCodeFlag = convertToBoolean((String) mp2.get(Keys.LY34_CAUSE_CODE_ATTR_Field));
 
    
      /*Extract Certificate of insurance no.*/
      Vector v3 = (Vector) mp1.get(Keys.LY34_COI_TABLE_Table);
      for(int x =0; x < v3.size();x++)
      {
        MappedRecord mp5 = (MappedRecord) v3.get(x);
        switch(x)
        {
          case 0:
            certInsNo1 = (String) mp5.get(Keys.LY34_CERT_INS_NO_Field);
            break;
          case 1:
            certInsNo2 = (String) mp5.get(Keys.LY34_CERT_INS_NO_Field);
            break;
          case 2:
            certInsNo3 = (String) mp5.get(Keys.LY34_CERT_INS_NO_Field);
            break;
          case 3:
            certInsNo4 = (String) mp5.get(Keys.LY34_CERT_INS_NO_Field);
            break;
          case 4:
            certInsNo5 = (String) mp5.get(Keys.LY34_CERT_INS_NO_Field);
        }
      }
      
      
      // Now Extract the COI attributes.
      Vector v4 = (Vector) mp2.get(Keys.LY34_COI_ATTRS_Table);
      for(int y =0; y < v4.size();y++)
      {
        MappedRecord mp6 = (MappedRecord) v4.get(y);
        switch(y)
        {
          case 0:
            certInsNo1Flag = enabledStatus((String) mp6.get(Keys.LY34_CERT_NO_ATTR_Field));
            break;
          case 1:
            certInsNo2Flag = enabledStatus((String) mp6.get(Keys.LY34_CERT_NO_ATTR_Field));
            break;
          case 2:
            certInsNo3Flag = enabledStatus((String) mp6.get(Keys.LY34_CERT_NO_ATTR_Field));
            break;
          case 3:
            certInsNo4Flag = enabledStatus((String) mp6.get(Keys.LY34_CERT_NO_ATTR_Field));
            break;
          case 4:
            certInsNo5Flag = enabledStatus((String) mp6.get(Keys.LY34_CERT_NO_ATTR_Field));
        }
      }
    }

    else if (event instanceof LY36Event) {
      showLossDetails = ((LY36Event)event).showLossDetails();

      // MappedRecord for the field values table
      MappedRecord mp1 = (MappedRecord) ((Vector) results.get(Keys.LY36_FIELD_VALUES_Table)).get(0);

      bkrContact = (String) mp1.get(Keys.LY36_BKR_CNTCT);
      bkrPhoneNo = (String) mp1.get(Keys.LY36_BKR_CNTCT_PHONE);
      bkrClaimRef1 = (String) mp1.get(Keys.LY36_BKR_REF_1);
      bkrClaimRef2 = (String) mp1.get(Keys.LY36_BKR_REF_2);
      bkrUcr = (String) mp1.get(Keys.LY36_BROKER_UCR);
      origInsured = (String) mp1.get(Keys.LY36_ORIG_INSURED);
      insured = (String) mp1.get(Keys.LY36_INSURED);
      reinsured = (String) mp1.get(Keys.LY36_REINSURED);
      coverholder = (String) mp1.get(Keys.LY36_COVER_HOLDER);
      claimant = (String) mp1.get(Keys.LY36_CLAIMANT);
      vesselAircraft = (String) mp1.get(Keys.LY36_VESSEL_AIRCRAFT);
      lossName = (String) mp1.get(Keys.LY36_LOSS_NAME);
      otherName = (String) mp1.get(Keys.LY36_OTHER_NAME);
      dolFrom = (String) mp1.get(Keys.LY36_LOSS_DATE_FROM);
      dolTo = (String) mp1.get(Keys.LY36_LOSS_DATE_TO);
      dolQual = (String) mp1.get(Keys.LY36_LOSS_DATE_QUAL);
      dcmFrom = (String) mp1.get(Keys.LY36_DCM_DOD_FROM);
      dcmTo = (String) mp1.get(Keys.LY36_DCM_DOD_TO);
      dcmQual = (String) mp1.get(Keys.LY36_DCM_DOD_QUAL);
      dolNarrative = (String) mp1.get(Keys.LY36_LOSS_DATE_NARR);
      lossLocation = (String) mp1.get(Keys.LY36_LOSS_LOCATION);
      voyage = (String) mp1.get(Keys.LY36_VOYAGE);
      catCode = (String) mp1.get(Keys.LY36_CAT_CODE);
      pcsCat = (String) mp1.get(Keys.LY36_PCS_CAT_CODE);
      claimRiskType = (String) mp1.get(Keys.LY36_CLM_RISK_TYPE);

      claimNarrative = "";
      Vector claimDetails = (Vector)mp1.get("#C036_LOSS_DETAILS[]");
      for (int i=0; i<claimDetails.size(); i++) {
        MappedRecord claimDetLine = (MappedRecord)claimDetails.elementAt(i);
        if (i>0)
          claimNarrative += "\n";

        claimNarrative += (String)claimDetLine.get("@C036_LOSS_DET_LINE");
      }
      while ((claimNarrative.length()>0) && (claimNarrative.lastIndexOf("\n")==claimNarrative.length()-1)) {
        claimNarrative = claimNarrative.substring(0,claimNarrative.length()-1);
      }

      adjSurvName = (String) mp1.get(Keys.LY36_ADJUSTER_NAME);
      adjSurvRef = (String) mp1.get(Keys.LY36_ADJUSTER_REF);
      lawyerName = (String) mp1.get(Keys.LY36_LAWYER_NAME);
      lawyerRef = (String) mp1.get(Keys.LY36_LAWYER_REF);

      causeCode = (String) mp1.get(Keys.LY36_CAUSE_CODE);

      // CCN 21    DEVO   15/01/2003
      chClmRef     = (String) mp1.get(Keys.LY36_CH_CLM_REF);

      
      /*Extract Certificate of insurance no.*/
      Vector v3 = (Vector) mp1.get(Keys.LY36_COI_TABLE);
      for(int x =0; x < v3.size();x++)
      {
        MappedRecord mp5 = (MappedRecord) v3.get(x);
        switch(x)
        {
          case 0:
            certInsNo1 = (String) mp5.get(Keys.LY36_CERT_INS_NO);
            break;
          case 1:
            certInsNo2 = (String) mp5.get(Keys.LY36_CERT_INS_NO);
            break;
          case 2:
            certInsNo3 = (String) mp5.get(Keys.LY36_CERT_INS_NO);
            break;
          case 3:
            certInsNo4 = (String) mp5.get(Keys.LY36_CERT_INS_NO);
            break;
          case 4:
            certInsNo5 = (String) mp5.get(Keys.LY36_CERT_INS_NO);
        }
      }
      
    }
  }
  
  /*
   * clintonj [SIR 37546] [10/03/2004]
   * Functions added to fix adjuster/lawyer 20 char issue.
   */
  public String getC034_ADJ_NAME_ATTR() {
    return C034_ADJ_NAME_ATTR;
  }
  
  public String getC034_ADJ_REF_ATTR() {
    return C034_ADJ_REF_ATTR;
  }
  
  public String getC034_LAW_NAME_ATTR() {
    return C034_LAW_NAME_ATTR;
  }
  
  public String getC034_LAW_REF_ATTR() {
    return C034_LAW_REF_ATTR;
  }
  
  public boolean getSaveButtonFlag() {
    return saveBtnFlag;
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

  public String getOsnd1() {
    return osnd1;
  }

  public String getOsnd2() {
    return osnd2;
  }

  public String getOsnd3() {
    return osnd3;
  }

  public String getPeerReview() {
    return peerReview;
  }

  public String getOrigBroker() {
    return origBroker;
  }

  public String getBkrContact() {
    return htmlSafe(bkrContact);
  }

  public String getBkrContactFlag() {
    return bkrContactFlag;
  }

  public String getBkrPhoneNo() {
    return htmlSafe(bkrPhoneNo);
  }

  public String getBkrPhoneNoFlag() {
    return bkrPhoneNoFlag;
  }

  public String getBkrClaimRef1() {
    return htmlSafe(bkrClaimRef1);
  }

  public String getBkrClaimRef1Flag() {
    return bkrClaimRef1Flag;
  }

  public String getBkrClaimRef2() {
    return htmlSafe(bkrClaimRef2);
  }

  public String getBkrClaimRef2Flag() {
    return bkrClaimRef2Flag;
  }

  public boolean getBkrUcrFlag() {
    return bkrUcrFlag;
  }

  public String getBkrUcr() {
    return bkrUcr;
  }

  public String getOrigInsured() {
    return htmlSafe(origInsured);
  }

  public String getBkrOrigInsuredFlag() {
    return bkrOrigInsuredFlag;
  }

  public String getInsured() {
    return htmlSafe(insured);
  }

  public String getInsuredFlag() {
    return insuredFlag;
  }

  public String getReinsured() {
    return htmlSafe(reinsured);
  }

  public String getReinsuredFlag() {
    return reinsuredFlag;
  }

  public String getCoverholder() {
    return htmlSafe(coverholder);
  }

  public String getCoverholderFlag() {
    return coverholderFlag;
  }

  public String getClaimant() {
    return htmlSafe(claimant);
  }

  public String getClaimantFlag() {
    return claimantFlag;
  }

  public String getVesselAircraft() {
    return htmlSafe(vesselAircraft);
  }

  public String getVesselAircraftFlag() {
    return vesselAircraftFlag;
  }

  public String getLossName() {
    return htmlSafe(lossName);
  }

  public String getLossNameFlag() {
    return lossNameFlag;
  }

  public String getOtherName() {
    return htmlSafe(otherName);
  }

  public String getOtherNameFlag() {
    return otherNameFlag;
  }

  public boolean getDolFromFlag() {
    return dolFromFlag;
  }

  public String getDolFrom() {
    return dolFrom;
  }

  public boolean getDolToFlag() {
    return dolToFlag;
  }

  public String getDolTo() {
    return dolTo;
  }

  public String getDolQual() {
    return dolQual;
  }

  public boolean getDolQualFlag() {
    return dolQualFlag;
  }

  public boolean getDcmFromFlag() {
    return dcmFromFlag;
  }

  public String getDcmFrom() {
    return dcmFrom;
  }

  public boolean getDcmToFlag() {
    return dcmToFlag;
  }

  public String getDcmTo() {
    return dcmTo;
  }

  public String getDcmQual() {
    return dcmQual;
  }

  public boolean getDcmQualFlag() {
    return dcmQualFlag;
  }

  public String getDolNarrative() {
    return htmlSafe(dolNarrative);
  }

  public String getDolNarrativeFlag() {
    return dolNarrativeFlag;
  }

  public String getLossLocation() {
    return htmlSafe(lossLocation);
  }

  public String getLossLocationFlag() {
    return lossLocationFlag;
  }

  public String getVoyage() {
    return htmlSafe(voyage);
  }

  public String getVoyageFlag() {
    return voyageFlag;
  }

  public String getCatCode() {
    return catCode;
  }

  public boolean getCatCodeFlag() {
    return catCodeFlag;
  }

  public String getPcsCat() {
    return pcsCat;
  }

  public boolean getPcsCatFlag() {
    return pcsCatFlag;
  }

  public String getClaimRiskType() {
    return htmlSafe(claimRiskType);
  }

  public boolean getClaimRiskTypeFlag() {
    return claimRiskTypeFlag;
  }

  public String getClaimNarrativeFlag() {
    return claimNarrativeFlag;
  }

  public String getClaimNarrative() {
    return htmlSafe(claimNarrative.replace('¬','\n'));
  }

  public String getAdjSurvName() {
    return htmlSafe(removeAmps(adjSurvName));
  }

  public boolean getAdjSurvNameFlag() {
    return adjSurvNameFlag;
  }

  public String getAdjSurvCode() {
    return adjSurvCode;
  }

  public String getAdjSurvCodeFlag() {
    return adjSurvCodeFlag;
  }

  public String getAdjSurvRef() {
    return htmlSafe(adjSurvRef);
  }

  public String getAdjSurvRefFlag() {
    return adjSurvRefFlag;
  }

  public String getLawyerName() {
    return htmlSafe(removeAmps(lawyerName));
  }

  public boolean getLawyerNameFlag() {
    return lawyerNameFlag;
  }

  public String getLawyerCode() {
    return lawyerCode;
  }

  public String getLawyerCodeFlag() {
    return lawyerCodeFlag;
  }

  public String getLawyerRef() {
    return htmlSafe(lawyerRef);
  }

  public String getLawyerRefFlag() {
    return lawyerRefFlag;
  }

  public String getCauseCode() {
    return causeCode;
  }

  public boolean getCauseCodeFlag() {
    return causeCodeFlag;
  }

  public String getFinderCode1() {
    return finderCode1;
  }

  public String getFinderCode1Flag() {
    return finderCode1Flag;
  }

  public String getFinderCode2() {
    return finderCode2;
  }

  public String getFinderCode2Flag() {
    return finderCode2Flag;
  }

  public String getFinderCode3() {
    return finderCode3;
  }

  public String getFinderCode3Flag() {
    return finderCode3Flag;
  }
  public String getOrigBrokerFlag() {
    return origBrokerFlag;
  }
  public String getOsnd1Flag() {
    return osnd1Flag;
  }
  public String getOsnd2Flag() {
    return osnd2Flag;
  }
  public String getOsnd3Flag() {
    return osnd3Flag;
  }
  public String getPeerReviewFlag() {
    return peerReviewFlag;
  }
  public String getScreenMode() {
    return screenMode;
  }
  public String getTrFlag() {
    return trFlag;
  }
  public String getUcrFlag() {
    return ucrFlag;
  }
  public String getXcrFlag() {
    return xcrFlag;
  }
  public String getSignedInd() {
    return signedInd;
  }
  public String getSignedIndFlag() {
    return signedIndFlag;
  }
  public String getChClmRef() {
    return htmlSafe(chClmRef);
  }
  public String getChClmRefFlag() {
    return chClmRefFlag;
  }
  public boolean showLossDetails() {
    return showLossDetails;
  }


    public String getCertInsNo1()
    {
        return certInsNo1;
    }

    public String getCertInsNo1Flag()
    {
        return certInsNo1Flag;
    }

    public String getCertInsNo2()
    {
        return certInsNo2;
    }

    public String getCertInsNo2Flag()
    {
        return certInsNo2Flag;
    }

    public String getCertInsNo3()
    {
        return certInsNo3;
    }

    public String getCertInsNo3Flag()
    {
        return certInsNo3Flag;
    }

    public String getCertInsNo4()
    {
        return certInsNo4;
    }

    public String getCertInsNo4Flag()
    {
        return certInsNo4Flag;
    }

    public String getCertInsNo5()
    {
        return certInsNo5;
    }

    public String getCertInsNo5Flag()
    {
        return certInsNo5Flag;
    }

    public ModelManager getMm()
    {
        return mm;
    }

    public boolean isSaveBtnFlag()
    {
        return saveBtnFlag;
    }

    public boolean isShowLossDetails()
    {
        return showLossDetails;
    }

	public String getBindClass() {
		return bindClass;
	}

	public boolean isBindClassFlag() {
		return bindClassFlag;
	}
    
    
}