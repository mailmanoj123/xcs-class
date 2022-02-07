package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceVATWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {

  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SCMAdviceModel scmAdvice = mm.getSCMAdviceModel();

    double vatAmount = (Double.parseDouble(request.getParameter("vatAmount")) * Double.parseDouble(request.getParameter("totalLine")))/100;

    scmAdvice.setBureauPpnOfVATAmount(round(vatAmount,2));

    Vector v = new Vector();
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }

  public static double round(double val, int places) {
    long factor = (long)Math.pow(10,places);

    // Shift the decimal the correct number of places
    // to the right.
    val = val * factor;

    // Round to the nearest integer.
    long tmp = Math.round(val);

    // Shift the decimal the correct number of places
    // back to the left.
    return (double)tmp / factor;
  }

}