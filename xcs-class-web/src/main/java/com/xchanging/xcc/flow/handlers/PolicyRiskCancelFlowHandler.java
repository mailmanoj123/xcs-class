package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class PolicyRiskCancelFlowHandler extends FlowHandler {

  public PolicyRiskCancelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {

  }

  public String processFlow(HttpServletRequest request) {
    // Basically this method should not be called as we
    // are just refreshing the screen and the Flow Handler
    // does not need to do anything-
    // However just in case we'll return '1' here which will
    // return us to the PolicyRiskScreen.
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}