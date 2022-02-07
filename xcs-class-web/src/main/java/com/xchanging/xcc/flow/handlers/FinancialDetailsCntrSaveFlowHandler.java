package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class FinancialDetailsCntrSaveFlowHandler extends FlowHandler{

  public FinancialDetailsCntrSaveFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}