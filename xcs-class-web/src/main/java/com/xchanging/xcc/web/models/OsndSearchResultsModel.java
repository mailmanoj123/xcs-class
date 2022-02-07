package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY05Event;
import com.xchanging.xcc.events.LY06Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class OsndSearchResultsModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private Vector claims = new Vector();

  private String prevScreenId = "";
  private String osnd = "";
  private String apsnd = "";

  private String firstSysRef = "";
  private String firstCurrNo = "";
  private String firstSdnNo = "";
  private String firstSplitNo = "";
  private String firstBdownNo = "";

  private String lastSysRef = "";
  private String lastCurrNo = "";
  private String lastSdnNo = "";
  private String lastSplitNo = "";
  private String lastBdownNo = "";

  private String moreNext = "";
  private String morePrev = "";

  private boolean contAttr;

  public OsndSearchResultsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.OsndSearchResultsModelKey, this);
  }

  public Enumeration getResults() {
    return claims.elements();
  }

  public Vector getResultsAsVector() {
    return claims;
  }

  public String getOsnd() {
    return osnd;
  }

  public boolean getPrevButtonFlag() {
    return morePrev.equals("N");
  }

  public boolean getNextButtonFlag() {
    return moreNext.equals("N");
  }

  public void performUpdate() {
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    if (event instanceof LY06Event) {

    claims = new Vector();

    prevScreenId = (String)results.get("@C006_PREV_SCREEN_ID");
    osnd = (String)results.get("@C006_SEARCH_OSDN");

    /**
     * First Key Values
     */
    Vector firstKey = (Vector)results.get("#C006_FIRST_KEY[]");
    MappedRecord firstKeyrecords = (MappedRecord)firstKey.get(0);
    firstSysRef = (String)firstKeyrecords.get("@C006_FIRST_SYS_REF");
    firstCurrNo = (String)firstKeyrecords.get("@C006_FIRST_CURR_NO");
    firstSdnNo = (String)firstKeyrecords.get("@C006_FIRST_SDN_NO");
    firstSplitNo = (String)firstKeyrecords.get("@C006_FIRST_SPLIT_NO");
    firstBdownNo = (String)firstKeyrecords.get("@C006_FIRST_BDOWN_NO");

    /**
     * Last Key Values
     */
    Vector lastKey = (Vector)results.get("#C006_LAST_KEY[]");
    MappedRecord lastKeyrecords = (MappedRecord)lastKey.get(0);
    firstSysRef = (String)lastKeyrecords.get("@C006_LAST_SYS_REF");
    firstCurrNo = (String)lastKeyrecords.get("@C006_LAST_CURR_NO");
    firstSdnNo = (String)lastKeyrecords.get("@C006_LAST_SDN_NO");
    firstSplitNo = (String)lastKeyrecords.get("@C006_LAST_SPLIT_NO");
    firstBdownNo = (String)lastKeyrecords.get("@C006_LAST_BDOWN_NO");

    moreNext = (String)results.get("@C006_MORE_NEXT");
    morePrev = (String)results.get("@C006_MORE_PREV");

    Vector resultsTable = (Vector)results.get("#C006_RESULTS_TABLE[]");
    MappedRecord resultTableRecords = (MappedRecord)resultsTable.get(0);
    Vector lines = (Vector)resultTableRecords.get("#C006_RESULT_LINE[]");

    for (int x = 0; x < lines.size(); x++) {
      MappedRecord result = (MappedRecord)lines.get(x);
      if (!(result.get("@C006_UCR").equals(""))) {
        claims.add( new OSNDResult( (String)result.get("@C006_UCR"),
                                    (String)result.get("@C006_TR"),
                                    (String)result.get("@C006_UCR_TR_SYS_REF"),
                                    (String)result.get("@C006_CURR_NO"),
                                    (String)result.get("@C006_SDN_NO"),
                                    (String)result.get("@C006_STAT_SPLIT_NO"),
                                    (String)result.get("@C006_BREAKDOWN_NO"),
                                    (String)result.get("@C006_COR"),
                                    (String)result.get("@C006_NAME_1"),
                                    (String)result.get("@C006_NAME_2"),
                                    (String)result.get("@C006_LOSS_DATE_FROM"),
                                    (String)result.get("@C006_LOSS_DATE_TO"),
                                    (String)result.get("@C006_STATE_CODE"),
                                    (String)result.get("@C006_BKR_REF_1"),
                                    (String)result.get("@C006_OUTST_TOT_QL")));
      }
    }

    Vector commandAttributes = (Vector)results.get("#C006_COMMAND_ATTRIBUTES[]");
    MappedRecord commandAttributesRec = (MappedRecord)commandAttributes.get(0);
    contAttr = convertToBoolean((String)commandAttributesRec.get("@C006_CONT_ATTR"));

    } else if (event instanceof LY05Event) {

      apsnd = (String)results.get(Keys.LY05APRefField);

    }


  }
  public String getMoreNext() {
    return moreNext;
  }
  public String getMorePrev() {
    return morePrev;
  }
  public String getPrevScreenId() {
    return prevScreenId;
  }
  public String getLastSysRef() {
    return lastSysRef;
  }
  public String getLastSplitNo() {
    return lastSplitNo;
  }
  public String getLastSdnNo() {
    return lastSdnNo;
  }
  public String getLastCurrNo() {
    return lastCurrNo;
  }
  public String getLastBdownNo() {
    return lastBdownNo;
  }
  public String getFirstSysRef() {
    return firstSysRef;
  }
  public String getFirstSplitNo() {
    return firstSplitNo;
  }
  public String getFirstSdnNo() {
    return firstSdnNo;
  }
  public String getFirstCurrNo() {
    return firstCurrNo;
  }
  public String getFirstBdownNo() {
    return firstBdownNo;
  }
  public boolean getContButtonFlag() {
    return contAttr;
  }
  public String getApsnd() {
    return apsnd;
  }
}