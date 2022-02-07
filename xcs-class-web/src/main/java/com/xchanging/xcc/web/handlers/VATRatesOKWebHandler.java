package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.VATRatesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class VATRatesOKWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    VATRatesModel vatModel = mm.getVATRatesModel();

    String rate1 = request.getParameter("vatRate1");
    String rate2 = request.getParameter("vatRate2");
    String rate3 = request.getParameter("vatRate3");
    String rate4 = request.getParameter("vatRate4");
    String rate5 = request.getParameter("vatRate5");
    String rate6 = request.getParameter("vatRate6");

    String amt1 = request.getParameter("vatAmt1");
    String amt2 = request.getParameter("vatAmt2");
    String amt3 = request.getParameter("vatAmt3");
    String amt4 = request.getParameter("vatAmt4");
    String amt5 = request.getParameter("vatAmt5");
    String amt6 = request.getParameter("vatAmt6");


    vatModel.setVatRates(rate1,amt1,
                         rate2,amt2,
                         rate3,amt3,
                         rate4,amt4,
                         rate5,amt5,
                         rate6,amt6);

    Vector v = new Vector();
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}