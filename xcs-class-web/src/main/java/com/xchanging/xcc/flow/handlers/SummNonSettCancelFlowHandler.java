package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class SummNonSettCancelFlowHandler extends FlowHandler{

  public SummNonSettCancelFlowHandler() {
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