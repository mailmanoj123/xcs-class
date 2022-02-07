package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class ClaimTxnCreationCancelWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LZ02Event());
    v.add(new LY13Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}