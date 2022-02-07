package com.xchanging.xcc.web.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import com.xchanging.xcc.events.AdvancedSearchEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class AdvancedSearchResultsModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private Vector results;
  private String query;
  private String displayQuery;
  private boolean hideNextBtn;
  private boolean hidePrevBtn;
  private int remainingRows;

  public AdvancedSearchResultsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.AdvancedSearchResultsModelKey, this);
  }

  public SearchResult getLastKey() {
    return (SearchResult)results.lastElement();
  }

  public SearchResult getFirstKey() {
    return (SearchResult)results.firstElement();
  }

  public void setDisplayQuery(String displayQuery) {
    this.displayQuery = displayQuery;
  }

  public String getDisplayQuery() {
    return displayQuery.replace('%','*');
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

  public void performUpdate() {

    AdvancedSearchEvent event = (AdvancedSearchEvent)session.getAttribute(Keys.WebEventKey);

    results = new Vector();
    HashMap map = (HashMap)session.getAttribute((Keys.CicsDataKey));
    ResultSet resultSet = (ResultSet)map.get("RESULT_SET");

    if (resultSet != null) {
      try {
        while (resultSet.next ()) {
          results.add(new SearchResult( resultSet.getString("COR"),
                                        resultSet.getString("NAME_1"),
                                        resultSet.getString("NAME_2"),
                                        resultSet.getString("DATE_OF_LOSS"),
                                        resultSet.getString("CAT_CODE"),
                                        resultSet.getString("PROCESSING_USER"),
                                        resultSet.getString("DATE_PROCESSED"),
                                        resultSet.getString("CLAIMANT"),
                                        resultSet.getString("BKR_REF_1"),
                                        resultSet.getString("UCR")));
        }

        if (event.getDirection().equals("back")) {
          for (int x = results.size(); x > 0; x--) {
            results.add(results.remove(x-1));
          }
        }

        remainingRows = ((Integer)map.get("MAX_ROWS")).intValue() - results.size();

        if (event.getDirection().equals("")) {
          if (remainingRows > 0) {
            hideNextBtn = false;
            hidePrevBtn = true;
          }
          else {
            hideNextBtn = true;
            hidePrevBtn = true;
          }
        }
        if (event.getDirection().equals("fwd")) {
          if (remainingRows > 0) {
            hideNextBtn = false;
            hidePrevBtn = false;
          }
          else {
            hideNextBtn = true;
            hidePrevBtn = false;
          }
        }
        if (event.getDirection().equals("back")) {
          if (remainingRows > 0) {
            hideNextBtn = false;
            hidePrevBtn = false;
          }
          else {
            hideNextBtn = false;
            hidePrevBtn = true;
          }
        }
      }
      catch (SQLException sqlE) {
        sqlE.printStackTrace();
      }
    }
    else {
      hideNextBtn = true;
      hidePrevBtn = true;
    }
  }

  public Enumeration getResults() {
    if (results == null) {
      results = new Vector();
    }
    return results.elements();
  }

  public boolean getPrevButtonFlag() {
    return hidePrevBtn;
  }

  public boolean getNextButtonFlag() {
    return hideNextBtn;
  }

}