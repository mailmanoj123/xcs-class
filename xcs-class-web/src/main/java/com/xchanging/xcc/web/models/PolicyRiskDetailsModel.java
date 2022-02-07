package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY29Event;
import com.xchanging.xcc.events.LY30Event;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class PolicyRiskDetailsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  String screenMode;

  private String ucr = "";
  private String xcr = "";
  private String tr = "";
  private String osnd1 = "";
  private String osnd2 = "";
  private String osnd3 = "";

  // CCN# N0009 - BA - 07/01/2002
  private String peerReview = "";

  private String currentBroker = "";
  private String riskCode = "";

  // CCN# N0030 - BA - 06/01/2002
  private String marketCode = "" ;

  private String yoa = "";
  private String interest = "";
  private String perilsCondition = "";
  private String locationVoyageOfRisk = "";
  private String slipOrder1 = "";
  private String slipOrder2 = "";
  private String BOL = "";
  private String polCertPeriodFrom = "";
  private String polCertPeriodTo = "";
  private String polCertQual = "";
  private String coverLineSlipFrom = "";
  private String coverLineSlipTo = "";
  private String coverLineSlipQual = "";
  private String warInd = "";
  private String umr = "";
  private String umrLIDS = "";

  
  private String sumInsuredNarrative1 = "";
  private String sumInsuredNarrative2 = "";
  private String polCertNarrative = "";
  // held within a table of 3
  private String ccyOfLimits1 = "";
  private String limits1 = "";
  private String excess1 = "";
  private String limits2 = "";
  private String excess2 = "";
  private String ccyOfLimits2 = "";
  private String limits3 = "";
  private String excess3 = "";
  private String ccyOfLimits3 = "";

  private String xcrFlag;
  private String ucrFlag;
  private String trFlag;
  private String origRef1Flag;
  private String origRef2Flag;
  private String origRef3Flag;
  private String sumInsuredNarrative1Flag;
  private String sumInsuredNarrative2Flag;
  private String polCertNarrativeFlag;
  private boolean coverLineSlipToFlag;
  private boolean coverLineSlipFromFlag;
  private boolean coverLineSlipQualFlag;
  private String warIndFlag;
  
  private String slipType = "";
  //***
  // Used to signal if the UMR can be edited or not
  private String umrFlag; // ***
  //***
  
  private boolean slipTypeFlag;
  private boolean BOLFlag;
  private boolean polCertPeriodFromFlag;
  private boolean polCertPeriodToFlag;
  private boolean polCertQualFlag;
  private boolean peerReviewFlag;
  private boolean currentBrokerFlag;
  private String riskCodeFlag;
  // CCN# N0030 - BA - 06/01/2002
  private boolean mktCodeFlag;
  private String yoaFlag;
  private String interestFlag;
  private String perilsConditionFlag;
  private String locationVoyageOfRiskFlag;
  private String slipOrder1Flag;
  private String slipOrder2Flag;

  // These three variables reflect whether or not
  // all three sets of "limit table" details
  // are protected or not.
  private boolean ccyOfLimitsFlag;
  private String limitsFlag;
  private String excessFlag;

  private boolean saveButtonFlag;

  // This will detail whether any errors are returned
  // from this model
  // NOTE: THIS WILL BE FALSE all the time.
  private boolean errorsInModel;

  //3B change
  private String origBroker="";
  private boolean origBrokerFlag;
  
  public PolicyRiskDetailsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.PolicyRiskDetailsModelKey, this);
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

  if (event instanceof LY28Event) {

      screenMode = (String) results.get(Keys.LY28_SCREEN_MODE_Field);
      mm.getUserWebModel().setUpdateMode(screenMode);

      if (screenMode.equals("E"))
          {saveButtonFlag = true;}
      else {saveButtonFlag = false;}


      MappedRecord subResults = (MappedRecord) ((Vector) results.get(Keys.LY28_FIELD_VALUES_Table)).get(0);

      currentBroker = (String) subResults.get(Keys.LY28_CURRENT_BKR_Field);
      origBroker = (String) subResults.get(Keys.LY28_ORIG_BKR_Field);

      xcr = (String) subResults.get(Keys.LY28_XCR_Field);
      ucr = (String) subResults.get(Keys.LY28_UCR_Field);
      tr = (String) subResults.get(Keys.LY28_TR_Field);
      osnd1 = (String) subResults.get(Keys.LY28_ORIG_REF_1_Field);
      osnd2 = (String) subResults.get(Keys.LY28_ORIG_REF_2_Field);
      osnd3 = (String) subResults.get(Keys.LY28_ORIG_REF_3_Field);
      peerReview = (String) subResults.get(Keys.LY28_PEER_REV_IND_Field);

      riskCode = (String) subResults.get(Keys.LY28_RISK_CODE_Field);
      // CCN# N0030 - BA - 06/01/2002
      marketCode = (String) subResults.get(Keys.LY28_MARKET_CODE);
      yoa = (String) subResults.get(Keys.LY28_YEAR_OF_ACC_Field);
      interest = (String) subResults.get(Keys.LY28_INTEREST_Field);

      sumInsuredNarrative1 = (String) subResults.get(Keys.LY28_SI_NARR_1_Field);
      /*  CCN: N0047
      Changed on: 11/12/02 (DH)
      sumInsuredNarrative2 = (String) subResults.get(Keys.LY28_SI_NARR_2_Field);
      */

      slipOrder1 = (String) subResults.get(Keys.LY28_C028_SLIP_ORDER_1_Field);
      slipOrder2 = (String) subResults.get(Keys.LY28_C028_SLIP_ORDER_2_Field);
      perilsCondition = (String) subResults.get(Keys.LY28_PERILS_CONDS_Field);
      locationVoyageOfRisk = (String) subResults.get(Keys.LY28_LOCATION_VOYAGE_Field);
      BOL = (String) subResults.get(Keys.LY28_BASIS_OF_LIMIT_Field);
      polCertPeriodFrom = (String) subResults.get(Keys.LY28_POL_CERT_FROM_Field);
      polCertPeriodTo = (String) subResults.get(Keys.LY28_POL_CERT_TO_Field);
      polCertQual = (String) subResults.get(Keys.LY28_POL_CERT_QUAL_Field);
      polCertNarrative = (String) subResults.get(Keys.LY28_POL_PERIOD_NARR_Field);
      coverLineSlipFrom = (String) subResults.get(Keys.LY28_COVER_LS_FROM_Field);
      coverLineSlipTo = (String) subResults.get(Keys.LY28_COVER_LS_TO_Field);
      coverLineSlipQual = (String) subResults.get(Keys.LY28_COVER_LS_QUAL_Field);
      warInd = checkBoxStatus((String) subResults.get(Keys.LY28_WAR_IND_Field));
      slipType = (String) subResults.get(Keys.LY28_SLIP_TYPE_Field);
      
      // CCN# N0039 - BA - 06/01/2002
      umr = (String) subResults.get(Keys.LY28_UMR_Field);

      // Now save away the limit table details- these are stored in
      // 3 sets of separate fields as it makes it easier for the JSP
      // to extract them.
      // Initialise them all to true (or protected) first as the vector may not
     //  be of size three. And we would want to blank out existing results.
      ccyOfLimits1 = "";
      limits1= "";
      excess1 = "";
      ccyOfLimits2 = "";
      limits2= "";
      excess2 = "";
      ccyOfLimits3 = "";
      limits3= "";
      excess3 = "";
      Vector v1 = (Vector) subResults.get(Keys.LY28_LIMIT_TABLE_Table);
      for(int x=0; x<v1.size();x++){
        MappedRecord mp1 = (MappedRecord) v1.get(x);
        // if the ccy field is blank then we do not want to throw the damn thing out to the
        // string.
        if (!(((String) mp1.get(Keys.LY28_LIMIT_CURR_Field)).equals(""))){
          switch(x){
            case 0:
              ccyOfLimits1 = (String) mp1.get(Keys.LY28_LIMIT_CURR_Field);
              limits1 = (String) mp1.get(Keys.LY28_SI_LIMIT_Field);
              excess1 = (String) mp1.get(Keys.LY28_EXCESS_LIMIT_Field);
              break;
            case 1:
              ccyOfLimits2 = (String) mp1.get(Keys.LY28_LIMIT_CURR_Field);
              limits2 = (String) mp1.get(Keys.LY28_SI_LIMIT_Field);
              excess2 = (String) mp1.get(Keys.LY28_EXCESS_LIMIT_Field);
              break;
            case 2:
              ccyOfLimits3 = (String) mp1.get(Keys.LY28_LIMIT_CURR_Field);
              limits3 = (String) mp1.get(Keys.LY28_SI_LIMIT_Field);
              excess3 = (String) mp1.get(Keys.LY28_EXCESS_LIMIT_Field);
              break;
          }
        }
      }

      MappedRecord subResults2 = (MappedRecord) ((Vector) results.get(Keys.LY28_FIELD_ATTRIBUTES_Table)).get(0);

      origBrokerFlag    = convertToBoolean((String) subResults2.get(Keys.LY28_ORIG_BKR_ATTR_Field));
      currentBrokerFlag = convertToBoolean((String) subResults2.get(Keys.LY28_CURRENT_BKR_ATTR_Field));

      xcrFlag            = enabledStatus((String) subResults2.get(Keys.LY28_XCR_ATTR_Field));
      ucrFlag            = enabledStatus((String) subResults2.get(Keys.LY28_UCR_ATTR_Field));
      trFlag             = enabledStatus((String) subResults2.get(Keys.LY28_TR_ATTR_Field));
      origRef1Flag       = enabledStatus((String) subResults2.get(Keys.LY28_ORIG_REF_ATTR1_Field));
      origRef2Flag       = enabledStatus((String) subResults2.get(Keys.LY28_ORIG_REF_ATTR2_Field));
      origRef3Flag       = enabledStatus((String) subResults2.get(Keys.LY28_ORIG_REF_ATTR3_Field));
      peerReviewFlag     = convertToBoolean((String) subResults2.get(Keys.LY28_PEER_REV_ATTR_Field));
      riskCodeFlag       = enabledStatus((String) subResults2.get(Keys.LY28_RISK_CODE_ATTR_Field));
      // CCN# N0030 - BA - 06/01/2002
      mktCodeFlag        = convertToBoolean((String) subResults2.get(Keys.LY28_MKT_CODE_ATTR_Field));

      yoaFlag            = enabledStatus((String) subResults2.get(Keys.LY28_YOA_ATTR_Field));
      interestFlag       = enabledStatus((String) subResults2.get(Keys.LY28_INTEREST_ATTR_Field));

      sumInsuredNarrative1Flag = enabledStatus((String) subResults2.get(Keys.LY28_SI_NARR_ATTR1_Field));

      /*  CCN: N0047
      Changed on: 11/12/02 (DH)
      sumInsuredNarrative2Flag = enabledStatus((String) subResults2.get(Keys.LY28_SI_NARR_ATTR2_Field));

      */
      slipOrder1Flag           = enabledStatus((String) subResults2.get(Keys.LY28_SLIP_ORDER_ATTR1_Field));
      slipOrder2Flag           = enabledStatus((String) subResults2.get(Keys.LY28_SLIP_ORDER_ATTR2_Field));

      perilsConditionFlag      = enabledStatus((String) subResults2.get(Keys.LY28_PERILS_CONDS_ATTR_Field));
      locationVoyageOfRiskFlag = enabledStatus((String) subResults2.get(Keys.LY28_LOC_VGE_ATTR_Field));
      BOLFlag                  = convertToBoolean((String) subResults2.get(Keys.LY28_BASIS_OF_LIMIT_ATTR_Field));
      polCertPeriodFromFlag    = convertToBoolean((String) subResults2.get(Keys.LY28_POL_FROM_ATTR_Field));
      polCertPeriodToFlag      = convertToBoolean((String) subResults2.get(Keys.LY28_POL_TO_ATTR_Field));
      polCertQualFlag          = convertToBoolean((String) subResults2.get(Keys.LY28_POL_CERT_Q_ATTR_Field));
      polCertNarrativeFlag     = enabledStatus((String) subResults2.get(Keys.LY28_POL_NARR_ATTR_Field));
      coverLineSlipFromFlag    = convertToBoolean((String) subResults2.get(Keys.LY28_COVER_FROM_ATTR_Field));
      coverLineSlipToFlag      = convertToBoolean((String) subResults2.get(Keys.LY28_COVER_TO_ATTR_Field));
      coverLineSlipQualFlag    = convertToBoolean((String) subResults2.get(Keys.LY28_COVER_LS_Q_ATTR_Field));
      umrFlag                  = enabledStatus((String) subResults2.get(Keys.LY28_UMR_ATTR_Field));
      Logger.debug("umrFlag = " + umrFlag +" : in " + this.getClass().getName().substring(18));
      warIndFlag               = enabledStatusCheckbox((String) subResults2.get(Keys.LY28_WAR_IND_ATTR_Field));
      slipTypeFlag                         = convertToBoolean((String) subResults2.get(Keys.LY28_SLIP_TYPE_ATTR_Field));
      ccyOfLimitsFlag  = convertToBoolean((String) subResults2.get(Keys.LY28_LIMIT_CURR_ATTR_Field));
      limitsFlag       = enabledStatus((String) subResults2.get(Keys.LY28_SI_LIMIT_ATTR_Field));
      excessFlag       = enabledStatus((String) subResults2.get(Keys.LY28_EXCESS_LIM_ATTR_Field));

    } else if (event instanceof LY29Event){

      MappedRecord subResults = (MappedRecord) ((Vector) results.get(Keys.LY29_FIELD_VALUES_Table)).get(0);

      if (screenMode.equals("E"))
          {saveButtonFlag = true;}
      else {saveButtonFlag = false;}

      // CCN# N0009 - BA - 07/01/2002
      peerReview = (String) subResults.get(Keys.LY29_PEER_REV_IND_Field);

      currentBroker = (String) subResults.get(Keys.LY29_CURRENT_BKR_Field);
      riskCode   = (String) subResults.get(Keys.LY29_RISK_CODE_Field);
      // CCN# N0030 - BA - 06/01/2002
      marketCode = (String) subResults.get(Keys.LY29_MARKET_CODE_Field);
      yoa        = (String) subResults.get(Keys.LY29_YEAR_OF_ACC_Field);
      interest   = (String) subResults.get(Keys.LY29_INTEREST_Field);

      slipOrder1           = (String) subResults.get(Keys.LY29_SLIP_ORDER_1_Field);
      slipOrder2           = (String) subResults.get(Keys.LY29_SLIP_ORDER_2_Field);
      perilsCondition      = (String) subResults.get(Keys.LY29_PERILS_CONDS_Field);
      locationVoyageOfRisk = (String) subResults.get(Keys.LY29_LOCATION_VOYAGE_Field);
      BOL                  = (String) subResults.get(Keys.LY29_BASIS_OF_LIMIT_Field);
      polCertPeriodFrom    = (String) subResults.get(Keys.LY29_POL_CERT_FROM_Field);
      polCertPeriodTo      = (String) subResults.get(Keys.LY29_POL_CERT_TO_Field);
      polCertQual          = (String) subResults.get(Keys.LY29_POL_CERT_QUAL_Field);
      polCertNarrative     = (String) subResults.get(Keys.LY29_POL_PERIOD_NARR_Field);
      coverLineSlipFrom    = (String) subResults.get(Keys.LY29_COVER_LS_FROM_Field);
      coverLineSlipTo      = (String) subResults.get(Keys.LY29_COVER_LS_TO_Field);
      coverLineSlipQual    = (String) subResults.get(Keys.LY29_COVER_LS_QUAL_Field);
      warInd               = checkBoxStatus((String) subResults.get(Keys.LY29_WAR_IND_Field));
      slipType             = (String)subResults.get(Keys.LY29_SLIP_TYPE_Field);
      umr                  = (String) subResults.get(Keys.LY29_UMR_Field);
      umrLIDS              = (String) subResults.get(Keys.LY29_UMR_LIDS_Field);
      //origBroker = (String) subResults.get(Keys.LY29_ORIG_BKR_Field);

      // Now save away the limit table details- these are stored in
      // 3 sets of separate fields as it makes it easier for the JSP
      // to extract them.
      Vector v2 = (Vector) subResults.get(Keys.LY29_LIMIT_TABLE_Table);
      for(int x=0; x<v2.size();x++){
        MappedRecord mp2 = (MappedRecord) v2.get(x);
        if (!(((String) mp2.get(Keys.LY29_LIMIT_CURR_Field)).equals(""))){
          switch(x){
            case 0:
              ccyOfLimits1 = (String) mp2.get(Keys.LY29_LIMIT_CURR_Field);
              limits1 = (String) mp2.get(Keys.LY29_SI_LIMIT_Field);
              excess1 = (String) mp2.get(Keys.LY29_EXCESS_LIMIT_Field);
              break;
            case 1:
              ccyOfLimits2 = (String) mp2.get(Keys.LY29_LIMIT_CURR_Field);
              limits2 = (String) mp2.get(Keys.LY29_SI_LIMIT_Field);
              excess2 =(String) mp2.get(Keys.LY29_EXCESS_LIMIT_Field);
              break;
            case 2:
              ccyOfLimits3 = (String) mp2.get(Keys.LY29_LIMIT_CURR_Field);
              limits3 = (String) mp2.get(Keys.LY29_SI_LIMIT_Field);
              excess3 = (String) mp2.get(Keys.LY29_EXCESS_LIMIT_Field);
              break;
          }
        }
      }
      // NOTE:
      // now parse the errors into a mapped record- not too sure at this stage what
      // is going to occur to them- so this processing will be left out for the time being.

    } else if (event instanceof LY30Event) {
      MappedRecord subResults = (MappedRecord) ((Vector) results.get(Keys.LY30_FIELD_VALUES)).get(0);

      xcr = (String) subResults.get(Keys.LY30_XCR);
      ucr = (String) subResults.get(Keys.LY30_UCR);
      tr = (String) subResults.get(Keys.LY30_TR);
      osnd1 = (String) subResults.get(Keys.LY30_ORIG_REF_1);
      osnd2 = (String) subResults.get(Keys.LY30_ORIG_REF_2);
      osnd3 = (String) subResults.get(Keys.LY30_ORIG_REF_3);
      peerReview = (String) subResults.get(Keys.LY30_PEER_REV_IND);
      currentBroker = (String) subResults.get(Keys.LY30_CURRENT_BKR);
      riskCode = (String) subResults.get(Keys.LY30_RISK_CODE);
      // CCN# N0030 - BA - 06/01/2002
      marketCode = (String) subResults.get(Keys.LY30_MARKET_CODE);
      yoa = (String) subResults.get(Keys.LY30_YEAR_OF_ACC);
      interest = (String) subResults.get(Keys.LY30_INTEREST);

      sumInsuredNarrative1 = (String) subResults.get(Keys.LY30_SI_NARR_1);

      /*  CCN: N0047
      Changed on: 11/12/02 (DH)
      sumInsuredNarrative2 = (String) subResults.get(Keys.LY30_SI_NARR_2_Field);
      */

      slipOrder1 = (String) subResults.get(Keys.LY30_SLIP_ORDER_1);
      slipOrder2 = (String) subResults.get(Keys.LY30_SLIP_ORDER_2);
      perilsCondition = (String) subResults.get(Keys.LY30_PERILS_CONDS);
      locationVoyageOfRisk = (String) subResults.get(Keys.LY30_LOCATION_VOYAGE);
      BOL = (String) subResults.get(Keys.LY30_BASIS_OF_LIMIT);
      polCertPeriodFrom = (String) subResults.get(Keys.LY30_POL_CERT_FROM);
      polCertPeriodTo = (String) subResults.get(Keys.LY30_POL_CERT_TO);
      polCertQual = (String) subResults.get(Keys.LY30_POL_CERT_QUAL);
      polCertNarrative = (String) subResults.get(Keys.LY30_POL_PERIOD_NARR);
      coverLineSlipFrom = (String) subResults.get(Keys.LY30_COVER_LS_FROM);
      coverLineSlipTo = (String) subResults.get(Keys.LY30_COVER_LS_TO);
      coverLineSlipQual = (String) subResults.get(Keys.LY30_COVER_LS_QUAL);
      warInd = checkBoxStatus((String) subResults.get(Keys.LY30_WAR_IND));
      slipType = (String)subResults.get(Keys.LY30_SLIP_TYPE);
      // CCN# N0039 - BA - 06/01/2002
      umr = (String) subResults.get(Keys.LY30_UMR_Field);

      // Now save away the limit table details- these are stored in
      // 3 sets of separate fields as it makes it easier for the JSP
      // to extract them.
      // Initialise them all to true (or protected) first as the vector may not
     //  be of size three. And we would want to blank out existing results.
      ccyOfLimits1 = "";
      limits1= "";
      excess1 = "";
      ccyOfLimits2 = "";
      limits2= "";
      excess2 = "";
      ccyOfLimits3 = "";
      limits3= "";
      excess3 = "";
      Vector v1 = (Vector) subResults.get(Keys.LY30_LIMIT_TABLE);
      for(int x=0; x<v1.size();x++){
        MappedRecord mp1 = (MappedRecord) v1.get(x);
        // if the ccy field is blank then we do not want to throw the damn thing out to the
        // string.
        if (!(((String) mp1.get(Keys.LY30_LIMIT_CURR)).equals(""))){
          switch(x){
            case 0:
              ccyOfLimits1 = (String) mp1.get(Keys.LY30_LIMIT_CURR);
              limits1 = (String) mp1.get(Keys.LY30_SI_LIMIT);
              excess1 = (String) mp1.get(Keys.LY30_EXCESS_LIMIT);
              break;
            case 1:
              ccyOfLimits2 = (String) mp1.get(Keys.LY30_LIMIT_CURR);
              limits2 = (String) mp1.get(Keys.LY30_SI_LIMIT);
              excess2 = (String) mp1.get(Keys.LY30_EXCESS_LIMIT);
              break;
            case 2:
              ccyOfLimits3 = (String) mp1.get(Keys.LY30_LIMIT_CURR);
              limits3 = (String) mp1.get(Keys.LY30_SI_LIMIT);
              excess3 = (String) mp1.get(Keys.LY30_EXCESS_LIMIT);
              break;
          }
        }
      }
    }
  }

  public String getUcr(){
    return ucr;
  }

  public String getXcr(){
    return xcr;
  }

  public String getTr(){
    return tr;
  }

  public String getOsnd1(){
    return osnd1;
  }

  public String getOsnd2(){
    return osnd2;
  }

  public String getOsnd3(){
    return osnd3;
  }

  public String getPeerReview(){
    return htmlSafe(peerReview);
  }

  public String getCurrentBroker(){
    return currentBroker;
  }

  public String getRiskCode(){
    return riskCode;
  }

  // CCN# N0030 - BA - 06/01/2002
  public String getMarketCode(){
    return marketCode;
  }

  public String getYoa(){
    return yoa;
  }

  public String getInterest(){
    return htmlSafe(interest);
  }

  public String getPerilsCondition(){
    return htmlSafe(perilsCondition);
  }

  public String getLocationVoyageOfRisk(){
    return htmlSafe(locationVoyageOfRisk);
  }

  public String getSlipOrder1(){
    return slipOrder1;
  }

  public String getSlipOrder2(){
    return slipOrder2;
  }


  public String getLimits1(){
    return limits1;
  }

  public String getLimits2(){
    return limits2;
  }

  public String getLimits3(){
    return limits3;
  }

  public String getExcess1(){
    return excess1;
  }

  public String getExcess2(){
    return excess2;
  }

  public String getExcess3(){
    return excess3;
  }

  public String getBOL(){
    return BOL;
  }

  public String getPolCertPeriodFrom(){
    return polCertPeriodFrom;
  }

  public String getPolCertPeriodTo(){
    return polCertPeriodTo;
  }

  public String getPolCertQual(){
    return polCertQual;
  }

  public String getCoverLineSlipFrom(){
    return coverLineSlipFrom;
  }

  public String getCoverLineSlipTo(){
    return coverLineSlipTo;
  }

  public String getCoverLineSlipQual(){
    return coverLineSlipQual;
  }

  public String getWarInd(){
    return warInd;
  }

  public String getUmr(){
    return umr;
  }

  public String getUmrLIDS(){
    return umrLIDS;
  }

  public String getSumInsuredNarrative1() {
    return sumInsuredNarrative1;
  }

  public String getSumInsuredNarrative2() {
    return sumInsuredNarrative2;
  }

  public String getPolCertNarrative() {
    return htmlSafe(polCertNarrative);
  }




  public String getUmrFlag() {
    return umrFlag;
 }

  public String getSumInsuredNarrative1Flag(){
    return sumInsuredNarrative1Flag;
  }

  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }
  public String getCcyOfLimits1() {
    return ccyOfLimits1;
  }

  public String getCcyOfLimits2() {
    return ccyOfLimits2;
  }

  public String getCcyOfLimits3() {
    return ccyOfLimits3;
  }


  public String getScreenMode() {
    return screenMode;
  }
  public boolean getBOLFlag() {
    return BOLFlag;
  }
  public boolean getCcyOfLimitsFlag() {
    return ccyOfLimitsFlag;
  }
  public boolean getCoverLineSlipFromFlag() {
    return coverLineSlipFromFlag;
  }
  public boolean getCoverLineSlipQualFlag() {
    return coverLineSlipQualFlag;
  }
  public boolean getCoverLineSlipToFlag() {
    return coverLineSlipToFlag;
  }
  public String getExcessFlag() {
    return excessFlag;
  }
  public String getInterestFlag() {
    return interestFlag;
  }
  public String getLimitsFlag() {
    return limitsFlag;
  }
  public String getLocationVoyageOfRiskFlag() {
    return locationVoyageOfRiskFlag;
  }
  public boolean getCurrentBrokerFlag() {
    return currentBrokerFlag;
  }
  public boolean getOrigBrokerFlag() {
            return origBrokerFlag;
          }
  public String getOrigRef1Flag() {
    return origRef1Flag;
  }
  public String getOrigRef2Flag() {
    return origRef2Flag;
  }
  public String getOrigRef3Flag() {
    return origRef3Flag;
  }
  public boolean getPeerReviewFlag() {
    return peerReviewFlag;
  }
  public String getPerilsConditionFlag() {
    return perilsConditionFlag;
  }
  public String getPolCertNarrativeFlag() {
    return polCertNarrativeFlag;
  }
  public boolean getPolCertPeriodFromFlag() {
    return polCertPeriodFromFlag;
  }
  public boolean getPolCertPeriodToFlag() {
    return polCertPeriodToFlag;
  }
  public boolean getPolCertQualFlag() {
    return polCertQualFlag;
  }
  public String getRiskCodeFlag() {
    return riskCodeFlag;
  }
  // CCN# N0030 - BA - 06/01/2002
  public boolean getMktCodeFlag() {
    return mktCodeFlag;
  }
  public String getSlipOrder1Flag() {
    return slipOrder1Flag;
  }
  public String getSlipOrder2Flag() {
    return slipOrder2Flag;
  }
  public String getTrFlag() {
    return trFlag;
  }
  public String getUcrFlag() {
    return ucrFlag;
  }
  public String getWarIndFlag() {
    return warIndFlag;
  }
  public String getXcrFlag() {
    return xcrFlag;
  }
  public String getYoaFlag() {
    return yoaFlag;
  }

  // For the moment this will always return false
  // Meaning there are no errors coming out of it.
  public boolean geterrorsInModel() {
    return errorsInModel;
  }

public String getOrigBroker() {
        return origBroker;
}

public String getSlipType() {
        return slipType;
}

public boolean getSlipTypeFlag() {
        return slipTypeFlag;
}



}

/*
$Log: PolicyRiskDetailsModel.java,v $
Revision 1.5  2004/03/15 17:16:41  coganp
Added logger debug staments


*/