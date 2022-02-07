package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SecurityNotesProceedWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSecurityNotesModel();
    mm.getClaimTransactionCreationModel();
    mm.getSingleClaimLossReservesModel();
    mm.getSCMAdviceModel();
    mm.getClaimDetailsModel();
    mm.getVATRatesModel();
    mm.getMarketsModel();
    mm.getFinancialDetailsModel();
    mm.getExpertFeeBreakDownModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY11Event("SCR008","","N"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}