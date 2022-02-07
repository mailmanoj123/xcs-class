package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LY78Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class RateOfExchReleaseWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSummarySettlementModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String[] exchRates = new String[3];
    String[] settAmts = new String[3];

    for (int i=0;i<3;i++) {
      exchRates[i] = request.getParameter("revisedExchangeRate" + (i+1));
      settAmts[i]  = request.getParameter("revisedSettAmt" + (i+1));
    }

    Vector v = new Vector();
    v.add(new LY78Event(exchRates,settAmts));
    v.add(new LY12Event("SCR022"));
    v.add(new LY62Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}