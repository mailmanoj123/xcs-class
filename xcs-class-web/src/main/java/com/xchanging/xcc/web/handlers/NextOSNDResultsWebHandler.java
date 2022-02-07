package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY06Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.OSNDResult;
import com.xchanging.xcc.web.models.OsndSearchResultsModel;

public class NextOSNDResultsWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();

    OsndSearchResultsModel osndModel = (OsndSearchResultsModel)request.getSession().getAttribute(Keys.OsndSearchResultsModelKey);
    OSNDResult searchResult = (OSNDResult)osndModel.getResultsAsVector().lastElement();

    v.add(new LY06Event(osndModel.getOsnd(),
                        osndModel.getPrevScreenId(),
                        searchResult.getUcrTrSysRef(),
                        searchResult.getCurrNo(),
                        searchResult.getSdnNo(),
                        searchResult.getStatSplitNo(),
                        searchResult.getBreakdownNo(),
                        "NEXT"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}