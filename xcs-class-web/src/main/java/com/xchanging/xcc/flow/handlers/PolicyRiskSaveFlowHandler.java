package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;


public class PolicyRiskSaveFlowHandler extends FlowHandler {

  public PolicyRiskSaveFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {

    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {

      return "1";  // redisplay the policy risk details screen.

  }

  public void doEnd(HttpServletRequest request) {

  }

}