package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ16Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementSearchResultsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String noSearchResults;
  // This vector will contain all the search results details- this can range from zero, up to a max of 200 returned records.
  private Vector vAllSearchDetails;


  // All values are initialised to blank.
  // There are no values to extract from the Mapped Record detailed below.

  public FindSettlementSearchResultsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SettSearchResultsScreenModelKey, this);
  }

  public void performUpdate() {

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LZ16Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      noSearchResults = (String) results.get(Keys.C115_NO_OF_SEARCH_RESULTS);
      // Extract the market details lines from the Mapped Record.
      Vector vSearchDetails =  (Vector) results.get(Keys.C115_SEARCH_RESULTS);

      // Just in case (for any reason) that the vector derived from the MappedRecord
      // is null (it shouldn't be).
      if (vSearchDetails == null) {
        vSearchDetails = new Vector();
      }

      vAllSearchDetails = new Vector();
      for (int i=0; i<vSearchDetails.size(); i++) {
        MappedRecord mpSingleSearch = (MappedRecord)vSearchDetails.get(i);
        if (((String)mpSingleSearch.get(Keys.C115_LIDS_TAKE_DOWN_DATE)).equals("0"))
          break;

        singleSearchResultsLine searchDetailModel = new singleSearchResultsLine(
            (String)mpSingleSearch.get(Keys.C115_LIDS_TAKE_DOWN_DATE),
            (String)mpSingleSearch.get(Keys.C115_LIDS_TAKE_DOWN_NO),
            (String)mpSingleSearch.get(Keys.C115_VERSION_NO),
            (String)mpSingleSearch.get(Keys.C115_LIDS_YEAR_OF_ACC),
            (String)mpSingleSearch.get(Keys.C115_LIDS_PAYEE_BKR),
            (String)mpSingleSearch.get(Keys.C115_LIDS_BKR_REF),
            (String)mpSingleSearch.get(Keys.C115_LIDS_HPC_SETT_AMT),
            (String)mpSingleSearch.get(Keys.C115_NAME_1),
            (String)mpSingleSearch.get(Keys.C115_NAME_1_PARTIAL_IND),
            (String)mpSingleSearch.get(Keys.C115_NAME_2),
            (String)mpSingleSearch.get(Keys.C115_NAME_2_PARTIAL_IND));

        // This Vector will contain all the market detail line objects
        vAllSearchDetails.add(searchDetailModel);
        }
    }

  }
  // This getter returns all the elements within the vector. This will be called by the calling JSP only.
  public Vector getVAllSearchDetails() {
    return vAllSearchDetails;
  }
  public String getNoSearchResults() {
    return noSearchResults;
  }

// This inner class is used to store all the information stored in each line of
// the market details.
  public class singleSearchResultsLine {
    private String lidstdnDate = "";
    private String lidstdnNo = "";
    private String version = "";
    private String lidsyoa = "";
    private String lidspbkr = "";
    private String lidsbkrref = "";
    private String lidshpc = "";
    private String lidsname1 = "";
    private String lidsname1qual = "";
    private String lidsname2 = "";
    private String lidsname2qual = "";

    public singleSearchResultsLine(String lidstdnDate,
                                  String lidstdnNo,
                                  String version,
                                  String lidsyoa,
                                  String lidspbkr,
                                  String lidsbkrref,
                                  String lidshpc,
                                  String lidsname1,
                                  String lidsname1qual,
                                  String lidsname2,
                                  String lidsname2qual){
      this.lidstdnDate = lidstdnDate;
      this.lidstdnNo = lidstdnNo;
      this.version = version;
      this.lidsyoa = lidsyoa;
      this.lidspbkr = lidspbkr;
      this.lidsbkrref = lidsbkrref;
      this.lidshpc = lidshpc;
      this.lidsname1 = lidsname1;
      this.lidsname1qual = lidsname1qual;
      this.lidsname2 = lidsname2;
      this.lidsname2qual = lidsname2qual;

    }

    public String getLidstdnDate() {
      return lidstdnDate;
    }
    public String getLidstdnNo() {
      return lidstdnNo;
    }
    public String getVersion() {
      return version;
    }
    public String getLidsyoa() {
      return lidsyoa;
    }
    public String getLidspbkr() {
      return lidspbkr;
    }
    public String getLidshpc() {
      return lidshpc;
    }
    public String getLidsname1() {
      return lidsname1;
    }
    public String getLidsname1qual() {
      return lidsname1qual;
    }
    public String getLidsname2() {
      return lidsname2;
    }
    public String getLidsname2qual() {
      return lidsname2qual;
    }

  }

}

