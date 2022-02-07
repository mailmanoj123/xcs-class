package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class ClaimTxnCreationCancelFlowHandler extends FlowHandler {

  public ClaimTxnCreationCancelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {}
  public void doEnd(HttpServletRequest request) {}

  public String processFlow(HttpServletRequest request) {
    return "1";
  }
}