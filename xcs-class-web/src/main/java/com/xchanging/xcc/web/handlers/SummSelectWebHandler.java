package com.xchanging.xcc.web.handlers;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ03Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SummSettCollection;
import com.xchanging.xcc.web.models.SummSettCurrency;
import com.xchanging.xcc.web.models.SummarySettlementModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SummSelectWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SummarySettlementModel ssm = mm.getSummarySettlementModel();

    Vector v = new Vector();

    Enumeration ccys = ssm.getCurrencies();

    boolean show = true;
    while (ccys.hasMoreElements()) {
      SummSettCurrency ccy = (SummSettCurrency)ccys.nextElement();
      if (ccy.getCurrNo().equals(request.getParameter("currNo"))) {
        Enumeration colls = ccy.getCollections();
        while (colls.hasMoreElements()) {
          SummSettCollection coll = (SummSettCollection)colls.nextElement();
          if (coll.getstatSplitNo().equals(request.getParameter("statSplitNo"))) {
            if (coll.hasBreakdowns()) {
              coll.clearBreakdowns();
              show = false;
            }
          }
        }
      }
    }

    if (show)
      v.add(new LZ03Event(request.getParameter("currNo"),request.getParameter("sdnNo"),request.getParameter("statSplitNo")));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}