package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MovementHistoryModel extends WebModel implements ModelUpdateListener {

  // NOTES:
  // The LY70 spec details the following values which will be passed from the GUI.
  // NextPressed, PrevPressed, StartSysRef, StartCurrNo, StartSDNNo, StartSplitNo, StartBDownNo.
  // The latter 5 values will be stashed in getters here- and will have to be extracted in the Web
  // Handler through accessing this model.
  // The first two are determined by whether the next or the previous button was pressed. We will
  // have to have a little logic in the Web Handler which will determine this- perhaps through the URL
  // itself.

  private ModelManager mm;

  private String ucr;
  private String xcr;
  private String osnd;
  private String signed;
  private String origBkr;
  private String origCcy;
  private String cor;
  private String peerReview;
  private String totalPaid;
  private Vector movements;
  private boolean prevButtonFlag;
  private boolean nextButtonFlag;

  // This will have stored within it the values for the
  // first line of movement details on the screen
  private String ucrPrev;
  private String currNOPrev;
  private String sdnNoPrev;
  private String statSplitPrev;
  private String breakdownNoPrev;

  // This will have stored within it the values for the
  // second line of movement details on the screen
  private String ucrNext;
  private String currNONext;
  private String sdnNoNext;
  private String statSplitNext;
  private String breakdownNoNext;

  public MovementHistoryModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.MovementHistoryModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    // First hide the previous or next buttons if required.
    prevButtonFlag = convertToBoolean((String)results.get(Keys.LY70_PREV_ATTR_Field));
    nextButtonFlag = convertToBoolean((String)results.get(Keys.LY70_NEXT_ATTR_Field));
    // Now get out the respective values.
    MappedRecord subResults = (MappedRecord)((Vector)results.get(Keys.LY70_FIELD_VALUES_Table)).get(0);
    ucr = (String) subResults.get(Keys.LY70_UCR_Field);
    xcr = (String) subResults.get(Keys.LY70_XCR_Field);
    osnd = (String) subResults.get(Keys.LY70_ORIG_REF_Field);
    signed = (String) subResults.get(Keys.LY70_SIGNED_IND_Field);
    origBkr = (String) subResults.get(Keys.LY70_ORIG_BKR_Field);
    origCcy = (String) subResults.get(Keys.LY70_ORIG_CURR_Field);
    cor = (String) subResults.get(Keys.LY70_COR_Field);
    peerReview = (String) subResults.get(Keys.LY70_PEER_REV_IND_Field);
    totalPaid = (String) subResults.get(Keys.LY70_TOTAL_PAID_Field);

    Vector vMvmtDets = (Vector) subResults.get(Keys.LY70_MOVEMENT_DETS_Table);
    if (vMvmtDets==null)
      vMvmtDets = new Vector(0);

    movements = new Vector();
    for (int objInd = 0; objInd < vMvmtDets.size(); objInd++) {
     MappedRecord record = (MappedRecord)vMvmtDets.get(objInd);
     if (!(record.get(Keys.LY70_UCR_TR_SYS_REF_Field).equals("0"))) {
       if (objInd == 0){
         // This is the very first record on the screen- so store the
         // value (these will be stored within a hidden field in the JSP) and
         // will in turn be extracted when the "previous" button is pressed.
         extractValues(record, false);
       }
       else if (objInd == (vMvmtDets.size() - 1)) {
         // This is the very first record on the screen- so store the
         // value (these will be stored within a hidden field in the JSP) and
         // will in turn be extracted when the "previous" button is pressed.
         extractValues(record, true);
       }
       movements.add(new MovementHistory(record));
     }
    }

  }

  private void extractValues(MappedRecord mp, boolean bLastRecord){
    // Populate the ***Next fields with the last values in the MovementDetails Vector.
    if (bLastRecord){
      ucrNext         = (String) mp.get(Keys.LY70_UCR_TR_SYS_REF_Field);
      currNONext      = (String) mp.get(Keys.LY70_CURR_NO_Field);
      sdnNoNext       = (String) mp.get(Keys.LY70_SDN_NO_Field);
      statSplitNext   = (String) mp.get(Keys.LY70_STAT_SPLIT_NO_Field);
      breakdownNoNext = (String) mp.get(Keys.LY70_BREAKDOWN_NO_Field);
    }
    // Populate the ***Prev fields with the first values in the MovementDetails Vector.
    else {
      ucrPrev         = (String) mp.get(Keys.LY70_UCR_TR_SYS_REF_Field);
      currNOPrev      = (String) mp.get(Keys.LY70_CURR_NO_Field);
      sdnNoPrev       = (String) mp.get(Keys.LY70_SDN_NO_Field);
      statSplitPrev   = (String) mp.get(Keys.LY70_STAT_SPLIT_NO_Field);
      breakdownNoPrev = (String) mp.get(Keys.LY70_BREAKDOWN_NO_Field);
    }
  }

  public String getUcr() {
    return ucr;
  }
  public String getXcr() {
    return xcr;
  }
  public String getOsnd() {
    return osnd;
  }
  public String getSigned() {
    return signed;
  }
  public String getOrigBkr() {
    return origBkr;
  }
  public String getCor() {
    return cor;
  }
  public String getPeerReview() {
    return peerReview;
  }
  public Enumeration getMovements() {
    return movements.elements();
  }
  public boolean getPrevButtonFlag() {
    return prevButtonFlag;
  }
  public boolean getNextButtonFlag() {
    return nextButtonFlag;
  }
  public String getTotalPaid() {
    return totalPaid;
  }
  public String getBreakdownNoNext() {
    return breakdownNoNext;
  }
  public String getBreakdownNoPrev() {
    return breakdownNoPrev;
  }
  public String getCurrNONext() {
    return currNONext;
  }
  public String getCurrNOPrev() {
    return currNOPrev;
  }
  public String getSdnNoNext() {
    return sdnNoNext;
  }
  public String getSdnNoPrev() {
    return sdnNoPrev;
  }
  public String getStatSplitNext() {
    return statSplitNext;
  }
  public String getStatSplitPrev() {
    return statSplitPrev;
  }
  public String getUcrNext() {
    return ucrNext;
  }
  public String getUcrPrev() {
    return ucrPrev;
  }

  public int getNoOfMovements() {
    return movements.size();
  }

  public MovementHistory getMovement(int i) {
    return (MovementHistory)movements.get(i);
  }
  public String getOrigCcy() {
    return origCcy;
  }

  public class MovementHistory {

    private String mvmtRef;
    private String seqNo;
    private String PTTInOrig;
    private String OSAmount;
    private String OSAmountQual;
    private String transDate;
    private String tdn;
    private String userId;
    private String status;
    private String sysRef;
    private String currNo;
    private String sdnNo;
    private String statSplitNo;
    private String breakdownNo;

    private boolean mvmtRefButtonFlag;

    public MovementHistory(MappedRecord mp){

     mvmtRef = (String) mp.get(Keys.LY70_MOVE_REF_Field);
     seqNo   = (String) mp.get(Keys.LY70_MOVE_SEQ_NO_Field);
     PTTInOrig   = (String) mp.get(Keys.LY70_PTT_AMT_Field);
     OSAmount   = (String) mp.get(Keys.LY70_OUTST_AMT_Field);
     OSAmountQual   = (String) mp.get(Keys.LY70_OUTST_QUAL_Field);
     transDate   = (String) mp.get(Keys.LY70_TRANS_DATE_Field);
     tdn   = (String) mp.get(Keys.LY70_TAKE_DOWN_NO_Field);
     userId   = (String) mp.get(Keys.LY70_USER_ID_Field);
     status   = (String) mp.get(Keys.LY70_MOVE_STATUS_Field);
     mvmtRefButtonFlag =  convertToBoolean((String) mp.get(Keys.LY70_MOVE_SELECT_ATTR_Field));
     sysRef = (String) mp.get(Keys.LY70_UCR_TR_SYS_REF_Field);
     currNo = (String) mp.get(Keys.LY70_CURR_NO_Field);
     sdnNo = (String) mp.get(Keys.LY70_SDN_NO_Field);
     statSplitNo = (String) mp.get(Keys.LY70_STAT_SPLIT_NO_Field);
     breakdownNo = (String) mp.get(Keys.LY70_BREAKDOWN_NO_Field);
    }
    public String getMvmtRef() {
      return mvmtRef;
    }
    public String getSeqNo() {
      return seqNo;
    }
    public String getPTTInOrig() {
      return PTTInOrig;
    }
    public String getOSAmount() {
      return OSAmount;
    }
    public String getOSAmountQual() {
      return OSAmountQual;
    }
    public String getTransDate() {
      return transDate;
    }
    public String getTdn() {
      return tdn;
    }
    public String getUserId() {
      return userId;
    }
    public String getStatus() {
      return status;
    }
    public boolean getMvmtRefButtonFlag() {
      return mvmtRefButtonFlag;
    }
    public String getSysRef() {
      return sysRef;
    }
    public String getCurrNo() {
      return currNo;
    }
    public String getSdnNo() {
      return sdnNo;
    }
    public String getStatSplitNo() {
      return statSplitNo;
    }
    public String getBreakdownNo() {
      return breakdownNo;
    }

  }
}