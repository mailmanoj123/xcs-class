package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CTODeleteFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    String currentScreen = request.getParameter("currentScreen");

    Vector list = new Vector();
    list.add(new LY11Event(currentScreen,"","Y"));
    fireEvents(list);

    NextScreenModel nextScreen = mm.getNextScreenModel();

    if (nextScreen.getNextScreen().equals("SCR004")) {
      return "1";
    } else if (nextScreen.getNextScreen().equals("SCR005")) {
      return "2";
    } else if (nextScreen.getNextScreen().equals("SCR025")) {
      return "3";
    } else if (nextScreen.getNextScreen().equals("SCR026")) {
      return "4";
    } else if (nextScreen.getNextScreen().equals("SCR007")) {
      return "6";
    } else if (nextScreen.getNextScreen().equals("NONE")) {
      return "7";
    } else if (nextScreen.getNextScreen().equals("SCR006")) {
        return "8";
    } else if (nextScreen.getNextScreen().equals("SCR045")) {
      return "9";
    } else //should never happen
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}