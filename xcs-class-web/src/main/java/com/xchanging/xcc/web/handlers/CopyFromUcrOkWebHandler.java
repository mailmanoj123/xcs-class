package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY84Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class CopyFromUcrOkWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String ucr = request.getParameter("ucrpt1") +
                 request.getParameter("ucrpt2") +
                 request.getParameter("ucrpt3");

    if (ucr==null) ucr="";

    String tr = request.getParameter("trpt1") +
                request.getParameter("trpt2") +
                request.getParameter("trpt3");

    if (tr==null) tr="";

    Vector v = new Vector();

    v.add(new LY84Event(ucr,tr));
    v.add(new LY12Event("SCR009"));
    v.add(new LY13Event());

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}