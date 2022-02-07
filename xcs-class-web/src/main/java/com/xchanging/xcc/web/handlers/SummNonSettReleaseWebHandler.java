package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY61Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class SummNonSettReleaseWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY61Event(request.getParameter("fileseen")));
    v.add(new LY11Event("SCR021","","N"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}