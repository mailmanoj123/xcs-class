package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LogoffEvent;

public class SecurityNotesExitFlowHandler extends FlowHandler {

  public SecurityNotesExitFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    String prevScreen = request.getParameter("prevScreen");

    if (prevScreen.equals("SCR005"))
      return "2";
    else if (prevScreen.equals("SCR006"))
      return "3";
    else if (prevScreen.equals("SCR007"))
      return "4";
    else if (prevScreen.equals("SCR023")) {
      Vector v = new Vector(1);
      v.add(new LogoffEvent(false));
      fireEvents(v);
      return "5";//should never happen
    }else if (prevScreen.equals("SCR045")) {
        return "6";
    }else
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}