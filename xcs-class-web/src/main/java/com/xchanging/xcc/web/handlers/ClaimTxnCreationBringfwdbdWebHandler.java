package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY93Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class ClaimTxnCreationBringfwdbdWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LY93Event());
    v.add(new LY12Event("SCR009"));
    v.add(new LZ02Event());
    v.add(new LY13Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}