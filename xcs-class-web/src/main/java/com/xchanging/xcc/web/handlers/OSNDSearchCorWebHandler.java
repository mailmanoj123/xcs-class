package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY09Event;
import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class OSNDSearchCorWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSCMAdviceModel();
    mm.getClaimDetailsModel();
    mm.getMarketsModel();
    mm.getNavigationBar();
    mm.getSingleClaimLossReservesModel() ;
    mm.getVATRatesModel();
    mm.getFinancialDetailsModel();
    mm.getExpertFeeBreakDownModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String breakdownNo = request.getParameter("breakdownNo");
    String sdnNo       = request.getParameter("sdnNo");
    String currNo      = request.getParameter("currNo");
    String ucrTrSysRef = request.getParameter("ucrTrSysRef");
    String statSplitNo = request.getParameter("statSplitNo");

    Vector v = new Vector();

    v.add(new LY10Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,"SCR006"));
    v.add(new LY09Event("SCR006"));
    v.add(new LY11Event("SCR006","Y","N"));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}