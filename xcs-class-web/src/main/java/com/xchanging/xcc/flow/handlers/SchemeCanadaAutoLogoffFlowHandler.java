package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LogoffEvent;

public class SchemeCanadaAutoLogoffFlowHandler extends FlowHandler {

  public SchemeCanadaAutoLogoffFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    Vector list = new Vector();
    list.add(new LogoffEvent(false));
    fireEvents(list);
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}