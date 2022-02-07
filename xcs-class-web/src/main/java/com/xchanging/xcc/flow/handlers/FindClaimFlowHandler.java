package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class FindClaimFlowHandler extends FlowHandler {

  public FindClaimFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {

  }

  public String processFlow(HttpServletRequest request) {
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }
}