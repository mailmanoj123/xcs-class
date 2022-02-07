package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class SubsAdviceCancelWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY56Event("","",""));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}