package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LZ10Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class LossReserveNewMvmtWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();

    v.add(new LZ10Event());
    v.add(new LY40Event()) ;

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}