package com.xchanging.xcc.web.models;

import java.lang.Math;
import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY44Event;
import com.xchanging.xcc.events.LY45Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String hUcr = "" ;
  private String hXcr = "" ;
  private String hTr = "" ;
  private String hOsnd = "" ;
  private String hOrigBkr = "" ;
  private String hOrigCcy = "" ;
  private String hCor = "" ;
  private String hPayeeBkr = "" ;
  private String hMvmtRefDate = "" ;
  private String hSigned = "" ;
  private String hLoc = "" ;
  private String hPeerReview = "" ;
  private String hRedenomInd = "" ;
  private String origCcy = "" ;
  private String claimRefRec = "" ;
  private String osRateOfExch = "" ;
  private String pTDLoss = "" ;
  private String pTTLoss = "" ;
  private String osLoss = "" ;
  private String osLossQual = "" ;
  private String pTDExp = "" ;
  private String pTTExp = "" ;
  private String osExp = "" ;
  private String pTDFee = "" ;
  private String pTTFee = "" ;
  private String osFee = "" ;
  private String osFeeQual = "" ;
  private String pTDTotal = "" ;
  private String pTTTotal = "" ;
  private String osTotal = "" ;
  private String osTotalQual = "" ;
  private String highestEst = "" ;
  private String incurred = "" ;
  private String settCcy = "" ;
  private String settRateOfExch = "" ;
  private String pTDInSettCcy = "" ;
  private String settledRateInSettCcy = "" ;
  private String totalLine = "" ;
  private String bureauPpn = "" ;
  private String vATAmount = "" ;
  private String wARAmount = "" ;
  private String narrativeCode1 = "" ;
  private String narrativeCode2 = "" ;
  private String narrativeForSet = "" ;
  private String narrativeForSet2 = "" ;
  private String narrativeForSet3 = "" ;
  private String finderCode1 = "" ;
  private String finderCode2 = "" ;
  private String finderCode3 = "" ;
  private String subrogation = "" ;
  private String checkedSubrogation = "";

  private String xCSRecovery = "" ;
  private String attachmentsInd = "" ;
  private String checkedAttachmentsInd = "" ;


  // Change N0045
  // private String cashCor = "" ;
  private String filCode1 = "" ;
  private String filCode2 = "" ;
  private String tfCode = "" ;
  private String stateCode = "" ;
  private String naicCode = "" ;
  private String naicQual = "" ;
  private String warInd = "" ;
  private String checkedWarInd = "" ;

  private String brokerContact = "" ;
  private String brokerPhoneNo = "" ;
  private String claimBrokerRef1 = "";
  private String claimBrokerRef2 = "";
  private String brokerClaimRef1 = "" ;
  private String brokerClaimRef2 = "" ;
  private String origInsured = "" ;
  private String insured = "" ;
  private String resinsured = "" ;
  private String claimholder = "" ;
  private String claimant = "" ;
  private String vesselAircraft = "" ;
  private String countryOfOrigin = "" ;
  private String polCertPeriodFrom = "" ;
  private String polCertPeriodTo = "" ;
  private String polCertQual = "" ;
  private String dOLFrom = "" ;
  private String dOLTo = "" ;
  private String dOLQual = "" ;
  private String dolNarr = "";
  private String dCMFrom = "" ;
  private String dCMTo = "" ;
  private String dCMQual = "" ;
  private String ccyOfLimits = "" ;
  private String limits = "" ;
  private String excess = "" ;
  private String catCode = "" ;
  private String pcsCode = "" ;
  private String serviceType = "" ;         // for CR8  
  private String perilsCondition = "" ;
  private String lossLocation = "" ;
  private String voyage = "" ;
  private String lossName = "" ;
  private String claimNarrative = "" ;
  private String lawyerName = "" ;
  private String adjusterName = "" ;
  private String lawyerRef = "" ;
  private String adjusterRef = "" ;
  private String lawyerCode = "" ;
  private String adjusterCode = "" ;
  private String otherTfCode = "" ;
  private String dti = "" ;
  private String schemeCode = "" ;
  private String countyCode="";
  
  private boolean origCcyFlag;
  private boolean claimRefRecFlag;
  private String osRateOfExchFlag;
  private String pTDLossFlag;
  private String pTTLossFlag;
  private String osLossFlag;
  private boolean osLossQualFlag;
  private String pTDExpFlag;
  private String pTTExpFlag;
  private String osExpFlag;
  private String pTDFeeFlag;
  private String pTTFeeFlag;
  private String osFeeFlag;
  private boolean osFeeQualFlag;
  private String pTDTotalFlag;
  private String pTTTotalFlag;
  private String osTotalFlag;
  private String highestEstFlag;
  private String incurredFlag;
  private boolean settCcyFlag;
  private String settRateOfExchFlag;
  private String pTDInSettCcyFlag;
  private String settledRateInSettCcyFlag;
  private String totalLineFlag;
  private String bureauPpnFlag;
  private String vATAmountFlag;
  private String wARAmountFlag;
  private boolean narrativeCode1Flag;
  private boolean narrativeCode2Flag;
  private String narrativeForSetFlag;
  private String narrativeForSet2Flag;
  private String narrativeForSet3Flag;
  private String finderCode1Flag;
  private String finderCode2Flag;
  private String finderCode3Flag;
  private String subrogationFlag;

  private String xCSRecoveryFlag;
  private String attachmentsIndFlag;
  // Change N0045
  // private boolean cashCorFlag;
  private boolean filCode1Flag;
  private boolean filCode2Flag;
  private boolean tfCodeFlag;
  private boolean stateCodeFlag;
  private String naicCodeFlag;
  private boolean naicQualFlag;
  private String warIndFlag;
  private String brokerContactFlag;
  private String brokerPhoneNoFlag;
  private String claimBrokerRef1Flag;
  private String claimBrokerRef2Flag;
  private String brokerClaimRef1Flag;
  private String brokerClaimRef2Flag;
  private String origInsuredFlag;
  private String insuredFlag;
  private String reinsuredFlag;
  private String claimholderFlag;
  private String claimantFlag;
  private String vesselAircraftFlag;
  private boolean countryOfOriginFlag;
  private boolean polCertPeriodFromFlag;
  private boolean polCertPeriodToFlag;
  private boolean polCertQualFlag;
  private boolean dOLFromFlag;
  private boolean dOLToFlag;
  private boolean dOLQualFlag;
  private String dolNarrFlag;
  private boolean dCMFromFlag;
  private boolean dCMToFlag;
  private boolean dCMQualFlag;
  private boolean ccyOfLimitsFlag;
  private String limitsFlag;
  private String excessFlag;
  private boolean catCodeFlag;
  private boolean pcsCodeFlag;
  private boolean serviceTypeFlag;
  private String perilsConditionFlag;
  private String lossLocationFlag;
  private String voyageFlag;
  private String lossNameFlag;
  private String claimNarrativeFlag;
  private boolean lawyerNameFlag;
  private boolean adjusterNameFlag;
  private String lawyerRefFlag;
  private String adjusterRefFlag;
  private String lawyerCodeFlag;
  private String adjusterCodeFlag;
  private boolean otherTfCodeFlag;
  private boolean dtiFlag;
  private boolean schemeCodeFlag;
  private String countyCodeflag;
  // The following items are present in the LY43 commarea but were not defined in
  // this class, as at 11/2002.  They are present in case they are used in
  // future.
  private String otherName = "";
  private String slipTypeDesc = "";

  private String hXCRFlag;
  private String hUCRFlag;
  private String hTRFlag;
  private String hOrigRefFlag;
  private String hOrigBkrFlag;
  private String hSignIndFlag;
  private String hPeerRevFlag;
  private String hOrigCurrFlag;
  private String hLocIndFlag;
  private String hPayeeBkrFlag;
  private String hRedenomFlag;
  private String hMoveRefAttr;
  private boolean osTotalQualFlag;
  private String corFlag;
  private String otherNameFlag;
  private String slipTypeDescFlag;
  private double bureauPpnOfVATAmount;

  private String screenMode;

  // Members stored as boolean, and used as boolean in JSP calls.
  // Type should be kept as boolean
  private boolean saveButtonFlag;
  private boolean endBDFlag;
  private boolean newBDFlag;
  private boolean riSchdFlag;
  private boolean bindSchdFlag;
  private boolean backFlag;
  private boolean euroFlag;
  private boolean ccsFlag;
  private boolean newMovementFlag;
  private boolean vatRateButtonFlag;


  // The following items are present in the LY44 commarea but were not defined in
  // this class, as at 11/2002.  They are present in case they are used in
  // future.
  private String currNoVal = "" ;
  private String sdnNoVal = "" ;
  private String bdownNoVal = "" ;

  // Changes resulting from CCN K0009
  private String usaCanInd = "";
  private String checkedUsaCanInd = "";
  private String usaCanIndFlag;

  // CCN #N0031 and N0021 - BA - 15/01/2003
  private String lfEntryInd = "" ;
  private String lfAdvanceInd = "" ;
  private String blockInd = "" ;
  
 
  //SIR:150695 ECF Phase 6 Changes - start
  private String directReportInd = "" ;   
  private String clmInLitigationInd = "" ;
//TP866603 Changes for newly added barcode field
  private String barcode= "";
  private String checkedDirectReportInd = "" ;
  private String checkedClmInLitigationInd = "" ;
  
  private String directReportFlag = "" ;
  private String clmInLitigationFlag = "" ;
//TP866603 Changes for newly added barcode field to make as protected

  private String barcodeFlag= "";
  //SIR:150695 ECF Phase 6 Changes - end

  // CR 1442 - D.Smith - 12/12/03
  private String cOptOutStatus = "";
  private String cOptOutDate = "";

  private String checkedLFEntryInd = "" ;
  private String checkedLFAdvanceInd = "" ;
  private String checkedBlockInd = "" ;

  private String lfAdvanceFlag = "" ;
  private String lfEntryFlag = "" ;
  private String blockFlag = "" ;

 // CR 1442 - D.Smith - 12/12/03
   private String clmOptOutStatusFlag = "" ;
   private String clmOptOutDateFlag = "" ;

  // Devo September 2003   CCN s229
  // Adding new fields to the scm screen as part of the work to split the two
  // screens into an update and enquiry version
  //
  // These are the new fields to be displayed on the new enquiry screen
  private String sAP_REF                      ="";
  private String sYEAR_OF_ACC                 ="";
  private String sGROUP_REF                   ="";
  private String sUMR                         ="";
  private String sMKT_CODE                    ="";
  private String sCOV_DATE_FROM               ="";
  private String sCOV_DATE_TO                 ="";
  private String sCOV_QUAL                    ="";
  private String sPER_NARR                    ="";
  private String sSLIP_ORD_1                  ="";
  private String sSLIP_ORD_2                  ="";
  private String sLIMIT_BASIS                 ="";
  private String sSI_NARR                     ="";

  private String sPOLICY_NARR_TABLE           ="";
  private String sPOLICY_NARR_LINE1           ="";
  private String sPOLICY_NARR_LINE2           ="";
  private String sPOLICY_NARR_LINE3           ="";
  private String sPOLICY_NARR_LINE4           ="";

  private String sRISK_CODE                   ="";
  private String sNO_SYNDS                    ="";
  private String sMARKET_SOURCE               ="";
  private String sMARKET_COUNT                ="";
  private String sMARKET_TABLE                ="";
  private String sCLAIM_LINE_NO               ="";
  private String sCOY_CODE                    ="";
  private String sCOY_LINE                    ="";
  private String sCOY_REF_1                   ="";
  private String sBUREAU_LEAD_IND             ="";
  private String sLLOYDS_CLAIM_TYPE           ="";
  private String sINTEREST                    ="";
  private String sLOC_VOYAGE                  ="";

  private String sXCR_CLAIM_NARR              ="";
  private String sCLM_NARR_LINE1              ="";
  private String sCLM_NARR_LINE2              ="";
  private String sCLM_NARR_LINE3              ="";

  private String sCHOLDER_CLM_REF             ="";
  private String sTRANS_SYNOPSIS              ="";
  private String sTRANS_SYNOPSIS_LINE         ="";
  private String sSYNOPSIS_TEXT1   	          ="";
  private String sSYNOPSIS_TEXT2   	          ="";
  private String sSYNOPSIS_TEXT3   	          ="";
  private String sSYNOPSIS_TEXT4   	          ="";

  private String sTDN_REF             	      ="";
  private String sUSER_ID             	      ="";
  private String sCHARGE_TYPE                 ="";

  // This vector will contain the 10 Mapped Records which will
  // contain the market details. Note the Mainframe will only be sending through
  // 10 market details - even if more exist. The user will go to the Market Details
  // screen if they want the others!
  private Vector vAllMarketDetails;


  // These are the new attributes which match up with the fields
  // defined above for the new enquiry screen.
  private boolean bAP_REFFlag;
  private boolean bYOAFlag;
  private boolean bGROUP_REFFlag;
  private boolean bUMRFlag;
  private boolean bMKT_CODEFlag;
  private boolean bCOV_DATE_FROMFlag;
  private boolean bCOV_DATE_TOFlag;
  private boolean bCOV_QUALFlag;
  private boolean bPER_NARRFlag;
  private boolean bSLIP_ORD_1Flag;
  private boolean bSLIP_ORD_2Flag;
  private boolean bLIMIT_BASISFlag;
  private boolean bSI_NARRFlag;
  private boolean bPOLICY_NARRFlag;
  private boolean bRISK_CODEFlag;
  private boolean bNO_SYNDSFlag;
  private boolean bMARKET_SOURCEFlag;
  private boolean bMARKETFlag;
  private boolean bLLOYDS_CLAIM_TYPEFlag;
  private boolean bINTERESTFlag;
  private boolean bLOC_VOYFlag;
  private boolean bXCR_CLAIM_NARRFlag;
  private boolean bCHOLDER_CLM_REFFlag;
  private boolean bTRANS_SYNOPSISFlag;
  private boolean bTDN_REFFlag;
  private boolean bUSER_IDFlag;
  private boolean bCHARGE_TYPEFlag;

  /*Expert Fee breakdown screen flag*/
  private boolean bExpertFeeBreakDownLinkFlag;
 

  public SCMAdviceModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SCMAdviceModelKey, this);
  }

  public void performUpdate() {
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);
    
    

    if (event instanceof LY43Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      screenMode = (String) results.get("@C043_SCREEN_MODE");
      mm.getUserWebModel().setUpdateMode(screenMode);
      if (screenMode.equals("E"))
          {saveButtonFlag = true;}
      else {saveButtonFlag = false;}


      Vector v = (Vector)results.get(Keys.LY43_FIELD_VALUES) ;
      MappedRecord mrFieldValues = (MappedRecord)v.get(0);

      hXcr = (String)mrFieldValues.get(Keys.LY43_XCR) ;
      hUcr = (String)mrFieldValues.get(Keys.LY43_UCR) ;
      hTr = (String)mrFieldValues.get(Keys.LY43_TR) ;
      hOsnd = (String)mrFieldValues.get(Keys.LY43_ORIG_REF) ;
      hOrigBkr = (String)mrFieldValues.get(Keys.LY43_ORIG_BKR) ;
      hSigned = (String)mrFieldValues.get(Keys.LY43_SIGNED_IND) ;
      hPeerReview = (String)mrFieldValues.get(Keys.LY43_PEER_REV_IND) ;
      hOrigCcy = (String)mrFieldValues.get(Keys.LY43_ORIG_CURR_HDR) ;
      hCor = (String)mrFieldValues.get(Keys.LY43_COR) ;
      hLoc = (String)mrFieldValues.get(Keys.LY43_LOC_IND) ;
      hPayeeBkr = (String)mrFieldValues.get(Keys.LY43_PAYEE_BKR_CODE) ;
      hRedenomInd = (String)mrFieldValues.get(Keys.LY43_REDENOM_IND) ;
      hMvmtRefDate = (String)mrFieldValues.get(Keys.LY43_MOVE_REF) ;
      claimRefRec = (String)mrFieldValues.get(Keys.LY43_CLM_REF_REC) ;
      origCcy = (String)mrFieldValues.get(Keys.LY43_ORIG_CURR) ;
      settCcy = (String)mrFieldValues.get(Keys.LY43_SETT_CURR) ;
      settRateOfExch = (String)mrFieldValues.get(Keys.LY43_EXCH_RATE) ;
      pTDLoss = (String)mrFieldValues.get(Keys.LY43_PTD_LOSS) ;
      pTDExp = (String)mrFieldValues.get(Keys.LY43_PTD_EXP) ;
      pTDFee = (String)mrFieldValues.get(Keys.LY43_PTD_FEE) ;
      pTDTotal = (String)mrFieldValues.get(Keys.LY43_PTD_TOTAL) ;
      pTTLoss = (String)mrFieldValues.get(Keys.LY43_PTT_LOSS) ;
      pTTExp = (String)mrFieldValues.get(Keys.LY43_PTT_EXP) ;
      pTTFee = (String)mrFieldValues.get(Keys.LY43_PTT_FEE) ;
      pTTTotal = (String)mrFieldValues.get(Keys.LY43_PTT_TOTAL) ;
      
      osLoss = (String)mrFieldValues.get(Keys.LY43_OUTST_LOSS) ;
      osLossQual = (String)mrFieldValues.get(Keys.LY43_OUTST_LOSS_QUAL) ;
      osExp = (String)mrFieldValues.get(Keys.LY43_OUTST_EXP) ;
      osFee = (String)mrFieldValues.get(Keys.LY43_OUTST_FEE) ;
      osFeeQual = (String)mrFieldValues.get(Keys.LY43_OUTST_FEE_QUAL) ;
      osTotal = (String)mrFieldValues.get(Keys.LY43_OUTST_TOT) ;
      osTotalQual = (String)mrFieldValues.get(Keys.LY43_OUTST_TOT_QUAL) ;
      pTDInSettCcy = (String)mrFieldValues.get(Keys.LY43_PTD_SETT_AMT) ;
      settledRateInSettCcy = (String)mrFieldValues.get(Keys.LY43_CLAIM_AMT_SETT) ;
      totalLine = (String)mrFieldValues.get(Keys.LY43_BUREAU_LINE) ;
      bureauPpn = (String)mrFieldValues.get(Keys.LY43_BUR_PROP_AMT) ;
      vATAmount = (String)mrFieldValues.get(Keys.LY43_HPC_VAT_AMT) ;



      wARAmount = (String)mrFieldValues.get(Keys.LY43_WAR_AMT) ;
      narrativeCode1 = (String)mrFieldValues.get(Keys.LY43_NARR_CODE_1) ;
      narrativeCode2 = (String)mrFieldValues.get(Keys.LY43_NARR_CODE_2) ;
      narrativeForSet = (String)mrFieldValues.get(Keys.LY43_SETT_NARR_1) ;
      narrativeForSet2 = (String)mrFieldValues.get(Keys.LY43_SETT_NARR_2) ;
      narrativeForSet3 = (String)mrFieldValues.get(Keys.LY43_SETT_NARR_3) ;
      subrogation = (String)mrFieldValues.get(Keys.LY43_SUBROGATION) ;
      checkedSubrogation = checkBoxStatus(subrogation);

      xCSRecovery = (String)mrFieldValues.get(Keys.LY43_XCS_REC_REF) ;
      highestEst = (String)mrFieldValues.get(Keys.LY43_HIGHEST_EST) ;
      incurred = (String)mrFieldValues.get(Keys.LY43_INCURRED_AMT) ;
      osRateOfExch = (String)mrFieldValues.get(Keys.LY43_RATE_EXCH_OUTST) ;
      finderCode1 = (String)mrFieldValues.get(Keys.LY43_FINDER_CODE_1) ;
      finderCode2 = (String)mrFieldValues.get(Keys.LY43_FINDER_CODE_2) ;
      finderCode3 = (String)mrFieldValues.get(Keys.LY43_FINDER_CODE_3) ;
      attachmentsInd = (String)mrFieldValues.get(Keys.LY43_ATTACHMENT_IND) ;
      checkedAttachmentsInd = checkBoxStatus(attachmentsInd);

      /*
        Change: N0045
        Date:   12th Dec 02 (DH)
        cashCor = (String)mrFieldValues.get(Keys.LY43_CASH_COR) ;
      */

      brokerContact = (String)mrFieldValues.get(Keys.LY43_BKR_CNTCT) ;
      brokerPhoneNo = (String)mrFieldValues.get(Keys.LY43_BKR_CNTCT_PHONE) ;
      brokerClaimRef1 = (String)mrFieldValues.get(Keys.LY43_BKR_REF_1) ;
      brokerClaimRef2 = (String)mrFieldValues.get(Keys.LY43_BKR_REF_2) ;
      claimBrokerRef1 = (String)mrFieldValues.get(Keys.LY43_CLM_BKR_REF_1) ;
      claimBrokerRef2 = (String)mrFieldValues.get(Keys.LY43_CLM_BKR_REF_2) ;

      countryOfOrigin = (String)mrFieldValues.get(Keys.LY43_CNTRY_OF_ORIGIN) ;
      origInsured = (String)mrFieldValues.get(Keys.LY43_ORIG_INSURED) ;
      if (origInsured.length() > 25) {
        origInsured = origInsured.substring(0, 25);
      }
      insured = (String)mrFieldValues.get(Keys.LY43_INSURED) ;
      if (insured.length() > 25) {
        insured = insured.substring(0, 25);
      }
      resinsured = (String)mrFieldValues.get(Keys.LY43_REINSURED) ;
      if (resinsured.length() > 25) {
        resinsured = resinsured.substring(0, 25);
      }
      claimholder = (String)mrFieldValues.get(Keys.LY43_COVER_HOLDER) ;
      if (claimholder.length() > 25) {
        claimholder = claimholder.substring(0, 25);
      }
      claimant = (String)mrFieldValues.get(Keys.LY43_CLAIMANT) ;
      vesselAircraft = (String)mrFieldValues.get(Keys.LY43_VESSEL_AIRCRAFT) ;
      if (vesselAircraft.length() > 25) {
        vesselAircraft = vesselAircraft.substring(0, 25);
      }
      otherName = (String)mrFieldValues.get(Keys.LY43_OTHER_NAME) ;
      if (otherName.length() > 25) {
        otherName = otherName.substring(0, 25);
      }
      polCertPeriodFrom = (String)mrFieldValues.get(Keys.LY43_POL_CERT_FROM) ;
      polCertPeriodTo = (String)mrFieldValues.get(Keys.LY43_POL_CERT_TO) ;
      polCertQual = (String)mrFieldValues.get(Keys.LY43_POL_CERT_QUAL) ;
      dOLFrom = (String)mrFieldValues.get(Keys.LY43_LOSS_DATE_FROM) ;
      dOLTo = (String)mrFieldValues.get(Keys.LY43_LOSS_DATE_TO) ;
      dOLQual = (String)mrFieldValues.get(Keys.LY43_LOSS_DATE_QUAL) ;
      dolNarr = (String)mrFieldValues.get(Keys.LY43_LOSS_DATE_NARR) ;
      dCMFrom = (String)mrFieldValues.get(Keys.LY43_CLAIM_DATE_FROM) ;
      dCMTo = (String)mrFieldValues.get(Keys.LY43_CLAIM_DATE_TO) ;
      dCMQual = (String)mrFieldValues.get(Keys.LY43_CLAIM_DATE_QUAL) ;
      catCode = (String)mrFieldValues.get(Keys.LY43_CAT_CODE) ;
      pcsCode = (String)mrFieldValues.get(Keys.LY43_PCS_CAT_CODE) ;
      ccyOfLimits = (String)mrFieldValues.get(Keys.LY43_LIMIT_CURR) ;
      limits = (String)mrFieldValues.get(Keys.LY43_SI_LIMIT) ;
      excess = (String)mrFieldValues.get(Keys.LY43_EXCESS_AMT) ;
      perilsCondition = (String)mrFieldValues.get(Keys.LY43_PERILS_CONDS) ;
      lossLocation = (String)mrFieldValues.get(Keys.LY43_LOSS_LOCATION) ;
      voyage = (String)mrFieldValues.get(Keys.LY43_VOYAGE) ;
      lossName = (String)mrFieldValues.get(Keys.LY43_LOSS_NAME) ;
      slipTypeDesc = (String)mrFieldValues.get(Keys.LY43_SLIP_TYPE_DESC) ;
      claimNarrative = "";
      Vector claimDetails = (Vector)mrFieldValues.get("#C043_CLAIM_DETAILS[]");
      for (int i=0; i<claimDetails.size(); i++) {
        MappedRecord claimDetLine = (MappedRecord)claimDetails.elementAt(i);
        if (i>0)
          claimNarrative += "\n";

        claimNarrative += (String)claimDetLine.get("@C043_CLAIM_DET_LINE");
      }
      while ((claimNarrative.length()>0) && (claimNarrative.lastIndexOf("\n")==claimNarrative.length()-1)) {
        claimNarrative = claimNarrative.substring(0,claimNarrative.length()-1);
      }

      lawyerName = (String)mrFieldValues.get(Keys.LY43_LAWYER_NAME) ;
      lawyerRef = (String)mrFieldValues.get(Keys.LY43_LAWYER_REF) ;
      lawyerCode = (String)mrFieldValues.get(Keys.LY43_LAWYER_CODE) ;
      adjusterName = (String)mrFieldValues.get(Keys.LY43_ADJUSTER_NAME) ;
      adjusterRef = (String)mrFieldValues.get(Keys.LY43_ADJUSTER_REF) ;
      adjusterCode = (String)mrFieldValues.get(Keys.LY43_ADJUSTER_CODE) ;
      countyCode= 	(String)mrFieldValues.get(Keys.LY43_COUNTY_CODE) ;
      
      
      schemeCode = (String)mrFieldValues.get(Keys.LY43_SCHEME_CODE) ;
      tfCode = (String)mrFieldValues.get(Keys.LY43_TF_CODE) ;
      stateCode = (String)mrFieldValues.get(Keys.LY43_STATE_CODE) ;
      naicCode = (String)mrFieldValues.get(Keys.LY43_NAIC_CODE) ;
      naicQual = (String)mrFieldValues.get(Keys.LY43_NAIC_QUAL) ;
      warInd = (String)mrFieldValues.get(Keys.LY43_WAR_IND) ;
      checkedWarInd = checkBoxStatus(warInd);

      filCode1 = (String)mrFieldValues.get(Keys.LY43_FIL_CODE_1) ;
      filCode2 = (String)mrFieldValues.get(Keys.LY43_FIL_CODE_2) ;
      otherTfCode = (String)mrFieldValues.get(Keys.LY43_OTHER_TF_CODE) ;
      dti = (String)mrFieldValues.get(Keys.LY43_DTI_CODE) ;

      usaCanInd = (String)mrFieldValues.get(Keys.LY43_USA_CAN_IND);
      checkedUsaCanInd = checkBoxStatus(usaCanInd);

      // CCN #N0031 and N0021 - BA - 15/01/2003
      lfEntryInd = (String)mrFieldValues.get(Keys.LY43_LF_ENTRY_IND) ;
      checkedLFEntryInd = checkBoxStatus(lfEntryInd) ;
      lfAdvanceInd = (String)mrFieldValues.get(Keys.LY43_LF_ADVANCE_IND) ;
      checkedLFAdvanceInd = checkBoxStatus(lfAdvanceInd) ;
      blockInd = (String)mrFieldValues.get(Keys.LY43_BLOCK_IND) ;
      checkedBlockInd = checkBoxStatus(blockInd) ;

      //** SIR:150695 ECF Phase 6 changes start *****      
      directReportInd = (String)mrFieldValues.get(Keys.LY43_DIRECT_REPORT_IND);
      checkedDirectReportInd = checkBoxStatus(directReportInd);
      
      clmInLitigationInd = (String)mrFieldValues.get(Keys.LY43_LITIGATION_IND);
    //TP868446 Changes for newly added barcode field 
      barcode=(String)mrFieldValues.get(Keys.LY43_BARCODE);
      checkedClmInLitigationInd = checkBoxStatus(clmInLitigationInd);
      serviceType = (String)mrFieldValues.get(Keys.LY43_SERVICE_TYPE);
      //** SIR:150695 ECF Phase 6 changes end ****

      // CR 1442 - D.Smith - 12/12/03
      cOptOutStatus = (String)mrFieldValues.get(Keys.LY43_CLM_OPT_OUT_STATUS) ;
      cOptOutDate = (String)mrFieldValues.get(Keys.LY43_CLM_OPT_OUT_DATE) ;

      Vector vAttributes = (Vector)results.get(Keys.LY43_FIELD_ATTRIBUTES);
      MappedRecord mrFieldAttributes = (MappedRecord)vAttributes.get(0);

      hXCRFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_XCR_ATTR)) ;
      hUCRFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_UCR_ATTR)) ;
      hTRFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_TR_ATTR)) ;
      hOrigRefFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_ORIG_REF_ATTR)) ;
      hOrigBkrFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_ORIG_BKR_HDR_ATTR)) ;
      hSignIndFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SIGN_IND_ATTR)) ;
      hPeerRevFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PEER_REV_ATTR)) ;
      hOrigCurrFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_ORIG_CURR_HDR_ATTR)) ;

      /*
        Change: N0045
        Date:   12th Dec 02 (DH)
        cashCorFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_COR_ATTR)) ;
      */


      hLocIndFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_LOC_IND_ATTR)) ;
      hPayeeBkrFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PAYEE_BKR_ATTR)) ;
      hRedenomFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_REDENOM_ATTR)) ;
      hMoveRefAttr = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_MOVE_REF_ATTR)) ;
      claimRefRecFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_CLM_REF_REC_ATTR)) ;
      origCcyFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_ORIG_CURR_ATTR)) ;
      settCcyFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_SETT_CURR_ATTR)) ;
      settRateOfExchFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_EXCH_RATE_ATTR)) ;
      pTDLossFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTD_LOSS_ATTR)) ;
      pTDExpFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTD_EXP_ATTR)) ;
      pTDFeeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTD_FEE_ATTR)) ;
      pTDTotalFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTD_TOTAL_ATTR)) ;
      pTTLossFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTT_LOSS_ATTR)) ;
      pTTExpFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTT_EXP_ATTR)) ;
      pTTFeeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTT_FEE_ATTR)) ;
      pTTTotalFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTT_TOTAL_ATTR)) ;
      osLossFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_OUTST_LOSS_ATTR)) ;
      osLossQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_OUT_LOSS_Q_ATTR)) ;
      osExpFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_OUTST_EXP_ATTR)) ;
      osFeeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_OUTST_FEE_ATTR)) ;
      osFeeQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_OUT_FEE_Q_ATTR)) ;
      osTotalFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_OUTST_TOT_ATTR)) ;
      osTotalQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_OUT_TOT_Q_ATTR)) ;
      pTDInSettCcyFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PTD_SETT_ATTR)) ;
      settledRateInSettCcyFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SETT_AMT_ATTR)) ;
      totalLineFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BUR_LINE_ATTR)) ;
      bureauPpnFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BUR_PROP_ATTR)) ;
      vATAmountFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_VAT_AMT_ATTR)) ;
       Vector vctVATRateFlags = (Vector)mrFieldAttributes.get(Keys.LY43_VAT_RATE_ATTRS) ;
      MappedRecord mrVATRateFlags = (MappedRecord)vctVATRateFlags.get(0);

      vatRateButtonFlag = convertToBoolean((String)mrVATRateFlags.get(Keys.LY43_VAT_RATE_ATTR)) && (Double.parseDouble(vATAmount)==0);

      wARAmountFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_WAR_AMT_ATTR)) ;
      narrativeCode1Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_NARR_CODE_ATTR1)) ;
      narrativeCode2Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_NARR_CODE_ATTR2)) ;
      narrativeForSetFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SETT_NARR_ATTR1)) ;
      narrativeForSet2Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SETT_NARR_ATTR2)) ;
      narrativeForSet3Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SETT_NARR_ATTR3)) ;
      subrogationFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_SUBROG_ATTR)) ;
      xCSRecoveryFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_XCS_REC_REF_ATTR)) ;
      highestEstFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_HIGHEST_EST_ATTR)) ;
      incurredFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_INCURRED_ATTR)) ;
      osRateOfExchFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_OUTST_ROE_ATTR)) ;
      finderCode1Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_FIND_CODE_ATTR1)) ;
      finderCode2Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_FIND_CODE_ATTR2)) ;
      finderCode3Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_FIND_CODE_ATTR3)) ;
      attachmentsIndFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_ATTACH_IND_ATTR)) ;

      /*
        Change: N0045
        Date:   12th Dec 02 (DH)
        corFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_CASH_COR_ATTR)) ;
      */

      brokerContactFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BKR_CNTCT_ATTR)) ;
      brokerPhoneNoFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BKR_PHONE_ATTR)) ;
   // TP866603 Changes for barcode field to behave as protected
      barcodeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BARCODE_ATTR));

      claimBrokerRef1Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_CLM_BKR_REF_ATTR1)) ;
      claimBrokerRef2Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_CLM_BKR_REF_ATTR2)) ;
      brokerClaimRef1Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BKR_REF_ATTR1)) ;
      brokerClaimRef2Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_BKR_REF_ATTR2)) ;
      countryOfOriginFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_CNTRY_ATTR)) ;
      origInsuredFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_ORIG_INS_ATTR)) ;
      insuredFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_INSURED_ATTR)) ;
      reinsuredFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_REINSURED_ATTR)) ;
      claimholderFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_COV_HOLD_ATTR)) ;
      claimantFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_CLAIMANT_ATTR)) ;
      vesselAircraftFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_VESS_AIR_ATTR)) ;
      slipTypeDescFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SLIP_TYPE_DESC_ATTR)) ;
      otherNameFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_OTHER_NAME_ATTR)) ;
      polCertPeriodFromFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_POL_FROM_ATTR)) ;
      polCertPeriodToFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_POL_TO_ATTR)) ;
      polCertQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_POL_QUAL_ATTR)) ;
      dOLFromFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DOL_FROM_ATTR)) ;
      dOLToFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DOL_TO_ATTR)) ;
      dOLQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DOL_QUAL_ATTR)) ;
      dolNarrFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_DOL_NARR_ATTR)) ;
      dCMFromFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DCM_FROM_ATTR)) ;
      dCMToFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DCM_TO_ATTR)) ;
      dCMQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DCM_QUAL_ATTR)) ;
      catCodeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_CAT_ATTR)) ;
      pcsCodeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_PCS_CAT_ATTR)) ;
      serviceTypeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_SERVICE_TYPE_ATTR)) ;
      ccyOfLimitsFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_LIMIT_CURR_ATTR)) ;
      limitsFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_SI_LIMIT_ATTR)) ;
      excessFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_EXCESS_AMT_ATTR)) ;
      perilsConditionFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_PERILS_COND_ATTR)) ;
      lossLocationFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_LOSS_LOC_ATTR)) ;
      voyageFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_VOYAGE_ATTR)) ;
      lossNameFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_LOSS_NAME_ATTR)) ;
      claimNarrativeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_CLAIM_DETS_ATTR)) ;
      lawyerNameFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_LAW_NAME_ATTR)) ;
      lawyerRefFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_LAW_REF_ATTR)) ;
      lawyerCodeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_LAW_CODE_ATTR)) ;
      adjusterNameFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_ADJ_NAME_ATTR)) ;
      adjusterRefFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_ADJ_REF_ATTR)) ;
      adjusterCodeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_ADJ_CODE_ATTR)) ;
      schemeCodeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_SCH_CODE_ATTR)) ;
      tfCodeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_TF_CODE_ATTR)) ;
      stateCodeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_STATE_CODE_ATTR)) ;
      naicCodeFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_NAIC_CODE_ATTR)) ;
      naicQualFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_NAIC_QUAL_ATTR)) ;
      warIndFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_WAR_IND_ATTR)) ;
      filCode1Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_FIL_CODE_ATTR1)) ;
      filCode2Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_FIL_CODE_ATTR2)) ;
      otherTfCodeFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_OTHER_TF_ATTR)) ;
      dtiFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY43_DTI_CODE_ATTR)) ;
      usaCanIndFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_USA_CAN_ATTR)) ;
      
      countyCodeflag = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_COUNTY_CODE_ATTR)) ;
      
      // CCN #N0031 and N0021 - BA - 15/01/2003
      lfEntryFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_LF_ENTRY_ATTR)) ;
      lfAdvanceFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_LF_ADVANCE_ATTR)) ;
      blockFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_BLOCK_ATTR)) ;
      
      //SIR:150695 ECF Phase 6 Changes start
      directReportFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_DIRECT_REPORT_ATTR)) ;
      clmInLitigationFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_LITIGATION_ATTR)) ;
      //SIR:150695 ECF Phase 6 Changes end
      // CR 1442 - D.Smith - 12/12/03
      // note : this is subject to a query with D.Wilcocks
      clmOptOutStatusFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_CLM_OO_STAT_ATTR)) ;
      clmOptOutDateFlag = enabledStatusCheckbox((String)mrFieldAttributes.get(Keys.LY43_CLM_OO_DATE_ATTR)) ;

      Vector vCommandAttributes = (Vector)results.get(Keys.LY43_COMMAND_ATTRIBUTES);
      MappedRecord mrCommandAttributes = (MappedRecord)vCommandAttributes.get(0);

      endBDFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_END_BD_ATTR)) ;
      newBDFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_NEW_BD_ATTR)) ;
      bindSchdFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_BIND_SCHD_ATTR)) ;
      riSchdFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_RI_SCHD_ATTR)) ;
      backFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_BACK_ATTR)) ;
      euroFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_EURO_ATTR)) ;
      ccsFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_CCS_ATTR)) ;
      newMovementFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_NEW_MOVE_ATTR)) ;

      // If the data in the mapped record is used to populate the Enquiry screen
      // then we need to extract the extra fields. The update screen does not need
      // these fields.
      if (screenMode.equals("E")) {
        // Devo September 2003   CCN s229
        // Adding new fields to the scm screen as part of the work to split the two
        // screens into an update and enquiry version
        //

        // Extract the Policy Narrative Lines from the Policy Narr Table- which occurs 4 times.
        Vector v1 = (Vector) mrFieldValues.get(Keys.LY43_POLICY_NARR_TABLE);
        // Just in case (for any reason) that the vector derived from the MappedRecord
        // is null (it shouldn't be).
        if (v1 == null) {
          v1 = new Vector();
        }
        for(int x =0; x < v1.size();x++){
          MappedRecord mp1 = (MappedRecord) v1.get(x);
          switch(x){
            case 0:
              sPOLICY_NARR_LINE1 = (String) mp1.get(Keys.LY43_POLICY_NARR_LINE);
              break;
            case 1:
              sPOLICY_NARR_LINE2 = (String) mp1.get(Keys.LY43_POLICY_NARR_LINE);
              break;
            case 2:
              sPOLICY_NARR_LINE3 = (String) mp1.get(Keys.LY43_POLICY_NARR_LINE);
              break;
            case 3:
              sPOLICY_NARR_LINE4 = (String) mp1.get(Keys.LY43_POLICY_NARR_LINE);
          }
        }

        // Extract the Claim Narrative Line from the XCR Claim Narrative- which occurs 3 times.
        Vector v2 = (Vector) mrFieldValues.get(Keys.LY43_XCR_CLAIM_NARR);
        // Just in case (for any reason) that the vector derived from the MappedRecord
        // is null (it shouldn't be).
        if (v2 == null) {
          v2 = new Vector();
        }
        for(int x =0; x < v2.size();x++){
          MappedRecord mp2 = (MappedRecord) v2.get(x);
          switch(x){
            case 0:
              sCLM_NARR_LINE1 = (String) mp2.get(Keys.LY43_CLM_NARR_LINE);
              break;
            case 1:
              sCLM_NARR_LINE2 = (String) mp2.get(Keys.LY43_CLM_NARR_LINE);
              break;
            case 2:
              sCLM_NARR_LINE3 = (String) mp2.get(Keys.LY43_CLM_NARR_LINE);
          }
        }

        // Extract the Trans Synopsis from the Mapped Record. Note that there is an inner array within
        // this structure- just to make it more interesting!!!
        MappedRecord mpTransSynopsis = (MappedRecord)((Vector)mrFieldValues.get(Keys.LY43_TRANS_SYNOPSIS)).get(0);
        Vector vTransSyn = (Vector)mpTransSynopsis.get(Keys.LY43_TRANS_SYNOPSIS_LINE);
        // Just in case (for any reason) that the vector derived from the MappedRecord
        // is null (it shouldn't be).
        if (vTransSyn == null) {
          vTransSyn = new Vector();
        }
        for(int x = 0; x < vTransSyn.size();x++){
          MappedRecord mp3 = (MappedRecord) vTransSyn.get(x);
          switch(x){
            case 0:
              sSYNOPSIS_TEXT1 = (String) mp3.get(Keys.LY43_SYNOPSIS_TEXT);
              break;
            case 1:
              sSYNOPSIS_TEXT2 = (String) mp3.get(Keys.LY43_SYNOPSIS_TEXT);
              break;
            case 2:
              sSYNOPSIS_TEXT3 = (String) mp3.get(Keys.LY43_SYNOPSIS_TEXT);
              break;
            case 3:
              sSYNOPSIS_TEXT4 = (String) mp3.get(Keys.LY43_SYNOPSIS_TEXT);
          }
        }

        // Extract the market details lines from the Mapped Record.
        Vector vMarketDetails =  (Vector) mrFieldValues.get(Keys.LY43_MARKET_TABLE);
        // Just in case (for any reason) that the vector derived from the MappedRecord
        // is null (it shouldn't be).
        if (vMarketDetails == null) {
          vMarketDetails = new Vector();
        }
        // There will always be 10 lines sent from the mainframe- balnk lines will
        // be blank- and despite this blank lines will be shown on the SCM enquiry screen.
        vAllMarketDetails = new Vector();
        for (int i=0; i<vMarketDetails.size(); i++) {
          MappedRecord mpSingleMarket = (MappedRecord)vMarketDetails.get(i);
          if (((String)mpSingleMarket.get(Keys.LY43_CLAIM_LINE_NO)).equals("0"))
            break;

          singleMarketDetailLine mktDetailModel = new singleMarketDetailLine(
              i+1,
              (String)mpSingleMarket.get(Keys.LY43_CLAIM_LINE_NO),
              (String)mpSingleMarket.get(Keys.LY43_COY_CODE),
              (String)mpSingleMarket.get(Keys.LY43_COY_LINE),
              (String)mpSingleMarket.get(Keys.LY43_COY_REF_1),
              // CR 1442 - D.Smith - 12/12/03
              (String)mpSingleMarket.get(Keys.LY43_SY_OPT_OUT_STATUS),
              (String)mpSingleMarket.get(Keys.LY43_SY_OPT_OUT_DATE),

              (String)mpSingleMarket.get(Keys.LY43_BUREAU_LEAD_IND));

          // This Vector will contain all the market detail line objects
          vAllMarketDetails.add(mktDetailModel);
        }

        // Now extract all the other new fields from the MappedRecord.
        sAP_REF      = (String)mrFieldValues.get(Keys.LY43_AP_REF) ;
        sYEAR_OF_ACC = (String)mrFieldValues.get(Keys.LY43_YEAR_OF_ACC) ;
        sGROUP_REF   = (String)mrFieldValues.get(Keys.LY43_GROUP_REF) ;
        sUMR         = (String)mrFieldValues.get(Keys.LY43_UMR) ;
        sMKT_CODE    = (String)mrFieldValues.get(Keys.LY43_MKT_CODE) ;
        sCOV_DATE_FROM = (String)mrFieldValues.get(Keys.LY43_COV_DATE_FROM) ;
        sCOV_DATE_TO   = (String)mrFieldValues.get(Keys.LY43_COV_DATE_TO) ;
        sCOV_QUAL    = (String)mrFieldValues.get(Keys.LY43_COV_QUAL) ;
        sPER_NARR    = (String)mrFieldValues.get(Keys.LY43_PER_NARR) ;
        sSLIP_ORD_1  = (String)mrFieldValues.get(Keys.LY43_SLIP_ORD_1) ;
        sSLIP_ORD_2  = (String)mrFieldValues.get(Keys.LY43_SLIP_ORD_2) ;
        sLIMIT_BASIS = (String)mrFieldValues.get(Keys.LY43_LIMIT_BASIS) ;
        sSI_NARR     = (String)mrFieldValues.get(Keys.LY43_SI_NARR) ;
        sRISK_CODE   = (String)mrFieldValues.get(Keys.LY43_RISK_CODE) ;
        sNO_SYNDS    = (String)mrFieldValues.get(Keys.LY43_NO_SYNDS) ;
        sMARKET_SOURCE = (String)mrFieldValues.get(Keys.LY43_MARKET_SOURCE) ;
        sMARKET_COUNT  = (String)mrFieldValues.get(Keys.LY43_MARKET_COUNT) ;
        sLLOYDS_CLAIM_TYPE = (String)mrFieldValues.get(Keys.LY43_LLOYDS_CLAIM_TYPE) ;
        sINTEREST    = (String)mrFieldValues.get(Keys.LY43_INTEREST) ;
        sLOC_VOYAGE  = (String)mrFieldValues.get(Keys.LY43_LOC_VOYAGE) ;
        sCHOLDER_CLM_REF = (String)mrFieldValues.get(Keys.LY43_CHOLDER_CLM_REF) ;
        sTDN_REF     = (String)mrFieldValues.get(Keys.LY43_TDN_REF) ;
        sUSER_ID     = (String)mrFieldValues.get(Keys.LY43_USER_ID) ;
        sCHARGE_TYPE = (String)mrFieldValues.get(Keys.LY43_CHARGE_TYPE) ;

        // The Mapped Record has a load of flags to determine whether or not we
        // should enable or disable the fields. However given that the SCM enquiry
        // fields are all to be labels we can ignore tham for the moment.
      }
      
      /*Expert Fee Breakdown Link*/
      bExpertFeeBreakDownLinkFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY43_FEES_BDOWN_ATTR)) ;

    } else if (event instanceof LY44Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      Vector v = (Vector)results.get(Keys.LY44_FIELD_VALUES) ;
      MappedRecord mrFieldValues = (MappedRecord)v.get(0);

      currNoVal = (String)mrFieldValues.get(Keys.LY44_CURR_NO_VAL) ;
      sdnNoVal = (String)mrFieldValues.get(Keys.LY44_SDN_NO_VAL) ;
      bdownNoVal = (String)mrFieldValues.get(Keys.LY44_BDOWN_NO_VAL) ;
      claimRefRec = (String)mrFieldValues.get(Keys.LY44_CLM_REF_REC) ;
      origCcy = (String)mrFieldValues.get(Keys.LY44_ORIG_CURR) ;
      settCcy = (String)mrFieldValues.get(Keys.LY44_SETT_CURR) ;
      settRateOfExch = (String)mrFieldValues.get(Keys.LY44_EXCH_RATE) ;
      pTDLoss = (String)mrFieldValues.get(Keys.LY44_PTD_LOSS) ;
      pTDExp = (String)mrFieldValues.get(Keys.LY44_PTD_EXP) ;
      pTDFee = (String)mrFieldValues.get(Keys.LY44_PTD_FEE) ;
      pTDTotal = (String)mrFieldValues.get(Keys.LY44_PTD_TOTAL) ;
      pTTLoss = (String)mrFieldValues.get(Keys.LY44_PTT_LOSS) ;
      pTTExp = (String)mrFieldValues.get(Keys.LY44_PTT_EXP) ;
      pTTFee = (String)mrFieldValues.get(Keys.LY44_PTT_FEE) ;
      pTTTotal = (String)mrFieldValues.get(Keys.LY44_PTT_TOTAL) ;
      
      osLoss = (String)mrFieldValues.get(Keys.LY44_OUTST_LOSS) ;
      osLossQual = (String)mrFieldValues.get(Keys.LY44_OUTST_LOSS_QUAL) ;
      osExp = (String)mrFieldValues.get(Keys.LY44_OUTST_EXP) ;
      osFee = (String)mrFieldValues.get(Keys.LY44_OUTST_FEE) ;
      osFeeQual = (String)mrFieldValues.get(Keys.LY44_OUTST_FEE_QUAL) ;
      osTotal = (String)mrFieldValues.get(Keys.LY44_OUTST_TOT) ;
      osTotalQual = (String)mrFieldValues.get(Keys.LY44_OUTST_TOT_QUAL) ;
      pTDInSettCcy = (String)mrFieldValues.get(Keys.LY44_PTD_SETT_AMT) ;
      settledRateInSettCcy = (String)mrFieldValues.get(Keys.LY44_CLAIM_AMT_SETT) ;
      totalLine = (String)mrFieldValues.get(Keys.LY44_BUREAU_LINE) ;
      bureauPpn = (String)mrFieldValues.get(Keys.LY44_BUR_PROP_AMT) ;
      vATAmount = (String)mrFieldValues.get(Keys.LY44_HPC_VAT_AMT) ;

      wARAmount = (String)mrFieldValues.get(Keys.LY44_WAR_AMT) ;
      narrativeCode1 = (String)mrFieldValues.get(Keys.LY44_NARR_CODE_1) ;
      narrativeCode2 = (String)mrFieldValues.get(Keys.LY44_NARR_CODE_2) ;
      narrativeForSet = (String)mrFieldValues.get(Keys.LY44_SETT_NARR_1) ;
      narrativeForSet2 = (String)mrFieldValues.get(Keys.LY44_SETT_NARR_2) ;
      narrativeForSet3 = (String)mrFieldValues.get(Keys.LY44_SETT_NARR_3) ;
      subrogation = (String)mrFieldValues.get(Keys.LY44_SUBROGATION) ;
      checkedSubrogation = checkBoxStatus(subrogation);

      xCSRecovery = (String)mrFieldValues.get(Keys.LY44_XCS_REC_REF) ;
      highestEst = (String)mrFieldValues.get(Keys.LY44_HIGHEST_EST) ;
      incurred = (String)mrFieldValues.get(Keys.LY44_INCURRED_AMT) ;
      osRateOfExch = (String)mrFieldValues.get(Keys.LY44_RATE_EXCH_OUTST) ;
      finderCode1 = (String)mrFieldValues.get(Keys.LY44_FINDER_CODE_1) ;
      finderCode2 = (String)mrFieldValues.get(Keys.LY44_FINDER_CODE_2) ;
      finderCode3 = (String)mrFieldValues.get(Keys.LY44_FINDER_CODE_3) ;
      attachmentsInd = (String)mrFieldValues.get(Keys.LY44_ATTACHMENT_IND) ;
      checkedAttachmentsInd = checkBoxStatus(attachmentsInd);


      /*
        Change: N0045
        Date:   12th Dec 02 (DH)
        cashCor = (String)mrFieldValues.get(Keys.LY44_CASH_COR) ;
      */

      brokerContact = (String)mrFieldValues.get(Keys.LY44_BKR_CNTCT) ;
      brokerPhoneNo = (String)mrFieldValues.get(Keys.LY44_BKR_CNTCT_PHONE) ;
      claimBrokerRef1 = (String)mrFieldValues.get(Keys.LY44_CLM_BKR_REF_1) ;
      claimBrokerRef2 = (String)mrFieldValues.get(Keys.LY44_CLM_BKR_REF_2) ;
      brokerClaimRef1 = (String)mrFieldValues.get(Keys.LY44_BKR_REF_1) ;
      brokerClaimRef2 = (String)mrFieldValues.get(Keys.LY44_BKR_REF_2) ;
      countryOfOrigin = (String)mrFieldValues.get(Keys.LY44_CNTRY_OF_ORIGIN) ;
      origInsured = (String)mrFieldValues.get(Keys.LY44_ORIG_INSURED) ;
      if (origInsured.length() > 25) {
        origInsured = origInsured.substring(0, 25);
      }
      insured = (String)mrFieldValues.get(Keys.LY44_INSURED) ;
      if (insured.length() > 25) {
        insured = insured.substring(0, 25);
      }
      resinsured = (String)mrFieldValues.get(Keys.LY44_REINSURED) ;
      if (resinsured.length() > 25) {
        resinsured = resinsured.substring(0, 25);
      }
      claimholder = (String)mrFieldValues.get(Keys.LY44_COVER_HOLDER) ;
      if (claimholder.length() > 25) {
        claimholder = claimholder.substring(0, 25);
      }
      claimant = (String)mrFieldValues.get(Keys.LY44_CLAIMANT) ;
      vesselAircraft = (String)mrFieldValues.get(Keys.LY44_VESSEL_AIRCRAFT) ;
      if (vesselAircraft.length() > 25) {
        vesselAircraft = vesselAircraft.substring(0, 25);
      }
      otherName = (String)mrFieldValues.get(Keys.LY44_OTHER_NAME) ;
      if (otherName.length() > 25) {
        otherName = otherName.substring(0, 25);
      }
      polCertPeriodFrom = (String)mrFieldValues.get(Keys.LY44_POL_CERT_FROM) ;
      polCertPeriodTo = (String)mrFieldValues.get(Keys.LY44_POL_CERT_TO) ;
      polCertQual = (String)mrFieldValues.get(Keys.LY44_POL_CERT_QUAL) ;
      dOLFrom = (String)mrFieldValues.get(Keys.LY44_LOSS_DATE_FROM) ;
      dOLTo = (String)mrFieldValues.get(Keys.LY44_LOSS_DATE_TO) ;
      dOLQual = (String)mrFieldValues.get(Keys.LY44_LOSS_DATE_QUAL) ;
      dolNarr = (String)mrFieldValues.get(Keys.LY44_LOSS_DATE_NARR) ;
      dCMFrom = (String)mrFieldValues.get(Keys.LY44_CLAIM_DATE_FROM) ;
      dCMTo = (String)mrFieldValues.get(Keys.LY44_CLAIM_DATE_TO) ;
      dCMQual = (String)mrFieldValues.get(Keys.LY44_CLAIM_DATE_QUAL) ;
      catCode = (String)mrFieldValues.get(Keys.LY44_CAT_CODE) ;
      pcsCode = (String)mrFieldValues.get(Keys.LY44_PCS_CAT_CODE) ;
      ccyOfLimits = (String)mrFieldValues.get(Keys.LY44_LIMIT_CURR) ;
      limits = (String)mrFieldValues.get(Keys.LY44_SI_LIMIT) ;
      excess = (String)mrFieldValues.get(Keys.LY44_EXCESS_AMT) ;
      perilsCondition = (String)mrFieldValues.get(Keys.LY44_PERILS_CONDS) ;
      lossLocation = (String)mrFieldValues.get(Keys.LY44_LOSS_LOCATION) ;
      voyage = (String)mrFieldValues.get(Keys.LY44_VOYAGE) ;
      lossName = (String)mrFieldValues.get(Keys.LY44_LOSS_NAME) ;
      // TP866603 Changes for barcode field to behave as protected
      barcode= (String)mrFieldValues.get(Keys.LY44_BARCODE);
      claimNarrative = "";
      Vector claimDetails = (Vector)mrFieldValues.get("#C044_CLAIM_DETAILS[]");
      for (int i=0; i<claimDetails.size(); i++) {
        MappedRecord claimDetLine = (MappedRecord)claimDetails.elementAt(i);
        if (i>0)
          claimNarrative += "\n";

        claimNarrative += (String)claimDetLine.get("@C044_CLAIM_DET_LINE");
      }
      while ((claimNarrative.length()>0) && (claimNarrative.lastIndexOf("\n")==claimNarrative.length()-1)) {
        claimNarrative = claimNarrative.substring(0,claimNarrative.length()-1);
      }

      lawyerName = (String)mrFieldValues.get(Keys.LY44_LAWYER_NAME) ;
      lawyerRef = (String)mrFieldValues.get(Keys.LY44_LAWYER_REF) ;
      lawyerCode = (String)mrFieldValues.get(Keys.LY44_LAWYER_CODE) ;
      adjusterName = (String)mrFieldValues.get(Keys.LY44_ADJUSTER_NAME) ;
      adjusterRef = (String)mrFieldValues.get(Keys.LY44_ADJUSTER_REF) ;
      adjusterCode = (String)mrFieldValues.get(Keys.LY44_ADJUSTER_CODE) ;
      countyCode = (String)mrFieldValues.get(Keys.LY44_COUNTY_CODE) ;  
      
      schemeCode = (String)mrFieldValues.get(Keys.LY44_SCHEME_CODE) ;
      tfCode = (String)mrFieldValues.get(Keys.LY44_TF_CODE) ;
      stateCode = (String)mrFieldValues.get(Keys.LY44_STATE_CODE) ;
      naicCode = (String)mrFieldValues.get(Keys.LY44_NAIC_CODE) ;
      naicQual = (String)mrFieldValues.get(Keys.LY44_NAIC_QUAL) ;
      warInd = (String)mrFieldValues.get(Keys.LY44_WAR_IND) ;
      checkedWarInd = checkBoxStatus(warInd);

      filCode1 = (String)mrFieldValues.get(Keys.LY44_FIL_CODE_1) ;
      filCode2 = (String)mrFieldValues.get(Keys.LY44_FIL_CODE_2) ;
      otherTfCode = (String)mrFieldValues.get(Keys.LY44_OTHER_TF_CODE) ;
      dti = (String)mrFieldValues.get(Keys.LY44_DTI_CODE) ;

      usaCanInd = (String)mrFieldValues.get(Keys.LY44_USA_CAN_IND);
      checkedUsaCanInd = checkBoxStatus(usaCanInd);

      // CCN #N0031 and N0021 - BA - 15/01/2003
      lfEntryInd = (String)mrFieldValues.get(Keys.LY44_LF_ENTRY_IND) ;
      checkedLFEntryInd = checkBoxStatus(lfEntryInd) ;
      lfAdvanceInd = (String)mrFieldValues.get(Keys.LY44_LF_ADVANCE_IND) ;
      checkedLFAdvanceInd = checkBoxStatus(lfAdvanceInd) ;
      blockInd = (String)mrFieldValues.get(Keys.LY44_BLOCK_IND) ;
      checkedBlockInd = checkBoxStatus(blockInd) ;
     
      //SIR:150695 ECF Phase 6 changes
      directReportInd = (String)mrFieldValues.get(Keys.LY44_DIRECT_REPORT_IND) ;
      checkedDirectReportInd = checkBoxStatus(directReportInd) ;
      clmInLitigationInd = (String)mrFieldValues.get(Keys.LY44_LITIGATION_IND) ;
      checkedClmInLitigationInd = checkBoxStatus(clmInLitigationInd) ;
      serviceType = (String)mrFieldValues.get(Keys.LY44_SERVICE_TPYE) ;
//    SIR:150695 ECF Phase 6 changes
      
      /** @todo validation errors are sent in LY44 commareas.
          these are not yet retrieved.*/
      MappedRecord mrFieldErrors = (MappedRecord)((Vector)(results.get(Keys.LY44_FIELD_ERRORS))).get(0) ;

    } else if (event instanceof LY45Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      Vector v = (Vector)results.get(Keys.LY45_FIELD_VALUES) ;
      MappedRecord mrFieldValues = (MappedRecord)v.get(0);

      hXcr = (String)mrFieldValues.get(Keys.LY45_XCR) ;
      hUcr = (String)mrFieldValues.get(Keys.LY45_UCR) ;
      hTr = (String)mrFieldValues.get(Keys.LY45_TR) ;
      hOsnd = (String)mrFieldValues.get(Keys.LY45_ORIG_REF) ;
      hOrigBkr = (String)mrFieldValues.get(Keys.LY45_ORIG_BKR) ;
      hSigned = (String)mrFieldValues.get(Keys.LY45_SIGNED_IND) ;
      hPeerReview = (String)mrFieldValues.get(Keys.LY45_PEER_REV_IND) ;
      hOrigCcy = (String)mrFieldValues.get(Keys.LY45_ORIG_CURR_HDR) ;
      hCor = (String)mrFieldValues.get(Keys.LY45_COR) ;
      hLoc = (String)mrFieldValues.get(Keys.LY45_LOC_IND) ;
      hPayeeBkr = (String)mrFieldValues.get(Keys.LY45_PAYEE_BKR_CODE) ;
      hRedenomInd = (String)mrFieldValues.get(Keys.LY45_REDENOM_IND) ;
      hMvmtRefDate = (String)mrFieldValues.get(Keys.LY45_MOVE_REF) ;
      claimRefRec = (String)mrFieldValues.get(Keys.LY45_CLM_REF_REC) ;
      origCcy = (String)mrFieldValues.get(Keys.LY45_ORIG_CURR) ;
      settCcy = (String)mrFieldValues.get(Keys.LY45_SETT_CURR) ;
      settRateOfExch = (String)mrFieldValues.get(Keys.LY45_EXCH_RATE) ;
      pTDLoss = (String)mrFieldValues.get(Keys.LY45_PTD_LOSS) ;
      pTDExp = (String)mrFieldValues.get(Keys.LY45_PTD_EXP) ;
      pTDFee = (String)mrFieldValues.get(Keys.LY45_PTD_FEE) ;
      pTDTotal = (String)mrFieldValues.get(Keys.LY45_PTD_TOTAL) ;
      pTTLoss = (String)mrFieldValues.get(Keys.LY45_PTT_LOSS) ;
      pTTExp = (String)mrFieldValues.get(Keys.LY45_PTT_EXP) ;
      pTTFee = (String)mrFieldValues.get(Keys.LY45_PTT_FEE) ;
      pTTTotal = (String)mrFieldValues.get(Keys.LY45_PTT_TOTAL) ;
    
      osLoss = (String)mrFieldValues.get(Keys.LY45_OUTST_LOSS) ;
      osLossQual = (String)mrFieldValues.get(Keys.LY45_OUTST_LOSS_QUAL) ;
      osExp = (String)mrFieldValues.get(Keys.LY45_OUTST_EXP) ;
      osFee = (String)mrFieldValues.get(Keys.LY45_OUTST_FEE) ;
      osFeeQual = (String)mrFieldValues.get(Keys.LY45_OUTST_FEE_QUAL) ;
      osTotal = (String)mrFieldValues.get(Keys.LY45_OUTST_TOT) ;
      osTotalQual = (String)mrFieldValues.get(Keys.LY45_OUTST_TOT_QUAL) ;
      pTDInSettCcy = (String)mrFieldValues.get(Keys.LY45_PTD_SETT_AMT) ;
      settledRateInSettCcy = (String)mrFieldValues.get(Keys.LY45_CLAIM_AMT_SETT) ;
      totalLine = (String)mrFieldValues.get(Keys.LY45_BUREAU_LINE) ;
      bureauPpn = (String)mrFieldValues.get(Keys.LY45_BUR_PROP_AMT) ;
      vATAmount = (String)mrFieldValues.get(Keys.LY45_HPC_VAT_AMT) ;



      wARAmount = (String)mrFieldValues.get(Keys.LY45_WAR_AMT) ;
      narrativeCode1 = (String)mrFieldValues.get(Keys.LY45_NARR_CODE_1) ;
      narrativeCode2 = (String)mrFieldValues.get(Keys.LY45_NARR_CODE_2) ;
      narrativeForSet = (String)mrFieldValues.get(Keys.LY45_SETT_NARR_1) ;
      narrativeForSet2 = (String)mrFieldValues.get(Keys.LY45_SETT_NARR_2) ;
      narrativeForSet3 = (String)mrFieldValues.get(Keys.LY45_SETT_NARR_3) ;
      subrogation = (String)mrFieldValues.get(Keys.LY45_SUBROGATION) ;
      checkedSubrogation = checkBoxStatus(subrogation);

      xCSRecovery = (String)mrFieldValues.get(Keys.LY45_XCS_REC_REF) ;
      highestEst = (String)mrFieldValues.get(Keys.LY45_HIGHEST_EST) ;
      incurred = (String)mrFieldValues.get(Keys.LY45_INCURRED_AMT) ;
      osRateOfExch = (String)mrFieldValues.get(Keys.LY45_RATE_EXCH_OUTST) ;
      finderCode1 = (String)mrFieldValues.get(Keys.LY45_FINDER_CODE_1) ;
      finderCode2 = (String)mrFieldValues.get(Keys.LY45_FINDER_CODE_2) ;
      finderCode3 = (String)mrFieldValues.get(Keys.LY45_FINDER_CODE_3) ;
      attachmentsInd = (String)mrFieldValues.get(Keys.LY45_ATTACHMENT_IND) ;
      checkedAttachmentsInd = checkBoxStatus(attachmentsInd);

      /*
        Change: N0045
        Date:   12th Dec 02 (DH)
        cashCor = (String)mrFieldValues.get(Keys.LY45_CASH_COR) ;
      */

      brokerContact = (String)mrFieldValues.get(Keys.LY45_BKR_CNTCT) ;
      brokerPhoneNo = (String)mrFieldValues.get(Keys.LY45_BKR_CNTCT_PHONE) ;
      claimBrokerRef1 = (String)mrFieldValues.get(Keys.LY45_CLM_BKR_REF_1) ;
      claimBrokerRef2 = (String)mrFieldValues.get(Keys.LY45_CLM_BKR_REF_2) ;
      brokerClaimRef1 = (String)mrFieldValues.get(Keys.LY45_BKR_REF_1) ;
      brokerClaimRef2 = (String)mrFieldValues.get(Keys.LY45_BKR_REF_2) ;
      countryOfOrigin = (String)mrFieldValues.get(Keys.LY45_CNTRY_OF_ORIGIN) ;
      origInsured = (String)mrFieldValues.get(Keys.LY45_ORIG_INSURED) ;
      if (origInsured.length() > 25) {
        origInsured = origInsured.substring(0, 25);
      }
      insured = (String)mrFieldValues.get(Keys.LY45_INSURED) ;
      if (insured.length() > 25) {
        insured = insured.substring(0, 25);
      }
      resinsured = (String)mrFieldValues.get(Keys.LY45_REINSURED) ;
      if (resinsured.length() > 25) {
        resinsured = resinsured.substring(0, 25);
      }
      claimholder = (String)mrFieldValues.get(Keys.LY45_COVER_HOLDER) ;
      if (claimholder.length() > 25) {
        claimholder = claimholder.substring(0, 25);
      }
      claimant = (String)mrFieldValues.get(Keys.LY45_CLAIMANT) ;
      vesselAircraft = (String)mrFieldValues.get(Keys.LY45_VESSEL_AIRCRAFT) ;
      if (vesselAircraft.length() > 25) {
        vesselAircraft = vesselAircraft.substring(0, 25);
      }
      otherName = (String)mrFieldValues.get(Keys.LY45_OTHER_NAME) ;
      if (otherName.length() > 25) {
        otherName = otherName.substring(0, 25);
      }
      polCertPeriodFrom = (String)mrFieldValues.get(Keys.LY45_POL_CERT_FROM) ;
      polCertPeriodTo = (String)mrFieldValues.get(Keys.LY45_POL_CERT_TO) ;
      polCertQual = (String)mrFieldValues.get(Keys.LY45_POL_CERT_QUAL) ;
      dOLFrom = (String)mrFieldValues.get(Keys.LY45_LOSS_DATE_FROM) ;
      dOLTo = (String)mrFieldValues.get(Keys.LY45_LOSS_DATE_TO) ;
      dOLQual = (String)mrFieldValues.get(Keys.LY45_LOSS_DATE_QUAL) ;
      dolNarr = (String)mrFieldValues.get(Keys.LY45_LOSS_DATE_NARR) ;
      dCMFrom = (String)mrFieldValues.get(Keys.LY45_CLAIM_DATE_FROM) ;
      dCMTo = (String)mrFieldValues.get(Keys.LY45_CLAIM_DATE_TO) ;
      dCMQual = (String)mrFieldValues.get(Keys.LY45_CLAIM_DATE_QUAL) ;
      catCode = (String)mrFieldValues.get(Keys.LY45_CAT_CODE) ;
      pcsCode = (String)mrFieldValues.get(Keys.LY45_PCS_CAT_CODE) ;
      ccyOfLimits = (String)mrFieldValues.get(Keys.LY45_LIMIT_CURR) ;
      limits = (String)mrFieldValues.get(Keys.LY45_SI_LIMIT) ;
      excess = (String)mrFieldValues.get(Keys.LY45_EXCESS_AMT) ;
      perilsCondition = (String)mrFieldValues.get(Keys.LY45_PERILS_CONDS) ;
      lossLocation = (String)mrFieldValues.get(Keys.LY45_LOSS_LOCATION) ;
      voyage = (String)mrFieldValues.get(Keys.LY45_VOYAGE) ;
      lossName = (String)mrFieldValues.get(Keys.LY45_LOSS_NAME) ;
          // TP866603 Changes for barcode field to carry forward to next screens
      barcode=   (String)mrFieldValues.get(Keys.LY45_BARCODE);

      claimNarrative = "";
      Vector claimDetails = (Vector)mrFieldValues.get("#C045_CLAIM_DETAILS[]");
      for (int i=0; i<claimDetails.size(); i++) {
        MappedRecord claimDetLine = (MappedRecord)claimDetails.elementAt(i);
        if (i>0)
          claimNarrative += "\n";

        claimNarrative += (String)claimDetLine.get("@C045_CLAIM_DET_LINE");
      }
      while ((claimNarrative.length()>0) && (claimNarrative.lastIndexOf("\n")==claimNarrative.length()-1)) {
        claimNarrative = claimNarrative.substring(0,claimNarrative.length()-1);
      }

      lawyerName = (String)mrFieldValues.get(Keys.LY45_LAWYER_NAME) ;
      lawyerRef = (String)mrFieldValues.get(Keys.LY45_LAWYER_REF) ;
      lawyerCode = (String)mrFieldValues.get(Keys.LY45_LAWYER_CODE) ;
      adjusterName = (String)mrFieldValues.get(Keys.LY45_ADJUSTER_NAME) ;
      adjusterRef = (String)mrFieldValues.get(Keys.LY45_ADJUSTER_REF) ;
      adjusterCode = (String)mrFieldValues.get(Keys.LY45_ADJUSTER_CODE) ;
      countyCode = (String)mrFieldValues.get(Keys.LY45_COUNTY_CODE) ;
      
      schemeCode = (String)mrFieldValues.get(Keys.LY45_SCHEME_CODE) ;
      tfCode = (String)mrFieldValues.get(Keys.LY45_TF_CODE) ;
      stateCode = (String)mrFieldValues.get(Keys.LY45_STATE_CODE) ;
      naicCode = (String)mrFieldValues.get(Keys.LY45_NAIC_CODE) ;
      naicQual = (String)mrFieldValues.get(Keys.LY45_NAIC_QUAL) ;
      warInd = (String)mrFieldValues.get(Keys.LY45_WAR_IND) ;
      checkedWarInd = checkBoxStatus(warInd);

      filCode1 = (String)mrFieldValues.get(Keys.LY45_FIL_CODE_1) ;
      filCode2 = (String)mrFieldValues.get(Keys.LY45_FIL_CODE_2) ;
      otherTfCode = (String)mrFieldValues.get(Keys.LY45_OTHER_TF_CODE) ;
      dti = (String)mrFieldValues.get(Keys.LY45_DTI_CODE) ;
      usaCanInd = (String)mrFieldValues.get(Keys.LY45_USA_CAN_IND);
      checkedUsaCanInd = checkBoxStatus(usaCanInd);

      // CCN #N0031 and N0021 - BA - 15/01/2003
      lfEntryInd = (String)mrFieldValues.get(Keys.LY45_LF_ENTRY_IND) ;
      checkedLFEntryInd = checkBoxStatus(lfEntryInd) ;
      lfAdvanceInd = (String)mrFieldValues.get(Keys.LY45_LF_ADVANCE_IND) ;
      checkedLFAdvanceInd = checkBoxStatus(lfAdvanceInd) ;
      blockInd = (String)mrFieldValues.get(Keys.LY45_BLOCK_IND) ;
      checkedBlockInd = checkBoxStatus(blockInd) ;
      
      //SIR:150695 ECF Phase 6 changes
      directReportInd = (String)mrFieldValues.get(Keys.LY45_DIRECT_REPORT_IND) ;
      checkedDirectReportInd = checkBoxStatus(directReportInd) ;
      clmInLitigationInd = (String)mrFieldValues.get(Keys.LY45_LITIGATION_IND) ;
      checkedClmInLitigationInd = checkBoxStatus(clmInLitigationInd) ;
      serviceType = (String)mrFieldValues.get(Keys.LY45_SERVICE_TYPE) ;
      //SIR:150695 ECF Phase 6 changes
    }
  }

  public String getAdjusterCode() {      
    return adjusterCode;
  }
  public String getAdjusterCodeFlag() {
    return adjusterCodeFlag;
  }
  public String getAdjusterName() {
    return removeAmps(adjusterName);
  }
  public boolean getAdjusterNameFlag() {
    return adjusterNameFlag;
  }
  public String getAdjusterRef() {
    return htmlSafe(adjusterRef);
  }
  public String getAdjusterRefFlag() {
    return adjusterRefFlag;
  }
  public String getAttachmentsInd() {
    return attachmentsInd;
  }
  public String getAttachmentsIndFlag() {
    return attachmentsIndFlag;
  }
  public String getBdownNoVal() {
    return bdownNoVal;
  }
  public String getBrokerClaimRef1() {
    return htmlSafe(brokerClaimRef1);
  }
  public String getBrokerClaimRef1Flag() {
    return brokerClaimRef1Flag;
  }
  public String getBrokerClaimRef2() {
    return htmlSafe(brokerClaimRef2);
  }
  public String getBrokerClaimRef2Flag() {
    return brokerClaimRef2Flag;
  }
  public String getBrokerContact() {
    return htmlSafe(brokerContact);
  }
  public String getBrokerContactFlag() {
    return brokerContactFlag;
  }
  public String getBrokerPhoneNo() {
    return htmlSafe(brokerPhoneNo);
  }
  public String getBrokerPhoneNoFlag() {
    return brokerPhoneNoFlag;
  }
//TP868446 Changes for barcode field to behave as protected
  
  public String getBarcodeFlag() {
      return barcodeFlag;
  }

  public String getBureauPpn() {
    return bureauPpn;
  }
  public String getBureauPpnFlag() {
    return bureauPpnFlag;
  }
  public String getCatCode() {
    return catCode;
  }
  public boolean getCatCodeFlag() {
    return catCodeFlag;
  }
  public String getCcyOfLimits() {
    return ccyOfLimits;
  }
  public boolean getCcyOfLimitsFlag() {
    return ccyOfLimitsFlag;
  }
  public String getClaimant() {
    return htmlSafe(claimant);
  }
  public String getClaimantFlag() {
    return claimantFlag;
  }
  public String getClaimholder() {
    return htmlSafe(claimholder);
  }
  public String getClaimholderFlag() {
    return claimholderFlag;
  }
  public String getClaimNarrative() {
    return htmlSafe(claimNarrative.replace('¬','\n'));
  }
  public String getClaimNarrativeFlag() {
    return claimNarrativeFlag;
  }
  public String getClaimRefRec() {
    return htmlSafe(claimRefRec);
  }
  public boolean getClaimRefRecFlag() {
    return claimRefRecFlag;
  }
  public String getCorFlag() {
    return corFlag;
  }
  public String getCountryOfOrigin() {
    return countryOfOrigin;
  }
  public boolean getCountryOfOriginFlag() {
    return countryOfOriginFlag;
  }
  public String getCurrNoVal() {
    return currNoVal;
  }
  public String getDCMFrom() {
    return dCMFrom;
  }
  public boolean getDCMFromFlag() {
    return dCMFromFlag;
  }
  public String getDCMQual() {
    return dCMQual;
  }
  public boolean getDCMQualFlag() {
    return dCMQualFlag;
  }
  public String getDCMTo() {
    return dCMTo;
  }
  public boolean getDCMToFlag() {
    return dCMToFlag;
  }
  public String getDOLFrom() {
    return dOLFrom;
  }
  public boolean getDOLFromFlag() {
    return dOLFromFlag;
  }
  public String getDOLQual() {
    return dOLQual;
  }
  public boolean getDOLQualFlag() {
    return dOLQualFlag;
  }
  public String getDOLNarrative() {
    return htmlSafe(dolNarr);
  }
  public String getDOLNarrativeFlag() {
    return dolNarrFlag;
  }
  public String getDOLTo() {
    return dOLTo;
  }
  public boolean getDOLToFlag() {
    return dOLToFlag;
  }
  public String getDti() {
    return dti;
  }
  public boolean getDtiFlag() {
    return dtiFlag;
  }
  public String getExcess() {
    return excess;
  }
  public String getExcessFormatted() {
	  String excessFormatted = new String(excess); //because StringBuffer.indexOf() doesn't work here for some mysterious reason
	  String decimals = new String();
	  int i = excessFormatted.indexOf('.');
	  if(!(i==-1)) {
		  decimals = excessFormatted.substring(i);
		  excessFormatted = new String(excessFormatted.substring(0, i));
	  }
	  int k = excessFormatted.length();
	  StringBuffer excessFormattedBuf = new StringBuffer(excessFormatted);
	  for(int j=3; k>j; k-=j) {
		  excessFormattedBuf = excessFormattedBuf.insert(k-j, ',');
	  }
	  if(!(i==-1)) {
		  excessFormattedBuf = excessFormattedBuf.append(decimals);
	  }
	  return excessFormattedBuf.toString();
  }
  public String getExcessFlag() {
    return excessFlag;
  }
  public String getFilCode1() {
    return filCode1;
  }
  public boolean getFilCode1Flag() {
    return filCode1Flag;
  }
  public String getFilCode2() {
    return filCode2;
  }
  public boolean getFilCode2Flag() {
    return filCode2Flag;
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
  public String getHCor() {
    return hCor;
  }
  public String getHighestEst() {
    return highestEst;
  }
  public String getHighestEstFlag() {
    return highestEstFlag;
  }
  public String getHLoc() {
    return hLoc;
  }
  public String getHLocIndFlag() {
    return hLocIndFlag;
  }
  public String getHMoveRefAttr() {
    return hMoveRefAttr;
  }
  public String getHMvmtRefDate() {
    return hMvmtRefDate;
  }
  public String getHOrigBkr() {
    return hOrigBkr;
  }
  public String getHOrigBkrFlag() {
    return hOrigBkrFlag;
  }
  public String getHOrigCcy() {
    return hOrigCcy;
  }
  public String getHOrigCurrFlag() {
    return hOrigCurrFlag;
  }
  public String getHOrigRefFlag() {
    return hOrigRefFlag;
  }
  public String getHOsnd() {
    return hOsnd;
  }
  public String getHPayeeBkr() {
    return hPayeeBkr;
  }
  public String getHPayeeBkrFlag() {
    return hPayeeBkrFlag;
  }
  public String getHPeerRevFlag() {
    return hPeerRevFlag;
  }
  public String getHPeerReview() {
    return hPeerReview;
  }
  public String getHRedenomFlag() {
    return hRedenomFlag;
  }
  public String getHRedenomInd() {
    return hRedenomInd;
  }
  public String getHSigned() {
    return hSigned;
  }
  public String getHSignIndFlag() {
    return hSignIndFlag;
  }
  public String getHTr() {
    return hTr;
  }
  public String getHTRFlag() {
    return hTRFlag;
  }
  public String getHUcr() {
    return hUcr;
  }
  public String getHXcr() {
    return hXcr;
  }
  public String getHXCRFlag() {
    return hXCRFlag;
  }
  public String getIncurred() {
    return incurred;
  }
  public String getIncurredFlag() {
    return incurredFlag;
  }
  public String getHUCRFlag() {
    return hUCRFlag;
  }
  public String getInsured() {
    return htmlSafe(insured);
  }
  public String getInsuredFlag() {
    return insuredFlag;
  }
  public String getLawyerCode() {
    return lawyerCode;
  }
  public String getLawyerCodeFlag() {
    return lawyerCodeFlag;
  }
  public String getLawyerName() {
    return removeAmps(lawyerName);
  }
  public boolean getLawyerNameFlag() {
    return lawyerNameFlag;
  }
  public String getLawyerRef() {
    return htmlSafe(lawyerRef);
  }
  public String getLawyerRefFlag() {
    return lawyerRefFlag;
  }
  public String getLimits() {
	  return limits;
  }
  public String getLimitsFormatted() {
	  String limitsFormatted = new String(limits); //because StringBuffer.indexOf() doesn't work here for some mysterious reason
	  String decimals = new String();
	  int i = limitsFormatted.indexOf('.');
	  if(!(i==-1)) {
		  decimals = limitsFormatted.substring(i);
		  limitsFormatted = new String(limitsFormatted.substring(0, i));
	  }
	  int k = limitsFormatted.length();
	  StringBuffer limitsFormattedBuf = new StringBuffer(limitsFormatted);
	  for(int j=3; k>j; k-=j) {
		  limitsFormattedBuf = limitsFormattedBuf.insert(k-j, ',');
	  }
	  if(!(i==-1)) {
		  limitsFormattedBuf = limitsFormattedBuf.append(decimals);
	  }
	  return limitsFormattedBuf.toString();
  }
  public String getLimitsFlag() {
    return limitsFlag;
  }
  public String getLossLocation() {
    return htmlSafe(lossLocation);
  }
  public String getLossLocationFlag() {
    return lossLocationFlag;
  }
  public String getLossName() {
    return htmlSafe(lossName);
  }
  public String getLossNameFlag() {
    return lossNameFlag;
  }
  public ModelManager getMm() {
    return mm;
  }
  public String getNaicCode() {
    return naicCode;
  }
  public String getNaicCodeFlag() {
    return naicCodeFlag;
  }
  public String getNaicQual() {
    return htmlSafe(naicQual);
  }
  public boolean getNaicQualFlag() {
    return naicQualFlag;
  }
  public String getNarrativeCode1() {
    return narrativeCode1;
  }
  public boolean getNarrativeCode1Flag() {
    return narrativeCode1Flag;
  }
  public String getNarrativeCode2() {
    return narrativeCode2;
  }
  public boolean getNarrativeCode2Flag() {
    return narrativeCode2Flag;
  }
  public String getNarrativeForSet() {
    return htmlSafe(narrativeForSet);
  }
  public String getNarrativeForSet2() {
    return htmlSafe(narrativeForSet2);
  }
  public String getNarrativeForSet2Flag() {
    return narrativeForSet2Flag;
  }
  public String getNarrativeForSet3() {
    return htmlSafe(narrativeForSet3);
  }
  public String getNarrativeForSet3Flag() {
    return narrativeForSet3Flag;
  }
  public String getNarrativeForSetFlag() {
    return narrativeForSetFlag;
  }
  public String getOrigCcy() {
    return origCcy;
  }
  public boolean getOrigCcyFlag() {
    return origCcyFlag;
  }
  public String getOrigInsured() {
    return htmlSafe(origInsured);
  }
  public String getOrigInsuredFlag() {
    return origInsuredFlag;
  }
  public String getOsExp() {
    return removeDecimals(osExp);
  }
  public String getOsExpFlag() {
    return osExpFlag;
  }
  public String getOsFee() {
    return removeDecimals(osFee);
  }
  public String getOsFeeFlag() {
    return osFeeFlag;
  }
  public String getOsFeeQual() {
    return osFeeQual;
  }
  public boolean getOsFeeQualFlag() {
    return osFeeQualFlag;
  }
  public String getOsLoss() {
    return removeDecimals(osLoss);
  }
  public String getOsLossFlag() {
    return osLossFlag;
  }
  public String getOsLossQual() {
    return osLossQual;
  }
  public boolean getOsLossQualFlag() {
    return osLossQualFlag;
  }
  public String getOsRateOfExch() {
    return osRateOfExch;
  }
  public String getOsRateOfExchFlag() {
    return osRateOfExchFlag;
  }
  public String getOsTotal() {
    return removeDecimals(osTotal);
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
  public String getOtherName() {
    return htmlSafe(otherName);
  }
  public String getOtherNameFlag() {
    return otherNameFlag;
  }
  public String getOtherTfCode() {
    return otherTfCode;
  }
  public boolean getOtherTfCodeFlag() {
    return otherTfCodeFlag;
  }
  public String getPcsCode() {
    return pcsCode;
  }
  public boolean getPcsCodeFlag() {
    return pcsCodeFlag;
  }
  public String getPerilsCondition() {
    return htmlSafe(perilsCondition);
  }
  public String getPerilsConditionFlag() {
    return perilsConditionFlag;
  }
  public String getPolCertPeriodFrom() {
    return polCertPeriodFrom;
  }
  public boolean getPolCertPeriodFromFlag() {
    return polCertPeriodFromFlag;
  }
  public String getPolCertPeriodTo() {
    return polCertPeriodTo;
  }
  public boolean getPolCertPeriodToFlag() {
    return polCertPeriodToFlag;
  }
  public String getPolCertQual() {
    return polCertQual;
  }
  public boolean getPolCertQualFlag() {
    return polCertQualFlag;
  }
  public String getPTDExpFlag() {
    return pTDExpFlag;
  }
  public String getPTDFee() {
    return pTDFee;
  }
  public String getPTDFeeFlag() {
    return pTDFeeFlag;
  }
  public String getPTDInSettCcy() {
    return pTDInSettCcy;
  }
  public String getPTDInSettCcyFlag() {
    return pTDInSettCcyFlag;
  }
  public String getPTDExp() {
    return pTDExp;
  }
  public String getPTDLoss() {
    return pTDLoss;
  }
  public String getPTDLossFlag() {
    return pTDLossFlag;
  }
  public String getPTDTotal() {
    return pTDTotal;
  }
  public String getPTDTotalFlag() {
    return pTDTotalFlag;
  }
  public String getPTTExp() {
    return pTTExp;
  }
  public String getPTTExpFlag() {
    return pTTExpFlag;
  }
  public String getPTTFee() {
    return pTTFee;
  }
  public String getPTTFeeFlag() {
    return pTTFeeFlag;
  }
  public String getPTTLoss() {
    return pTTLoss;
  }
  public String getPTTLossFlag() {
    return pTTLossFlag;
  }
  public String getPTTTotal() {
    return pTTTotal;
  }
  public String getPTTTotalFlag() {
    return pTTTotalFlag;
  }
  public String getReinsuredFlag() {
    return reinsuredFlag;
  }
  public String getResinsured() {
    return htmlSafe(resinsured);
  }
  public String getSchemeCode() {
    return schemeCode;
  }
  public boolean getSchemeCodeFlag() {
    return schemeCodeFlag;
  }
  public String getSdnNoVal() {
    return sdnNoVal;
  }
  public String getSettCcy() {
    return settCcy;
  }
  public boolean getSettCcyFlag() {
    return settCcyFlag;
  }
  public String getSettledRateInSettCcy() {
    return settledRateInSettCcy;
  }
  public String getSettledRateInSettCcyFlag() {
    return settledRateInSettCcyFlag;
  }
  public String getSettRateOfExch() {
    return settRateOfExch;
  }
  public String getSettRateOfExchFlag() {
    return settRateOfExchFlag;
  }
  public String getStateCode() {
    return stateCode;
  }
  public boolean getStateCodeFlag() {
    return stateCodeFlag;
  }
  public String getSubrogation() {
    return subrogation;
  }
  public String getSubrogationFlag() {
    return subrogationFlag;
  }
  public String getTfCode() {
    return tfCode;
  }
  public boolean getTfCodeFlag() {
    return tfCodeFlag;
  }
  public String getTotalLine() {
    return totalLine;
  }
  public String getTotalLineFlag() {
    return totalLineFlag;
  }
  public String getVATAmount() {
    return vATAmount;
  }
  public void setBureauPpnOfVATAmount(double vatAmount) {
    bureauPpnOfVATAmount = vatAmount;
  }
  public String getVATAmountFlag() {
    return vATAmountFlag;
  }
  public String getVesselAircraft() {
    return htmlSafe(vesselAircraft);
  }
  public String getVesselAircraftFlag() {
    return vesselAircraftFlag;
  }
  public String getVoyage() {
    return htmlSafe(voyage);
  }
  public String getVoyageFlag() {
    return voyageFlag;
  }
  public String getWARAmount() {
    return wARAmount;
  }
  public String getWARAmountFlag() {
    return wARAmountFlag;
  }
  public String getWarInd() {
    return warInd;
  }
  public String getWarIndFlag() {
    return warIndFlag;
  }
  public String getXCSRecovery() {
    return htmlSafe(xCSRecovery);
  }
  public String getXCSRecoveryFlag() {
    return xCSRecoveryFlag;
  }

  // DETAILS whether to show the save button or not.
  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }
  public boolean getVATRatesButtonFlag() {
    return vatRateButtonFlag;
  }
  public boolean getEndBDFlag() {
    return endBDFlag;
  }
  public boolean getNewBDFlag() {
    return newBDFlag;
  }
  public boolean getRiSchdFlag() {
    return riSchdFlag;
  }
  public boolean getBindSchdFlag() {
    return bindSchdFlag;
  }
  public boolean getBackFlag() {
    return backFlag;
  }
  public boolean getEuroFlag() {
    return euroFlag;
  }
  public boolean getCcsFlag() {
    return ccsFlag;
  }
  public String getCheckedWarInd() {
    return checkedWarInd;
  }
  public String getCheckedSubrogation() {
    return checkedSubrogation;
  }
  public String getCheckedAttachmentsInd() {
    return checkedAttachmentsInd;
  }
  public String getUsaCanInd() {
    return usaCanInd;
  }
  public String getUsaCanIndFlag() {
    return usaCanIndFlag;
  }
  public String getCheckedUsaCanInd() {
    return checkedUsaCanInd;
  }

  // CCN #N0031 and N0021 - BA - 15/01/2003
  public String getLfEntryInd() {
    return lfEntryInd ;
  }
  public String getCheckedLFEntryInd() {
    return checkedLFEntryInd;
  }
  public String getLFEntryFlag() {
    return lfEntryFlag;
  }
  public String getLFAdvanceInd() {
    return lfAdvanceInd;
  }
  public String getCheckedLFAdvanceInd() {
    return checkedLFAdvanceInd;
  }
  public String getLFAdvanceFlag() {
    return lfAdvanceFlag;
  }
  public String getBlockInd() {
    return blockInd;
  }

  // CR1442 - D.Smith - 12/12/03
  public String getClmOptOutStatus() {
    return cOptOutStatus;
  }
  public String getClmOptOutDate() {
   return cOptOutDate;
  }

  public String getCheckedBlockInd() {
    return checkedBlockInd;
  }
  public String getBlockFlag() {
    return blockFlag;
  }

  // CR1442 - D.Smith - 12/12/03
  public String getClmOptOutStatusFlag() {
    return clmOptOutStatusFlag;
  }
  public String getClmOptOutDateFlag() {
   return clmOptOutDateFlag;
  }
  public double getBureauPpnOfVATAmount() {
    return bureauPpnOfVATAmount;
  }
  public String getClaimBrokerRef1() {
    return claimBrokerRef1;
  }
  public String getClaimBrokerRef1Flag() {
    return claimBrokerRef1Flag;
  }
  public String getClaimBrokerRef2() {
    return claimBrokerRef2;
  }
  public String getClaimBrokerRef2Flag() {
    return claimBrokerRef2Flag;
  }
  public boolean getNewMovementFlag() {
    return newMovementFlag;
  }
  public String getScreenMode() {
    return screenMode;
  }

  // Devo September 2003   CCN s229
  // Adding new fields to the scm screen as part of the work to split the two
  // screens into an update and enquiry version
  //
  // These are the new fields to be displayed on the new enquiry screen
  public String getsAP_REF() {
    return  sAP_REF ;
  }
  public String getsYEAR_OF_ACC() {
    return  sYEAR_OF_ACC ;
  }
  public String getsGROUP_REF() {
    return  sGROUP_REF ;
  }
  public String getsUMR() {
    return sUMR  ;
  }
  public String getsMKT_CODE() {
    return  sMKT_CODE ;
  }
  public String getsCOV_DATE_FROM() {
    return sCOV_DATE_FROM  ;
  }
  public String getsCOV_DATE_TO() {
    return sCOV_DATE_TO  ;
  }
  public String getsCOV_QUAL() {
    return  sCOV_QUAL ;
  }
  public String getsPER_NARR() {
    return  sPER_NARR ;
  }
  public String getsSLIP_ORD_1() {
    return sSLIP_ORD_1  ;
  }
  public String getsSLIP_ORD_2() {
    return sSLIP_ORD_2  ;
  }
  public String getsLIMIT_BASIS() {
    return sLIMIT_BASIS  ;
  }
  public String getsSI_NARR() {
    return sSI_NARR  ;
  }
  public String getsPOLICY_NARR_TABLE() {
    return sPOLICY_NARR_TABLE  ;
  }

  public String getsRISK_CODE () {
    return  sRISK_CODE ;
  }
  public String getsNO_SYNDS() {
    return  sNO_SYNDS ;
  }
  public String getsMARKET_SOURCE() {
    return  sMARKET_SOURCE ;
  }
  public String getsMARKET_COUNT() {
    return  sMARKET_COUNT ;
  }
  public String getsMARKET_TABLE() {
    return  sMARKET_TABLE ;
  }
  public String getsCLAIM_LINE_NO() {
    return  sCLAIM_LINE_NO ;
  }
  public String getsCOY_CODE() {
    return  sCOY_CODE ;
  }
  public String getsCOY_LINE() {
    return  sCOY_LINE ;
  }
  public String getsCOY_REF_1() {
    return  sCOY_REF_1 ;
  }
  public String getsBUREAU_LEAD_IND() {
    return  sBUREAU_LEAD_IND ;
  }
  public String getsLLOYDS_CLAIM_TYPE() {
    return sLLOYDS_CLAIM_TYPE ;
  }
  public String getsINTEREST() {
    return sINTEREST  ;
  }
  public String getsLOC_VOYAGE() {
    return  sLOC_VOYAGE ;
  }
  public String getsXCR_CLAIM_NARR() {
    return  sXCR_CLAIM_NARR ;
  }

  public String getsCHOLDER_CLM_REF() {
    return sCHOLDER_CLM_REF  ;
  }
  public String getsTRANS_SYNOPSIS() {
    return sTRANS_SYNOPSIS  ;
  }
  public String getsTRANS_SYNOPSIS_LINE() {
    return  sTRANS_SYNOPSIS_LINE ;
  }

  public String getsTDN_REF() {
    return sTDN_REF  ;
  }
  public String getsUSER_ID() {
    return  sUSER_ID ;
  }
  public String getsCHARGE_TYPE() {
    return  sCHARGE_TYPE ;
  }
  // These are the new attributes which match up with the fields
  // defined above for the new enquiry screen.


  public boolean getbAP_REFFlag() {
    return bAP_REFFlag    ;
  }
  public boolean getbYOAFlag() {

    return bYOAFlag   ;
  }
  public boolean getbGROUP_REFFlag() {
    return bGROUP_REFFlag   ;
  }
  public boolean getbUMRFlag() {
    return bUMRFlag   ;
  }
  public boolean getbMKT_CODEFlag() {
    return bMKT_CODEFlag   ;
  }
  public boolean getbCOV_DATE_FROMFlag() {
    return bCOV_DATE_FROMFlag   ;
  }
  public boolean getbCOV_DATE_TOFlag() {
    return bCOV_DATE_TOFlag    ;
  }
  public boolean getbCOV_QUALFlag() {
    return bCOV_QUALFlag  ;
  }
  public boolean getbPER_NARRFlag() {
    return bPER_NARRFlag   ;
  }
  public boolean getbSLIP_ORD_1Flag() {
    return bSLIP_ORD_1Flag  ;
  }
  public boolean getbSLIP_ORD_2Flag() {
    return bSLIP_ORD_2Flag   ;
  }
  public boolean getbLIMIT_BASISFlag() {
    return bLIMIT_BASISFlag    ;
  }
  public boolean getbSI_NARRFlag() {
    return bSI_NARRFlag   ;
  }
  public boolean getbPOLICY_NARRFlag() {
    return bPOLICY_NARRFlag   ;
  }
  public boolean getbRISK_CODEFlag() {
    return bRISK_CODEFlag  ;
  }
  public boolean getbNO_SYNDSFlag() {
    return bNO_SYNDSFlag   ;
  }
  public boolean getbMARKET_SOURCEFlag() {
    return bMARKET_SOURCEFlag  ;
  }
  public boolean getbMARKETFlag() {
    return bMARKETFlag   ;
  }
  public boolean getbLLOYDS_CLAIM_TYPEFlag() {
    return bLLOYDS_CLAIM_TYPEFlag   ;
  }
  public boolean getbINTERESTFlag() {
    return bINTERESTFlag   ;
  }
  public boolean getbLOC_VOYFlag() {
    return bLOC_VOYFlag    ;
  }
  public boolean getbXCR_CLAIM_NARRFlag() {
    return bXCR_CLAIM_NARRFlag    ;
  }
  public boolean getbCHOLDER_CLM_REFFlag() {
    return bCHOLDER_CLM_REFFlag   ;
  }
  public boolean getbTRANS_SYNOPSISFlag() {
    return bTRANS_SYNOPSISFlag   ;
  }
  public boolean getbTDN_REFFlag() {
    return bTDN_REFFlag   ;
  }
  public boolean getbUSER_IDFlag() {
    return bUSER_IDFlag   ;
  }
  public boolean getbCHARGE_TYPEFlag() {
    return bCHARGE_TYPEFlag    ;
  }


  // This function will return all the market details lines. Each element
  // in the vector will contain a singleMarketDetailLine object which
  // contains the breakdown of each line.
  // This will be called by the SCM enquiry JSP.
  public Enumeration getSyndicates() {
    return vAllMarketDetails.elements();
  }
  public String getsSYNOPSIS_TEXT1() {
    return sSYNOPSIS_TEXT1;
  }
  public String getsSYNOPSIS_TEXT2() {
    return sSYNOPSIS_TEXT2;
  }
  public String getsSYNOPSIS_TEXT3() {
    return sSYNOPSIS_TEXT3;
  }
  public String getsSYNOPSIS_TEXT4() {
    return sSYNOPSIS_TEXT4;
  }
  public String getsPOLICY_NARR_LINE4() {
    return sPOLICY_NARR_LINE4;
  }
  public String getsPOLICY_NARR_LINE3() {
    return sPOLICY_NARR_LINE3;
  }
  public String getsPOLICY_NARR_LINE2() {
    return sPOLICY_NARR_LINE2;
  }
  public String getsPOLICY_NARR_LINE1() {
    return sPOLICY_NARR_LINE1;
  }
  public String getsCLM_NARR_LINE1() {
    return sCLM_NARR_LINE1;
  }
  public String getsCLM_NARR_LINE2() {
    return sCLM_NARR_LINE2;
  }
  public String getsCLM_NARR_LINE3() {
    return sCLM_NARR_LINE3;
  }

// This inner class is used to store all the information stored in each line of
// the market details.
  public class singleMarketDetailLine {
    // This is merely the number in the list where this claim detail line
    // is shown.
    private int sScreenLineNo;
    // These are the fields stripped from the MappedRecord.
    private String sClaimLineNo;
    private String sCoyCode;
    private String sCoyLine;
    private String sCoyRef1;

    // CR1442 - D.Smith - 12/12/03
    private String sOptOutStatus;
    private String sOptOutDate;

    private String sBureauLeadInd;

    public singleMarketDetailLine(int sScreenLineNo,
                                  String sClaimLineNo,
                                  String sCoyCode,
                                  String sCoyLine,
                                  String sCoyRef1,
                                  String sOptOutStatus,
                                  String sOptOutDate,
                                  String sBureauLeadInd){
      this.sScreenLineNo     = sScreenLineNo;
      this.sClaimLineNo      = sClaimLineNo;
      this.sCoyCode          = sCoyCode;
      this.sCoyLine          = sCoyLine;
      this.sCoyRef1          = sCoyRef1;
      this.sOptOutStatus     = sOptOutStatus;
      this.sOptOutDate       = sOptOutDate;
      this.sBureauLeadInd    = sBureauLeadInd;
    }

    public int getsScreenLineNo() {
      return sScreenLineNo;
    }
    public String getsClaimLineNo() {
      return sClaimLineNo;
    }
    public String getsCoyCode() {
      return sCoyCode;
    }
    public String getsCoyLine() {
      return sCoyLine;
    }
    public String getsCoyRef1() {
      return sCoyRef1;
    }

    // CR 1442 - D.Smith - 12/12/03
    public String getsOptOutStatus() {
     return sOptOutStatus;
    }
    public String getsOptOutDate() {
     return sOptOutDate;
    }
    public String getsBureauLeadInd() {
      return sBureauLeadInd;
    }
  }

public String getClmInLitigationInd() {
	return clmInLitigationInd;
}
//TP868446 Changes for newly added barcode field 
public String getBarcode() {
	return barcode;
}


public void setClmInLitigationInd(String clmInLitigationInd) {
	this.clmInLitigationInd = clmInLitigationInd;
}
//TP868446 Changes for newly added barcode field 
public void setBarcode(String barcode) {
	this.barcode = barcode;
}

public String getDirectReportInd() {
	return directReportInd;
}

public void setDirectReportInd(String directReportInd) {
	this.directReportInd = directReportInd;

//	ECF Phase 6 Changes

}

public String getCheckedClmInLitigationInd() {
	return checkedClmInLitigationInd;
}

public void setCheckedClmInLitigationInd(String checkedClmInLitigationInd) {
	this.checkedClmInLitigationInd = checkedClmInLitigationInd;
}

public String getCheckedDirectReportInd() {
	return checkedDirectReportInd;
}

public void setCheckedDirectReportInd(String checkedDirectReportInd) {
	this.checkedDirectReportInd = checkedDirectReportInd;
}

public String getClmInLitigationFlag() {
	return clmInLitigationFlag;
}

public void setClmInLitigationFlag(String clmInLitigationFlag) {
	this.clmInLitigationFlag = clmInLitigationFlag;
}

public String getDirectReportFlag() {
	return directReportFlag;
}

public void setDirectReportFlag(String directReportFlag) {
	this.directReportFlag = directReportFlag;
}
//ECF Phase 6 Changes

    /* Expert Fee break down button flag */
    public boolean getExpertFeeBreakDownLinkFlag()
    {
        return this.bExpertFeeBreakDownLinkFlag;
    }

    public String getCountyCodeFlag()
    {
        return countyCodeflag;
    }

    public String getCountyCode()
    {
        return countyCode;
    }
    
        
    public void setAdjusterCode(String adjusterCode)
    {
        this.adjusterCode = adjusterCode;
    }

    
    public void setAdjusterCodeFlag(String adjusterCodeFlag)
    {
        this.adjusterCodeFlag = adjusterCodeFlag;
    }

    
    public void setAdjusterName(String adjusterName)
    {
        this.adjusterName = adjusterName;
    }

    
    public void setAdjusterNameFlag(boolean adjusterNameFlag)
    {
        this.adjusterNameFlag = adjusterNameFlag;
    }

    
    public void setAdjusterRef(String adjusterRef)
    {
        this.adjusterRef = adjusterRef;
    }

    
    public void setAdjusterRefFlag(String adjusterRefFlag)
    {
        this.adjusterRefFlag = adjusterRefFlag;
    }

    
    public void setAttachmentsInd(String attachmentsInd)
    {
        this.attachmentsInd = attachmentsInd;
    }

    
    public void setAttachmentsIndFlag(String attachmentsIndFlag)
    {
        this.attachmentsIndFlag = attachmentsIndFlag;
    }

    
    public void setBackFlag(boolean backFlag)
    {
        this.backFlag = backFlag;
    }

    
    public void setBAP_REFFlag(boolean flag)
    {
        bAP_REFFlag = flag;
    }

    
    public void setBCHARGE_TYPEFlag(boolean flag)
    {
        bCHARGE_TYPEFlag = flag;
    }

    
    public void setBCHOLDER_CLM_REFFlag(boolean flag)
    {
        bCHOLDER_CLM_REFFlag = flag;
    }

    
    public void setBCOV_DATE_FROMFlag(boolean flag)
    {
        bCOV_DATE_FROMFlag = flag;
    }

    
    public void setBCOV_DATE_TOFlag(boolean flag)
    {
        bCOV_DATE_TOFlag = flag;
    }

    
    public void setBCOV_QUALFlag(boolean flag)
    {
        bCOV_QUALFlag = flag;
    }

    
    public void setBdownNoVal(String bdownNoVal)
    {
        this.bdownNoVal = bdownNoVal;
    }

    
    public void setBExpertFeeBreakDownLinkFlag(boolean expertFeeBreakDownLinkFlag)
    {
        bExpertFeeBreakDownLinkFlag = expertFeeBreakDownLinkFlag;
    }

    
    public void setBGROUP_REFFlag(boolean flag)
    {
        bGROUP_REFFlag = flag;
    }

    
    public void setBindSchdFlag(boolean bindSchdFlag)
    {
        this.bindSchdFlag = bindSchdFlag;
    }

    
    public void setBINTERESTFlag(boolean flag)
    {
        bINTERESTFlag = flag;
    }

    
    public void setBLIMIT_BASISFlag(boolean flag)
    {
        bLIMIT_BASISFlag = flag;
    }

    
    public void setBLLOYDS_CLAIM_TYPEFlag(boolean flag)
    {
        bLLOYDS_CLAIM_TYPEFlag = flag;
    }

    
    public void setBLOC_VOYFlag(boolean flag)
    {
        bLOC_VOYFlag = flag;
    }

    
    public void setBlockFlag(String blockFlag)
    {
        this.blockFlag = blockFlag;
    }

    
    public void setBlockInd(String blockInd)
    {
        this.blockInd = blockInd;
    }

    
    public void setBMARKET_SOURCEFlag(boolean flag)
    {
        bMARKET_SOURCEFlag = flag;
    }

    
    public void setBMARKETFlag(boolean flag)
    {
        bMARKETFlag = flag;
    }

    
    public void setBMKT_CODEFlag(boolean flag)
    {
        bMKT_CODEFlag = flag;
    }

    
    public void setBNO_SYNDSFlag(boolean flag)
    {
        bNO_SYNDSFlag = flag;
    }

    
    public void setBPER_NARRFlag(boolean flag)
    {
        bPER_NARRFlag = flag;
    }

    
    public void setBPOLICY_NARRFlag(boolean flag)
    {
        bPOLICY_NARRFlag = flag;
    }

    
    public void setBRISK_CODEFlag(boolean flag)
    {
        bRISK_CODEFlag = flag;
    }

    
    public void setBrokerClaimRef1(String brokerClaimRef1)
    {
        this.brokerClaimRef1 = brokerClaimRef1;
    }

    
    public void setBrokerClaimRef1Flag(String brokerClaimRef1Flag)
    {
        this.brokerClaimRef1Flag = brokerClaimRef1Flag;
    }

    
    public void setBrokerClaimRef2(String brokerClaimRef2)
    {
        this.brokerClaimRef2 = brokerClaimRef2;
    }

    
    public void setBrokerClaimRef2Flag(String brokerClaimRef2Flag)
    {
        this.brokerClaimRef2Flag = brokerClaimRef2Flag;
    }

    
    public void setBrokerContact(String brokerContact)
    {
        this.brokerContact = brokerContact;
    }

    
    public void setBrokerContactFlag(String brokerContactFlag)
    {
        this.brokerContactFlag = brokerContactFlag;
    }

    
    public void setBrokerPhoneNo(String brokerPhoneNo)
    {
        this.brokerPhoneNo = brokerPhoneNo;
    }

    
    public void setBrokerPhoneNoFlag(String brokerPhoneNoFlag)
    {
        this.brokerPhoneNoFlag = brokerPhoneNoFlag;
    }

    
    public void setBSI_NARRFlag(boolean flag)
    {
        bSI_NARRFlag = flag;
    }

    
    public void setBSLIP_ORD_1Flag(boolean flag)
    {
        bSLIP_ORD_1Flag = flag;
    }

    
    public void setBSLIP_ORD_2Flag(boolean flag)
    {
        bSLIP_ORD_2Flag = flag;
    }

    
    public void setBTDN_REFFlag(boolean flag)
    {
        bTDN_REFFlag = flag;
    }

    
    public void setBTRANS_SYNOPSISFlag(boolean flag)
    {
        bTRANS_SYNOPSISFlag = flag;
    }

    
    public void setBUMRFlag(boolean flag)
    {
        bUMRFlag = flag;
    }

    
    public void setBureauPpn(String bureauPpn)
    {
        this.bureauPpn = bureauPpn;
    }

    
    public void setBureauPpnFlag(String bureauPpnFlag)
    {
        this.bureauPpnFlag = bureauPpnFlag;
    }

    
    public void setBUSER_IDFlag(boolean flag)
    {
        bUSER_IDFlag = flag;
    }

    
    public void setBXCR_CLAIM_NARRFlag(boolean flag)
    {
        bXCR_CLAIM_NARRFlag = flag;
    }

    
    public void setBYOAFlag(boolean flag)
    {
        bYOAFlag = flag;
    }

    
    public void setCatCode(String catCode)
    {
        this.catCode = catCode;
    }

    
    public void setCatCodeFlag(boolean catCodeFlag)
    {
        this.catCodeFlag = catCodeFlag;
    }

    
    public void setCcsFlag(boolean ccsFlag)
    {
        this.ccsFlag = ccsFlag;
    }

    
    public void setCcyOfLimits(String ccyOfLimits)
    {
        this.ccyOfLimits = ccyOfLimits;
    }

    
    public void setCcyOfLimitsFlag(boolean ccyOfLimitsFlag)
    {
        this.ccyOfLimitsFlag = ccyOfLimitsFlag;
    }

    
    public void setCheckedAttachmentsInd(String checkedAttachmentsInd)
    {
        this.checkedAttachmentsInd = checkedAttachmentsInd;
    }

    
    public void setCheckedBlockInd(String checkedBlockInd)
    {
        this.checkedBlockInd = checkedBlockInd;
    }

    
    public void setCheckedLFAdvanceInd(String checkedLFAdvanceInd)
    {
        this.checkedLFAdvanceInd = checkedLFAdvanceInd;
    }

    
    public void setCheckedLFEntryInd(String checkedLFEntryInd)
    {
        this.checkedLFEntryInd = checkedLFEntryInd;
    }

    
    public void setCheckedSubrogation(String checkedSubrogation)
    {
        this.checkedSubrogation = checkedSubrogation;
    }

    
    public void setCheckedUsaCanInd(String checkedUsaCanInd)
    {
        this.checkedUsaCanInd = checkedUsaCanInd;
    }

    
    public void setCheckedWarInd(String checkedWarInd)
    {
        this.checkedWarInd = checkedWarInd;
    }

    
    public void setClaimant(String claimant)
    {
        this.claimant = claimant;
    }

    
    public void setClaimantFlag(String claimantFlag)
    {
        this.claimantFlag = claimantFlag;
    }

    
    public void setClaimBrokerRef1(String claimBrokerRef1)
    {
        this.claimBrokerRef1 = claimBrokerRef1;
    }

    
    public void setClaimBrokerRef1Flag(String claimBrokerRef1Flag)
    {
        this.claimBrokerRef1Flag = claimBrokerRef1Flag;
    }

    
    public void setClaimBrokerRef2(String claimBrokerRef2)
    {
        this.claimBrokerRef2 = claimBrokerRef2;
    }

    
    public void setClaimBrokerRef2Flag(String claimBrokerRef2Flag)
    {
        this.claimBrokerRef2Flag = claimBrokerRef2Flag;
    }

    
    public void setClaimholder(String claimholder)
    {
        this.claimholder = claimholder;
    }

    
    public void setClaimholderFlag(String claimholderFlag)
    {
        this.claimholderFlag = claimholderFlag;
    }

    
    public void setClaimNarrative(String claimNarrative)
    {
        this.claimNarrative = claimNarrative;
    }

    
    public void setClaimNarrativeFlag(String claimNarrativeFlag)
    {
        this.claimNarrativeFlag = claimNarrativeFlag;
    }

    
    public void setClaimRefRec(String claimRefRec)
    {
        this.claimRefRec = claimRefRec;
    }

    
    public void setClaimRefRecFlag(boolean claimRefRecFlag)
    {
        this.claimRefRecFlag = claimRefRecFlag;
    }

    
    public void setClmOptOutDateFlag(String clmOptOutDateFlag)
    {
        this.clmOptOutDateFlag = clmOptOutDateFlag;
    }

    
    public void setClmOptOutStatusFlag(String clmOptOutStatusFlag)
    {
        this.clmOptOutStatusFlag = clmOptOutStatusFlag;
    }

    
    public void setCOptOutDate(String optOutDate)
    {
        cOptOutDate = optOutDate;
    }

    
    public void setCOptOutStatus(String optOutStatus)
    {
        cOptOutStatus = optOutStatus;
    }

    
    public void setCorFlag(String corFlag)
    {
        this.corFlag = corFlag;
    }

    
    public void setCountryOfOrigin(String countryOfOrigin)
    {
        this.countryOfOrigin = countryOfOrigin;
    }

    
    public void setCountryOfOriginFlag(boolean countryOfOriginFlag)
    {
        this.countryOfOriginFlag = countryOfOriginFlag;
    }

    
    public void setCurrNoVal(String currNoVal)
    {
        this.currNoVal = currNoVal;
    }

    
    public void setDCMFrom(String from)
    {
        dCMFrom = from;
    }

    
    public void setDCMFromFlag(boolean fromFlag)
    {
        dCMFromFlag = fromFlag;
    }

    
    public void setDCMQual(String qual)
    {
        dCMQual = qual;
    }

    
    public void setDCMQualFlag(boolean qualFlag)
    {
        dCMQualFlag = qualFlag;
    }

    
    public void setDCMTo(String to)
    {
        dCMTo = to;
    }

    
    public void setDCMToFlag(boolean toFlag)
    {
        dCMToFlag = toFlag;
    }

    
    public void setDOLFrom(String from)
    {
        dOLFrom = from;
    }

    
    public void setDOLFromFlag(boolean fromFlag)
    {
        dOLFromFlag = fromFlag;
    }

    
    public void setDolNarr(String dolNarr)
    {
        this.dolNarr = dolNarr;
    }

    
    public void setDolNarrFlag(String dolNarrFlag)
    {
        this.dolNarrFlag = dolNarrFlag;
    }

    
    public void setDOLQual(String qual)
    {
        dOLQual = qual;
    }

    
    public void setDOLQualFlag(boolean qualFlag)
    {
        dOLQualFlag = qualFlag;
    }

    
    public void setDOLTo(String to)
    {
        dOLTo = to;
    }

    
    public void setDOLToFlag(boolean toFlag)
    {
        dOLToFlag = toFlag;
    }

    
    public void setDti(String dti)
    {
        this.dti = dti;
    }

    
    public void setDtiFlag(boolean dtiFlag)
    {
        this.dtiFlag = dtiFlag;
    }

    
    public void setEndBDFlag(boolean endBDFlag)
    {
        this.endBDFlag = endBDFlag;
    }

    
    public void setEuroFlag(boolean euroFlag)
    {
        this.euroFlag = euroFlag;
    }

    
    public void setExcess(String excess)
    {
        this.excess = excess;
    }

    
    public void setExcessFlag(String excessFlag)
    {
        this.excessFlag = excessFlag;
    }

    
    public void setFilCode1(String filCode1)
    {
        this.filCode1 = filCode1;
    }

    
    public void setFilCode1Flag(boolean filCode1Flag)
    {
        this.filCode1Flag = filCode1Flag;
    }

    
    public void setFilCode2(String filCode2)
    {
        this.filCode2 = filCode2;
    }

    
    public void setFilCode2Flag(boolean filCode2Flag)
    {
        this.filCode2Flag = filCode2Flag;
    }

    
    public void setFinderCode1(String finderCode1)
    {
        this.finderCode1 = finderCode1;
    }

    
    public void setFinderCode1Flag(String finderCode1Flag)
    {
        this.finderCode1Flag = finderCode1Flag;
    }

    
    public void setFinderCode2(String finderCode2)
    {
        this.finderCode2 = finderCode2;
    }

    
    public void setFinderCode2Flag(String finderCode2Flag)
    {
        this.finderCode2Flag = finderCode2Flag;
    }

    
    public void setFinderCode3(String finderCode3)
    {
        this.finderCode3 = finderCode3;
    }

    
    public void setFinderCode3Flag(String finderCode3Flag)
    {
        this.finderCode3Flag = finderCode3Flag;
    }

    
    public void setHCor(String cor)
    {
        hCor = cor;
    }

    
    public void setHighestEst(String highestEst)
    {
        this.highestEst = highestEst;
    }

    
    public void setHighestEstFlag(String highestEstFlag)
    {
        this.highestEstFlag = highestEstFlag;
    }

    
    public void setHLoc(String loc)
    {
        hLoc = loc;
    }

    
    public void setHLocIndFlag(String locIndFlag)
    {
        hLocIndFlag = locIndFlag;
    }

    
    public void setHMoveRefAttr(String moveRefAttr)
    {
        hMoveRefAttr = moveRefAttr;
    }

    
    public void setHMvmtRefDate(String mvmtRefDate)
    {
        hMvmtRefDate = mvmtRefDate;
    }

    
    public void setHOrigBkr(String origBkr)
    {
        hOrigBkr = origBkr;
    }

    
    public void setHOrigBkrFlag(String origBkrFlag)
    {
        hOrigBkrFlag = origBkrFlag;
    }

    
    public void setHOrigCcy(String origCcy)
    {
        hOrigCcy = origCcy;
    }

    
    public void setHOrigCurrFlag(String origCurrFlag)
    {
        hOrigCurrFlag = origCurrFlag;
    }

    
    public void setHOrigRefFlag(String origRefFlag)
    {
        hOrigRefFlag = origRefFlag;
    }

    
    public void setHOsnd(String osnd)
    {
        hOsnd = osnd;
    }

    
    public void setHPayeeBkr(String payeeBkr)
    {
        hPayeeBkr = payeeBkr;
    }

    
    public void setHPayeeBkrFlag(String payeeBkrFlag)
    {
        hPayeeBkrFlag = payeeBkrFlag;
    }

    
    public void setHPeerRevFlag(String peerRevFlag)
    {
        hPeerRevFlag = peerRevFlag;
    }

    
    public void setHPeerReview(String peerReview)
    {
        hPeerReview = peerReview;
    }

    
    public void setHRedenomFlag(String redenomFlag)
    {
        hRedenomFlag = redenomFlag;
    }

    
    public void setHRedenomInd(String redenomInd)
    {
        hRedenomInd = redenomInd;
    }

    
    public void setHSigned(String signed)
    {
        hSigned = signed;
    }

    
    public void setHSignIndFlag(String signIndFlag)
    {
        hSignIndFlag = signIndFlag;
    }

    
    public void setHTr(String tr)
    {
        hTr = tr;
    }

    
    public void setHTRFlag(String flag)
    {
        hTRFlag = flag;
    }

    
    public void setHUcr(String ucr)
    {
        hUcr = ucr;
    }

    
    public void setHUCRFlag(String flag)
    {
        hUCRFlag = flag;
    }

    
    public void setHXcr(String xcr)
    {
        hXcr = xcr;
    }

    
    public void setHXCRFlag(String flag)
    {
        hXCRFlag = flag;
    }

    
    public void setIncurred(String incurred)
    {
        this.incurred = incurred;
    }

    
    public void setIncurredFlag(String incurredFlag)
    {
        this.incurredFlag = incurredFlag;
    }

    
    public void setInsured(String insured)
    {
        this.insured = insured;
    }

    
    public void setInsuredFlag(String insuredFlag)
    {
        this.insuredFlag = insuredFlag;
    }

    
    public void setLawyerCode(String lawyerCode)
    {
        this.lawyerCode = lawyerCode;
    }

    
    public void setLawyerCodeFlag(String lawyerCodeFlag)
    {
        this.lawyerCodeFlag = lawyerCodeFlag;
    }

    
    public void setLawyerName(String lawyerName)
    {
        this.lawyerName = lawyerName;
    }

    
    public void setLawyerNameFlag(boolean lawyerNameFlag)
    {
        this.lawyerNameFlag = lawyerNameFlag;
    }

    
    public void setLawyerRef(String lawyerRef)
    {
        this.lawyerRef = lawyerRef;
    }

    
    public void setLawyerRefFlag(String lawyerRefFlag)
    {
        this.lawyerRefFlag = lawyerRefFlag;
    }

    
    public void setLfAdvanceFlag(String lfAdvanceFlag)
    {
        this.lfAdvanceFlag = lfAdvanceFlag;
    }

    
    public void setLfAdvanceInd(String lfAdvanceInd)
    {
        this.lfAdvanceInd = lfAdvanceInd;
    }

    
    public void setLfEntryFlag(String lfEntryFlag)
    {
        this.lfEntryFlag = lfEntryFlag;
    }

    
    public void setLfEntryInd(String lfEntryInd)
    {
        this.lfEntryInd = lfEntryInd;
    }

    
    public void setLimits(String limits)
    {
        this.limits = limits;
    }

    
    public void setLimitsFlag(String limitsFlag)
    {
        this.limitsFlag = limitsFlag;
    }

    
    public void setLossLocation(String lossLocation)
    {
        this.lossLocation = lossLocation;
    }

    
    public void setLossLocationFlag(String lossLocationFlag)
    {
        this.lossLocationFlag = lossLocationFlag;
    }

    
    public void setLossName(String lossName)
    {
        this.lossName = lossName;
    }

    
    public void setLossNameFlag(String lossNameFlag)
    {
        this.lossNameFlag = lossNameFlag;
    }

    
    public void setMm(ModelManager mm)
    {
        this.mm = mm;
    }

    
    public void setNaicCode(String naicCode)
    {
        this.naicCode = naicCode;
    }

    
    public void setNaicCodeFlag(String naicCodeFlag)
    {
        this.naicCodeFlag = naicCodeFlag;
    }

    
    public void setNaicQual(String naicQual)
    {
        this.naicQual = naicQual;
    }

    
    public void setNaicQualFlag(boolean naicQualFlag)
    {
        this.naicQualFlag = naicQualFlag;
    }

    
    public void setNarrativeCode1(String narrativeCode1)
    {
        this.narrativeCode1 = narrativeCode1;
    }

    
    public void setNarrativeCode1Flag(boolean narrativeCode1Flag)
    {
        this.narrativeCode1Flag = narrativeCode1Flag;
    }

    
    public void setNarrativeCode2(String narrativeCode2)
    {
        this.narrativeCode2 = narrativeCode2;
    }

    
    public void setNarrativeCode2Flag(boolean narrativeCode2Flag)
    {
        this.narrativeCode2Flag = narrativeCode2Flag;
    }

    
    public void setNarrativeForSet(String narrativeForSet)
    {
        this.narrativeForSet = narrativeForSet;
    }

    
    public void setNarrativeForSet2(String narrativeForSet2)
    {
        this.narrativeForSet2 = narrativeForSet2;
    }

    
    public void setNarrativeForSet2Flag(String narrativeForSet2Flag)
    {
        this.narrativeForSet2Flag = narrativeForSet2Flag;
    }

    
    public void setNarrativeForSet3(String narrativeForSet3)
    {
        this.narrativeForSet3 = narrativeForSet3;
    }

    
    public void setNarrativeForSet3Flag(String narrativeForSet3Flag)
    {
        this.narrativeForSet3Flag = narrativeForSet3Flag;
    }

    
    public void setNarrativeForSetFlag(String narrativeForSetFlag)
    {
        this.narrativeForSetFlag = narrativeForSetFlag;
    }

    
    public void setNewBDFlag(boolean newBDFlag)
    {
        this.newBDFlag = newBDFlag;
    }

    
    public void setNewMovementFlag(boolean newMovementFlag)
    {
        this.newMovementFlag = newMovementFlag;
    }

    
    public void setOrigCcy(String origCcy)
    {
        this.origCcy = origCcy;
    }

    
    public void setOrigCcyFlag(boolean origCcyFlag)
    {
        this.origCcyFlag = origCcyFlag;
    }

    
    public void setOrigInsured(String origInsured)
    {
        this.origInsured = origInsured;
    }

    
    public void setOrigInsuredFlag(String origInsuredFlag)
    {
        this.origInsuredFlag = origInsuredFlag;
    }

    
    public void setOsExp(String osExp)
    {
        this.osExp = osExp;
    }

    
    public void setOsExpFlag(String osExpFlag)
    {
        this.osExpFlag = osExpFlag;
    }

    
    public void setOsFee(String osFee)
    {
        this.osFee = osFee;
    }

    
    public void setOsFeeFlag(String osFeeFlag)
    {
        this.osFeeFlag = osFeeFlag;
    }

    
    public void setOsFeeQual(String osFeeQual)
    {
        this.osFeeQual = osFeeQual;
    }

    
    public void setOsFeeQualFlag(boolean osFeeQualFlag)
    {
        this.osFeeQualFlag = osFeeQualFlag;
    }

    
    public void setOsLoss(String osLoss)
    {
        this.osLoss = osLoss;
    }

    
    public void setOsLossFlag(String osLossFlag)
    {
        this.osLossFlag = osLossFlag;
    }

    
    public void setOsLossQual(String osLossQual)
    {
        this.osLossQual = osLossQual;
    }

    
    public void setOsLossQualFlag(boolean osLossQualFlag)
    {
        this.osLossQualFlag = osLossQualFlag;
    }

    
    public void setOsRateOfExch(String osRateOfExch)
    {
        this.osRateOfExch = osRateOfExch;
    }

    
    public void setOsRateOfExchFlag(String osRateOfExchFlag)
    {
        this.osRateOfExchFlag = osRateOfExchFlag;
    }

    
    public void setOsTotal(String osTotal)
    {
        this.osTotal = osTotal;
    }

    
    public void setOsTotalFlag(String osTotalFlag)
    {
        this.osTotalFlag = osTotalFlag;
    }

    
    public void setOsTotalQual(String osTotalQual)
    {
        this.osTotalQual = osTotalQual;
    }

    
    public void setOsTotalQualFlag(boolean osTotalQualFlag)
    {
        this.osTotalQualFlag = osTotalQualFlag;
    }

    
    public void setOtherName(String otherName)
    {
        this.otherName = otherName;
    }

    
    public void setOtherNameFlag(String otherNameFlag)
    {
        this.otherNameFlag = otherNameFlag;
    }

    
    public void setOtherTfCode(String otherTfCode)
    {
        this.otherTfCode = otherTfCode;
    }

    
    public void setOtherTfCodeFlag(boolean otherTfCodeFlag)
    {
        this.otherTfCodeFlag = otherTfCodeFlag;
    }

    
    public void setPcsCode(String pcsCode)
    {
        this.pcsCode = pcsCode;
    }

    
    public void setPcsCodeFlag(boolean pcsCodeFlag)
    {
        this.pcsCodeFlag = pcsCodeFlag;
    }

    
    public void setPerilsCondition(String perilsCondition)
    {
        this.perilsCondition = perilsCondition;
    }

    
    public void setPerilsConditionFlag(String perilsConditionFlag)
    {
        this.perilsConditionFlag = perilsConditionFlag;
    }

    
    public void setPolCertPeriodFrom(String polCertPeriodFrom)
    {
        this.polCertPeriodFrom = polCertPeriodFrom;
    }

    
    public void setPolCertPeriodFromFlag(boolean polCertPeriodFromFlag)
    {
        this.polCertPeriodFromFlag = polCertPeriodFromFlag;
    }

    
    public void setPolCertPeriodTo(String polCertPeriodTo)
    {
        this.polCertPeriodTo = polCertPeriodTo;
    }

    
    public void setPolCertPeriodToFlag(boolean polCertPeriodToFlag)
    {
        this.polCertPeriodToFlag = polCertPeriodToFlag;
    }

    
    public void setPolCertQual(String polCertQual)
    {
        this.polCertQual = polCertQual;
    }

    
    public void setPolCertQualFlag(boolean polCertQualFlag)
    {
        this.polCertQualFlag = polCertQualFlag;
    }

    
    public void setPTDExp(String exp)
    {
        pTDExp = exp;
    }

    
    public void setPTDExpFlag(String expFlag)
    {
        pTDExpFlag = expFlag;
    }

    
    public void setPTDFee(String fee)
    {
        pTDFee = fee;
    }

    
    public void setPTDFeeFlag(String feeFlag)
    {
        pTDFeeFlag = feeFlag;
    }

    
    public void setPTDInSettCcy(String inSettCcy)
    {
        pTDInSettCcy = inSettCcy;
    }

    
    public void setPTDInSettCcyFlag(String inSettCcyFlag)
    {
        pTDInSettCcyFlag = inSettCcyFlag;
    }

    
    public void setPTDLoss(String loss)
    {
        pTDLoss = loss;
    }

    
    public void setPTDLossFlag(String lossFlag)
    {
        pTDLossFlag = lossFlag;
    }

    
    public void setPTDTotal(String total)
    {
        pTDTotal = total;
    }

    
    public void setPTDTotalFlag(String totalFlag)
    {
        pTDTotalFlag = totalFlag;
    }

    
    public void setPTTExp(String exp)
    {
        pTTExp = exp;
    }

    
    public void setPTTExpFlag(String expFlag)
    {
        pTTExpFlag = expFlag;
    }

    
    public void setPTTFee(String fee)
    {
        pTTFee = fee;
    }

    
    public void setPTTFeeFlag(String feeFlag)
    {
        pTTFeeFlag = feeFlag;
    }

    
    public void setPTTLoss(String loss)
    {
        pTTLoss = loss;
    }

    
    public void setPTTLossFlag(String lossFlag)
    {
        pTTLossFlag = lossFlag;
    }

    
    public void setPTTTotal(String total)
    {
        pTTTotal = total;
    }

    
    public void setPTTTotalFlag(String totalFlag)
    {
        pTTTotalFlag = totalFlag;
    }

    
    public void setReinsuredFlag(String reinsuredFlag)
    {
        this.reinsuredFlag = reinsuredFlag;
    }

    
    public void setResinsured(String resinsured)
    {
        this.resinsured = resinsured;
    }

    
    public void setRiSchdFlag(boolean riSchdFlag)
    {
        this.riSchdFlag = riSchdFlag;
    }

    
    public void setSAP_REF(String sap_ref)
    {
        sAP_REF = sap_ref;
    }

    
    public void setSaveButtonFlag(boolean saveButtonFlag)
    {
        this.saveButtonFlag = saveButtonFlag;
    }

    
    public void setSBUREAU_LEAD_IND(String sbureau_lead_ind)
    {
        sBUREAU_LEAD_IND = sbureau_lead_ind;
    }

    
    public void setSCHARGE_TYPE(String scharge_type)
    {
        sCHARGE_TYPE = scharge_type;
    }

    
    public void setSchemeCode(String schemeCode)
    {
        this.schemeCode = schemeCode;
    }

    
    public void setSchemeCodeFlag(boolean schemeCodeFlag)
    {
        this.schemeCodeFlag = schemeCodeFlag;
    }

    
    public void setSCHOLDER_CLM_REF(String scholder_clm_ref)
    {
        sCHOLDER_CLM_REF = scholder_clm_ref;
    }

    
    public void setSCLAIM_LINE_NO(String sclaim_line_no)
    {
        sCLAIM_LINE_NO = sclaim_line_no;
    }

    
    public void setSCLM_NARR_LINE1(String sclm_narr_line1)
    {
        sCLM_NARR_LINE1 = sclm_narr_line1;
    }

    
    public void setSCLM_NARR_LINE2(String sclm_narr_line2)
    {
        sCLM_NARR_LINE2 = sclm_narr_line2;
    }

    
    public void setSCLM_NARR_LINE3(String sclm_narr_line3)
    {
        sCLM_NARR_LINE3 = sclm_narr_line3;
    }

    
    public void setSCOV_DATE_FROM(String scov_date_from)
    {
        sCOV_DATE_FROM = scov_date_from;
    }

    
    public void setSCOV_DATE_TO(String scov_date_to)
    {
        sCOV_DATE_TO = scov_date_to;
    }

    
    public void setSCOV_QUAL(String scov_qual)
    {
        sCOV_QUAL = scov_qual;
    }

    
    public void setSCOY_CODE(String scoy_code)
    {
        sCOY_CODE = scoy_code;
    }

    
    public void setSCOY_LINE(String scoy_line)
    {
        sCOY_LINE = scoy_line;
    }

    
    public void setSCOY_REF_1(String scoy_ref_1)
    {
        sCOY_REF_1 = scoy_ref_1;
    }

    
    public void setScreenMode(String screenMode)
    {
        this.screenMode = screenMode;
    }

    
    public void setSdnNoVal(String sdnNoVal)
    {
        this.sdnNoVal = sdnNoVal;
    }

    
    public void setSettCcy(String settCcy)
    {
        this.settCcy = settCcy;
    }

    
    public void setSettCcyFlag(boolean settCcyFlag)
    {
        this.settCcyFlag = settCcyFlag;
    }

    
    public void setSettledRateInSettCcy(String settledRateInSettCcy)
    {
        this.settledRateInSettCcy = settledRateInSettCcy;
    }

    
    public void setSettledRateInSettCcyFlag(String settledRateInSettCcyFlag)
    {
        this.settledRateInSettCcyFlag = settledRateInSettCcyFlag;
    }

    
    public void setSettRateOfExch(String settRateOfExch)
    {
        this.settRateOfExch = settRateOfExch;
    }

    
    public void setSettRateOfExchFlag(String settRateOfExchFlag)
    {
        this.settRateOfExchFlag = settRateOfExchFlag;
    }

    
    public void setSGROUP_REF(String sgroup_ref)
    {
        sGROUP_REF = sgroup_ref;
    }

    
    public void setSINTEREST(String sinterest)
    {
        sINTEREST = sinterest;
    }

    
    public void setSLIMIT_BASIS(String slimit_basis)
    {
        sLIMIT_BASIS = slimit_basis;
    }

    
    public void setSLLOYDS_CLAIM_TYPE(String slloyds_claim_type)
    {
        sLLOYDS_CLAIM_TYPE = slloyds_claim_type;
    }

    
    public void setSLOC_VOYAGE(String sloc_voyage)
    {
        sLOC_VOYAGE = sloc_voyage;
    }

    
    public void setSMARKET_COUNT(String smarket_count)
    {
        sMARKET_COUNT = smarket_count;
    }

    
    public void setSMARKET_SOURCE(String smarket_source)
    {
        sMARKET_SOURCE = smarket_source;
    }

    
    public void setSMARKET_TABLE(String smarket_table)
    {
        sMARKET_TABLE = smarket_table;
    }

    
    public void setSMKT_CODE(String smkt_code)
    {
        sMKT_CODE = smkt_code;
    }

    
    public void setSNO_SYNDS(String sno_synds)
    {
        sNO_SYNDS = sno_synds;
    }

    
    public void setSPER_NARR(String sper_narr)
    {
        sPER_NARR = sper_narr;
    }

    
    public void setSPOLICY_NARR_LINE1(String spolicy_narr_line1)
    {
        sPOLICY_NARR_LINE1 = spolicy_narr_line1;
    }

    
    public void setSPOLICY_NARR_LINE2(String spolicy_narr_line2)
    {
        sPOLICY_NARR_LINE2 = spolicy_narr_line2;
    }

    
    public void setSPOLICY_NARR_LINE3(String spolicy_narr_line3)
    {
        sPOLICY_NARR_LINE3 = spolicy_narr_line3;
    }

    
    public void setSPOLICY_NARR_LINE4(String spolicy_narr_line4)
    {
        sPOLICY_NARR_LINE4 = spolicy_narr_line4;
    }

    
    public void setSPOLICY_NARR_TABLE(String spolicy_narr_table)
    {
        sPOLICY_NARR_TABLE = spolicy_narr_table;
    }

    
    public void setSRISK_CODE(String srisk_code)
    {
        sRISK_CODE = srisk_code;
    }

    
    public void setSSI_NARR(String ssi_narr)
    {
        sSI_NARR = ssi_narr;
    }

    
    public void setSSLIP_ORD_1(String sslip_ord_1)
    {
        sSLIP_ORD_1 = sslip_ord_1;
    }

    
    public void setSSLIP_ORD_2(String sslip_ord_2)
    {
        sSLIP_ORD_2 = sslip_ord_2;
    }

    
    public void setSSYNOPSIS_TEXT1(String ssynopsis_text1)
    {
        sSYNOPSIS_TEXT1 = ssynopsis_text1;
    }

    
    public void setSSYNOPSIS_TEXT2(String ssynopsis_text2)
    {
        sSYNOPSIS_TEXT2 = ssynopsis_text2;
    }

    
    public void setSSYNOPSIS_TEXT3(String ssynopsis_text3)
    {
        sSYNOPSIS_TEXT3 = ssynopsis_text3;
    }

    
    public void setSSYNOPSIS_TEXT4(String ssynopsis_text4)
    {
        sSYNOPSIS_TEXT4 = ssynopsis_text4;
    }

    
    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }

    
    public void setStateCodeFlag(boolean stateCodeFlag)
    {
        this.stateCodeFlag = stateCodeFlag;
    }

    
    public void setSTDN_REF(String stdn_ref)
    {
        sTDN_REF = stdn_ref;
    }

    
    public void setSTRANS_SYNOPSIS(String strans_synopsis)
    {
        sTRANS_SYNOPSIS = strans_synopsis;
    }

    
    public void setSTRANS_SYNOPSIS_LINE(String strans_synopsis_line)
    {
        sTRANS_SYNOPSIS_LINE = strans_synopsis_line;
    }

    
    public void setSubrogation(String subrogation)
    {
        this.subrogation = subrogation;
    }

    
    public void setSubrogationFlag(String subrogationFlag)
    {
        this.subrogationFlag = subrogationFlag;
    }

    
    public void setSUMR(String sumr)
    {
        sUMR = sumr;
    }

    
    public void setSUSER_ID(String suser_id)
    {
        sUSER_ID = suser_id;
    }

    
    public void setSXCR_CLAIM_NARR(String sxcr_claim_narr)
    {
        sXCR_CLAIM_NARR = sxcr_claim_narr;
    }

    
    public void setSYEAR_OF_ACC(String syear_of_acc)
    {
        sYEAR_OF_ACC = syear_of_acc;
    }

    
    public void setTfCode(String tfCode)
    {
        this.tfCode = tfCode;
    }

    
    public void setTfCodeFlag(boolean tfCodeFlag)
    {
        this.tfCodeFlag = tfCodeFlag;
    }

    
    public void setTotalLine(String totalLine)
    {
        this.totalLine = totalLine;
    }

    
    public void setTotalLineFlag(String totalLineFlag)
    {
        this.totalLineFlag = totalLineFlag;
    }

    
    public void setUsaCanInd(String usaCanInd)
    {
        this.usaCanInd = usaCanInd;
    }

    
    public void setUsaCanIndFlag(String usaCanIndFlag)
    {
        this.usaCanIndFlag = usaCanIndFlag;
    }

    
    public void setVAllMarketDetails(Vector allMarketDetails)
    {
        vAllMarketDetails = allMarketDetails;
    }

    
    public void setVATAmount(String amount)
    {
        vATAmount = amount;
    }

    
    public void setVATAmountFlag(String amountFlag)
    {
        vATAmountFlag = amountFlag;
    }

    
    public void setVatRateButtonFlag(boolean vatRateButtonFlag)
    {
        this.vatRateButtonFlag = vatRateButtonFlag;
    }

    
    public void setVesselAircraft(String vesselAircraft)
    {
        this.vesselAircraft = vesselAircraft;
    }

    
    public void setVesselAircraftFlag(String vesselAircraftFlag)
    {
        this.vesselAircraftFlag = vesselAircraftFlag;
    }

    
    public void setVoyage(String voyage)
    {
        this.voyage = voyage;
    }

    
    public void setVoyageFlag(String voyageFlag)
    {
        this.voyageFlag = voyageFlag;
    }

    
    public void setWARAmount(String amount)
    {
        wARAmount = amount;
    }

    
    public void setWARAmountFlag(String amountFlag)
    {
        wARAmountFlag = amountFlag;
    }

    
    public void setWarInd(String warInd)
    {
        this.warInd = warInd;
    }

    
    public void setWarIndFlag(String warIndFlag)
    {
        this.warIndFlag = warIndFlag;
    }

    
    public void setXCSRecovery(String recovery)
    {
        xCSRecovery = recovery;
    }

    
    public void setXCSRecoveryFlag(String recoveryFlag)
    {
        xCSRecoveryFlag = recoveryFlag;
    }

    
    public void setCountyCode(String countyCode)
    {
        this.countyCode = countyCode;
    }

    
    public String getSlipTypeDesc()
    {
        return slipTypeDesc;
    }

    
    public void setSlipTypeDesc(String slipTypeDesc)
    {
        this.slipTypeDesc = slipTypeDesc;
    }

    
    public String getSlipTypeDescFlag()
    {
        return slipTypeDescFlag;
    }

    
    public void setSlipTypeDescFlag(String slipTypeDescFlag)
    {
        this.slipTypeDescFlag = slipTypeDescFlag;
    }

    
    public String getServiceType()
    {
        return serviceType;
    }

    
    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    
    public boolean getServiceTypeFlag()
    {
        return serviceTypeFlag;
    }

    
    public void setServiceTypeFlag(boolean serviceTypeFlag)
    {
        this.serviceTypeFlag = serviceTypeFlag;
    }
}
