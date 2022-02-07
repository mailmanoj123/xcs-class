package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY08Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.GroupSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class GroupSearchPrevWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    GroupSearchResultsModel resultsModel = (GroupSearchResultsModel)mm.getGroupSearchResultsModel();
    GroupSearchResultsModel.GroupResult result = (GroupSearchResultsModel.GroupResult)resultsModel.getResultsAsVector().firstElement();

    Vector v = new Vector();

    v.add(new LY08Event(resultsModel.getGroupRef(),resultsModel.getBkrUcr(),
                        result.getUcrTRSysRef(),result.getCurrNo(),
                        result.getSdnNo(),result.getStatSplitNo(),
                        result.getBreakdownNo(),
                        "0","0","0","0","0"));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}