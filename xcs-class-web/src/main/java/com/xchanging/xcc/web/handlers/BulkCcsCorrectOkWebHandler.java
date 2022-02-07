package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LY92Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCcsCorrectOkWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSummarySettlementModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String[] origCcys = new String[3];
    String[] settCcys = new String[3];
    String[] treasuryRates = new String[3];
    String reduceOs = checkboxValue(request.getParameter("reduceOSAmount"));

    for (int i=0;i<3;i++) {
      origCcys[i] = request.getParameter("origCcy" + (i+1));
      settCcys[i] = request.getParameter("settCcy" + (i+1));
      treasuryRates[i] = request.getParameter("treasuryRate" + (i+1));
    }

    Vector v = new Vector();
    v.add(new LY92Event(origCcys,settCcys,treasuryRates,reduceOs));
    v.add(new LY12Event("SCR022"));
    v.add(new LY62Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}