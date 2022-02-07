package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.attunity.adapter.AttuMappedRecord;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LY57Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SubsequentAdviceScheduleModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String xcr = "" ;
  private String ucr = "" ;
  private String tr = "" ;
  private String origRef1 = "" ;
  private String origBkr = "" ;
  private String signedInd = "" ;
  private String peerRevInd = "" ;
  private String origCurr = "" ;

  private String ucrTrSysRef = "" ;
  private String currNo = "" ;
  private String sdnNo = "" ;

  private Vector breakdowns ;

  private String startBreakdownNumber ;
  private String endBreakdownNumber ;

  private boolean xcrFlag ;
  private boolean ucrFlag ;
  private boolean trFlag ;
  private boolean origRef1Flag ;
  private boolean origBkrFlag ;
  private boolean signedIndFlag ;
  private boolean peerRevIndFlag ;
  private boolean origCurrFlag ;

  private boolean deleteSelectedButtonFlag ;
  private boolean newBreakdownButtonFlag ;
  private boolean finishButtonFlag ;
  private boolean nextCcyFlag ;
  private boolean saveButtonFlag ;
  private boolean prevButtonFlag ;
  private boolean nextButtonFlag ;

  public SubsequentAdviceScheduleModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SubAdviceScheduleModelKey, this);
  }

  public String getxcr() {
    return xcr ;
  }
  public String getucr() {
    return ucr ;
  }
  public String gettr() {
    return tr ;
  }
  public String getorigRef1() {
    return origRef1 ;
  }
  public String getorigBkr() {
    return origBkr ;
  }
  public String getsignedInd() {
    return signedInd ;
  }
  public String getpeerRevInd() {
    return peerRevInd ;
  }
  public String getorigCurr() {
    return origCurr ;
  }


  public String getucrTrSysRef() {
    return ucrTrSysRef ;
  }
  public String getcurrNo() {
    return currNo ;
  }
  public String getsdnNo() {
    return sdnNo ;
  }


  public Enumeration getbreakdowns() {
    return breakdowns.elements();
  }

  public SubsAdviceSchedule getbreakdown(int i) {
    return (SubsAdviceSchedule)breakdowns.get(i);
  }


  public String getstartBreakdownNumber() {
    return startBreakdownNumber ;
  }
  public String getendBreakdownNumber() {
   return endBreakdownNumber ;
  }


  private boolean getxcrFlag() {
    return xcrFlag;
  }
  private boolean getucrFlag() {
    return ucrFlag;
  }
  private boolean gettrFlag() {
    return trFlag;
  }
  private boolean getorigRef1Flag() {
    return origRef1Flag;
  }
  private boolean getorigBkrFlag() {
    return origBkrFlag;
  }
  private boolean getsignedIndFlag() {
    return signedIndFlag;
  }
  private boolean getpeerRevIndFlag() {
    return peerRevIndFlag;
  }
  private boolean getorigCurrFlag() {
    return origCurrFlag;
  }


  public boolean getDeleteSelectedButtonFlag() {
    return deleteSelectedButtonFlag;
  }
  public boolean getNewBreakdownButtonFlag() {
    return newBreakdownButtonFlag;
  }
  public boolean getFinishButtonFlag() {
    return finishButtonFlag;
  }
  public boolean getNextCcyFlag() {
    return nextCcyFlag;
  }
  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }
  public boolean getPrevButtonFlag() {
    return prevButtonFlag;
  }
  public boolean getNextButtonFlag() {
    return nextButtonFlag;
  }


  public void performUpdate() {
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY56Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      // Field Values
      MappedRecord mrFieldValues = (MappedRecord)((Vector)results.get(Keys.LY56_FIELD_VALUES_Table)).get(0) ;
      xcr = (String)mrFieldValues.get(Keys.LY56_XCR_Field) ;
      ucr = (String)mrFieldValues.get(Keys.LY56_UCR_Field) ;
      tr = (String)mrFieldValues.get(Keys.LY56_TR_Field) ;
      origRef1 = (String)mrFieldValues.get(Keys.LY56_ORIG_REF_1_Field) ;
      origBkr = (String)mrFieldValues.get(Keys.LY56_ORIG_BKR_Field) ;
      signedInd = (String)mrFieldValues.get(Keys.LY56_SIGNED_IND_Field) ;
      peerRevInd = (String)mrFieldValues.get(Keys.LY56_PEER_REV_IND_Field) ;
      origCurr = (String)mrFieldValues.get(Keys.LY56_ORIG_CURR_Field) ;

      // Key Values
      MappedRecord mrKeyValues = (MappedRecord)((Vector)mrFieldValues.get(Keys.LY56_KEY_VALUES_Table)).get(0) ;
      ucrTrSysRef = (String)mrKeyValues.get(Keys.LY56_UCR_TR_SYS_REF_Field) ;
      currNo = (String)mrKeyValues.get(Keys.LY56_CURR_NO_Field) ;
      sdnNo = (String)mrKeyValues.get(Keys.LY56_SDN_NO_Field) ;

      // Breakdown Values
      Vector vctBreakDownTable = (Vector)mrFieldValues.get(Keys.LY56_BREAKDOWN_Table) ;
      if (vctBreakDownTable==null)
        vctBreakDownTable = new Vector(0);

      breakdowns = new Vector();
      for (int i=0; i < vctBreakDownTable.size(); i++) {
        SubsAdviceSchedule sas = new SubsAdviceSchedule((MappedRecord)vctBreakDownTable.get(i), event);
        if ((sas.getbreakdownNo()!=null) && (!sas.getbreakdownNo().trim().equals("0")))
          breakdowns.add(sas);
        else
          break;
      }

      // Get start and end breakdown numbers from the breakdown table
      SubsAdviceSchedule tempBreakdown = (SubsAdviceSchedule)breakdowns.get(0) ;
      if (tempBreakdown != null) {
        startBreakdownNumber = tempBreakdown.getbreakdownNo() ;
      }
      tempBreakdown = (SubsAdviceSchedule)breakdowns.get(breakdowns.size()-1) ;
      if (tempBreakdown != null) {
        endBreakdownNumber = tempBreakdown.getbreakdownNo() ;
      }

      // Field Attributes
      MappedRecord mrFieldAttributes = (MappedRecord)((Vector)results.get(Keys.LY56_FIELD_ATTRIBUTES_Table)).get(0) ;
      xcrFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_XCR_ATTR_Field)) ;
      ucrFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_UCR_ATTR_Field)) ;
      trFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_TR_ATTR_Field)) ;
      origRef1Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_ORIG_REF_1_ATTR_Field)) ;
      origBkrFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_ORIG_BKR_ATTR_Field)) ;
      signedIndFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_SIGN_IND_ATTR_Field)) ;
      peerRevIndFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_PEER_REV_ATTR_Field)) ;
      origCurrFlag = convertToBoolean((String)mrFieldAttributes.get(Keys.LY56_ORIG_CURR_ATTR_Field)) ;

      // Breakdown Attributes
      Vector vctBreakdownAttributeTable = (Vector)mrFieldAttributes.get(Keys.LY56_BREAKDOWN_ATTR_Table) ;
      for (int i=0; i < breakdowns.size(); i++) {
        ((SubsAdviceSchedule)breakdowns.get(i)).addAttributes((MappedRecord)vctBreakdownAttributeTable.get(i)) ;
      }

      // Command Attrributes
      MappedRecord mrCommandAttributes = (MappedRecord)((Vector)results.get(Keys.LY56_COMMAND_ATTRIBUTES_Table)).get(0) ;
      deleteSelectedButtonFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY56_DEL_BD_ATTR_Field)) ;
      newBreakdownButtonFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY56_NEW_BD_ATTR_Field)) ;
      finishButtonFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY56_FINISH_ATTR_Field)) ;
      nextCcyFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY56_NEXT_CURR_ATTR_Field)) ;
      prevButtonFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY56_PREV_ATTR_Field)) ;
      nextButtonFlag = convertToBoolean((String)mrCommandAttributes.get(Keys.LY56_NEXT_ATTR_Field)) ;

      String screenMode = ((String)results.get(Keys.LY56_SCREEN_MODE_Field)).toUpperCase();
      mm.getUserWebModel().setUpdateMode(screenMode);
      if (screenMode == "U") {
        saveButtonFlag = true ;
      } else if (screenMode == "E") {
        saveButtonFlag = false ;
      }

      // Breakdown Command Attributes
      Vector attributes = (Vector)mrCommandAttributes.get("#C056_DELETE_ATTR[]");
      for (int i=0; i < breakdowns.size(); i++) {
        ((SubsAdviceSchedule)breakdowns.get(i)).adddeleteAttribute((AttuMappedRecord)attributes.elementAt(i));
      }
    } else if (event instanceof LY57Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      // Field Values
      MappedRecord mrFieldValues = (MappedRecord)((Vector)results.get(Keys.LY57_FIELD_VALUES)).get(0) ;

      // Breakdown Values
      Vector vctBreakDownTable = (Vector)mrFieldValues.get(Keys.LY57_BREAKDOWN_TABLE) ;
      breakdowns = new Vector(vctBreakDownTable.size()) ;
      for (int i=0; i < vctBreakDownTable.size(); i++) {
        MappedRecord mrBreakdown = (MappedRecord)vctBreakDownTable.get(i) ;
        breakdowns.add(new SubsAdviceSchedule(mrBreakdown, event)) ;
      }

      // Breakdown Errors
      MappedRecord mrErrorInds = (MappedRecord)((Vector)results.get(Keys.LY57_ERROR_INDS)).get(0) ;
      Vector vctBreakDownErrs = (Vector)mrFieldValues.get(Keys.LY57_BREAKDOWN_Errs) ;

      /** @todo Error processing as yet undecided */
    }
  }

  public class SubsAdviceSchedule {
    private String cor = "" ;
    // deleteInd populated from LY57 only
    private boolean deleteInd ;
    private String statSplitNo = "" ;
    private String breakdownNo = "" ;
    private String mvmtRef = "" ;
    private String name1 = "" ;
    private String name1Qual = "" ;
    private String name2 = "" ;
    private String name2Qual = "" ;
    private String filCode = "" ;
    private String tfCode = "" ;
    private String stateCode = "" ;
    private String dolFrom = "";
    private String dolTo = "";
    private String dolQual = "" ;
    private String catCode = "" ;
    private String pcsCode = "" ;
    private String naicCode = "" ;
    private String naicQual = "" ;
    private String pttAmt = "";
    private String osAmt = "";
    private String osAmtTotQual = "";

    private boolean corFlag ;
    private boolean moveRefFlag ;
    private boolean name1Flag ;
    private boolean name1QualFlag ;
    private boolean name2Flag ;
    private boolean name2QualFlag ;
    private boolean filCodeFlag ;
    private boolean tfCodeFlag ;
    private boolean stateCodeFlag ;
    private boolean dolFlag ;
    private boolean catCodeFlag ;
    private boolean pcsCodeFlag ;
    private boolean naicCodeFlag ;
    private boolean naicQualFlag ;
    private boolean pttAmtFlag;
    private boolean osAmtFlag;
    private boolean osAmtTotQualFlag;
    private String delChkBoxFlag ;

    public SubsAdviceSchedule(MappedRecord mrData, ClaimsEvent event) {
      if (event instanceof LY56Event) {
        cor = (String)mrData.get(Keys.LY56_COR_Field) ;
        statSplitNo = (String)mrData.get(Keys.LY56_STAT_SPLIT_NO_Field) ;
        breakdownNo = (String)mrData.get(Keys.LY56_BREAKDOWN_NO_Field) ;
        mvmtRef = (String)mrData.get(Keys.LY56_MOVE_REF_Field)  ;
        name1 = (String)mrData.get(Keys.LY56_NAME_1_Field)  ;
        name1Qual = (String)mrData.get(Keys.LY56_NAME_1_QUAL_Field)  ;
        name2 = (String)mrData.get(Keys.LY56_NAME_2_Field)  ;
        name2Qual = (String)mrData.get(Keys.LY56_NAME_2_QUAL_Field)  ;
        filCode = (String)mrData.get(Keys.LY56_FIL_CODE_Field)  ;
        tfCode = (String)mrData.get(Keys.LY56_TF_CODE_Field)  ;
        stateCode = (String)mrData.get(Keys.LY56_STATE_CODE_Field)  ;
        dolFrom = (String)mrData.get(Keys.LY56_LOSS_DATE_FROM_Field) ;
        dolTo = (String)mrData.get(Keys.LY56_LOSS_DATE_TO_Field) ;
        dolQual = (String)mrData.get(Keys.LY56_LOSS_DATE_QUAL_Field)  ;
        catCode = (String)mrData.get(Keys.LY56_CAT_CODE_Field)  ;
        pcsCode = (String)mrData.get(Keys.LY56_PCS_CAT_CODE_Field)  ;
        naicCode = (String)mrData.get(Keys.LY56_NAIC_CODE_Field)  ;
        naicQual = (String)mrData.get(Keys.LY56_NAIC_QUAL_Field)  ;
        osAmt = (String)mrData.get(Keys.LY56_OUTST_AMT)  ;
        pttAmt = (String)mrData.get(Keys.LY56_PTT_AMT_TOTAL)  ;
        osAmtTotQual = (String)mrData.get(Keys.LY56_OUTST_AMT_TOT_QL)  ;
      } else if (event instanceof LY57Event) {
        cor = (String)mrData.get(Keys.LY57_COR) ;
        deleteInd = convertToBoolean((String)mrData.get(Keys.LY57_DELETE_IND)) ;
        statSplitNo = (String)mrData.get(Keys.LY57_STAT_SPLIT_NO) ;
        breakdownNo = (String)mrData.get(Keys.LY57_BREAKDOWN_NO) ;
        mvmtRef = (String)mrData.get(Keys.LY57_MOVE_REF)  ;
        name1 = (String)mrData.get(Keys.LY57_NAME_1)  ;
        name1Qual = (String)mrData.get(Keys.LY57_NAME_1_QUAL)  ;
        name2 = (String)mrData.get(Keys.LY57_NAME_2)  ;
        name2Qual = (String)mrData.get(Keys.LY57_NAME_2_QUAL)  ;
        filCode = (String)mrData.get(Keys.LY57_FIL_CODE)  ;
        tfCode = (String)mrData.get(Keys.LY57_TF_CODE)  ;
        stateCode = (String)mrData.get(Keys.LY57_STATE_CODE)  ;
        dolFrom = (String)mrData.get(Keys.LY57_LOSS_DATE_FROM) ;
        dolTo = (String)mrData.get(Keys.LY57_LOSS_DATE_TO) ;
        dolQual = (String)mrData.get(Keys.LY57_LOSS_DATE_QUAL)  ;
        catCode = (String)mrData.get(Keys.LY57_CAT_CODE)  ;
        pcsCode = (String)mrData.get(Keys.LY57_PCS_CAT_CODE)  ;
        naicCode = (String)mrData.get(Keys.LY57_NAIC_CODE)  ;
        naicQual = (String)mrData.get(Keys.LY57_NAIC_QUAL)  ;
        osAmt = (String)mrData.get(Keys.LY57_OUTST_AMT)  ;
        pttAmt = (String)mrData.get(Keys.LY57_PTT_AMT_TOTAL)  ;
      }
    }

    public void addAttributes(MappedRecord mrData) {
      corFlag = convertToBoolean((String)mrData.get(Keys.LY56_COR_ATTR_Field)) ;
      moveRefFlag = convertToBoolean((String)mrData.get(Keys.LY56_MOVE_REF_ATTR_Field)) ;
      name1Flag = convertToBoolean((String)mrData.get(Keys.LY56_NAME_1_ATTR_Field)) ;
      name1QualFlag = convertToBoolean((String)mrData.get(Keys.LY56_NAME_1_QL_ATTR_Field)) ;
      name2Flag = convertToBoolean((String)mrData.get(Keys.LY56_NAME_2_ATTR_Field)) ;
      name2QualFlag = convertToBoolean((String)mrData.get(Keys.LY56_NAME_2_QL_ATTR_Field)) ;
      filCodeFlag = convertToBoolean((String)mrData.get(Keys.LY56_FIL_CODE_ATTR_Field)) ;
      tfCodeFlag = convertToBoolean((String)mrData.get(Keys.LY56_TF_CODE_ATTR_Field)) ;
      stateCodeFlag = convertToBoolean((String)mrData.get(Keys.LY56_STATE_CODE_ATTR_Field)) ;
      dolFlag = convertToBoolean((String)mrData.get(Keys.LY56_DOL_ATTR_Field)) ;
      catCodeFlag = convertToBoolean((String)mrData.get(Keys.LY56_CAT_ATTR_Field)) ;
      pcsCodeFlag = convertToBoolean((String)mrData.get(Keys.LY56_PCS_CAT_ATTR_Field)) ;
      naicCodeFlag = convertToBoolean((String)mrData.get(Keys.LY56_NAIC_CODE_ATTR_Field)) ;
      naicQualFlag = convertToBoolean((String)mrData.get(Keys.LY56_NAIC_QUAL_ATTR_Field)) ;
      osAmtFlag = convertToBoolean((String)mrData.get(Keys.LY56_OUTST_AMT_ATTR)) ;
      pttAmtFlag = convertToBoolean((String)mrData.get(Keys.LY56_PTT_AMT_ATTR)) ;
      osAmtTotQualFlag = convertToBoolean((String)mrData.get(Keys.LY56_OUTST_AMT_TOT_QL_ATTR)) ;
    }

    public void adddeleteAttribute(AttuMappedRecord mrData) {
      try {
        delChkBoxFlag = enabledStatusCheckbox(mrData.getDom().getFirstChild().getNodeValue()) ;
      } catch (Exception e) {
        delChkBoxFlag = "";
      }
    }

    public String getcor() {
      return cor ;
    }
    public boolean getdeleteInd() {
      return deleteInd ;
    }
    public String getstatSplitNo() {
      return statSplitNo ;
    }
    public String getbreakdownNo() {
      return breakdownNo ;
    }
    public String getmvmtRef() {
      return mvmtRef ;
    }
    public String getname1() {
      return name1 ;
    }
    public String getname1Qual() {
      return name1Qual ;
    }
    public String getname2() {
      return name2 ;
    }
    public String getname2Qual() {
      return name2Qual ;
    }
    public String getfilCode() {
      return filCode ;
    }
    public String gettfCode() {
      return tfCode ;
    }
    public String getstateCode() {
      return stateCode ;
    }
    public String getdolFrom() {
      return dolFrom ;
    }
    public String getdolTo() {
      return dolTo ;
    }
    public String getdolQual() {
      return dolQual ;
    }
    public String getcatCode() {
      return catCode ;
    }
    public String getpcsCode() {
      return pcsCode ;
    }
    public String getnaicCode() {
      return naicCode ;
    }
    public String getnaicQual() {
      return naicQual ;
    }
    public String getPttAmt() {
      return pttAmt;
    }
    public String getOsAmt() {
      return osAmt;
    }
    
    public String getOsAmtTotQual()
    {
        return osAmtTotQual;
    }
    public boolean getcorFlag () {
      return corFlag ;
    }
    public boolean getmoveRefFlag () {
      return moveRefFlag ;
    }
    public boolean getname1Flag () {
      return name1Flag ;
    }
    public boolean getname1QualFlag () {
      return name1QualFlag ;
    }
    public boolean getname2Flag () {
      return name2Flag ;
    }
    public boolean getname2QualFlag () {
      return name2QualFlag ;
    }
    public boolean getfilCodeFlag () {
      return filCodeFlag ;
    }
    public boolean gettfCodeFlag () {
      return tfCodeFlag ;
    }
    public boolean getstateCodeFlag () {
      return stateCodeFlag ;
    }
    public boolean getdolFlag () {
      return dolFlag ;
    }
    public boolean getdolQualFlag () {
      // The date of loss attribute covers the date of loss from, to and qualifier flags
      return dolFlag ;
    }
    public boolean getcatCodeFlag () {
      return catCodeFlag ;
    }
    public boolean getpcsCodeFlag () {
      return pcsCodeFlag ;
    }
    public boolean getnaicCodeFlag () {
      return naicCodeFlag ;
    }
    public boolean getnaicQualFlag () {
      return naicQualFlag ;
    }
    public boolean getPttAmtFlag() {
      return pttAmtFlag;
    }
    public boolean getOsAmtFlag() {
      return osAmtFlag;
    }

    public String getdelChkBoxFlag () {
      return delChkBoxFlag ;
    }
    public boolean getOsAmtTotQualFlag () {
        return osAmtTotQualFlag ;
      }
   
  }
}