package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindClaimWebHandler extends WebHandler {

  private ModelManager mm;

  public FindClaimWebHandler() {
  }

  public void doStart(HttpServletRequest request) {
    ModelManager modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    modelManager.getFindClaimModel();
    modelManager.getFindClaimModel().setCor("");
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY10Event("0","0","0","0","0","SCR005"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}