package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;

public class ErrorWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {

  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ClaimsEvent event = (ClaimsEvent)request.getSession().getAttribute(Keys.WebEventKey);
    com.xchanging.xcc.cics.handlers.CICSHandler.ignoreErrors = true;

    Vector v = new Vector();
    v.add(event);
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}
