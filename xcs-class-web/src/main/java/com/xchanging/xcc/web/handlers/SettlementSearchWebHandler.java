package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ15Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SettlementSearchModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SettlementSearchWebHandler extends WebHandler {

  private ModelManager mm;

  public SettlementSearchWebHandler() {
  }

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SettlementSearchModel settsearch = mm.getSettlementSearch();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LZ15Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}

