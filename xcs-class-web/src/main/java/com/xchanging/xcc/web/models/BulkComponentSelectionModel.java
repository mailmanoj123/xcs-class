package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY65Event;
import com.xchanging.xcc.events.LY66Event;
import com.xchanging.xcc.events.LZ09Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkComponentSelectionModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String screenMode;  // extra value
  private String ucr;
  private String xcr;
  private String tr;
  private String osnd1;
  private String osnd2;
  private String osnd3;
  private String peerReview;
  private String origBkr;
  private boolean prevButtonFlag;
  private boolean nextButtonFlag;
  private Vector items;
  private String progStatus;

  private String targetPTTAmount;
  private String targetOSAmount;
  private String actualPTTAmount;
  private String actualOSAmount;

  public BulkComponentSelectionModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.BulkComponentSelectionModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LZ09Event) {

      String compSysRef = (String)results.get(Keys.LZ09_COMP_SYS_REF);
      MappedRecord componentDetails = (MappedRecord)((Vector)results.get(Keys.LZ09_COMPONENT_DETAILS)).get(0);

      String breakdownCount = (String)componentDetails.get(Keys.LZ09_BREAKDOWN_COUNT);
      Vector breakdownDetails = (Vector)componentDetails.get(Keys.LZ09_BREAKDOWN_DETAILS);

      Vector breakdowns = new Vector(Integer.parseInt(breakdownCount));

      for (int i=0; i<Integer.parseInt(breakdownCount); i++) {
        MappedRecord current = (MappedRecord)breakdownDetails.get(i);

        BreakdownDetail bdown = new BreakdownDetail((String)current.get(Keys.LZ09_COR),
            (String)current.get(Keys.LZ09_ORIG_CURR),
            (String)current.get(Keys.LZ09_NAME_1),
            (String)current.get(Keys.LZ09_LOSS_DATE_FROM),
            (String)current.get(Keys.LZ09_LOSS_DATE_TO),
            (String)current.get(Keys.LZ09_CLAIM_DATE_FROM),
            (String)current.get(Keys.LZ09_CLAIM_DATE_TO),
            (String)current.get(Keys.LZ09_STATE_CODE),
            (String)current.get(Keys.LZ09_NAIC_CODE),
            (String)current.get(Keys.LZ09_NAIC_QUAL),
            (String)current.get(Keys.LZ09_CAT_CODE),
            (String)current.get(Keys.LZ09_PCS_CAT_CODE),
            (String)current.get(Keys.LZ09_PTT_AMT),
            (String)current.get(Keys.LZ09_OUTST_AMT));

        breakdowns.add(bdown);
      }

      BulkSettlementItem item = getItem(compSysRef);
      item.addBreakdownDetails(breakdowns);
      setItem(compSysRef,item);

    } else if (event instanceof LY66Event) {

      UserWebModel user = (UserWebModel)session.getAttribute(Keys.UserWebModelKey);
      user.setSecondaySessionNo((String)results.get(Keys.LY66_COMP_SESSION_NO));

    } else if (event instanceof LY65Event) {

      progStatus = (String)results.get(Keys.LY65_PROG_STATUS);

    } else {

      screenMode = (String)results.get(Keys.LY64_SCREEN_MODE);
      mm.getUserWebModel().setUpdateMode(screenMode);

      MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY64_FIELD_VALUES)).get(0);

      xcr = (String)fieldValues.get(Keys.LY64_XCR);
      ucr = (String)fieldValues.get(Keys.LY64_UCR);
      tr = (String)fieldValues.get(Keys.LY64_TR);
      osnd1 = (String)fieldValues.get(Keys.LY64_ORIG_REF_1);
      osnd2 = (String)fieldValues.get(Keys.LY64_ORIG_REF_2);
      osnd3 = (String)fieldValues.get(Keys.LY64_ORIG_REF_3);
      origBkr = (String)fieldValues.get(Keys.LY64_ORIG_BKR);
      peerReview = (String)fieldValues.get(Keys.LY64_PEER_REV_IND);

      targetPTTAmount = (String)fieldValues.get(Keys.LY64_PTT_AMT_TARGET);
      targetOSAmount = (String)fieldValues.get(Keys.LY64_OUT_AMT_TARGET);
      actualPTTAmount = (String)fieldValues.get(Keys.LY64_PTT_AMT_ACTUAL);
      actualOSAmount = (String)fieldValues.get(Keys.LY64_OUT_AMT_ACTUAL);

      MappedRecord fieldAttributes = (MappedRecord)((Vector)results.get(Keys.LY64_FIELD_ATTRIBUTES)).get(0);
      Vector compAttrs = (Vector)fieldAttributes.get(Keys.LY64_COMP_ATTRIBUTES);

      if (compAttrs==null)
        compAttrs = new Vector(0);

      String[] includeAttrs = new String[compAttrs.size()];
      for (int i=0; i<includeAttrs.length; i++) {
        MappedRecord compAttr = (MappedRecord)compAttrs.get(i);
        includeAttrs[i] = enabledStatusCheckbox((String)compAttr.get(Keys.LY64_INCLUDE_ATTR));
      }

      prevButtonFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY64_PREV_ATTR));
      nextButtonFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY64_NEXT_ATTR));


      Vector componentClaims = (Vector)fieldValues.get(Keys.LY64_COMPONENT_CLAIMS);
      if (componentClaims==null)
        componentClaims = new Vector(0);

      items = new Vector();

      for (int i=0; i<componentClaims.size(); i++) {

        MappedRecord componentClaim = (MappedRecord)componentClaims.get(i);
        BulkSettlementItem item = new BulkSettlementItem((String)componentClaim.get(Keys.LY64_COMP_SYS_REF),
            checkBoxStatus((String)componentClaim.get(Keys.LY64_INCLUDE_IND)),
            includeAttrs[i],
            (String)componentClaim.get(Keys.LY64_COMP_UCR),
            (String)componentClaim.get(Keys.LY64_COR),
            (String)componentClaim.get(Keys.LY64_NAME_1),
            (String)componentClaim.get(Keys.LY64_NAME_2),
            (String)componentClaim.get(Keys.LY64_LOSS_DATE_FROM),
            (String)componentClaim.get(Keys.LY64_CLAIM_DATE_FROM),
            (String)componentClaim.get(Keys.LY64_BKR_REF_1),
            checkBoxStatus((String)componentClaim.get(Keys.LY64_PROC_IND))
            );

        if (!item.getCompSysRef().equals("0"))
          items.add(item);
        else
          break;
      }
    }
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
  public String getOrigBkr() {
    return origBkr;
  }
  public java.util.Enumeration getItems() {
    return items.elements();
  }
  public BulkSettlementItem getItem(int i) {
    return (BulkSettlementItem)items.get(i);
  }
  public int getNoOfItems() {
    return items.size();
  }
  public boolean getPrevButtonFlag() {
    return prevButtonFlag;
  }
  public boolean getNextButtonFlag() {
    return nextButtonFlag;
  }
  public String getProgStatus() {
    if (progStatus==null)
      return "";
    else
      return progStatus;
  }
  public String getActualOSAmount() {
    return actualOSAmount;
  }
  public String getActualPTTAmount() {
    return actualPTTAmount;
  }
  public String getTargetOSAmount() {
    return targetOSAmount;
  }
  public String getTargetPTTAmount() {
    return targetPTTAmount;
  }

  public BulkSettlementItem getItem(String compSysRef) {
    for (int i=0; i<items.size(); i++) {
      if (((BulkSettlementItem)items.get(i)).getCompSysRef().equals(compSysRef))
        return (BulkSettlementItem)items.get(i);
    }
    return null;
  }

  public void setItem(String compSysRef, BulkSettlementItem item) {
    for (int i=0; i<items.size(); i++) {
      if (((BulkSettlementItem)items.get(i)).getCompSysRef().equals(compSysRef))
        items.set(i,item);
    }
  }

  public class BulkSettlementItem {
    private String include;
    private String includeAttr;
    private String compSysRef;
    private String ucr;
    private String COR;
    private String name1;
    private String name2;
    private String DOL;
    private String DCM;
    private String bkrClaimRef1;
    private String processed;
    private Vector breakdownDetails;

    public BulkSettlementItem(String compSysRef,
                              String include,
                              String includeAttr,
                              String ucr,
                              String COR,
                              String name1,
                              String name2,
                              String DOL,
                              String DCM,
                              String bkrClaimRef1,
                              String processed) {

      this.include = include;
      this.includeAttr = includeAttr;
      this.compSysRef = compSysRef;
      this.ucr = ucr;
      this.COR = COR;
      this.name1 = name1;
      this.name2 = name2;
      this.DOL = DOL;
      this.DCM = DCM;
      this.bkrClaimRef1 = bkrClaimRef1;
      this.processed = processed;
    }

    public String getUcr() {
      return ucr;
    }
    public String getCOR() {
      return COR;
    }
    public String getName1() {
      return htmlSafe(name1);
    }
    public String getDCM() {
      return DCM;
    }
    public String getProcessed() {
      return processed;
    }
    public String getName2() {
      return htmlSafe(name2);
    }
    public String getDOL() {
      return DOL;
    }
    public String getBkrClaimRef1() {
      return bkrClaimRef1;
    }
    public String getInclude() {
      return include;
    }
    public void setInclude(String sInclude) {
      include = sInclude ;
    }
    public String getIncludeFlag() {
      return includeAttr;
    }
    public String getCompSysRef() {
      return compSysRef;
    }
    public Vector getBreakdownDetails() {
      return breakdownDetails;
    }
    public boolean showMore() {
      return breakdownDetails!=null && breakdownDetails.size()>0;
    }
    public void clearBreakdownDetails() {
      breakdownDetails = null;
    }
    public void addBreakdownDetails(Vector breakdownDetails) {
      this.breakdownDetails = breakdownDetails;
    }
  }

  public class BreakdownDetail {
    private String COR;
    private String origCcy;
    private String name1;
    private String DOLFrom;
    private String DOLTo;
    private String DCMFrom;
    private String DCMTo;
    private String stateCode;
    private String naicCode;
    private String naicQual;
    private String catCode;
    private String PCSCatCode;
    private String PTTAmount;
    private String OSAmount;

    public BreakdownDetail(String COR,
                           String origCcy,
                           String name1,
                           String DOLFrom,
                           String DOLTo,
                           String DCMFrom,
                           String DCMTo,
                           String stateCode,
                           String naicCode,
                           String naicQual,
                           String catCode,
                           String PCSCatCode,
                           String PTTAmount,
                           String OSAmount) {
      this.COR = COR;
      this.origCcy = origCcy;
      this.name1 = name1;
      this.DOLFrom = DOLFrom;
      this.DOLTo = DOLTo;
      this.DCMFrom = DCMFrom;
      this.DCMTo = DCMTo;
      this.stateCode = stateCode;
      this.naicCode = naicCode;
      this.naicQual = naicQual;
      this.catCode = catCode;
      this.PCSCatCode = PCSCatCode;
      this.PTTAmount = PTTAmount;
      this.OSAmount = OSAmount;
    }

    public String getCatCode() {
      return catCode;
    }
    public String getCOR() {
      return COR;
    }
    public String getDCMFrom() {
      return DCMFrom;
    }
    public String getDCMTo() {
      return DCMTo;
    }
    public String getDOLFrom() {
      return DOLFrom;
    }
    public String getDOLTo() {
      return DOLTo;
    }
    public String getNaicCode() {
      return naicCode;
    }
    public String getName1() {
      return name1;
    }
    public String getNaicQual() {
      return naicQual;
    }
    public String getOrigCcy() {
      return origCcy;
    }
    public String getOSAmount() {
      return OSAmount;
    }
    public String getPCSCatCode() {
      return PCSCatCode;
    }
    public String getPTTAmount() {
      return PTTAmount;
    }
    public String getStateCode() {
      return stateCode;
    }
  }
}