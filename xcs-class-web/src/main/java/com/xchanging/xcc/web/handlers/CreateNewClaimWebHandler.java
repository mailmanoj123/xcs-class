package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY16Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CreateNewClaimWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getTransactionStatusModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getTransactionStatusModel().reset();

    Vector v = new Vector();

    boolean cto = request.getParameter("cto")==null?false:request.getParameter("cto").equals("true");

    if (cto) {
      String currentScreen = request.getParameter("currentScreen");
      if (currentScreen==null)
        throw new GeneralFailureException("Screen ID not passed to Create New Claim");

      v.add(new LY16Event(currentScreen));
    }

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}