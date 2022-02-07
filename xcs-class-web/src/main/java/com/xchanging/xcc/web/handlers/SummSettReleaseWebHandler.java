package com.xchanging.xcc.web.handlers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY61Event;
import com.xchanging.xcc.events.LY82Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SummSettCollection;
import com.xchanging.xcc.web.models.SummSettCurrency;
import com.xchanging.xcc.web.models.SummarySettlementModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SummSettReleaseWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SummarySettlementModel ssm = mm.getSummarySettlementModel();
    int curr = 1;

    Enumeration e = ssm.getCurrencies();
    Vector ccys = new Vector();

    while (e.hasMoreElements()) {
      SummSettCurrency ccy = (SummSettCurrency)e.nextElement();
      HashMap ccyMap = new HashMap();

      ccyMap.put("CURR_NO",ccy.getCurrNo());
      ccyMap.put("SDN_NO",ccy.getSdnNo());

      Enumeration f = ccy.getCollections();
      Vector colls = new Vector();
      int coll = 1;
      while(f.hasMoreElements()) {
        SummSettCollection collection = (SummSettCollection)f.nextElement();
        HashMap collMap = new HashMap();
        collMap.put("STAT_SPLIT_NO",collection.getstatSplitNo());
        collMap.put("TDN_ATTR",collection.gettdnFlag()?"P":"U");
        if (collection.gettdnFlag())
          collMap.put("TDN_REF",collection.getTdn());
        else
          collMap.put("TDN_REF",getTdn(request,curr,coll));

        collMap.put("TREASURY_ATTR",collection.getTreasuryRateFlag().trim().equals("")?"U":"P");
        if (!ssm.hasTreasuryRates())
          collMap.put("TREASURY_RATE",collection.getTreasuryRate());
        else
          collMap.put("TREASURY_RATE",request.getParameter("TREASURYCURR" + curr + "COLL" + coll));

        colls.add(collMap);
        coll++;
      }
      ccyMap.put("COLLECTION_DETAILS",colls.elements());
      ccys.add(ccyMap);
      curr++;
    }

    Vector v = new Vector();
    v.add(new LY82Event("R",ccys.elements()));
    v.add(new LY61Event(request.getParameter("fileseen")));
    v.add(new LY11Event("SCR022","","N"));
    return v;
  }

  private String getTdn(HttpServletRequest request, int currNo, int collNo) {
    String tdn = request.getParameter("TDNCURR" + currNo + "COLL" + collNo + "sssss");
    if (tdn!=null) {
      tdn = request.getParameter("TDNCURR" + currNo + "COLL" + collNo + "ccyy");
      tdn += request.getParameter("TDNCURR" + currNo + "COLL" + collNo + "mm");
      tdn += request.getParameter("TDNCURR" + currNo + "COLL" + collNo + "dd");
      tdn += request.getParameter("TDNCURR" + currNo + "COLL" + collNo + "sssss");
    } else
      tdn = "";
    return tdn;
  }

  public void doEnd(HttpServletRequest request) {
  }
}