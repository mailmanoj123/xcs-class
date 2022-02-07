package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY16Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ExitWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getTransactionStatusModel();
    mm.getMarketsModel();
    mm.getFindClaimModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    Vector v = new Vector();
    v.add(new LY16Event((String)request.getSession().getAttribute(Keys.ScreenOkKey)));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}