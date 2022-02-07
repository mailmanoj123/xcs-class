package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.VATRatesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceVATDeleteWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    VATRatesModel vatModel = mm.getVATRatesModel();

    vatModel.setVatRates("","",
                         "","",
                         "","",
                         "","",
                         "","",
                         "","");

    Vector v = new Vector();
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}