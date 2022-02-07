package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.utils.Keys;

public class ErrorFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    String screen = (String)request.getSession().getAttribute(Keys.ScreenOkKey);

    if (screen==null)
      return "1";
    else if (screen.equals("SCR009"))
      return "2";
    else
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }
}
