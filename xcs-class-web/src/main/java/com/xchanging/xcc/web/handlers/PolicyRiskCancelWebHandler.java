package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class PolicyRiskCancelWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    Vector v = new Vector();
    v.add(new LY28Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}