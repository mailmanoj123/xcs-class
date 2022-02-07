package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY41Event;
import com.xchanging.xcc.events.LY42Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;


public class SingleClaimLossReservesModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String ucr = "";
  private String xcr = "";
  private String tr = "";
  private String osnd = "";
  private String origBkr = "";
  private String signed = "";
  private String peerReview = "";
  private String origCcy = "";
  private String cor = "";
  private String loc = "";
  private String mvmtRefDate = "";
  // Believe this is the lr_adj_date
  private String lrAdjustmentAt = "";
  private String interest = "";
  private String refundedLR = "";
  private String tax = "";
  private String paidClaim = "";
  private String net = "";
  private String lrAdvanced = "";
  private String OSAmount = "";
  private String OSQual = "";
  private String screenMode = "";

  // This is for the save button which will be disabled when the
  // screenMode is equal to 'E'
  private boolean saveButtonFlag;

  private boolean ucrFlag;
  private boolean xcrFlag;
  private boolean trFlag;
  private boolean osndFlag;
  private boolean origBkrFlag;
  private boolean signedFlag;
  private boolean peerReviewFlag;
  private boolean origCcyFlag;
  private boolean corFlag;
  private boolean locFlag;
  private boolean mvmtRefDateFlag;
  private boolean lrAdjustmentAtFlag;
  private String interestFlag;
  private String refundedLRFlag;
  private String taxFlag;
  private String paidClaimFlag;
  private String netFlag;
  private String lrAdvancedFlag;
  private String OSAmountFlag;
  private boolean OSQualFlag;

  private boolean newMovementFlag;

  // For the moment store the Errors in the extracted mapped record.
  private MappedRecord storeErrors;

  public SingleClaimLossReservesModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SingleClaimLossResModelKey, this);
  }

  public void performUpdate() {
    MappedRecord origResults = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY40Event) {
      screenMode = (String) origResults.get(Keys.LY40_SCREEN_MODE_Field);
      mm.getUserWebModel().setUpdateMode(screenMode);

      saveButtonFlag = screenMode.equals("E");

      // First strip out all the attributes- these tell us whether a field is read only or not
      MappedRecord results = (MappedRecord)((Vector)origResults.get(Keys.LY40_FIELD_ATTR_VALUES)).get(0);

      xcrFlag            = convertToBoolean((String) results.get(Keys.LY40_XCR_ATTR_Field));
      ucrFlag            = convertToBoolean((String) results.get(Keys.LY40_UCR_ATTR_Field));
      trFlag             = convertToBoolean((String) results.get(Keys.LY40_TR_ATTR_Field));
      osndFlag           = convertToBoolean((String) results.get(Keys.LY40_ORIG_REF_ATTR_Field));
      origBkrFlag        = convertToBoolean((String) results.get(Keys.LY40_ORIG_BKR_ATTR_Field));
      signedFlag         = convertToBoolean((String) results.get(Keys.LY40_SIGNED_IND_ATTR_Field));
      peerReviewFlag     = convertToBoolean((String) results.get(Keys.LY40_PEER_REV_IND_ATTR_Field));
      origCcyFlag        = convertToBoolean((String) results.get(Keys.LY40_ORIG_CURR_ATTR_Field));
      corFlag            = convertToBoolean((String) results.get(Keys.LY40_COR_ATTR_Field));
      locFlag            = convertToBoolean((String) results.get(Keys.LY40_LOC_IND_ATTR_Field));
      mvmtRefDateFlag    = convertToBoolean((String) results.get(Keys.LY40_MOVE_REF_ATTR_Field));
      lrAdjustmentAtFlag = convertToBoolean((String) results.get(Keys.LY40_LR_ADJ_DATE_ATTR_Field));
      refundedLRFlag     = enabledStatus((String) results.get(Keys.LY40_LR_REFUNDED_ATTR_Field));
      paidClaimFlag      = enabledStatus((String) results.get(Keys.LY40_LR_PAID_CLAIM_ATTR_Field));
      lrAdvancedFlag     = enabledStatus((String) results.get(Keys.LY40_LR_ADVANCED_ATTR_Field));
      interestFlag       = enabledStatus((String) results.get(Keys.LY40_LR_INTEREST_ATTR_Field));
      taxFlag            = enabledStatus((String) results.get(Keys.LY40_LR_TAX_ATTR_Field));
      netFlag            = enabledStatus((String) results.get(Keys.LY40_LR_NET_AMT_ATTR_Field));
      OSAmountFlag       = enabledStatus((String) results.get(Keys.LY40_LR_OUTST_AMT_ATTR_Field));
      OSQualFlag         = convertToBoolean((String) results.get(Keys.LY40_LR_OUTST_QUAL_ATTR_Field));

      // Now strip out the actual values.
      MappedRecord results2 = (MappedRecord)((Vector)origResults.get(Keys.LY40_FIELD_VALUES)).get(0);

      xcr            = (String) results2.get(Keys.LY40_XCR_Field);
      ucr            = (String) results2.get(Keys.LY40_UCR_Field);
      tr             = (String) results2.get(Keys.LY40_TR_Field);
      osnd           = (String) results2.get(Keys.LY40_ORIG_REF_Field);
      origBkr        = (String) results2.get(Keys.LY40_ORIG_BKR_Field);
      signed         = (String) results2.get(Keys.LY40_SIGNED_IND_Field);
      peerReview     = (String) results2.get(Keys.LY40_PEER_REV_IND_Field);
      origCcy        = (String) results2.get(Keys.LY40_ORIG_CURR_Field);
      cor            = (String) results2.get(Keys.LY40_COR_Field);
      loc            = (String) results2.get(Keys.LY40_LOC_IND_Field);
      mvmtRefDate    = (String) results2.get(Keys.LY40_MOVE_REF_Field);
      lrAdjustmentAt = (String) results2.get(Keys.LY40_LR_ADJ_DATE_Field);
      refundedLR     = (String) results2.get(Keys.LY40_LR_REFUNDED_Field);
      paidClaim      = (String) results2.get(Keys.LY40_LR_PAID_CLAIM_Field);
      lrAdvanced     = (String) results2.get(Keys.LY40_LR_ADVANCED_Field);
      interest       = (String) results2.get(Keys.LY40_LR_INTEREST_Field);
      tax            = (String) results2.get(Keys.LY40_LR_TAX_Field);
      net            = (String) results2.get(Keys.LY40_LR_NET_AMT_Field);
      OSAmount       = (String) results2.get(Keys.LY40_LR_OUTST_AMT_Field);
      OSQual         = (String) results2.get(Keys.LY40_LR_OUTST_QUAL_Field);

      Vector vCommandAttributes = (Vector)origResults.get(Keys.LY40_COMMAND_ATTRIBUTES);
      MappedRecord mrCommandAttributes = (MappedRecord)vCommandAttributes.get(0);

      newMovementFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY40_NEW_MOVE_ATTR)) ;
    }
    else if (event instanceof LY41Event) {
      // Extract out the values from this event.
      MappedRecord results3 = (MappedRecord)((Vector)origResults.get(Keys.LY41_FIELD_VALUES_OUTPUT)).get(0);

       xcr            = (String) results3.get(Keys.LY41_XCR_Field);
       ucr            = (String) results3.get(Keys.LY41_UCR_Field);
       tr             = (String) results3.get(Keys.LY41_TR_Field);
       osnd           = (String) results3.get(Keys.LY41_ORIG_REF_Field);
       origBkr        = (String) results3.get(Keys.LY41_ORIG_BKR_Field);
       signed         = (String) results3.get(Keys.LY41_SIGNED_IND_Field);
       peerReview     = (String) results3.get(Keys.LY41_PEER_REV_IND_Field);
       origCcy        = (String) results3.get(Keys.LY41_ORIG_CURR_Field);
       cor            = (String) results3.get(Keys.LY41_COR_Field);
       loc            = (String) results3.get(Keys.LY41_LOC_IND_Field);
       mvmtRefDate    = (String) results3.get(Keys.LY41_MOVE_REF_Field);
       lrAdjustmentAt = (String) results3.get(Keys.LY41_LR_ADJ_DATE_Field);
       refundedLR     = (String) results3.get(Keys.LY41_LR_REFUNDED_Field);
       paidClaim      = (String) results3.get(Keys.LY41_LR_PAID_CLAIM_Field);
       lrAdvanced     = (String) results3.get(Keys.LY41_LR_ADVANCED_Field);
       interest       = (String) results3.get(Keys.LY41_LR_INTEREST_Field);
       tax            = (String) results3.get(Keys.LY41_LR_TAX_Field);
       net            = (String) results3.get(Keys.LY41_LR_NET_AMT_Field);
       OSAmount       = (String) results3.get(Keys.LY41_LR_OUTST_AMT_Field);
       OSQual         = (String) results3.get(Keys.LY41_LR_OUTST_QUAL_Field);

       // now extract out the errors.
       // For the moment we will store the errors MappedRecord object.
      storeErrors = (MappedRecord)((Vector)origResults.get(Keys.LY41_FIELD_ERRORS)).get(0);

    }
    else if (event instanceof LY42Event){
      // Extract out the values from this event.
      MappedRecord results4 = (MappedRecord)((Vector)origResults.get(Keys.LY42_FIELD_VALUES)).get(0);

      xcr            = (String) results4.get(Keys.LY42_XCR);
      ucr            = (String) results4.get(Keys.LY42_UCR);
      tr             = (String) results4.get(Keys.LY42_TR);
      osnd           = (String) results4.get(Keys.LY42_ORIG_REF);
      origBkr        = (String) results4.get(Keys.LY42_ORIG_BKR);
      signed         = (String) results4.get(Keys.LY42_SIGNED_IND);
      peerReview     = (String) results4.get(Keys.LY42_PEER_REV_IND);
      origCcy        = (String) results4.get(Keys.LY42_ORIG_CURR);
      cor            = (String) results4.get(Keys.LY42_COR);
      loc            = (String) results4.get(Keys.LY42_LOC_IND);
      mvmtRefDate    = (String) results4.get(Keys.LY42_MOVE_REF);
      lrAdjustmentAt = (String) results4.get(Keys.LY42_LR_ADJ_DATE);
      refundedLR     = (String) results4.get(Keys.LY42_LR_REFUNDED);
      paidClaim      = (String) results4.get(Keys.LY42_LR_PAID_CLAIM);
      lrAdvanced     = (String) results4.get(Keys.LY42_LR_ADVANCED);
      interest       = (String) results4.get(Keys.LY42_LR_INTEREST);
      tax            = (String) results4.get(Keys.LY42_LR_TAX);
      net            = (String) results4.get(Keys.LY42_LR_NET_AMT);
      OSAmount       = (String) results4.get(Keys.LY42_LR_OUTST_AMT);
      OSQual         = (String) results4.get(Keys.LY42_LR_OUTST_QUAL);

    }

  }

  public String getUcr() {
    return ucr;
  }
  public void setUcr(String ucr) {
    this.ucr = ucr;
  }
  public String getXcr() {
    return xcr;
  }
  public String getTr() {
    return tr;
  }
  public String getOsnd() {
    return osnd;
  }
  public String getOrigBkr() {
    return origBkr;
  }
  public String getSigned() {
    return signed;
  }
  public String getOrigCcy() {
    return origCcy;
  }
  public String getCor() {
    return cor;
  }
  public String getLoc() {
    return loc;
  }
  public String getPeerReview() {
    return peerReview;
  }
  public String getMvmtRefDate() {
    return mvmtRefDate;
  }
  public String getLrAdjustmentAt() {
    return lrAdjustmentAt;
  }
  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }
  public boolean getLrAdjustmentAtFlag() {
    return lrAdjustmentAtFlag;
  }
  public String getInterest() {
    return interest;
  }
  public String getRefundedLR() {
    return refundedLR;
  }
  public String getTax() {
    return tax;
  }
  public String getPaidClaim() {
    return paidClaim;
  }
  public String getNet() {
    return net;
  }
  public String getLrAdvanced() {
    return lrAdvanced;
  }
  public String getOSAmount() {
    return removeDecimals(OSAmount);
  }
  public String getOSQual() {
    return OSQual;
  }
  public String getInterestFlag() {
    return interestFlag;
  }
  public String getRefundedLRFlag() {
    return refundedLRFlag;
  }
  public String getTaxFlag() {
    return taxFlag;
  }
  public String getPaidClaimFlag() {
    return paidClaimFlag;
  }
  public String getNetFlag() {
    return netFlag;
  }
  public String getLrAdvancedFlag() {
    return lrAdvancedFlag;
  }
  public String getOSAmountFlag() {
    return OSAmountFlag;
  }
  public boolean getOSQualFlag() {
    return OSQualFlag;
  }
  public String getScreenMode() {
    return screenMode;
  }
  public boolean isCorFlag() {
    return corFlag;
  }
  public boolean isLocFlag() {
    return locFlag;
  }
  public boolean isMvmtRefDateFlag() {
    return mvmtRefDateFlag;
  }
  public boolean isOrigBkrFlag() {
    return origBkrFlag;
  }
  public boolean isOrigCcyFlag() {
    return origCcyFlag;
  }
  public boolean isOsndFlag() {
    return osndFlag;
  }
  public boolean isPeerReviewFlag() {
    return peerReviewFlag;
  }
  public boolean isSignedFlag() {
    return signedFlag;
  }
  public boolean isTrFlag() {
    return trFlag;
  }
  public boolean isUcrFlag() {
    return ucrFlag;
  }
  public boolean isXcrFlag() {
    return xcrFlag;
  }
  public MappedRecord getStoreErrors() {
    return storeErrors;
  }
  public boolean getNewMovementFlag() {
    return newMovementFlag;
  }
}