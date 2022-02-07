package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY25Event;
import com.xchanging.xcc.events.LY94Event;
import com.xchanging.xcc.refdata.RefDataHandler;
import com.xchanging.xcc.refdata.TableRow;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;
import com.xchanging.xcc.web.models.reference.GUIErrorList;

public class ClaimTransactionCreationModel extends WebModel implements ModelUpdateListener{

  private String[] osnd = new String[3];
  private String[] apsnd = new String[3];
  private String[] currency = new String[3];

  private boolean[] osndFlag = new boolean[3];
  private boolean[] apsndFlag = new boolean[3];
  private boolean[] currencyFlag = new boolean[3];

  private String screenMode;

  private String ucr = "";
  private String xcr = "";
  private String tr = "";
  private String transactionSynopsis = "";
  private boolean transactionSynopsisFlag;
  private String settAdv = "";
  private boolean settAdvFlag;
  private boolean presDateFlag;
  private String presDate = "";
  private String bulkInd = "";
  private String bulkIndFlag = "";
  private String treaty = "";
  private String treatyFlag = "";
  private String simRI = "";
  private String simRIFlag = "";
  private String nonScmAdvised = "";
  private String nonScmAdvisedFlag = "";
  private String ecfClaim = "";
  private String ecfClaimFlag = "";
  private String riskUnsigned = "";
  private String riskUnsignedFlag = "";
  private String prevAdvNonNet = "";
  private String prevAdvNonNetFlag = "";
  private String lossReserve = "";
  private String lossReserveFlag = "";
  private String loc = "";
  private String locFlag = "";

  // CCN# N0058 - 09/01/2003 - BA
  private String locDrawingInd ;
  private String locDrawingIndFlag ;

  // CCN# ?????? - 03/12/2003 - S.Caine
  private String SpecPymtInd ;
  private String SpecPymtIndFlag ;

  private String lossFund = "";
  private String lossFundFlag = "";
  private String prevPaidInd = "";
  private String prevPaidIndFlag = "";
  private String ecfClass = "";
  private boolean ecfClassFlag;
  //TP871424- Changes for Quality Validation
  private String payByCheque = "";
  private boolean payByChequeFlag;
  private String payByCheque_ATTR;
  private String nonChargeableInd = "";
  private String nonChargeableIndFlag = "";
  private String chargeType = "";
  private boolean chargeTypeFlag;

  private String riskCode = "";
  private String yearOfAcc = "";
  private String umr = "";
  private String slipOrder1 = "";
  private String slipOrder2 = "";
  private String slipType = "";
  private String lineSlipCh = "";
  private String insured = "";
  private String reinsured = "";
  private String vesselAircraft = "";
  private String interest = "";
  private String siLimit = "";
  private String excessLimit = "";
  private String siCurr = "";
  private String perilsConds = "";
  private String policyPeriodFrom = "";
  private String policyPeriodTo = "";
  private String valueCount = "";
  private boolean saveButtonFlag;
  private boolean bringFwdBtnFlag;
  private boolean deleteBDownBtnFlag;

  // These hold the original values- as the values thrown out to checkboxes will
  // be converted into CHECKED or just blank.
  private String NV_nonScmAdvised  = "";
  private String NV_bulkInd  = "";
  private String NV_treaty  = "";
  private String NV_ecfClaim = "";
  private String NV_ecfClass = "";
  private String NV_payByCheque  = "";
  private String NV_lossReserve = "";
  private String NV_prevPaidInd = "";
  private String NV_loc    = "";

  // CCN# N0058 - 09/01/2003 - BA
  private String NV_locDrawingInd = "" ;

  // CCN# ????? - 03/12/2003 - S.Caine
  private String NV_SpecPymtInd = "" ;

  // CCN 21 devo 15/01/2003- all 9 fields
  private String NV_SchemeCanInd = "" ;
  private String SchemeCanInd = "";
  private String SchemeCanIndFlag = "" ;
  private String NV_CPAInd = "" ;
  private String CPAInd = "";
  private String CPAIndFlag = "" ;
  private String NV_DirLStockInd = "" ;
  private String DirLStockInd = "";
  private String DirLStockIndFlag = "" ;




  private String NV_nonChargeableInd = "";
  private String NV_lossFund  = "";
  private String NV_riskUnsigned  = "";
  private String NV_prevAdvNonNet  = "";
  private String NV_simRI    = "";

/*  private String nonScmAdvisedValue;
  private String bulkIndValue;
  private String treatyValue;
  private String payByChequeValue;
  private String lossReserveValue;
  private String prevPaidIndValue;
  private String locValue;
  private String nonChargeableIndValue;
  private String lossFundValue;
  private String riskUnsignedValue;
  private String prevAdvNonNetValue;*/
  // private String simRIValue;

  // CCN 52 - Devo
  private String peerRevInd;

  private String[] osndErr = new String[3];
  private String[] apsndErr = new String[3];
  private String[] currencyErr = new String[3];
  private String settAdvIndErr = "";
//  private String nonScmAdvErr = "";
//  private String bulkIndErr = "";
//  private String unsignedRiskErr = "";
//  private String treatyIndErr = "";
//  private String simRiIndErr = "";
//  private String lossReserveIndErr = "";
//  private String locIndErr = "";
//  private String lossFundIndErr = "";
//  private String chequePymtErr = "";
  private String chargeTypeErr = "";
//  private String nonChargeIndErr = "";
//  private String prevAdvNoNetErr = "";
//  private String prevPaidIndErr = "";
//  private String locDrawingErr = "";
//  private String schemeCanErr = "";
//  private String cpaIndErr = "";
//  private String dirLstockErr = "";
  private String presDateErr = "";

  private int errorCount;

  public static GUIErrorList errorList = new GUIErrorList();
  static {
    RefDataHandler refData = new RefDataHandler();

    errorList = new GUIErrorList();

    Vector results = refData.readTable(Keys.GUIErrorTable);

    for (int i=0; i<results.size(); i++) {
      errorList.createGUIError(((TableRow)results.get(i)).getColumn(0),((TableRow)results.get(i)).getColumn(1));
    }
  }

  private ModelManager mm;

  public ClaimTransactionCreationModel(ModelManager mm)
  {
    this.mm = mm;
    mm.addListener(Keys.ClaimTransCreationModelKey, this);
  }

  public String[] getCurrencies() {
    return currency;
  }

  public String[] getOsnd() {
    return osnd;
  }

  public String[] getApsnd() {
    return apsnd;
  }


  public void updateValues(
      String riskCode,
      String yearOfAcc,
      String umr,
      String slipOrder1,
      String slipOrder2,
      String slipType,
      String lineSlipCh,
      String insured,
      String reinsured,
      String vesselAircraft,
      String interest,
      String siLimit,
      String excessLimit,
      String siCurr,
      String perilsConds,
      String policyPeriodFrom,
      String policyPeriodTo,
      String valueCount) {

    this.riskCode = riskCode;
    this.yearOfAcc = yearOfAcc;
    this.umr = umr;
    this.slipOrder1 = slipOrder1;
    this.slipOrder2 = slipOrder2;
    this.slipType = slipType;
    this.lineSlipCh = lineSlipCh;
    this.insured = insured;
    this.reinsured = reinsured;
    this.vesselAircraft = vesselAircraft;
    this.interest = interest;
    this.siLimit = siLimit;
    this.excessLimit = excessLimit;
    this.siCurr = siCurr;
    this.perilsConds = perilsConds;
    this.policyPeriodFrom = policyPeriodFrom;
    this.policyPeriodTo = policyPeriodTo;
    this.valueCount = valueCount;
  }

  public void performUpdate()
  {
    // Reset error indicators
    for (int x = 0; x < osndErr.length; x++) {
      osndErr[x] = "";
    }
    for (int x = 0; x < apsndErr.length; x++) {
      apsndErr[x] = "";
    }
    for (int x = 0; x < currencyErr.length; x++) {
      currencyErr[x] = "";
    }
    settAdvIndErr      = "";
//        nonScmAdvErr       = "";
//        bulkIndErr         = "";
//        unsignedRiskErr    = "";
//        treatyIndErr       = "";
//        simRiIndErr        = "";
//        lossReserveIndErr  = "";
//        locIndErr          = "";
//        lossFundIndErr     = "";
//        chequePymtErr      = "";
    chargeTypeErr      = "";
//        nonChargeIndErr    = "";
//        prevAdvNoNetErr    = "";
//        prevPaidIndErr     = "";
//        locDrawingErr      = "";
//        schemeCanErr       = "";
//        cpaIndErr          = "";
//        dirLstockErr       = "";
    presDateErr        = "";
    ModelManager mm = (ModelManager)session.getAttribute(Keys.ModelManagerKey);

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    /**
     * Process the data after the CTC Screen is built
     */
    if (event instanceof LY13Event) {

      Vector fieldValues = (Vector)(results).get(Keys.LY13FieldValuesList);
      screenMode = (String)results.get("@C013_SCREEN_MODE");

      if (screenMode.equals("E"))
          {saveButtonFlag = true;}
      else {saveButtonFlag = false;}

      mm.getUserWebModel().setUpdateMode(screenMode);
      MappedRecord fieldRecords = (MappedRecord)fieldValues.get(0);

      xcr = (String)fieldRecords.get(Keys.LY13XCRField);
      ucr = (String)fieldRecords.get(Keys.LY13UCRField);
      tr  = (String)fieldRecords.get(Keys.LY13TRField);
      //origBkr = (String)fieldRecords.get(Keys.LY13ORIG_BKRField);
      peerRevInd = (String)fieldRecords.get(Keys.LY13PEER_REV_INDField);

      /**
       * Set the check boxes
       */
      nonScmAdvised    = checkBoxStatus((String)fieldRecords.get(Keys.LY13NON_SCM_ADVField));
      bulkInd          = checkBoxStatus((String)fieldRecords.get(Keys.LY13BULK_INDField));
      treaty           = checkBoxStatus((String)fieldRecords.get(Keys.LY13TREATY_INDField));
      ecfClaim         = checkBoxStatus((String)fieldRecords.get(Keys.LY13ECF_CLAIM_INDField));
      ecfClass         = (String)fieldRecords.get(Keys.LY13ECF_CLASSField); 
      payByCheque      = (String)fieldRecords.get(Keys.LY13CHEQUE_PYMTField);
      lossReserve      = checkBoxStatus((String)fieldRecords.get(Keys.LY13LOSS_RESERVE_INDField));
      prevPaidInd      = checkBoxStatus((String)fieldRecords.get(Keys.LY13PREV_PAID_INDField));
      loc              = checkBoxStatus((String)fieldRecords.get(Keys.LY13LOC_INDField));

      // CCN# N0058 - 09/01/2003 - BA
      locDrawingInd    = checkBoxStatus((String)fieldRecords.get(Keys.LY13LOC_DRAWING_INDField));

      // CCN# ????? - 03/12/2003 - S.Caine
      SpecPymtInd    = checkBoxStatus((String)fieldRecords.get(Keys.LY13SPECIAL_PYMT_INDField));

      // CCN 21 - 15/01/2003 - devo
      SchemeCanInd    = checkBoxStatus((String)fieldRecords.get(Keys.LY13SCHEME_CAN_INDField));
      CPAInd          = checkBoxStatus((String)fieldRecords.get(Keys.LY13CPA_INDField));
      DirLStockInd    = checkBoxStatus((String)fieldRecords.get(Keys.LY13DIR_LSTOCK_INDField));



      nonChargeableInd = checkBoxStatus((String)fieldRecords.get(Keys.LY13NON_CHARGE_INDField));
      lossFund         = checkBoxStatus((String)fieldRecords.get(Keys.LY13LOSS_FUND_INDField));
      riskUnsigned     = checkBoxStatus((String)fieldRecords.get(Keys.LY13UNSIGNED_RISKField));
      prevAdvNonNet    = checkBoxStatus((String)fieldRecords.get(Keys.LY13PREV_ADV_NO_NETField));
      simRI            = checkBoxStatus((String)fieldRecords.get(Keys.LY13SIM_RI_INDField));

      NV_nonScmAdvised    = (String)fieldRecords.get(Keys.LY13NON_SCM_ADVField);
      NV_bulkInd          = (String)fieldRecords.get(Keys.LY13BULK_INDField);
      NV_treaty           = (String)fieldRecords.get(Keys.LY13TREATY_INDField);
      NV_ecfClaim         = (String)fieldRecords.get(Keys.LY13ECF_CLAIM_INDField);
      NV_ecfClass         = (String)fieldRecords.get(Keys.LY13ECF_CLASSField);
      NV_payByCheque      = (String)fieldRecords.get(Keys.LY13CHEQUE_PYMTField);
      NV_lossReserve      = (String)fieldRecords.get(Keys.LY13LOSS_RESERVE_INDField);
      NV_prevPaidInd      = (String)fieldRecords.get(Keys.LY13PREV_PAID_INDField);
      NV_loc              = (String)fieldRecords.get(Keys.LY13LOC_INDField);

      // CCN# N0058 - 09/01/2003 - BA
      NV_locDrawingInd    = (String)fieldRecords.get(Keys.LY13LOC_DRAWING_INDField);

      // CCN# ????? - 03/12/2003 - S.Caine
      NV_SpecPymtInd      = (String)fieldRecords.get(Keys.LY13SPECIAL_PYMT_INDField);

      // CCN# N0021 - 15/01/2003 - devo
      NV_SchemeCanInd    = (String)fieldRecords.get(Keys.LY13SCHEME_CAN_INDField);
      NV_CPAInd          = (String)fieldRecords.get(Keys.LY13CPA_INDField);
      NV_DirLStockInd    = (String)fieldRecords.get(Keys.LY13DIR_LSTOCK_INDField);


      NV_nonChargeableInd = (String)fieldRecords.get(Keys.LY13NON_CHARGE_INDField);
      NV_lossFund         = (String)fieldRecords.get(Keys.LY13LOSS_FUND_INDField);
      NV_riskUnsigned     = (String)fieldRecords.get(Keys.LY13UNSIGNED_RISKField);
      NV_prevAdvNonNet    = (String)fieldRecords.get(Keys.LY13PREV_ADV_NO_NETField);
      NV_simRI            = (String)fieldRecords.get(Keys.LY13SIM_RI_INDField);


      /**
       * Set the drop down lists
       */
      chargeType       = (String)fieldRecords.get(Keys.LY13CHARGE_TYPEField);
      settAdv          = (String)fieldRecords.get(Keys.LY13SETT_ADV_INDField);

      MappedRecord transSynopRec = (MappedRecord)((Vector)fieldRecords.get(Keys.LY13TRANS_SYNOPSISField)).get(0);
      Vector tsLines = (Vector)transSynopRec.get(Keys.LY13TRANS_SYSNOPSIS_LINE);
      transactionSynopsis = "";
      for (int i=0; i<tsLines.size(); i++) {
        if ((i>0) && (!((String)((MappedRecord)tsLines.get(i)).get(Keys.LY13SYNOPSIS_TEXT)).equals("")))
          transactionSynopsis += "\r\n";

        transactionSynopsis += (String)((MappedRecord)tsLines.get(i)).get(Keys.LY13SYNOPSIS_TEXT);
      }

      presDate            = (String)fieldRecords.get(Keys.LY13PRES_DATEField);

      /**
       * Change N0075
       *  - DB date of 1900-01-01 displayed as spaces
       */

      if (presDate.indexOf("1900-01-01") >= 0) {
        presDate = "";
      }

      /**
       * Set the currencies, osnd and apsnd values
       */
      Vector origRefTable = (Vector)fieldRecords.get(Keys.LY13OrigRefList);

      for (int x = 0; x < origRefTable.size(); x++) {
        MappedRecord record = (MappedRecord)origRefTable.get(x);
        osnd[x]     = (String)record.get(Keys.LY13ORIG_REFField);
        apsnd[x]    = (String)record.get(Keys.LY13AP_REFField);
        currency[x] = (String)record.get(Keys.LY13ORIG_CURRField);
      }

      /**
       * Set the enabled/disabled status of the screen elements
       */
      Vector fieldAttrs = (Vector)results.get(Keys.LY13FieldAttributesList);
      MappedRecord fieldAttrsRecords = (MappedRecord)fieldAttrs.get(0);

      /**
       * Set the enabled/disabled status of the drop down lists
       */
      settAdvFlag             = convertToBoolean((String)fieldAttrsRecords.get(Keys.LY13SETT_ADV_ATTRField));
      chargeTypeFlag          = convertToBoolean((String)fieldAttrsRecords.get(Keys.LY13CHARGE_TYPE_ATTRField));

      /**
       * Set the enabled/disabled status of the check boxes
       */
      nonScmAdvisedFlag       = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13NON_SCM_ADV_ATTRField));
      bulkIndFlag             = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13BULK_IND_ATTRField));
      riskUnsignedFlag        = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13UNSGN_RISK_ATTRField));
      treatyFlag              = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13TREATY_IND_ATTRField));
      ecfClaimFlag            = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13ECF_CLAIM_IND_ATTRField));
      ecfClassFlag            = convertToBoolean((String)fieldAttrsRecords.get(Keys.LY13ECF_CLASS_ATTRField));
      lossReserveFlag         = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13LOSS_RES_ATTRField));
      locFlag                 = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13LOC_IND_ATTRField));

      // CCN# N0058 - 09/01/2003 - BA
      locDrawingIndFlag       = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13LOC_DRAWING_IND_ATTRField));

      // CCN# ????? - 03/12/2003 - S.Caine
      SpecPymtIndFlag         = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13SPECIAL_PYMT_IND_ATTRField));

      // CCN# N0021 - 15/01/2003 - pd
      SchemeCanIndFlag       = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13SCHEME_CAN_ATTRField));
      CPAIndFlag             = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13CPA_IND_ATTRField));
      DirLStockIndFlag       = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13DIR_LSTOCK_INDATTRField));


      lossFundFlag            = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13LOSS_FUND_ATTRField));
      payByChequeFlag         = convertToBoolean((String)fieldAttrsRecords.get(Keys.LY13CHEQUE_PYMT_ATTRField));
            // TP871424- Changes for Quality Validation
      payByCheque_ATTR 		  = enabledStatusCheckbox((String) fieldAttrsRecords.get(Keys.LY13CHEQUE_PYMT_ATTRField));
      nonChargeableIndFlag    = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13NON_CHG_ATTRField));
      prevAdvNonNetFlag       = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13PREV_ADV_ATTRField));
      prevPaidIndFlag         = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13PREV_PAID_ATTRField));
      simRIFlag               = enabledStatusCheckbox((String)fieldAttrsRecords.get(Keys.LY13SIM_RI_IND_ATTRField));

      presDateFlag            = convertToBoolean((String)fieldAttrsRecords.get(Keys.LY13PRES_DATE_ATTRField));
      transactionSynopsisFlag = convertToBoolean((String)fieldAttrsRecords.get(Keys.LY13TRANS_SYN_ATTRField));

      /**
       * Set the enabled/disabled status of the currencies, osnd and apsnd fields
       */
      Vector origRefAttrTable = (Vector)fieldAttrsRecords.get(Keys.LY13OrigRefAttrList);
      for (int x = 0; x < origRefAttrTable.size(); x++) {
        MappedRecord record = (MappedRecord)origRefAttrTable.get(x);
        osndFlag[x]     = convertToBoolean((String)record.get(Keys.LY13ORIG_REF_ATTRField));
        apsndFlag[x]    = convertToBoolean((String)record.get(Keys.LY13AP_REF_ATTRField));
        currencyFlag[x] = convertToBoolean((String)record.get(Keys.LY13ORIG_CURR_ATTRField));
      }

      /**
       * Set the enabled/disabled status of the 'Bring Fwd' and 'Delete Breakdown'
       * buttons
       */
      Vector commAttrs = (Vector)results.get(Keys.LY13CommandAttrList);
      for (int x = 0; x < commAttrs.size(); x++) {
        MappedRecord record = (MappedRecord)commAttrs.get(x);
        bringFwdBtnFlag    = convertToBoolean((String)record.get(Keys.LY13BRING_FWD_ATTRField));
        deleteBDownBtnFlag = convertToBoolean((String)record.get(Keys.LY13DEL_BDOWN_ATTRField));
      }
    }


    /**
     * Process the data after the CTC Screen has been validated
     */
    else if (event instanceof LY25Event) {

      /*
        Need to process the C025-ERROR-INDICATORS after the validation
        and highlight the GUI accordingly.  If there are no errors then
        update this model.
      */
      errorCount = 0;
      errorCount = errorsFound(results, "C025");

      Vector errorIndicators = (Vector)results.get(Keys.LY25ErrorIndicatorsList);
      MappedRecord errorIndRecords = (MappedRecord)errorIndicators.get(0);

      Vector origRefErrTable = (Vector)errorIndRecords.get(Keys.LY25OrigRefErrList);

      for (int x = 0; x < origRefErrTable.size(); x++) {
        MappedRecord record = (MappedRecord)origRefErrTable.get(x);
        osndErr[x]     = (String)record.get(Keys.LY25OrigRefErrField);
        apsndErr[x]    = (String)record.get(Keys.LY25ApRefErrField);
        currencyErr[x] = (String)record.get(Keys.LY25OrigCurrErrField);
      }

      settAdvIndErr      = (String)errorIndRecords.get(Keys.LY25SetAdvIndErrField);
//        nonScmAdvErr       = (String)errorIndRecords.get(Keys.LY25NonScmAdvErrField);
//        bulkIndErr         = (String)errorIndRecords.get(Keys.LY25BulkIndErrField);
//        unsignedRiskErr    = (String)errorIndRecords.get(Keys.LY25UnsignedRiskErrField);
//        treatyIndErr       = (String)errorIndRecords.get(Keys.LY25TreatyIndErrField);
//        simRiIndErr        = (String)errorIndRecords.get(Keys.LY25SimRiIndErrField);
//        lossReserveIndErr  = (String)errorIndRecords.get(Keys.LY25LossReserveIndErrField);
//        locIndErr          = (String)errorIndRecords.get(Keys.LY25LocIndErrField);
//        lossFundIndErr     = (String)errorIndRecords.get(Keys.LY25LossFundIndErrField);
//        chequePymtErr      = (String)errorIndRecords.get(Keys.LY25ChequePymtErrField);
      chargeTypeErr      = (String)errorIndRecords.get(Keys.LY25ChargeTypeErrField);
//        nonChargeIndErr    = (String)errorIndRecords.get(Keys.LY25NonChargeIndErrField);
//        prevAdvNoNetErr    = (String)errorIndRecords.get(Keys.LY25PrevAdvNoNetErrField);
//        prevPaidIndErr     = (String)errorIndRecords.get(Keys.LY25PrevPaidIndErrField);
//        locDrawingErr      = (String)errorIndRecords.get(Keys.LY25LocDrawingErrField);
//        schemeCanErr       = (String)errorIndRecords.get(Keys.LY25SchemeCanErrField);
//        cpaIndErr          = (String)errorIndRecords.get(Keys.LY25CpaIndErrField);
//        dirLstockErr       = (String)errorIndRecords.get(Keys.LY25DirLstockErrField);
      presDateErr        = (String)errorIndRecords.get(Keys.LY25PresDateErrField);

      Vector fieldValues = (Vector)results.get(Keys.LY25FieldValuesList);
      MappedRecord fieldRecords = (MappedRecord)fieldValues.get(0);

      settAdv          = (String)fieldRecords.get(Keys.LY25SettAdvIndField);
      chargeType       = (String)fieldRecords.get(Keys.LY25ChargeTypeField);
      presDate         = (String)fieldRecords.get(Keys.LY25PresDateField);

      nonScmAdvised    = checkBoxStatus ((String)fieldRecords.get(Keys.LY25NonScmAdvField));
      bulkInd          = checkBoxStatus ((String)fieldRecords.get(Keys.LY25BulkIndField));
      treaty           = checkBoxStatus ((String)fieldRecords.get(Keys.LY25TreatyIndField));
      ecfClaim         = checkBoxStatus ((String)fieldRecords.get(Keys.LY25EcfClaimIndField));
      ecfClass         = (String)fieldRecords.get(Keys.LY25EcfClassField);
      payByCheque      = (String)fieldRecords.get(Keys.LY25ChequePymtField);
      lossReserve      = checkBoxStatus ((String)fieldRecords.get(Keys.LY25LossReserveIndField));
      prevPaidInd      = checkBoxStatus ((String)fieldRecords.get(Keys.LY25PrevPaidIndField));
      loc              = checkBoxStatus ((String)fieldRecords.get(Keys.LY25LocIndField));

      // CCN# N0058 - 09/01/2003 - BA
      locDrawingInd    = checkBoxStatus((String)fieldRecords.get(Keys.LY25LOCDrawingIndField));

      // CCN# ????? - 03/12/2003 - S.Caine
      SpecPymtInd    = checkBoxStatus((String)fieldRecords.get(Keys.LY25SpecialPymtIndField));

      // CCN# N0021 - 15/01/2003 - pd
      SchemeCanInd       = checkBoxStatus((String)fieldRecords.get(Keys.LY25SchemeCanIndField));
      CPAInd             = checkBoxStatus((String)fieldRecords.get(Keys.LY25CPAIndField));
      DirLStockInd       = checkBoxStatus((String)fieldRecords.get(Keys.LY25DirLSTockIndField));
      NV_SchemeCanInd    = (String)fieldRecords.get(Keys.LY25SchemeCanIndField);
      NV_CPAInd          = (String)fieldRecords.get(Keys.LY25CPAIndField);
      NV_DirLStockInd    = (String)fieldRecords.get(Keys.LY25DirLSTockIndField);


      nonChargeableInd = checkBoxStatus ((String)fieldRecords.get(Keys.LY25NonChargeIndField));
      lossFund         = checkBoxStatus ((String)fieldRecords.get(Keys.LY25LossFundIndField));
      riskUnsigned     = checkBoxStatus ((String)fieldRecords.get(Keys.LY25UnsignedRiskField));
      prevAdvNonNet    = checkBoxStatus ((String)fieldRecords.get(Keys.LY25PrevAdvNoNetField));
      simRI            = checkBoxStatus((String)fieldRecords.get(Keys.LY25SimRIIndField));

      NV_nonScmAdvised    = (String)fieldRecords.get(Keys.LY25NonScmAdvField);
      NV_bulkInd          = (String)fieldRecords.get(Keys.LY25BulkIndField);
      NV_treaty           = (String)fieldRecords.get(Keys.LY25TreatyIndField);
      NV_ecfClaim         = (String)fieldRecords.get(Keys.LY25EcfClaimIndField);
      NV_ecfClass         = (String)fieldRecords.get(Keys.LY25EcfClassField);
      NV_payByCheque      = (String)fieldRecords.get(Keys.LY25ChequePymtField);
      NV_lossReserve      = (String)fieldRecords.get(Keys.LY25LossReserveIndField);
      NV_prevPaidInd      = (String)fieldRecords.get(Keys.LY25PrevPaidIndField);
      NV_loc              = (String)fieldRecords.get(Keys.LY25LocIndField);

      // CCN# N0058 - 09/01/2003 - BA
      NV_locDrawingInd    = (String)fieldRecords.get(Keys.LY25LOCDrawingIndField);

      // CCN# ????? - 03/12/2003 - S.Caine
      NV_SpecPymtInd    = (String)fieldRecords.get(Keys.LY25SpecialPymtIndField);

      NV_nonChargeableInd = (String)fieldRecords.get(Keys.LY25NonChargeIndField);
      NV_lossFund         = (String)fieldRecords.get(Keys.LY25LossFundIndField);
      NV_riskUnsigned     = (String)fieldRecords.get(Keys.LY25UnsignedRiskField);
      NV_prevAdvNonNet    = (String)fieldRecords.get(Keys.LY25PrevAdvNoNetField);
      NV_simRI            = (String)fieldRecords.get(Keys.LY25SimRIIndField);

      Vector origRefTable = (Vector)fieldRecords.get(Keys.LY25OrigRefList);

      for (int x = 0; x < origRefTable.size(); x++) {
        MappedRecord record = (MappedRecord)origRefTable.get(x);
        osnd[x]     = (String)record.get(Keys.LY25OrigRefField);
        apsnd[x]    = (String)record.get(Keys.LY25ApRefField);
        currency[x] = (String)record.get(Keys.LY25OrigCurrField);
      }
    } else if (event instanceof LY94Event) {

      settAdv           = ((LY94Event)(event)).getSettAdv();
      chargeType        = ((LY94Event)(event)).getChargeType();
      presDate          = ((LY94Event)(event)).getPresDate();
      nonScmAdvised     = checkBoxStatus (((LY94Event)(event)).getNonScmAdvised());
      bulkInd           = checkBoxStatus (((LY94Event)(event)).getBulkInd());
      treaty            = checkBoxStatus (((LY94Event)(event)).getTreaty());
      ecfClaim          = checkBoxStatus (((LY94Event)(event)).getEcfClaim());
      ecfClass           = ((LY94Event)(event)).getEcfClass();
          payByCheque       = ((LY94Event)(event)).getPayByCheque();
      lossReserve       = checkBoxStatus (((LY94Event)(event)).getLossReserve());
      prevPaidInd       = checkBoxStatus (((LY94Event)(event)).getPrevPaidInd());
      loc               = checkBoxStatus (((LY94Event)(event)).getLoc());
      locDrawingInd     = checkBoxStatus(((LY94Event)(event)).getLocDrawingInd());
      SchemeCanInd      = checkBoxStatus(((LY94Event)(event)).getSchemeCanInd());
      CPAInd            = checkBoxStatus(((LY94Event)(event)).getCpaInd());
      DirLStockInd      = checkBoxStatus(((LY94Event)(event)).getDirLStockInd());
      NV_SchemeCanInd   = ((LY94Event)(event)).getSchemeCanInd();
      NV_CPAInd         = ((LY94Event)(event)).getCpaInd();
      NV_DirLStockInd   = ((LY94Event)(event)).getDirLStockInd();
      nonChargeableInd = checkBoxStatus (((LY94Event)(event)).getNoChargeableInd());
      lossFund         = checkBoxStatus (((LY94Event)(event)).getLossFund());
      riskUnsigned     = checkBoxStatus (((LY94Event)(event)).getRiskUnsigned());
      prevAdvNonNet    = checkBoxStatus (((LY94Event)(event)).getPrevAdvNoNet());
      simRI            = checkBoxStatus(((LY94Event)(event)).getSimRi());
      NV_nonScmAdvised    = ((LY94Event)(event)).getNonScmAdvised();
      NV_bulkInd          = ((LY94Event)(event)).getBulkInd();
      NV_treaty           = ((LY94Event)(event)).getTreaty();
      NV_ecfClaim         = ((LY94Event)(event)).getEcfClaim();
     
      NV_ecfClass          = ((LY94Event)(event)).getEcfClass();
      NV_payByCheque      = ((LY94Event)(event)).getPayByCheque();
      NV_lossReserve      = ((LY94Event)(event)).getLossReserve();
      NV_prevPaidInd      = ((LY94Event)(event)).getPrevPaidInd();
      NV_loc              = ((LY94Event)(event)).getLoc();
      NV_locDrawingInd    = ((LY94Event)(event)).getLocDrawingInd();

      NV_nonChargeableInd = ((LY94Event)(event)).getNoChargeableInd();
      NV_lossFund         = ((LY94Event)(event)).getLossFund();
      NV_riskUnsigned     = ((LY94Event)(event)).getRiskUnsigned();
      NV_prevAdvNonNet    = ((LY94Event)(event)).getPrevAdvNoNet();
      NV_simRI            = ((LY94Event)(event)).getSimRi();

      osnd     = ((LY94Event)event).getOsnd();
      apsnd    = ((LY94Event)event).getApsnd();
      currency = ((LY94Event)event).getCurrencies();
    }
  }

  public String getRiskCode() {
    return riskCode;
  }

  public String getYearOfAcc() {
    return yearOfAcc;
  }

  public String getUmr() {
    return umr;
  }

  public String getSlipOrder1() {
    return slipOrder1;
  }

  public String getSlipOrder2() {
    return slipOrder2;
  }

  public String getSlipType() {
    return slipType;
  }

  public String getLineSlipCH() {
    return lineSlipCh;
  }

  public String getInsured() {
    return insured;
  }

  public String getReinsured() {
    return reinsured;
  }

  public String getVesselAircraft() {
    return vesselAircraft;
  }

  public String getInterest() {
    return interest;
  }

  public String getSiLimit() {
    return siLimit;
  }

  public String getExcessLimit() {
    return excessLimit;
  }

  public String getSiCurr() {
    return siCurr;
  }

  public String getPerilsConds() {
    return perilsConds;
  }

  public String getPolicyPeriodFrom() {
    return policyPeriodFrom;
  }

  public String getPolicyPeriodTo() {
    return policyPeriodTo;
  }

  public String getValueCount() {
    return valueCount;
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

  public String getHOsnd1() {
    return osnd[0];
  }

  public String getHOsnd2() {
    return osnd[1];
  }

  public String getHOsnd3() {
    return osnd[2];
  }

  public String getTransactionSynopsis() {
    return transactionSynopsis;
  }

  public boolean getTransactionSynopsisFlag() {
    return transactionSynopsisFlag;
  }

  public boolean getOsnd1Flag() {
    return osndFlag[0];
  }

  public String getOsnd1() {
    return osnd[0];
  }

  public boolean getApsnd1Flag() {
    return apsndFlag[0];
  }

  public String getApsnd1() {
    return apsnd[0];
  }

  public boolean getOsnd2Flag() {
    return osndFlag[1];
  }

  public String getOsnd2() {
    return osnd[1];
  }

  public boolean getApsnd2Flag() {
    return apsndFlag[1];
  }

  public String getApsnd2() {
    return apsnd[1];
  }

  public boolean getOsnd3Flag() {
    return osndFlag[2];
  }

  public String getOsnd3() {
    return osnd[2];
  }

  public boolean getApsnd3Flag() {
    return apsndFlag[2];
  }

  public String getApsnd3() {
    return apsnd[2];
  }

  public String getSettAdv() {
    return settAdv;
  }

  public boolean getSettAdvFlag() {
    return settAdvFlag;
  }

  public boolean getPresDateFlag() {
    return presDateFlag;
  }

  public String getPresDate() {
    return presDate;
  }

  public String getBulkInd() {
    return bulkInd;
  }

  public String getBulkIndFlag() {
    return bulkIndFlag;
  }

  public String getTreaty() {
    return treaty;
  }

  public String getTreatyFlag() {
    return treatyFlag;
  }
  
  public String getEcfClaim() {
    return ecfClaim;
  }

  public String getEcfClaimFlag() {
    return ecfClaimFlag;
  }

  public String getSimRI() {
    return simRI;
  }

  public String getSimRIFlag() {
    return simRIFlag;
  }

  public String getNonScmAdvised() {
    return nonScmAdvised;
  }

  public String getNonScmAdvisedFlag() {
    return nonScmAdvisedFlag;
  }

  public String getRiskUnsigned() {
    return riskUnsigned;
  }

  public String getRiskUnsignedFlag() {
    return riskUnsignedFlag;
  }

  public String getPrevAdvNonNet() {
    return prevAdvNonNet;
  }

  public String getPrevAdvNonNetFlag() {
    return prevAdvNonNetFlag;
  }

  public String getLossReserve() {
    return lossReserve;
  }

  public String getLossReserveFlag() {
    return lossReserveFlag;
  }

  public String getLoc() {
    return loc;
  }

  public String getLocFlag() {
    return locFlag;
  }

  // CCN# N0058 - 09/01/2003 - BA
  public String getLocDrawingInd() {
    return locDrawingInd ;
  }
  public String getLocDrawingIndFlag() {
    return locDrawingIndFlag ;
  }
  // CCN ??????? - 03/12/2003 - S.Caine
  public String getSpecPymtInd() {
    return SpecPymtInd ;
  }
  public String getSpecPymtIndFlag() {
    return SpecPymtIndFlag ;
  }


  public String getLossFund() {
    return lossFund;
  }

  public String getLossFundFlag() {
    return lossFundFlag;
  }

  public String getPrevPaidInd() {
    return prevPaidInd;
  }

  public String getPrevPaidIndFlag() {
    return prevPaidIndFlag;
  }

  public String getPayByCheque() {
    return payByCheque;
  }
//  TP871424- Changes for Quality Validation
  public String getPayByCheque_ATTR()
  {
      return payByCheque_ATTR;
  }
  public boolean getPayByChequeFlag() {
    return payByChequeFlag;
  }

  public String getNonChargeableInd() {
    return nonChargeableInd;
  }

  public String getNonChargeableIndFlag() {
    return nonChargeableIndFlag;
  }

  public String getChargeType() {
    return chargeType;
  }

  public boolean getChargeTypeFlag() {
    return chargeTypeFlag;
  }

  public String getCurr1() {
    return currency[0];
  }

  public String getCurr2() {
    return currency[1];
  }

  public String getCurr3() {
    return currency[2];
  }

  public boolean getCurr1Flag() {
    return currencyFlag[0];
  }

  public boolean getCurr2Flag() {
    return currencyFlag[1];
  }

  public boolean getCurr3Flag() {
    return currencyFlag[2];
  }

  public boolean getBringFwdBDButtonFlag() {
    return bringFwdBtnFlag;
  }

  public boolean getDeleteBDButtonFlag() {
    return deleteBDownBtnFlag;
  }

  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }
  public String getNV_bulkInd() {
    return NV_bulkInd;
  }
  public String getNV_loc() {
    return NV_loc;
  }

  // CCN# N0058 - 09/01/2003 - BA
  public String getNV_locDrawingInd() {
    return NV_locDrawingInd ;
  }

  // CCN# ????? - 03/12/2003 - S.Caine
  public String getNV_SpecPymtInd() {
    return NV_SpecPymtInd ;
  }

  public String getNV_lossFund() {
    return NV_lossFund;
  }
  public String getNV_lossReserve() {
    return NV_lossReserve;
  }
  public String getNV_nonChargeableInd() {
    return NV_nonChargeableInd;
  }
  public String getNV_nonScmAdvised() {
    return NV_nonScmAdvised;
  }
  public String getNV_payByCheque() {
    return NV_payByCheque;
  }
  public String getNV_prevAdvNonNet() {
    return NV_prevAdvNonNet;
  }
  public String getNV_prevPaidInd() {
    return NV_prevPaidInd;
  }
  public String getNV_riskUnsigned() {
    return NV_riskUnsigned;
  }
  public String getNV_SimRI() {
    return NV_simRI;
  }
  public String getNV_treaty() {
    return NV_treaty;
  }
  public String getNV_ecfClaim() {
    return NV_ecfClaim;
  }
  public String getScreenMode() {
    return screenMode;
  }
  public String getPeerRevInd() {
    return peerRevInd;
  }
  public String getCPAIndFlag() {
    return CPAIndFlag;
  }
  public String getCPAInd() {
    return CPAInd;
  }
  public String getNV_DirLStockInd() {
    return NV_DirLStockInd;
  }
  public String getNV_CPAInd() {
    return NV_CPAInd;
  }
  public String getNV_SchemeCanInd() {
    return NV_SchemeCanInd;
  }
  public String getSchemeCanInd() {
    return SchemeCanInd;
  }
  public String getSchemeCanIndFlag() {
    return SchemeCanIndFlag;
  }
  public String getDirLStockIndFlag() {
    return DirLStockIndFlag;
  }
  public String getDirLStockInd() {
    return DirLStockInd;
  }

  private int errorsFound(MappedRecord rec,String id) {
    String errorStr = (String)((MappedRecord)rec).get("@"+id+"_ERROR_COUNT");
    return Integer.parseInt(errorStr);
  }

  public boolean getOsnd1ErrFlg() {
    if (osndErr[0] != null) {
      if (osndErr[0].equals("Y")) {
        return(true);
      }
    }
    return(false);
  }

  public boolean getOsnd2ErrFlg() {
    if (osndErr[1] != null) {
      if (osndErr[1].equals("Y")) {
        return(true);
      }
    }
    return(false);
  }

  public boolean getOsnd3ErrFlg() {
    if (osndErr[2] != null) {
      if (osndErr[2].equals("Y")) {
        return(true);
      }
    }
    return(false);
  }

  public boolean getApsnd1ErrFlg() {
    if (apsndErr[0] != null) {
      if (apsndErr[0].equals("Y")) {
        return(true);
      }
    }
    return(false);
  }

  public boolean getApsnd2ErrFlg() {
    if (apsndErr[1] != null) {
      if (apsndErr[1].equals("Y")) {
        return(true);
      }
    }
    return(false);
  }

  public boolean getApsnd3ErrFlg() {
    if (apsndErr[2] != null) {
      if (apsndErr[2].equals("Y")) {
        return(true);
      }
    }
    return(false);
  }

  public String getCurr1Cls() {
    if (currencyErr[0] != null) {
      if (currencyErr[0].equals("Y")) {
        return("class='fieldError'");
      }
    }
    return("class='field'");
  }

  public String getCurr2Cls() {
    if (currencyErr[1] != null) {
      if (currencyErr[1].equals("Y")) {
        return("class='fieldError'");
      }
    }
    return("class='field'");
  }

  public String getCurr3Cls() {
    if (currencyErr[2] != null) {
      if (currencyErr[2].equals("Y")) {
        return("class='fieldError'");
      }
    }
    return("class='field'");
  }

  public String getSettAdvIndCls() {
    if (settAdvIndErr.equals("Y")) {
      return("class='fieldError'");
    } else {
      return("class='field'");
    }
  }

  public boolean getPresDateErrFlg() {
    if (presDateErr.equals("Y")) {
      return(true);
    } else {
      return(false);
    }
  }

  public String getChargeTypeCls() {
    if (chargeTypeErr.equals("Y")) {
      return("class='fieldError'");
    } else {
      return("class='field'");
    }
  }


public String getEcfClass()
{
    return ecfClass;
}


public boolean getEcfClassFlag()
{
    return ecfClassFlag;
}


public String getNV_ecfClass()
{
    return NV_ecfClass;
}

}
