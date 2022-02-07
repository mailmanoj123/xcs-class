package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LY79Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ContraCorrectReleaseWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSummarySettlementModel();
    mm.getNavigationBar();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY79Event(checkboxValue(request.getParameter("reduceOutstandingAmtToZero"))));
    v.add(new LY12Event("SCR022"));
    v.add(new LY62Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}