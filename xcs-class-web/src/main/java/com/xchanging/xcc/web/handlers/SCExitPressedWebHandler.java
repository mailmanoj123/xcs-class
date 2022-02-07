package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCExitPressedWebHandler extends WebHandler {

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public void doStart(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    scwm = mm.getSchemeCanadaModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}