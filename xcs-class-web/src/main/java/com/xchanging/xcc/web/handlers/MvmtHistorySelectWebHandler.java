package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.MovementHistoryModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MvmtHistorySelectWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getNavigationBar();
    mm.getSCMAdviceModel();
    mm.getClaimDetailsModel();
    mm.getVATRatesModel();
    mm.getSingleClaimLossReservesModel();
    mm.getMarketDetailsModel();
    mm.getMarketsModel();
    mm.getExpertFeeBreakDownModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MovementHistoryModel mh = mm.getMovementHistoryModel();

    String mvmtRef = request.getParameter("mvmtref");
    String sysRef = request.getParameter("sysRef");
    String currNo = request.getParameter("currNo");
    String sdnNo = request.getParameter("sdnNo");
    String statSplitNo = request.getParameter("statSplitNo");
    String breakdownNo = request.getParameter("breakdownNo");

    Vector v = new Vector();
    v.add(new LY10Event(sysRef,currNo,sdnNo,statSplitNo,breakdownNo,"SCR026"));
    v.add(new LY11Event("SCR026","","N"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}