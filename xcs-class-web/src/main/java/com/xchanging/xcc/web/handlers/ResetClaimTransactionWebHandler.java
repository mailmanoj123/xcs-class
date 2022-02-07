package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ06Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class ResetClaimTransactionWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    v.add(new LZ06Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}

