package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ18Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SettlementSearchModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementDetailsCancelWebHandler extends WebHandler {

  private SettlementSearchModel settsearch;

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    // this should already be within the session- however this does no harm!
    mm.getFindSettlementSearchDetailResults();
    // Now we extract the settlement search model from the seesion- so that we can delete down the values.
    settsearch = mm.getSettlementSearch();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    settsearch.setName1("");
    settsearch.setName2("");
    settsearch.setOsndDate("");
    settsearch.setOsndNo("");
    settsearch.setPbkr("");
    settsearch.setTdnDate("");
    settsearch.setTdnNo("");
    settsearch.setYoa("");

    Vector v = new Vector();
    v.add(new LZ18Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}

