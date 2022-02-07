package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SummNonSettHoldFlowHandler extends FlowHandler {

  public SummNonSettHoldFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String nextScreen = mm.getNextScreenModel().getNextScreen();
    mm.getFindClaimModel();

    if (nextScreen.equals("SCR004")) {

      return "2";
    } else if (nextScreen.equals("SCR005")) {

      return "3";
    } else if (nextScreen.equals("SCR025")) {

      return "4";
    } else if (nextScreen.equals("SCR026")) {

      return "5";
    } else if (nextScreen.equals("NONE")) {

      return "6";
    } else if (nextScreen.equals("SCR007")) {

      return "8";
    } else if (nextScreen.equals("SCR006")) {

      return "7";
    }  else if (nextScreen.equals("SCR045")) {

        return "9";
      } else // should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}