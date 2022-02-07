package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class GroupSearchResultsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String groupRef;
  private String bkrUcr;

  private boolean prevButtonFlag;
  private boolean nextButtonFlag;

  private Vector results;

  public GroupSearchResultsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.GroupSearchResultsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord CICSresults = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    groupRef = (String)CICSresults.get(Keys.LY08_SEARCH_GRP_REF_Field) ;
    bkrUcr   = (String)CICSresults.get(Keys.LY08_SEARCH_BKR_UCR_Field) ;

    prevButtonFlag = ((String)CICSresults.get(Keys.LY08_MORE_PREV_FIELD)).trim().equals("N");
    nextButtonFlag = ((String)CICSresults.get(Keys.LY08_MORE_NEXT_FIELD)).trim().equals("N");

    MappedRecord resultsTable = (MappedRecord)(((Vector)(CICSresults).get(Keys.LY08_RESULTS_TABLE)).get(0)) ;
    Vector vctResultLine = (Vector)(resultsTable.get(Keys.LY08_RESULT_LINE));
    if (vctResultLine==null)
      vctResultLine = new Vector(0);

    results = new Vector();
    for (int i=0; i<vctResultLine.size(); i++) {
      MappedRecord resultLine = (MappedRecord)vctResultLine.get(i);
      if (!((String)resultLine.get(Keys.LY08_COR_Field)).equals("")) {
        GroupResult groupResult = new GroupResult(resultLine);
        results.add(groupResult);
      }
    }
  }

  public String getGroupRef() {
    return groupRef;
  }
  public String getBkrUcr() {
    return bkrUcr;
  }

  public boolean getPrevButtonFlag() {
    return prevButtonFlag;
  }
  public boolean getNextButtonFlag() {
    return nextButtonFlag;
  }

  public Enumeration getResults() {
    return results.elements();
  }

  public Vector getResultsAsVector() {
    return results;
  }

  public class GroupResult {
    public GroupResult(MappedRecord record) {
      cor               = (String)record.get(Keys.LY08_COR_Field) ;
      reinsuredLossName = (String)record.get(Keys.LY08_REINS_LOSS_Field) ;
      bkrClaimRef1      = (String)record.get(Keys.LY08_BKR_REF_1_Field) ;
      TFCode            = (String)record.get(Keys.LY08_TF_CODE_Field) ;
      stateCode         = (String)record.get(Keys.LY08_STATE_CODE_Field) ;
      DOLFrom           = (String)record.get(Keys.LY08_LOSS_DATE_FROM_Field) ;
      DOLTo             = (String)record.get(Keys.LY08_LOSS_DATE_TO_Field) ;
      catCode           = (String)record.get(Keys.LY08_CAT_CODE_Field) ;
      naicCode          = (String)record.get(Keys.LY08_NAIC_CODE_Field) ;
      naicQual          = (String)record.get(Keys.LY08_NAIC_QUAL_Field) ;
      origCcy           = (String)record.get(Keys.LY08_ORIG_CURR_Field) ;
      PTDAmount         = (String)record.get(Keys.LY08_PTD_AMT_Field) ;
      OSAmount          = (String)record.get(Keys.LY08_OUTST_AMT_Field) ;

      ucr               = (String)record.get(Keys.LY08_UCR_Field) ;
      tr                = (String)record.get(Keys.LY08_TR_Field) ;
      ucrTRSysRef       = (String)record.get(Keys.LY08_UCR_TR_SYS_REF_Field) ;
      currNo            = (String)record.get(Keys.LY08_CURR_NO_Field) ;
      sdnNo             = (String)record.get(Keys.LY08_SDN_NO_Field) ;
      statSplitNo       = (String)record.get(Keys.LY08_STAT_SPLIT_NO_Field) ;
      breakdownNo       = (String)record.get(Keys.LY08_BREAKDOWN_NO_Field) ;
      pcsCatCode        = (String)record.get(Keys.LY08_PCS_CAT_CODE_Field) ;
      outStanQual       = (String)record.get(Keys.LY08_OUTST_AMT_QL_Field) ;
    }

    // The following are defined in the commarea and used by the GUI
    private String cor;
    private String reinsuredLossName;
    private String bkrClaimRef1;
    private String TFCode;
    private String stateCode;
    private String DOLFrom;
    private String DOLTo;
    private String catCode;
    private String naicCode;
    private String naicQual;
    private String origCcy;
    private String PTDAmount;
    private String OSAmount;

    // The following are defined in the commarea but not used by the GUI
    private String ucr ;
    private String tr ;
    private String ucrTRSysRef ;
    private String currNo ;
    private String sdnNo ;
    private String statSplitNo ;
    private String breakdownNo ;
    private String pcsCatCode ;
    private String outStanQual;
    public String getCor() {
      return cor;
    }
    public String getReinsuredLossName() {
      return reinsuredLossName;
    }
    public String getBkrClaimRef1() {
      return bkrClaimRef1;
    }
    public String getTFCode() {
      return TFCode;
    }
    public String getStateCode() {
      return stateCode;
    }
    public String getDOLFrom() {
      return DOLFrom;
    }
    public String getDOLTo() {
      return DOLTo;
    }
    public String getCatCode() {
      return catCode;
    }
    public String getNaicCode() {
      return naicCode;
    }
    public String getNaicQual() {
      return naicQual;
    }
    public String getOrigCcy() {
      return origCcy;
    }
    public String getPTDAmount() {
      return PTDAmount;
    }
    public String getOSAmount() {
      return OSAmount;
    }


    public String getUcr() {
      return ucr ;
    }
    public String getTr() {
      return tr ;
    }
    public String getUcrTRSysRef() {
      return ucrTRSysRef ;
    }
    public String getCurrNo() {
      return currNo ;
    }
    public String getSdnNo() {
      return sdnNo ;
    }
    public String getStatSplitNo() {
      return statSplitNo ;
    }
    public String getBreakdownNo() {
      return breakdownNo ;
    }
    public String getPcsCatCode() {
      return pcsCatCode ;
    }
    
    public String getOutStanQual()
    {
        return outStanQual;
    }
  }
}