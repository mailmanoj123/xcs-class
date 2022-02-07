package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY68Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class HistoryWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

    mm.getHistoryModel();
    mm.getTransactionHistoryModel();
    mm.getMovementHistoryModel();

    Vector v = new Vector();
    v.add(new LY68Event(request.getParameter("currentScreen")));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}