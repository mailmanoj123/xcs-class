package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class SchemeCanadaFlowHandler extends FlowHandler {

  public SchemeCanadaFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}