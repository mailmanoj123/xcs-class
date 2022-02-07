package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class SummNonSettCancelWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY59Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}