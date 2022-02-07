package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.AdvancedSearchEvent;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.AdvancedSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MoreAddSrchWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
     
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    AdvancedSearchResultsModel model = mm.getAdvancedSearchModel();
    mm.getFindClaimModel();
    String cor;
    if (request.getParameter("direction").equals("fwd")) {
      cor = model.getLastKey().getCor();
    }
    else {
      cor = model.getFirstKey().getCor();
    }

    Vector v = new Vector();
   
    v.add(new AdvancedSearchEvent(model.getQuery(),cor,request.getParameter("direction")));
    return v;

  }

  public void doEnd(HttpServletRequest request) {

  }
}