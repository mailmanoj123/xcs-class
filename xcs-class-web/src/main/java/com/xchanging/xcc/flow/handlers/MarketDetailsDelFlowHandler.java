package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class MarketDetailsDelFlowHandler extends FlowHandler {

  public MarketDetailsDelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    return "";
  }

  public void doEnd(HttpServletRequest request) {

  }

}