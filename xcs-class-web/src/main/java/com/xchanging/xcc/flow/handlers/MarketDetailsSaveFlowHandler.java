package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;


public class MarketDetailsSaveFlowHandler extends FlowHandler {

  public MarketDetailsSaveFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {

    // just return the user back to the market details screen.
    return "1";

  }

  public void doEnd(HttpServletRequest request) {

  }

}